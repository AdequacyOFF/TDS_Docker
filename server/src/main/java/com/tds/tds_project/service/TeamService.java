package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import com.tds.tds_project.repository.TeamRepository;
import com.tds.tds_project.entity.Project;
import com.tds.tds_project.entity.Team;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Project> getProjectsByTeamId(Integer teamId) {
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team != null) {
            return team.getProjectList(teamId);
        }
        return Collections.emptyList();
    }
    public List<Team> getAllUserTeams() {
        return teamRepository.findAll();
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }
}
