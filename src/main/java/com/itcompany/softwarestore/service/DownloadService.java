package com.itcompany.softwarestore.service;

import java.io.File;

public interface DownloadService {

    File createZipArchive(Long softwareId);
}
