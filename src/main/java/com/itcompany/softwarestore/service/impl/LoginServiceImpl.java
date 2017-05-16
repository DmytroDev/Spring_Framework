package com.itcompany.softwarestore.service.impl;

import com.itcompany.softwarestore.dao.entity.User;
import com.itcompany.softwarestore.dao.repository.UserRepositiry;
import com.itcompany.softwarestore.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserRepositiry userRepositiry;

    @Override
    public boolean isCredentialsValid(String login, String password) {
        if ( (login == null) || (password == null) ) {
            return false;
        }
        List<User> userEntitiesAll = userRepositiry.findAll();
        List<User> userEntities = userEntitiesAll.stream()
                .filter(userEntity -> userEntity.getUsername().equalsIgnoreCase(login))
                .collect(Collectors.toList());

        if (userEntities == null || userEntities.isEmpty()) {
            return false;
        } else {
            return userEntities.stream().map(User::getPassword)
                    .anyMatch(pass -> DigestUtils.sha256Hex(password).equalsIgnoreCase(pass));
        }

    }
}
