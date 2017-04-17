package com.itcompany.softwarestore.model.dto;

/**
 * Category.
 *
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public enum Category {

    GAMES("Games"), MULTIMEDIA("Multimedia"), PRODUCTIVITY("Productivity"), TOOLS("Tools"), HEALS("Health"), LIFESTYLE("Lifestyle");

    private String categoryName;

    Category(String name) {
        this.categoryName = name;
    }


}
