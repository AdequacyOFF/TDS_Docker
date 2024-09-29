package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tds.tds_project.service.*;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.tds.tds_project.entity.*;

@Tag(name = "Контроллер проектов", description = "Обеспечивает взаимодействие с проектами")
@RestController
@RequestMapping("/api/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Task> getAllProjectTasks(@RequestParam Integer id) {
        return projectService.getTasksByProjectId(id);
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }
}