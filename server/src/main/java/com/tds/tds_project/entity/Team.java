package com.tds.tds_project.entity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", columnDefinition = "serial")
    @JsonProperty("id")
    private  Integer id;

    @Column(name = "t_name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "lead_id", nullable = false)
    @JsonProperty("leadId")
    private Integer leadId;

    @OneToMany(mappedBy = "team")
    Set<UserTeam> rely;

    @OneToMany(mappedBy = "team_id", fetch = FetchType.LAZY)
    @JsonProperty("projectList")
    private Set<Project> projectList;

    public List<Project> getProjectList(Integer teamId) {
        return projectList.stream()
            .filter(project -> project.getTeamId().equals(teamId))
            .collect(Collectors.toList());
    }

    Team() {}

    Team(String name, Integer leadId) {

    this.name = name;
    this.leadId = leadId;
  }

    // Геттеры и сеттеры
    public Integer getId() {
        return this.id;
      }
    
      public String getName() {
        return this.name;
      }
    
      public Integer getLead() {
        return this.leadId;
      }
    
      public void setName(String name) {
        this.name = name;
      }
    
      public void setLead(Integer leadId) {
        this.leadId = leadId;
      }
    
}