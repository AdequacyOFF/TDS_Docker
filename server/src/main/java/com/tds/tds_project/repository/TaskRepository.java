package com.tds.tds_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tds.tds_project.entity.Project;
import com.tds.tds_project.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findById(Integer taskId);
}
