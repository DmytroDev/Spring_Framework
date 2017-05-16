package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.dao.entity.Software;
import com.itcompany.softwarestore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class DetailsController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/view/details/{id}")
    public ModelAndView getDetails(@PathVariable long id) {
        ModelAndView mav = new ModelAndView("pages/details-page");
        Software software = homeService.getSoftwareById(id);
        mav.addObject("software", software);
        return mav;
    }

    @GetMapping(value = "/view/category/{categoryName}")
    public ModelAndView getSoftwareByCategory(@PathVariable String categoryName) {
        ModelAndView mav = new ModelAndView("fragments/software-by-category");
        List<Software> softwareList = homeService.getSoftwareByCategory(categoryName);
        mav.addObject("softwareList", softwareList);
        return mav;
    }

}
