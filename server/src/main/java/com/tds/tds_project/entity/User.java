package com.tds.tds_project.entity;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "serial")
    @JsonProperty("user_id")
    private  Integer id;

    @Column(name = "login", nullable = false)
    @JsonProperty("login")
    private String login;

    @Column(name = "password", nullable = false)
    @JsonProperty("password")
    private String password;

    @ManyToMany
    @JoinTable(
        name = "user_team",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Team> teams;

    User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

// Геттеры и сеттеры

    public Integer getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<Team> getTeams() {
        return teams;
    }
    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    

    
}
