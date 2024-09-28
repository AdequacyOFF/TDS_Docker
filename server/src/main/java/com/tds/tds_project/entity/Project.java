package com.tds.tds_project.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
// import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pr_id", columnDefinition = "serial")
    @JsonProperty("pr_id")
    private  Integer pr_id;

    @Column(name = "pr_name", nullable = false)
    @JsonProperty("pr_name")
    private String pr_name;

    @Column(name = "description",nullable = false)
    @JsonProperty("description")
    private String description;

    @Column(name = "p_progress", nullable = false)
    @JsonProperty("p_progress")
    private Integer p_progress;

    @Column(name = "team_id", nullable = false)
    @JsonProperty("team_id")
    private Integer team_id;

    @Column(name = "p_begin", nullable = false)
    @JsonProperty("p_begin")
    @Temporal(TemporalType.DATE)
    private Date p_begin;

    @Column(name = "p_end", nullable = false)
    @JsonProperty("p_end")
    @Temporal(TemporalType.DATE)
    private Date p_end;
    // Геттеры и сеттеры
    Project() {}

    Project(String pr_name, String description, Integer p_progress, Integer team_id, Date p_begin, Date p_end) {

    this.pr_name = pr_name;
    this.description = description;
    this.p_progress = p_progress;
    this.team_id = team_id;
    this.p_begin = p_begin;
    this.p_end = p_end;
  }

    // Геттеры и сеттеры
    public Integer getId() {
        return this.pr_id;
      }
      public String getName() {
        return this.pr_name;
      }
      public String getDescription() {
        return this.description;
      }
      public Integer getProgress() {
        return this.p_progress;
      }
      public Integer getTeamId() {
        return this.team_id;
      }
      public Date getBegin() {
        return this.p_begin;
      }
      public Date getEnd() {
        return this.p_end;
      }

      public void setName(String pr_name) {
        this.pr_name = pr_name;
      }
      public void setDescription(String description) {
        this.description = description;
      }
      public void setProgress(Integer p_progress) {
        this.p_progress = p_progress;
    }
    public void setTeamId(Integer team_id) {
        this.team_id = team_id;
    }
    public void setBegin(Date p_begin) {
        this.p_begin = p_begin;
    }
    public void setEnd(Date p_end) {
        this.p_end = p_end;
    }
}
