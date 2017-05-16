package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.dao.entity.Software;
import com.itcompany.softwarestore.service.HomeService;
import com.itcompany.softwarestore.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private final String defaultName = "guest";

    @Autowired
    private HomeService homeService;

    @Autowired
    private LoginService loginService;

/*    @PostMapping(value= "/view/login")
    public ModelAndView doLogin(@RequestParam(value = "j_username") String username,
                                @RequestParam(value = "j_password") String password) {
        ModelAndView view;
        if (loginService.isCredentialsValid(username, password)) {
            view = new ModelAndView("pages/all-software");
            List<String> categories = homeService.getAllCategoryNames();
            view.addObject("categories", categories);
            LOGGER.info("User '{}' successfully logged in", username);
            view.addObject("username", username);
        } else {
            LOGGER.warn("User '{}' unsuccessfully try logged in", username);
            view = new ModelAndView("pages/login");
            view.addObject("error", "Invalid username and password!");
        }
        return view;
    }*/


    @GetMapping("/view/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
            model.setViewName("pages/login");
        } else if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
            model.setViewName("/pages/login");
        } else {
            model.setViewName("pages/all-software");
        }
        return model;
    }

    @GetMapping(value = "/view/updateUser/{username}")
    public ModelAndView updateUser(@PathVariable(value = "username", required = false) String username) {
        ModelAndView view = new ModelAndView("fragments/header-top");

        if (username == null || username.isEmpty()) {
            view.addObject("username", defaultName);
        } else {
            view.addObject("username", username);
        }
        return view;
    }

    @GetMapping(value = "/view/logout")
    public ModelAndView doLogout() {
        ModelAndView view = new ModelAndView("pages/login");
        List<Software> softwaresTop10 = homeService.getTop10SoftwareByDesc();
        view.addObject("softwareList", softwaresTop10);
        view.addObject("username", "guest");
        return view;
    }

    //for 403 access denied page
    @GetMapping(value = "/view/403")
    public ModelAndView accesssDenied() {
        ModelAndView view = new ModelAndView("pages/403");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            view.addObject("username", userDetails.getUsername());
        }
        return view;
    }
}
