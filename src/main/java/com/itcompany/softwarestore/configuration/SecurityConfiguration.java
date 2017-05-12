package com.itcompany.softwarestore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Controller
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
        System.out.println("for check");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .anyRequest().permitAll()
                .and();

        http.authorizeRequests()
                //.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/view/upload").access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin().loginPage("/view/login").failureUrl("/index")
                .usernameParameter("username").passwordParameter("password")
                //.usernameParameter("j_username").passwordParameter("j_password") // Указываем параметры логина и пароля с формы логина
                .and()
                .logout().logoutSuccessUrl("/index")
                .and()
                .exceptionHandling().accessDeniedPage("/view/403")
                .and()
                .csrf();
    }

/*        http.formLogin()
                // указываем страницу с формой логина
                .loginPage("/login")
                // указываем action с формы логина
                .loginProcessingUrl("/j_spring_security_check")
                // указываем URL при неудачном логине
                .failureUrl("/login?error")
                // Указываем параметры логина и пароля с формы логина
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                // даем доступ к форме логина всем
                .permitAll();*/

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
