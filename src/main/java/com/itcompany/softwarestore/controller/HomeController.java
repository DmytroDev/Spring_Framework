package com.itcompany.softwarestore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HomeController.
 *
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class HomeController {

    /**
     * Index page.
     * @return model and view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "home/index";
    }
}
