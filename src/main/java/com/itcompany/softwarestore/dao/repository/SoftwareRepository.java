package com.itcompany.softwarestore.dao.repository;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface SoftwareRepository extends JpaRepository<SoftwareEntity, Long> {

}
