package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tds.tds_project.repository.TeamRepository;
import com.tds.tds_project.entity.Team;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
}
