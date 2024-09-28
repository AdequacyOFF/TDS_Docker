package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.tds.tds_project.repository.*;
import com.tds.tds_project.entity.*;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SubtaskRepository subtaskRepository;

    public String processAndStoreData(String jsonData) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonData);

            String entityType = rootNode.get("entityType").asText();
            JsonNode entityData = rootNode.get("data");

            switch (entityType) {
                case "user":
                    User user = mapper.treeToValue(entityData, User.class);
                    userRepository.save(user);
                    return "User saved successfully";
                case "team":
                    // Вывод данных в консоль
                    System.out.println("Team data: " + entityData);
                    Team team = mapper.treeToValue(entityData, Team.class);
                    teamRepository.save(team);
                    return "Team saved successfully";
                case "project":
                    Project project = mapper.treeToValue(entityData, Project.class);
                    projectRepository.save(project);
                    return "Project saved successfully";
                case "task":
                    Task task = mapper.treeToValue(entityData, Task.class);
                    taskRepository.save(task);
                    return "Task saved successfully";
                case "subtask":
                    Subtask subtask = mapper.treeToValue(entityData, Subtask.class);
                    subtaskRepository.save(subtask);
                    return "Subtask saved successfully";
                default:
                    return "Unknown entity type";
            }
        } catch (Exception e) {
            return "Error processing data: " + e.getMessage();
        }
    }
}
