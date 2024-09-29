package com.tds.tds_project.service;

import com.tds.tds_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public interface FilesService {

    // For save in directory
    ResponseEntity<?> saveFiles (MultipartFile[] multipartFiles, Integer userId);

    // For save in Database
    void saveInDb (MultipartFile multipartFile, String filePath, Integer userId);

    String checkType (File file);

    String getPathForFile (MultipartFile multipartFile);

    boolean checkFileExists (MultipartFile multipartFile);


}
