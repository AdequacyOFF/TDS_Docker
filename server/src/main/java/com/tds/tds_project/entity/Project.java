package com.tds.tds_project.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private  Integer projectId;

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

  @OneToMany(mappedBy = "team_id", fetch = FetchType.LAZY)
  @JsonProperty("projectList")
  private Set<Project> projectList;

  @OneToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    @JsonProperty("tasksList")
    private Set<Task> tasksList;
  public List<Task> getTasksList(Integer projectId) {
        return tasksList.stream()
            .filter(task -> task.getProjectId().equals(projectId))
            .collect(Collectors.toList());
    }
    
    
    @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
    result = prime * result + ((pr_name == null) ? 0 : pr_name.hashCode());
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((p_progress == null) ? 0 : p_progress.hashCode());
    result = prime * result + ((team_id == null) ? 0 : team_id.hashCode());
    result = prime * result + ((p_begin == null) ? 0 : p_begin.hashCode());
    result = prime * result + ((p_end == null) ? 0 : p_end.hashCode());
    result = prime * result + ((projectList == null) ? 0 : projectList.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Project other = (Project) obj;
    if (projectId == null) {
      if (other.projectId != null)
        return false;
    } else if (!projectId.equals(other.projectId))
      return false;
    if (pr_name == null) {
      if (other.pr_name != null)
        return false;
    } else if (!pr_name.equals(other.pr_name))
      return false;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (p_progress == null) {
      if (other.p_progress != null)
        return false;
    } else if (!p_progress.equals(other.p_progress))
      return false;
    if (team_id == null) {
      if (other.team_id != null)
        return false;
    } else if (!team_id.equals(other.team_id))
      return false;
    if (p_begin == null) {
      if (other.p_begin != null)
        return false;
    } else if (!p_begin.equals(other.p_begin))
      return false;
    if (p_end == null) {
      if (other.p_end != null)
        return false;
    } else if (!p_end.equals(other.p_end))
      return false;
    if (projectList == null) {
      if (other.projectList != null)
        return false;
    } else if (!projectList.equals(other.projectList))
      return false;
    return true;
  }


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
        return this.projectId;
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
