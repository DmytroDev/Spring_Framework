package com.itcompany.softwarestore.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "SOFTWARE")
public class SoftwareEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "APP_NAME", nullable = false)
    private String name;

    @Column(name = "PACKAGE")
    private String appPackage;

    @Column(name = "PICTURE_128")
    private byte[] pictureContent128;

    @Column(name = "PICTURE_512")
    private byte[] pictureContent512;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DOWNLOADS_NUM")
    private Integer downloadsNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public byte[] getPictureContent128() {
        return pictureContent128;
    }

    public void setPictureContent128(byte[] pictureContent128) {
        this.pictureContent128 = pictureContent128;
    }

    public byte[] getPictureContent512() {
        return pictureContent512;
    }

    public void setPictureContent512(byte[] pictureContent512) {
        this.pictureContent512 = pictureContent512;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getDownloadsNumber() {
        return downloadsNumber;
    }

    public void setDownloadsNumber(Integer downloadsNumber) {
        this.downloadsNumber = downloadsNumber;
    }

    @Override
    public String toString() {
        return "SoftwareEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appPackage='" + appPackage + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", downloadsNumber=" + downloadsNumber +
                '}';
    }
}
