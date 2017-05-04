package com.itcompany.softwarestore.service;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface LoginService {
    boolean isCredentialsValid(String login, String password);
}
