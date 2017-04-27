package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
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

    @Override
    public List<SoftwareEntity> getAllSoftware() {
        List<SoftwareEntity> softwareEntities = softwareEntityRepository.findAll();
        LOGGER.info("Information about the Software has been successfully extracted from the database");
        // TODO: remove line bellow later
        System.out.println(softwareEntities);
        return softwareEntities;
    }
}
