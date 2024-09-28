package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tds.tds_project.service.SubtaskService;
import com.tds.tds_project.entity.Subtask;

@RestController
@RequestMapping("/api/subtasks")
public class SubtaskController {
    @Autowired
    private SubtaskService subtaskService;

    @GetMapping
    public List<Subtask> getAllSubtasks() {
        return subtaskService.getAllSubtasks();
    }

    @PostMapping
    public Subtask createSubtask(@RequestBody Subtask subtask) {
        return subtaskService.createSubtask(subtask);
    }
}