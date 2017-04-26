package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.repository.SoftwareEntityRepository;
import com.itcompany.softwarestore.service.InitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Service
public class InitServiceImpl implements InitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitServiceImpl.class);

    @Autowired
    private SoftwareEntityRepository softwareEntityRepository;

    @Transactional
    @Override
    public void saveImageToDB() {
        softwareEntityRepository.updateImages("path_to_image_128px", 1L);
    }
}
