package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.dao.repository.SoftwareEntityRepository;
import com.itcompany.softwarestore.model.dto.FileInfo;
import com.itcompany.softwarestore.service.SoftwareEntityBuilder;
import com.itcompany.softwarestore.service.UploadService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Service
public class UploadServiceImpl implements UploadService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Autowired
    private SoftwareEntityRepository softwareRepository;

    @Autowired
    private SoftwareEntityBuilder softwareEntityBuilder;

    private final String NAME_FIELD = "name";
    private final String PACKAGE_FIELD = "package";
    private final String PICTURE_128_FIELD = "picture_128";
    private final String PICTURE_512_FIELD = "picture_512";
    private final String DELIMITER = ":";
    private final String TXT_FILE_MASK = ".txt";

    @Override
    public FileInfo parseZipFile(String packageName, String description, String fileName) {
        LOGGER.info("Start parsing ZIP-file '{}' ...", fileName);
        FileInfo fileInfo = null;
        List<ZipEntry> zipEntries = new ArrayList<>();

        try (ZipFile file = new ZipFile(fileName)) {
            Enumeration<? extends ZipEntry> entries = file.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                InputStream is = file.getInputStream(entry);
                if (entry.getName().endsWith(TXT_FILE_MASK)) {
                    fileInfo = getInfoFromTxtFile(entry, is);
                } else {
                    zipEntries.add(entry);
                }
            }
            for (ZipEntry zipEntry : zipEntries) {
                if (zipEntry.getName().equalsIgnoreCase(fileInfo.getImg128FileName())) {
                    fileInfo.setImg128Content(extractImgContent(file.getInputStream(zipEntry)));
                } else if (zipEntry.getName().equalsIgnoreCase(fileInfo.getImg512FileName())) {
                    fileInfo.setImg512Content(extractImgContent(file.getInputStream(zipEntry)));
                }
            }
            fileInfo.setPkgName(packageName);
            fileInfo.setDescription(description);
            LOGGER.info("'{}' successfully parsed", fileName);
        } catch (IOException e) {
            LOGGER.error("Unable to read ZIP-file '{}'", fileName);
        }
        return fileInfo;
    }

    public void saveSoftware(FileInfo fileInfo) {
        SoftwareEntity softwareEntity = softwareEntityBuilder.build(fileInfo);
        softwareRepository.saveAndFlush(softwareEntity);
        LOGGER.info("Software '{}' successfully saved into database", fileInfo.getFileName());
    }

    private byte[] extractImgContent(InputStream is) throws IOException {
        return IOUtils.toByteArray(is);
    }

    private FileInfo getInfoFromTxtFile(final ZipEntry entry, InputStream is) throws IOException {
        FileInfo fileInfo = new FileInfo();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(DELIMITER);
            switch (row[0]) {
                case NAME_FIELD:
                    fileInfo.setFileName(row[1].trim());
                    break;
                case PACKAGE_FIELD:
                    fileInfo.setPkgName(row[1].trim());
                    break;
                case PICTURE_128_FIELD:
                    fileInfo.setImg128FileName(row[1].trim());
                    break;
                case PICTURE_512_FIELD:
                    fileInfo.setImg512FileName(row[1].trim());
                    break;
                default:
                    LOGGER.warn("Invalid row '{}' into file '{}'", line, entry.getName());
            }
        }
        LOGGER.info("Information from '{}' successfully extracted", entry.getName());
        return fileInfo;
    }

}
