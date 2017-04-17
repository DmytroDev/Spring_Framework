package com.itcompany.softwarestore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * WebContextConfiguration.
 *
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
/*@Import({
        ConfClassName.class,
        ...
})*/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.itcompany.softwarestore")
        //, includeFilters = @ComponentScan.Filter(Controller.class), useDefaultFilters = false)
public class WebConfiguration extends WebMvcConfigurerAdapter {
    private static final String VIEWS_LOCATION = "/WEB_INF/views/";
    private static final String SUFFIX = ".jsp";
    private static final String RESOURCES_LOCATION = "/resources";
    private static final String RESOURCES_HANDLER = RESOURCES_LOCATION + "**";

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //resolver.setPrefix(VIEWS_LOCATION);
        resolver.setPrefix("/");
        resolver.setSuffix(SUFFIX);
        return resolver;
    }

/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/
}
