package com.tds.tds_project.entity;

import java.util.Set;

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

    @ManyToMany
    @JoinTable(
        name = "user_team",
        joinColumns = @JoinColumn(name = "team_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<Team> teams;

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