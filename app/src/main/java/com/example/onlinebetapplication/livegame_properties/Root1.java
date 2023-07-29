package com.example.onlinebetapplication.livegame_properties;

import java.util.ArrayList;
import java.util.List;
public class Root1 {
    private String id;
    private String sportKey;
    private String sportTitle;
    private String commenceTime;
    private Boolean completed;
    private String homeTeam;
    private String awayTeam;
    private List<Score> scores = new ArrayList<Score>();
    private String lastUpdate;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSportKey() {
        return sportKey;
    }
    public void setSportKey(String sportKey) {
        this.sportKey = sportKey;
    }
    public String getSportTitle() {
        return sportTitle;
    }
    public void setSportTitle(String sportTitle) {
        this.sportTitle = sportTitle;
    }
    public String getCommenceTime() {
        return commenceTime;
    }
    public void setCommenceTime(String commenceTime) {
        this.commenceTime = commenceTime;
    }
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public String getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
    }
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
    public List<Score> getScores() {
        return scores;
    }
    public void setScores(List<Score> scores) {
        this.scores = scores;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}