package com.itcompany.softwarestore.service;

import com.itcompany.softwarestore.dao.entity.Software;
import com.itcompany.softwarestore.model.dto.FileInfo;

public interface SoftwareEntityBuilder {

    Software build(FileInfo fileInfo, long startTime);
}
