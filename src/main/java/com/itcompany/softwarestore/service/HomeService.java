package com.itcompany.softwarestore.service;

import com.itcompany.softwarestore.dao.entity.Software;

import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface HomeService {

    Software getSoftwareById(long id);

    List<String> getAllCategoryNames();

    List<Software> getTop10SoftwareByDesc();

    List<Software> getSoftwareByCategory(String categoryName);
}
