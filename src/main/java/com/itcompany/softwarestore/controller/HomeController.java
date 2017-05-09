package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
     *
     * @return model and view
     */
    @GetMapping(value = {"/", "/index"})
    public ModelAndView home(HttpSession session) {
        ModelAndView view = new ModelAndView("home/index");
        List<SoftwareEntity> softwaresTop10 = homeService.getTop10SoftwareByDesc();
        view.addObject("softwareList", softwaresTop10);
        session.setAttribute("username", "guest");
        return view;
    }

    @GetMapping(value = "/imgController128/getImg{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable long id) {
        SoftwareEntity softwareEntity = homeService.getSoftwareById(id);
        byte[] image128 = softwareEntity.getPictureContent128();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image128, headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/catController/getAllNames")
    public ResponseEntity<List<String>> getAllCategoryNames() {
        List<String> names = homeService.getAllCategoryNames();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_HTML);
        return new ResponseEntity<>(names, headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/view/index")
    public ModelAndView toAllSoftwarePage() {
        ModelAndView view = new ModelAndView("pages/all-software");
        List<String> categories = homeService.getAllCategoryNames();
        view.addObject("categories", categories);
        return view;
    }
}
