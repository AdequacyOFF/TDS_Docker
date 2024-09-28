package com.tds.tds_project.entity;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "subtasks")
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id", columnDefinition = "serial")
    @JsonProperty("sub_id")
    private  Integer sub_id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "description", nullable = false)
    @JsonProperty("description")
    private String description;

    @Column(name = "status", nullable = false)
    @JsonProperty("status")
    private Boolean status;

    @Column(name = "begin", nullable = false)
    @JsonProperty("begin")
    @Temporal(TemporalType.DATE)
    private Date begin;

    @Column(name = "end", nullable = false)
    @JsonProperty("end")
    @Temporal(TemporalType.DATE)
    private Date end;

    @Column(name = "exe_id", nullable = false)
    @JsonProperty("exe_id")
    private Integer exe_id;

    @Column(name = "t_id", nullable = false)
    @JsonProperty("t_id")
    private Integer t_id;

    Subtask() {}

    Subtask(String name, String description, Boolean status, Date begin, Date end, Integer exe_id, Integer t_id) {

    this.name = name;
    this.description = description;
    this.status = status;
    this.begin = begin;
    this.end = end;
    this.exe_id = exe_id;
    this.t_id = t_id;
  }

    // Геттеры и сеттеры
    public Integer getId() {
        return sub_id;
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
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
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
    public Integer getExecutorId() {
        return exe_id;
    }
    public void setExecutorId(Integer exe_id) {
        this.exe_id = exe_id;
    }
    public Integer getTaskId() {
        return t_id;
    }
    public void setTaskId(Integer t_id) {
        this.t_id = t_id;
    }
}
