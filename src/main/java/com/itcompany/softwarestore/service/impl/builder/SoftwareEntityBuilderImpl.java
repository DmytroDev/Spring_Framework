package com.itcompany.softwarestore.service.impl.builder;

import com.itcompany.softwarestore.dao.entity.Category;
import com.itcompany.softwarestore.dao.entity.Software;
import com.itcompany.softwarestore.model.dto.FileInfo;
import com.itcompany.softwarestore.service.SoftwareEntityBuilder;
import org.springframework.stereotype.Service;

@Service
public class SoftwareEntityBuilderImpl implements SoftwareEntityBuilder {

    @Override
    public Software build(FileInfo fileInfo, long startTime) {
        Software software = new Software();
        software.setName(fileInfo.getFileName());
        software.setAppPackage(fileInfo.getPkgName());
        software.setPictureContent128(fileInfo.getImg128Content());
        software.setPictureContent512(fileInfo.getImg512Content());
        software.setDescription(fileInfo.getDescription());

        Category category = new Category();
        category.setName(fileInfo.getCategory());
        software.setCategory(category);
        software.setDownloadsNumber(0);
        software.setTimeUploaded(System.currentTimeMillis() - startTime);

        return software;
    }
}
