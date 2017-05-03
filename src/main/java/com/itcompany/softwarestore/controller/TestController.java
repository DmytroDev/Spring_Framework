package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.service.DownloadService;
import com.itcompany.softwarestore.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private UploadService uploadService;

    @Autowired
    private DownloadService downloadService;

    // Temporary stub. TODO: need remove it later
    Long softwareId = 1L;

    @GetMapping("/testDownload")
    public HttpStatus testDownload() {
        LOGGER.info("Running download file ...");
        downloadService.createZipArchive(softwareId);
        return HttpStatus.OK;
    }
}
