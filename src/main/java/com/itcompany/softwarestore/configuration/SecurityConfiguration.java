package com.itcompany.softwarestore.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll();
        http.csrf().disable();
    }

/*    The most basic example is to configure all URLs to require the role "ROLE_USER". The configuration below requires authentication to every URL and will grant access to both the user "admin" and "user".
    @Configuration
    @EnableWebSecurity
    public class AuthorizeUrlsSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("*//**").hasRole("USER").and().formLogin();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
                    .and().withUser("adminr").password("password").roles("ADMIN", "USER");
        }
    }*/

}
