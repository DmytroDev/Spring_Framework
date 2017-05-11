package com.itcompany.softwarestore.service.impl.builder;

import com.itcompany.softwarestore.dao.entity.CategoryEntity;
import com.itcompany.softwarestore.dao.entity.SoftwareEntity;
import com.itcompany.softwarestore.model.dto.Category;
import com.itcompany.softwarestore.model.dto.FileInfo;
import com.itcompany.softwarestore.service.SoftwareEntityBuilder;
import org.springframework.stereotype.Service;

@Service
public class SoftwareEntityBuilderImpl implements SoftwareEntityBuilder {

    @Override
    public SoftwareEntity build(FileInfo fileInfo, long startTime) {
        SoftwareEntity softwareEntity = new SoftwareEntity();
        softwareEntity.setName(fileInfo.getFileName());
        softwareEntity.setAppPackage(fileInfo.getPkgName());
        softwareEntity.setPictureContent128(fileInfo.getImg128Content());
        softwareEntity.setPictureContent512(fileInfo.getImg512Content());
        softwareEntity.setDescription(fileInfo.getDescription());

        CategoryEntity categoryEntity = new CategoryEntity();
        // temporary stub TODO: need modify later
        categoryEntity.setName(Category.GAMES);
        softwareEntity.setCategory(categoryEntity);
        softwareEntity.setDownloadsNumber(0);
        softwareEntity.setTimeUploaded(System.currentTimeMillis() - startTime);

        return softwareEntity;
    }
}
