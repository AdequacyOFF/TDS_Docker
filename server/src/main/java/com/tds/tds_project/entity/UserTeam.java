package com.tds.tds_project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
@Table(name = "user_team")
public class UserTeam {
    @Id
    @Column(name = "user_id")
    @JsonProperty("user_id")
    private Integer user_id;

    @Id
    @Column(name = "team_id")
    @JsonProperty("team_id")
    private Integer team_id;

    // Геттеры и сеттеры
}