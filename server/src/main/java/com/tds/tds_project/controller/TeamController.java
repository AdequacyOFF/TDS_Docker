package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tds.tds_project.service.TeamService;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.tds.tds_project.entity.Project;
import com.tds.tds_project.entity.Team;

@Tag(name = "Контроллер команд", description = "Обеспечивает взаимодействие с командами, добавление, удаление пользователей в них")
@RestController
@RequestMapping("/api/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Project> getAllTeamProjects(@RequestParam Integer id) {
        return teamService.getProjectsByTeamId(id);
}

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }
}