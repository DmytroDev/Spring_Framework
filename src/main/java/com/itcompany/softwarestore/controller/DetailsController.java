package com.itcompany.softwarestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class DetailsController {

    @GetMapping("/view/details")
    public String getDetails() {
        return "pages/details-page";
    }

}
