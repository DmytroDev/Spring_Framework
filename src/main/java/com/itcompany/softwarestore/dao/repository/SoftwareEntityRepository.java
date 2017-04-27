package com.itcompany.softwarestore.dao.repository;

import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface SoftwareEntityRepository extends JpaRepository<SoftwareEntity, Long> {

    @Modifying
    @Transactional
    @Query("update SoftwareEntity s "
            + "set s.pictureContent128 =:content "
            + "where s.id =:applicationId")
    void updatePictureContent128(@Param("content") byte[] content,
                      @Param("applicationId") Long applicationId);

    @Modifying
    @Transactional
    @Query("update SoftwareEntity s "
            + "set s.pictureContent512 =:content "
            + "where s.id =:applicationId")
    void updatePictureContent512(@Param("content") byte[] content,
                                 @Param("applicationId") Long applicationId);
}
