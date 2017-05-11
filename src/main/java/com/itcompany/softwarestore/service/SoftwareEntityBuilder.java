package com.itcompany.softwarestore.service;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.model.dto.FileInfo;

public interface SoftwareEntityBuilder {

    SoftwareEntity build(FileInfo fileInfo, long startTime);
}
