package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.service.HomeService;
import com.itcompany.softwarestore.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private HomeService homeService;

    @Autowired
    private LoginService loginService;

    @PostMapping(value= "/view/login")
    public ModelAndView doLogin(@RequestParam(value = "username") String username,
                                @RequestParam(value = "password") String password,
                                HttpSession session) {
        ModelAndView view = new ModelAndView("pages/all-software");
        List<String> categories = homeService.getAllCategoryNames();
        view.addObject("categories", categories);
        if (loginService.isCredentialsValid(username, password)) {
            LOGGER.info("User '{}' successfully logged in", username);
            session.setAttribute("username", username);
        } else {
            LOGGER.warn("User '{}' unsuccessfully try logged in", username);
        }
        return view;
    }

    @GetMapping(value = "/view/updateUser")
    public ModelAndView updateUser() {
        ModelAndView view = new ModelAndView("fragments/username");
        return view;
    }
}
