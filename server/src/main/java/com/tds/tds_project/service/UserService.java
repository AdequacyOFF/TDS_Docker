package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.tds.tds_project.repository.UserRepository;
import com.tds.tds_project.entity.User;
import com.tds.tds_project.entity.Team;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Team> getTeamsByUserId(Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            return user.getTeamsList();
        }
        return Collections.emptyList();
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
     }
    
}