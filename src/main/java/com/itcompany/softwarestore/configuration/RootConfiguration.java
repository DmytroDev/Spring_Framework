package com.itcompany.softwarestore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@ComponentScan({ "com.itcompany.softwarestore" })
@Configuration
public class RootConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTemplate getJbdcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/application.properties"));
		return ppc;
	}

}
