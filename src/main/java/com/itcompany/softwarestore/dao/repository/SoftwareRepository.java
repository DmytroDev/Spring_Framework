package com.itcompany.softwarestore.dao.repository;

import com.itcompany.softwarestore.dao.entity.Category;
import com.itcompany.softwarestore.dao.entity.Software;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface SoftwareRepository extends JpaRepository<Software, Long> {

    @Modifying
    @Transactional
    @Query("update Software s "
            + "set s.pictureContent128 =:content "
            + "where s.id =:applicationId")
    void updatePictureContent128(@Param("content") byte[] content,
                      @Param("applicationId") Long applicationId);

    @Modifying
    @Transactional
    @Query("update Software s "
            + "set s.pictureContent512 =:content "
            + "where s.id =:applicationId")
    void updatePictureContent512(@Param("content") byte[] content,
                                 @Param("applicationId") Long applicationId);

    @Modifying
    @Transactional
    @Query("update Software s "
            + "set s.downloadsNumber = s.downloadsNumber + 1 "
            + "where s.id =:applicationId")
    void increaseDownloadNum(@Param("applicationId") Long applicationId);

    @Transactional
    List<Software> findTop5ByOrderByDownloadsNumberDesc();

    @Transactional
    List<Software> findTop5ByOrderByTimeUploadedDesc();

    @Transactional
    List<Software> findByCategory(Category category);
}
