package com.tds.tds_project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tds.tds_project.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findById(Integer team_id);
}
