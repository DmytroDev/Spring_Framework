package com.itcompany.softwarestore.startup;

import com.itcompany.softwarestore.service.InitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Component
public class DatabaseInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private InitService initService;

    @EventListener(ContextRefreshedEvent.class)
    public void populate() {
        LOGGER.info("Started populate data into database ...");
        initService.saveImageToDB();
        LOGGER.info("Finished populate data into database");
    }
}
