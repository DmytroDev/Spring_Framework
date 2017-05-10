package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.CategoryEntity;
import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.dao.repository.CategoryEntityRepository;
import com.itcompany.softwarestore.dao.repository.SoftwareEntityRepository;
import com.itcompany.softwarestore.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Service
public class HomeServiceImpl implements HomeService {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Autowired
    private SoftwareEntityRepository softwareEntityRepository;

    @Autowired
    private CategoryEntityRepository categoryEntityRepository;


    @Override
    public List<SoftwareEntity> getAllSoftware() {
        List<SoftwareEntity> softwareEntities = softwareEntityRepository.findAll();
        LOGGER.info("Information about the Software has been successfully extracted from the database. List size '{}'", softwareEntities.size());
        return softwareEntities;
    }

    @Override
    public SoftwareEntity getSoftwareById(long id) {
        SoftwareEntity softwareEntity = softwareEntityRepository.findOne(id);
        LOGGER.info("Successfully got Software '{}'", softwareEntity);
        return softwareEntity;
    }

    @Override
    public List<String> getAllCategoryNames() {
        List<String> categoryNames = categoryEntityRepository.getAllCategories();
        LOGGER.info("All Category names has been successfully extracted from the database. List size '{}'", categoryNames.size());
        return categoryNames;
    }

    @Override
    public List<SoftwareEntity> getTop10SoftwareByDesc() {
        List<SoftwareEntity> softwareEntities = softwareEntityRepository.findTop5ByOrderByDownloadsNumberDesc();
        softwareEntities.addAll(softwareEntityRepository.findTop5ByOrderByTimeUploadedDesc());
        LOGGER.info("Successfully got Top 10 Software '{}'", softwareEntities);
        return softwareEntities;
    }

    @Override
    public List<SoftwareEntity> getSoftwareByCategory(String categoryName) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(categoryName);

        List<SoftwareEntity> softwareEntities = softwareEntityRepository.findByCategory(categoryEntity);
        LOGGER.info("Successfully got Software's by name '{}'", softwareEntities);
        return softwareEntities;
    }

}
