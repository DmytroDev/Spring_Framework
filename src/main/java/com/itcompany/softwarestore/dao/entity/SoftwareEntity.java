package com.itcompany.softwarestore.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Entity
public class SoftwareEntity {

    // TODO: fix Generated value for H2  http://stackoverflow.com/questions/11299675/how-to-set-h2-primary-key-id-to-auto-increment
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(name = "APP_NAME", nullable = false)
    private String name;

    @Column(name = "PACKAGE")
    private String appPackage;

    @Column(name = "PICTURE_128")
    private String picturePath128;

    @Column(name = "PICTURE_512")
    private String picturePath512;

    @Column(name = "DESCRIPTION")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getPicturePath128() {
        return picturePath128;
    }

    public void setPicturePath128(String picturePath128) {
        this.picturePath128 = picturePath128;
    }

    public String getPicturePath512() {
        return picturePath512;
    }

    public void setPicturePath512(String picturePath512) {
        this.picturePath512 = picturePath512;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SoftwareEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appPackage='" + appPackage + '\'' +
                ", picturePath128='" + picturePath128 + '\'' +
                ", picturePath512='" + picturePath512 + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
