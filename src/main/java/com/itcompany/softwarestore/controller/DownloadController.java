package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class DownloadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadController.class);

    @Autowired
    private DownloadService downloadService;

    @GetMapping(value= "/download/archive/{softwareId}")
    public ResponseEntity<InputStreamResource> doDownload(@PathVariable long softwareId) throws FileNotFoundException {
        LOGGER.info("Start download software. Id = '{}'", softwareId);
        File file = downloadService.createZipArchive(softwareId);
        final HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        header.setContentDispositionFormData("attachment", file.getName());
        header.setContentLength(file.length());
        InputStreamResource body = new InputStreamResource(new FileInputStream(file));
        downloadService.increaseDownloadNum(softwareId);
        LOGGER.info("Archive with '{}' successfully downloaded", file.getName());

        return new ResponseEntity<>(body, header, HttpStatus.OK);
    }

}
