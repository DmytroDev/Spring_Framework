package com.itcompany.softwarestore.service;

/**
 * @author Dmitriy Nadolenko
 * @version 1.0
 * @since 1.0
 */
public interface InitService {

    void scanFilesAndSaveToDB(String path, int pictureSize);
}
