package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.dao.repository.SoftwareEntityRepository;
import com.itcompany.softwarestore.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    private SoftwareEntityRepository repository;

    private final String SUFFIX = ".zip";

    @Override
    public File createZipArchive(Long softwareId) {
        SoftwareEntity softwareEntity = repository.findOne(softwareId);
        File zipfile = new File(softwareEntity.getName() + SUFFIX);
        try {
            // create the ZIP file
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));

            out.putNextEntry(new ZipEntry("11111.png"));
            out.write(softwareEntity.getPictureContent128());
            out.closeEntry();

            out.close();
            return zipfile;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return null;
    }

}
