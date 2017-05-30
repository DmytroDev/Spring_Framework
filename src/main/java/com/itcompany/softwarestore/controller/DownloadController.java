package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.model.dto.ZipArchiveInfo;
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

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;

/**
 * REST controller to handle Http request for download files.
 *
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class DownloadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DownloadController.class);

    @Autowired
    private DownloadService downloadService;

    /**
     * REST endpoint to download software by id.
     *
     * @param softwareId software id
     * @return {@link ResponseEntity}
     * @throws FileNotFoundException thrown if file which should be download not found
     */
    @GetMapping(value = "/download/archive/{softwareId}")
    public ResponseEntity<InputStreamResource> doDownload(@PathVariable long softwareId) throws FileNotFoundException {
        LOGGER.info("Start download software. Id = '{}'.", softwareId);
        ZipArchiveInfo zipArchiveInfo = downloadService.createZipArchive(softwareId);
        byte[] file = zipArchiveInfo.getOutputStream().toByteArray();

        final HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        header.setContentDispositionFormData("attachment", zipArchiveInfo.getFileName());
        header.setContentLength(file.length);
        InputStreamResource body = new InputStreamResource(new ByteArrayInputStream(file));
        downloadService.increaseDownloadNum(softwareId);
        LOGGER.info("Archive with '{}' successfully downloaded.", zipArchiveInfo.getFileName());

        return new ResponseEntity<>(body, header, HttpStatus.OK);
    }

}
