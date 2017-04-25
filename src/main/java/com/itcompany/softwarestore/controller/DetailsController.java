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
public class DetailsController {

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String getDetails() {
        return "fragments/details-page";
    }

}
