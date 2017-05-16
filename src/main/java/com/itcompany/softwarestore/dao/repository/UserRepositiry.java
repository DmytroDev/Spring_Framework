package com.itcompany.softwarestore.dao.repository;

import com.itcompany.softwarestore.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface UserRepositiry extends JpaRepository<User, String> {
}
