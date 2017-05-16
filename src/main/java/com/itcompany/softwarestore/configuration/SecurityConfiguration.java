package com.itcompany.softwarestore.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/view/upload").access("hasRole('ROLE_DEVELOPER')")
                .antMatchers("/j_spring_security_check/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/view/login")
                .loginProcessingUrl("/j_spring_security_check").permitAll()
                .successForwardUrl("/view/index")
                .failureUrl("/view/login?error")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .and()
                //.logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/view/logout").invalidateHttpSession(true)
                .logout().logoutUrl("/view/logout").logoutSuccessUrl("/index").invalidateHttpSession(true)
                .and()
                .exceptionHandling().accessDeniedPage("/view/403")
                .and()
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

}
