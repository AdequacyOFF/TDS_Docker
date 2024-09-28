package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tds.tds_project.service.UserService;
import com.tds.tds_project.entity.User;
import com.tds.tds_project.entity.Team;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Team> getAllUserTeams(@RequestParam Integer id) {
        return userService.getTeamsByUserId(id);
    }
    
    @PostMapping("/login")
    public Optional <User> login(@RequestBody Map<String, String> userData) {
        System.out.println(userData.get("login").trim());
        System.out.println(userData.get("password").trim());
        return userService.getAllUsers().stream()
            .filter(user -> user.getLogin().equalsIgnoreCase(userData.get("login").trim()) && user.getPassword().equalsIgnoreCase(userData.get("password").trim()))
            .findFirst();
    }

}
