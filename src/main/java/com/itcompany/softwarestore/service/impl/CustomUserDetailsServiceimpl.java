package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.UserRole;
import com.itcompany.softwarestore.dao.repository.UserRepositiry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);

    @Autowired
    private UserRepositiry userRepositiry;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        com.itcompany.softwarestore.dao.entity.User user = userRepositiry.findOne(username);
        List<GrantedAuthority> authorities =  buildUserAuthority(user.getUserRole());

        // TODO: simply for check. Need remove it later
        LOGGER.info("User: " + user);
        System.out.println("authorities: " + authorities);

        return buildUserForAuthentication(user, authorities);
    }


    // Converts com.itcompany.softwarestore.dao.entity.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.itcompany.softwarestore.dao.entity.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
        Set<SimpleGrantedAuthority> setAuthorities = userRoles.stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getRole()))
                .collect(Collectors.toSet());
        return new ArrayList<>(setAuthorities);
    }
}
