package com.itcompany.softwarestore.service;

import com.itcompany.softwarestore.model.dto.ZipArchiveInfo;

public interface DownloadService {

    ZipArchiveInfo createZipArchive(Long softwareId);

    void increaseDownloadNum(Long id);
}
