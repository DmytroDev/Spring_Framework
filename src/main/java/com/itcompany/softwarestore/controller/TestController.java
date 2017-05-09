package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.service.HomeService;
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
    private HomeService homeService;

    @GetMapping("/test")
    public HttpStatus doTest() {
        LOGGER.info("Running test controller ...");
        // ...
        return HttpStatus.OK;
    }
}
