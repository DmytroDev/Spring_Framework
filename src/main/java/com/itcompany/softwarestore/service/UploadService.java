package com.itcompany.softwarestore.service;

import com.itcompany.softwarestore.model.dto.FileInfo;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface UploadService {

    FileInfo parseZipFile(String packageName, String description, String fileName);

    void saveSoftware(FileInfo fileInfo);
}
