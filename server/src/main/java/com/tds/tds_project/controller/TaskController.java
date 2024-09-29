package com.tds.tds_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.tds.tds_project.service.TaskService;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.tds.tds_project.entity.Task;
import com.tds.tds_project.entity.Subtask;

@Tag(name = "Контроллер задач", description = "Обеспечивает взаимодействие с задачами")
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Subtask> getAllTaskSubtasks(@RequestParam Integer id) {
        return taskService.getSubtasksByTaskId(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
}
