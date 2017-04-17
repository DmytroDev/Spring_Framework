package com.itcompany.softwarestore.configuration;

import org.springframework.context.annotation.Configuration;


/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */

/*@ComponentScan(basePackages = "com.itcompany.softwarestore",
        excludeFilters = @ComponentScan.Filter({Controller.class, Configuration.class}))*/
@Configuration
public class RootConfiguration {

    //	@Bean
//	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
//		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
//		ppc.setLocation(new ClassPathResource("/persistence.properties"));
//		return ppc;
//	}
}
