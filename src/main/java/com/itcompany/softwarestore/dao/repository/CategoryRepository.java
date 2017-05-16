package com.itcompany.softwarestore.dao.repository;

import com.itcompany.softwarestore.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface CategoryRepository extends JpaRepository<Category, String> {


    @Query("select c.name from Category c")
    @Transactional
    List<String> getAllCategories();
}
