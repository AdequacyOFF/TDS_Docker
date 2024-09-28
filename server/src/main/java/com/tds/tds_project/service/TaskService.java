package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tds.tds_project.repository.TaskRepository;
import com.tds.tds_project.entity.Task;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
}
