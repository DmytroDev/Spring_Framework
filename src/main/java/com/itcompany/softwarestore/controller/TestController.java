package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.model.dto.FileInfo;
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

    private final String zipArchiveName = "testarchive.zip";
    private final String FILE_NAME = "D:\\for_test\\test.zip";

    // Temporary stub. TODO: remove it later
    Long softwareId = 1L;

    @GetMapping("/test")
    public HttpStatus testUpload() {
        LOGGER.info("Running readZipFile method ...");
        FileInfo fileInfo = uploadService.parseZipFile("com", "free description ... ", FILE_NAME);
        uploadService.saveSoftware(fileInfo);
        return HttpStatus.OK;
    }

    @GetMapping("/testDownload")
    public HttpStatus testDownload() {
        LOGGER.info("Running download file ...");
        downloadService.createZipArchive(softwareId);
        return HttpStatus.OK;
    }
}
