package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tds.tds_project.entity.Project;

import java.util.List;
import com.tds.tds_project.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getUserProjects() {
        return projectRepository.findAll();
    }

        public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
