package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tds.tds_project.service.DataProcessingService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080") // Adjust if your frontend is on a different port
public class DataProcessingController {

    @Autowired
    private DataProcessingService dataProcessingService;

    @PostMapping("/process")
    public String processData(@RequestBody String jsonData) {
        return dataProcessingService.processAndStoreData(jsonData);
    }
}
