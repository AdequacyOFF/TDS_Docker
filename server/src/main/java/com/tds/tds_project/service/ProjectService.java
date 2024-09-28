package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tds.tds_project.entity.Project;
import com.tds.tds_project.entity.Team;
import com.tds.tds_project.entity.Task;

import java.util.Collections;
import java.util.List;

import com.tds.tds_project.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Task> getTasksByProjectId(Integer projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        if (project != null) {
            return project.getTasksList(projectId);
        }
        return Collections.emptyList();
    }

    public List<Project> getUserProjects() {
        return projectRepository.findAll();
    }

        public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}
