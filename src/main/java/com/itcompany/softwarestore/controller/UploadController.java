package com.itcompany.softwarestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class UploadController {

    @RequestMapping(value = "/view/upload", method = RequestMethod.GET)
    //@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String doUpload() {
        return "pages/upload-form";
    }
}
