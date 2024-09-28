package com.tds.tds_project.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "serial")
    @JsonProperty("user_id")
    private  Integer user_id;

    @Column(name = "login", nullable = false)
    @JsonProperty("login")
    private String login;

    @Column(name = "password", nullable = false)
    @JsonProperty("password")
    private String password;

    @OneToMany(mappedBy = "user")
    Set<UserTeam> rely;


    public List<Team> getTeamsList() {
        return rely.stream()
            .map(UserTeam::getTeam)
            .collect(Collectors.toList());
    }

    public Set<UserTeam> getRely() {
        return rely;
    }

    public void setRely(Set<UserTeam> rely) {
        this.rely = rely;
    }

    User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

// Геттеры и сеттеры

    public Integer getId() {
        return user_id;
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

}
