package com.tds.tds_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tds.tds_project.entity.Project;
import com.tds.tds_project.entity.Task;
import com.tds.tds_project.entity.Team;
import com.tds.tds_project.entity.User;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findById(Integer project_id);
}

