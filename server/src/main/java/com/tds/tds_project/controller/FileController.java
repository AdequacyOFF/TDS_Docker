package com.tds.tds_project.controller;

import com.tds.tds_project.entity.File;
import com.tds.tds_project.entity.User;
import com.tds.tds_project.repository.FileRepository;
import com.tds.tds_project.repository.UserRepository;
import com.tds.tds_project.service.serviceImpl.FileServiceImpl;
import com.tds.tds_project.utils.TypeChecker;
import com.tds.tds_project.paths.UploadPaths;
import com.tds.tds_project.utils.ZipUtils;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FileController {

    private final FileServiceImpl fileService;
    private final UserRepository userRepository;
    private final FileRepository fileRepository;

    @Transactional
    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadNewFile(@RequestParam("file") MultipartFile[] multipartFiles, @RequestParam("userId") Integer userId) {
        try {
            fileService.saveFiles(multipartFiles, userId);
        } catch (Exception e) {
            return new ResponseEntity<>("Прозошла ошибка при сохранении файла: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok("Файлы успешно сохранены!");
    }

    @GetMapping("/get/file/{id}")
    public ResponseEntity<?> getFileById(@PathVariable Long id) {
        File file = fileRepository.findById(id).orElse(null);

        if(file == null) {
            return new ResponseEntity<>("Файл с " + id + " id не найден!", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(file.toString());
    }

    @GetMapping("/user-files/{id}")
    public ResponseEntity<?> getFilesByUserId(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            return new ResponseEntity<>("Пользователь с таким id не найден", HttpStatus.BAD_REQUEST);
        }

        List<File> userFiles = fileRepository.findAllByAuthorId(id);

        if(userFiles.size() <= 0) {
            return new ResponseEntity<>("У пользователя нет загруженных файлов", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(userFiles);
    }
}
