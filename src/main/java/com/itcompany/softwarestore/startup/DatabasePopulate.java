package com.itcompany.softwarestore.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Component
public class DatabasePopulate {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabasePopulate.class);

    @EventListener(ContextRefreshedEvent.class)
    public void populate() {
        LOGGER.info("Started populate data into database ...");
        // ...
        LOGGER.info("Finished populate data into database");
    }
}
