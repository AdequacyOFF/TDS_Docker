package com.tds.tds_project.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id", columnDefinition = "serial")
    @JsonProperty("taskId")
    private  Integer id;

    @Column(name = "t_name", nullable = false)
    @JsonProperty("t_name")
    private String name;

    @Column(name = "description", nullable = false)
    @JsonProperty("description")
    private String description;

    @Column(name = "t_progress", nullable = false)
    @JsonProperty("t_progress")
    private Integer progress;

    @Column(name = "begin", nullable = false)
    @JsonProperty("begin")
    @Temporal(TemporalType.DATE)
    private Date begin;

    @Column(name = "end", nullable = false)
    @JsonProperty("end")
    @Temporal(TemporalType.DATE)
    private Date end;

    @Column(name = "pr_id", nullable = false)
    @JsonProperty("pr_id")
    private Integer projectId;

    @OneToMany(mappedBy = "taskId", fetch = FetchType.LAZY)
    @JsonProperty("subtasksList")
    private Set<Subtask> subtasksList;
  public List<Subtask> getSubtasksList(Integer taskId) {
        return subtasksList.stream()
            .filter(task -> task.getTaskId().equals(taskId))
            .collect(Collectors.toList());
    }

    Task() {}

    Task(String name, String description, Integer progress, Date begin, Date end, Integer pr_id) {

    this.name = name;
    this.description = description;
    this.progress = progress;
    this.begin = begin;
    this.end = end;
    this.projectId = pr_id;
  }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setPr_id(Integer pr_id) {
        this.projectId = pr_id;
    }

    // Геттеры и сеттеры
    
}
