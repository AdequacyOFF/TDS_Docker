package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import com.tds.tds_project.service.UserService;
import com.tds.tds_project.entity.User;
import com.tds.tds_project.entity.Project;
import com.tds.tds_project.entity.Team;

import com.tds.tds_project.service.ProjectService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Team> getAllUserTeams(@RequestParam Integer id) {
        return userService.getTeamsByUserId(id);
    }
    

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
