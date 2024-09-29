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

    @Column(name = "login", nullable = false, unique = true)
    @JsonProperty("login")
    private String login;

    @Column(name = "password", nullable = false, unique = true)
    @JsonProperty("password")
    private String password;

    @Column(name = "number_of_files")
    private Long numberOfFiles;

    @OneToMany(mappedBy = "user")
    Set<UserTeam> rely;


    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((rely == null) ? 0 : rely.hashCode());
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
        User other = (User) obj;
        if (user_id == null) {
            if (other.user_id != null)
                return false;
        } else if (!user_id.equals(other.user_id))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (rely == null) {
            if (other.rely != null)
                return false;
        } else if (!rely.equals(other.rely))
            return false;
        return true;
    }

    public List<Team> getTeamsList() {
        return rely.stream()
            .map(UserTeam::getTeam)
            .collect(Collectors.toList());
    }

    // public Set<UserTeam> getRely() {
    //     return rely;
    // }

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
        return login.trim();
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password.trim();
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getNumberOfFiles() {
        return numberOfFiles;
    }
    public void setNumberOfFiles(Long numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }

}
