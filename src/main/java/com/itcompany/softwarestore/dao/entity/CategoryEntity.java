package com.itcompany.softwarestore.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @Column(name = "CATEGORY_NAME")
    private String name;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
