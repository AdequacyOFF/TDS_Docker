package com.tds.tds_project.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Embeddable
class UserTeamKey implements Serializable {

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "team_id")
    Integer teamId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        result = prime * result + ((teamId == null) ? 0 : teamId.hashCode());
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
            UserTeamKey other = (UserTeamKey) obj;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        if (teamId == null) {
            if (other.teamId != null)
                return false;
        } else if (!teamId.equals(other.teamId))
            return false;
        return true;
    }

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
@Entity
class UserTeam {

    @EmbeddedId
    UserTeamKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("teamId")
    @JoinColumn(name = "team_id")
    Team team;

    public UserTeam() {}
    
    public UserTeam(User user, Team team) {
        this.user = user;
        this.team = team;
    }

    public UserTeamKey getId() {
        return id;
    }

    public void setId(UserTeamKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    

    // standard constructors, getters, and setters
}
