package com.itcompany.softwarestore.service;

import com.itcompany.softwarestore.model.dto.FileInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface UploadService {

    FileInfo parseZipFile(String packageName, String description, MultipartFile multipartFile);

    void saveSoftware(FileInfo fileInfo, long startTime);
}
