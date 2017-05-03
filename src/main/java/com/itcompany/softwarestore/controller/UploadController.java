package com.itcompany.softwarestore.controller;

import com.itcompany.softwarestore.model.dto.FileInfo;
import com.itcompany.softwarestore.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
public class UploadController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private UploadService uploadService;


    @GetMapping("/view/upload")
    public String redirectToUploadPage() {
        return "pages/upload-form";
    }

    @PostMapping("/view/upload")
    public ModelAndView doUpload(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "description", required = false) String description,
                                 @RequestParam(value = "packageName", required = false) String packageName,
                                 @RequestParam(value = "file") MultipartFile file) {

        LOGGER.info("Running download file '{}'", file.getName());
        ModelAndView mav = new ModelAndView("pages/uploadStatus");
        String msg = null;
        if (file == null || file.isEmpty()) {
            msg = "Please select a file to upload";
        } else {
            FileInfo fileInfo = uploadService.parseZipFile(packageName, description, file);
            uploadService.saveSoftware(fileInfo);
            msg = "You successfully uploaded file: " + file.getOriginalFilename();
        }
        LOGGER.info("File '{}' successfully uploaded", name);
        mav.addObject("msg", msg);
        return mav;
    }

    @GetMapping("/view/uploadStatus")
    public String uploadStatus() {
        return "pages/uploadStatus";
    }
}
