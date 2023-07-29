package com.example.onlinebetapplication.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class User_bet {
    @ForeignKey
            (entity = User_Information.class,
                    parentColumns = "user_id",
                    childColumns = "Creator_ID",
                    onDelete = CASCADE
            )
    private String home_team;
    private long Creator_ID;

    public long getCreator_ID() {
        return Creator_ID;
    }

    public void setCreator_ID(long creator_ID) {
        Creator_ID = creator_ID;
    }

    public long getBet_id() {
        return bet_id;
    }

    public void setBet_id(long bet_id) {
        this.bet_id = bet_id;
    }

    @PrimaryKey(autoGenerate = true)
    private long bet_id;
    public User_bet(long Creator_ID, String home_team, String away_team, int team_that_money_has_been_put, double price, String league_name) {
        this.Creator_ID = Creator_ID;
        this.league_name = league_name;
        this.home_team = home_team;
        this.away_team = away_team;
        this.team_that_money_has_been_put = team_that_money_has_been_put;
        this.price = price;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public int getTeam_that_money_has_been_put() {
        return team_that_money_has_been_put;
    }

    public void setTeam_that_money_has_been_put(int team_that_money_has_been_put) {
        this.team_that_money_has_been_put = team_that_money_has_been_put;
    }

    public User_bet() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    private String league_name;
    private String away_team;
    private int team_that_money_has_been_put;
    private double price;
}
