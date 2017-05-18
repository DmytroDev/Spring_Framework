package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.dao.entity.Software;
import com.itcompany.softwarestore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * REST controller to handle Http request for login-page.
 *
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class LoginController {

    private static final String DEFAULT_NAME = "guest";

    @Autowired
    private HomeService homeService;

    /**
     * REST endpoint for update user name in page-header.
     *
     * @param username user name
     * @return {@link ModelAndView}
     */
    @GetMapping(value = "/view/updateUser/{username}")
    public ModelAndView updateUser(@PathVariable(value = "username", required = false) String username) {

        ModelAndView view = new ModelAndView("fragments/header-top");
        if (username == null || username.isEmpty()) {
            view.addObject("username", DEFAULT_NAME);
        } else {
            view.addObject("username", username);
        }
        return view;
    }

    /**
     * REST endpoint for logout user.
     *
     * @return {@link ModelAndView}
     */
    @GetMapping(value = "/view/logout")
    public ModelAndView doLogout() {
        ModelAndView view = new ModelAndView("pages/login");
        List<Software> softwaresTop10 = homeService.getTop10SoftwareByDesc();
        view.addObject("softwareList", softwaresTop10);
        view.addObject("username", "guest");
        return view;
    }

    /**
     * REST endpoint for processing situation when access denied for current user.
     *
     * @return {@link ModelAndView}
     */
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
