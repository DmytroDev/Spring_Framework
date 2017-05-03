package com.itcompany.softwarestore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    // TODO: move to application.properties later
    private static String SAVE_FOLDER = "D://temp//save//";

    @GetMapping("/view/upload")
    public String redirectToUploadPage() {
        return "pages/upload-form";
    }

    @PostMapping("/view/upload")
    public ModelAndView doUpload(@RequestParam(value="name") String name,
                           @RequestParam(value = "description", required = false) String description,
                           @RequestParam(value = "file") MultipartFile file) {

        ModelAndView mav = new ModelAndView("pages/uploadStatus");
        String msg = null;
        if (file.isEmpty()) {
            msg = "Please select a file to upload";
        } else {
            msg = "You successfully uploaded file: " + file.getOriginalFilename();
        }
        try {
            byte[] bytes = file.getBytes();
            //TODO: need add to Service and call logic for parsing and saving into DB
/*            Path path = Paths.get(SAVE_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);*/
            mav.addObject("msg", msg);
            LOGGER.info("File '{}' successfully uploaded", name);
        } catch (IOException e) {
            LOGGER.error("Unable upload file. '{}'", e);
        }
        return mav;
    }


    @GetMapping("/view/uploadStatus")
    public String uploadStatus() {
        return "pages/uploadStatus";
    }

}
