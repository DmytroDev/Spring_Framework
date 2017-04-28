package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
     *
     * @return model and view
     */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView view = new ModelAndView("home/index");
        List<SoftwareEntity> softwares = homeService.getAllSoftware();
        // TODO: temporary STUB. Need modify later
        view.addObject("softwareList", softwares.subList(0, 10));
        return view;
    }

    @RequestMapping(value = "/imgController128/getImg{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable long id) {
        SoftwareEntity softwareEntity = homeService.getSoftwareById(id);
        byte[] image128 = softwareEntity.getPictureContent128();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(image128, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/view/index"}, method = RequestMethod.GET)
    public ModelAndView toAllSoftwarePage() {
        ModelAndView view = new ModelAndView("pages/all-software");
        return view;
    }
}
