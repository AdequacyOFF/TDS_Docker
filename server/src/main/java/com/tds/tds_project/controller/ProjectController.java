package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tds.tds_project.service.ProjectService;
import com.tds.tds_project.entity.Project;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public List<Project> getUserProjects() {
        return projectService.getUserProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }
}