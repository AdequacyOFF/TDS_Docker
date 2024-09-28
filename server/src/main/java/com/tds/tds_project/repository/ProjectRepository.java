package com.tds.tds_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tds.tds_project.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {}
