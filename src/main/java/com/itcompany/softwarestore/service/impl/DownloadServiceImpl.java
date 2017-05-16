package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.Software;
import com.itcompany.softwarestore.dao.repository.SoftwareRepository;
import com.itcompany.softwarestore.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.itcompany.softwarestore.model.dto.TxtFileFields.DELIMITER;
import static com.itcompany.softwarestore.model.dto.TxtFileFields.LINE_SEPARATOR;
import static com.itcompany.softwarestore.model.dto.TxtFileFields.NAME_FIELD;
import static com.itcompany.softwarestore.model.dto.TxtFileFields.PACKAGE_FIELD;
import static com.itcompany.softwarestore.model.dto.TxtFileFields.PICTURE_128_FIELD;
import static com.itcompany.softwarestore.model.dto.TxtFileFields.PICTURE_512_FIELD;

@Service
public class DownloadServiceImpl implements DownloadService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DownloadServiceImpl.class);

    @Autowired
    private SoftwareRepository repository;

    private final String SUFFIX = ".zip";
    private final String IMG_128_NAME = "128.png";
    private final String IMG_512_NAME = "512.png";

    @Override
    public File createZipArchive(Long softwareId) {
        Software software = repository.findOne(softwareId);
        File zipfile = new File(software.getName() + SUFFIX);

        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile))) {

            out.putNextEntry(new ZipEntry(IMG_128_NAME));
            out.write(software.getPictureContent128());
            out.closeEntry();

            out.putNextEntry(new ZipEntry(IMG_512_NAME));
            out.write(software.getPictureContent128());
            out.closeEntry();

            out.putNextEntry(new ZipEntry(software.getName() + ".txt"));
            String txtFileContent = writeContentToTxtFile(software);
            out.write(txtFileContent.getBytes());
            out.closeEntry();
            LOGGER.info("ZIP archive was successfully created for software with id '{}'", softwareId);
            return zipfile;
        } catch (IOException ex) {
            LOGGER.error("Unable create ZIP archive for software with id '{}'", softwareId);
        }
        return null;
    }

    public void increaseDownloadNum(Long id) {
        repository.increaseDownloadNum(id);
        LOGGER.info("Download number was successfully increased for Software with id  '{}' ", id);
    }

    private String writeContentToTxtFile(Software software) throws IOException {
        StringJoiner stringJoiner = new StringJoiner(LINE_SEPARATOR);
        stringJoiner.add(NAME_FIELD + DELIMITER + software.getName());
        stringJoiner.add(PACKAGE_FIELD + DELIMITER + software.getAppPackage());
        stringJoiner.add(PICTURE_128_FIELD + DELIMITER + IMG_128_NAME);
        stringJoiner.add(PICTURE_512_FIELD + DELIMITER + IMG_512_NAME);
        return stringJoiner.toString();
    }

}
