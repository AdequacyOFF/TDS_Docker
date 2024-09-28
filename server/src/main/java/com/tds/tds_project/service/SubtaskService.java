package com.tds.tds_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tds.tds_project.repository.SubtaskRepository;
import com.tds.tds_project.entity.Subtask;

@Service
public class SubtaskService {
    @Autowired
    private SubtaskRepository subtaskRepository;

    public List<Subtask> getAllSubtasks() {
        return subtaskRepository.findAll();
    }

    public Subtask createSubtask(Subtask subtask) {
        return subtaskRepository.save(subtask);
    }
}
