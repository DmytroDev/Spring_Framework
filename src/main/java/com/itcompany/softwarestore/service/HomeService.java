package com.itcompany.softwarestore.service;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;

import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface HomeService {

    List<SoftwareEntity> getAllSoftware();

    SoftwareEntity getSoftwareById(long id);

    List<String> getAllCategoryNames();

    List<SoftwareEntity> getTop10SoftwareByDesc();
}
