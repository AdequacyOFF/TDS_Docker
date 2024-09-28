package com.tds.tds_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tds.tds_project.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {}
