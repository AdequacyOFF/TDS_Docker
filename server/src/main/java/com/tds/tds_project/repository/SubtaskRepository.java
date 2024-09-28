package com.tds.tds_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tds.tds_project.entity.Subtask;

public interface SubtaskRepository extends JpaRepository<Subtask, Integer> {}
