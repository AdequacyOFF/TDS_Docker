package com.tds.tds_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tds.tds_project.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {}
