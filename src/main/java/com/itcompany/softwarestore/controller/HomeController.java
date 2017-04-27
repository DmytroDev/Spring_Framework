package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * HomeController.
 *
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class HomeController {

    @Autowired
    private HomeService homeService;

    /**
     * Index page.
     * @return model and view
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("home/index");
        List<SoftwareEntity> softwares = homeService.getAllSoftware();
        view.addObject("softwares", softwares);
        return view;
    }
}
