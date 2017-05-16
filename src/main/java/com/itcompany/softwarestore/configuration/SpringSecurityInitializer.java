package com.itcompany.softwarestore.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

    // Need for Multipart (file upload)
/*    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
        insertFilters(servletContext, new MultipartFilter());
    }*/
}
