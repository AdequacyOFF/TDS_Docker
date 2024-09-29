package com.tds.tds_project.service.serviceImpl;

import com.tds.tds_project.entity.User;
import com.tds.tds_project.repository.FileRepository;
import com.tds.tds_project.repository.UserRepository;
import com.tds.tds_project.service.FilesService;
import com.tds.tds_project.utils.TypeChecker;

import lombok.RequiredArgsConstructor;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;

@Component
@RequiredArgsConstructor
public class FileServiceImpl implements FilesService {

    private final FileRepository fileRepository;
    private final UserRepository userRepository;
    

    

    // Главный метод для сохранения файлов
    @Override
    public ResponseEntity<?> saveFiles(MultipartFile[] multipartFiles, Integer userId) {
        for(MultipartFile multipartFile: multipartFiles) {

            String typeOfFile = multipartFile.getContentType();
            String fullNameOfFile = multipartFile.getOriginalFilename();

            if (typeOfFile == null) {
                return new ResponseEntity<>
                        ("Файл не может быть пустым", HttpStatus.BAD_REQUEST);
            }

            String pathToSave = TypeChecker.getPathByType(typeOfFile);

            // Если файл уже существует
            if(new File(pathToSave + fullNameOfFile).exists()) {
                return new ResponseEntity<>
                        ("Файл с таким именем уже существует", HttpStatus.BAD_REQUEST);
            }

            File file = new File(pathToSave + fullNameOfFile);

            try {
                multipartFile.transferTo(file); // Сохранение файла
            } catch (IOException e) {
                return new ResponseEntity<>
                        ("Ошибка при сохранении файла", HttpStatus.BAD_REQUEST);
            }
            // После того, как сохранили файл по директориям, мы должны сохранить информацию о нем в базе данных
            saveInDb(multipartFile, pathToSave + fullNameOfFile, userId);
        }
        return ResponseEntity.ok("Файлы успешно загружены и сохранены");
    }

    @Override
    public void saveInDb(MultipartFile multipartFile, String filePath, Integer userId) {
        com.tds.tds_project.entity.File file = new com.tds.tds_project.entity.File();

        User user = userRepository.findById(userId).orElse(null);

        if(user == null) {
            throw new IllegalArgumentException("Текущий пользователь не найден!");
        }

        user.setNumberOfFiles(user.getNumberOfFiles() + 1);
        userRepository.save(user);

        file.setFileName(multipartFile.getName());
        file.setFileType(TypeChecker.getTypeOfFile(multipartFile));
        file.setCreatedAt(ZonedDateTime.now());
        file.setSize((int)multipartFile.getSize());
        file.setAuthorId(userId);
        file.setPath(filePath);

        fileRepository.save(file);
    }



    // Метод для проверки, существует ли файл в базе для того, чтобы не было ошибок
    @Override
    public boolean checkFileExists(MultipartFile multipartFile) {
        return false;
    }

    @Override
    public String getPathForFile(MultipartFile multipartFile) {
        return null;
    }



    @Override
    public String checkType(File file) {
        return null;
    }
}
