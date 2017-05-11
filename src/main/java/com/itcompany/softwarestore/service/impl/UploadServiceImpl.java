package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.dao.repository.SoftwareEntityRepository;
import com.itcompany.softwarestore.model.dto.FileInfo;
import com.itcompany.softwarestore.model.dto.TxtFileFields;
import com.itcompany.softwarestore.service.SoftwareEntityBuilder;
import com.itcompany.softwarestore.service.UploadService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
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

    @Override
    public FileInfo parseZipFile(String packageName, String description, MultipartFile multipartFile) {
        LOGGER.info("Start parsing ZIP-file '{}' ...", multipartFile.getOriginalFilename());
        FileInfo fileInfo = null;
        List<ZipEntry> zipEntries = new ArrayList<>();
        File fileName = multipartToFile(multipartFile);

        try (ZipFile file = new ZipFile(fileName)) {
            Enumeration<? extends ZipEntry> entries = file.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                InputStream is = file.getInputStream(entry);
                if (entry.getName().endsWith(TxtFileFields.TXT_FILE_SUFFIX)) {
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
            LOGGER.info("'{}' successfully parsed", multipartFile.getOriginalFilename());
        } catch (IOException e) {
            LOGGER.error("Unable to read ZIP-file '{}'", multipartFile.getOriginalFilename());
        }
        return fileInfo;
    }

    public void saveSoftware(FileInfo fileInfo, long startTime) {
        SoftwareEntity softwareEntity = softwareEntityBuilder.build(fileInfo, startTime);
        softwareRepository.saveAndFlush(softwareEntity);
        LOGGER.info("Software '{}' successfully saved into database", fileInfo.getFileName());
    }

    private File multipartToFile(MultipartFile multipart) {
        File convFile = new File(multipart.getOriginalFilename());
        try {
            multipart.transferTo(convFile);
        } catch (IOException e) {
            LOGGER.error("Unable convert file '{}' from MultipartFile to File", multipart.getOriginalFilename());
        }
        return convFile;
    }

    private byte[] extractImgContent(InputStream is) throws IOException {
        return IOUtils.toByteArray(is);
    }

    private FileInfo getInfoFromTxtFile(final ZipEntry entry, InputStream is) throws IOException {
        FileInfo fileInfo = new FileInfo();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(TxtFileFields.DELIMITER);
            switch (row[0]) {
                case TxtFileFields.NAME_FIELD:
                    fileInfo.setFileName(row[1].trim());
                    break;
                case TxtFileFields.PACKAGE_FIELD:
                    fileInfo.setPkgName(row[1].trim());
                    break;
                case TxtFileFields.PICTURE_128_FIELD:
                    fileInfo.setImg128FileName(row[1].trim());
                    break;
                case TxtFileFields.PICTURE_512_FIELD:
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
