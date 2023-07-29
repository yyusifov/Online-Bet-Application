package com.example.onlinebetapplication.game_properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Root {
    private String id;
    private String sportKey;
    private String sportTitle;
    private String commenceTime;
    private String homeTeam;
    private String awayTeam;
    private List<Bookmaker> bookmakers = new ArrayList<Bookmaker>();
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
    public List<Bookmaker> getBookmakers() {
        return bookmakers;
    }
    public void setBookmakers(List<Bookmaker> bookmakers) {
        this.bookmakers = bookmakers;
    }
}