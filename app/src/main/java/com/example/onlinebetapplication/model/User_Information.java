package com.example.onlinebetapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.onlinebetapplication.game_properties.Root;

import java.util.List;

@Entity
public class User_Information {
    public User_Information() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private long userID;
    @ColumnInfo(name = "user_name")
    private String userName;
    private String user_email;
    private String user_password;

    public User_Information(String userName, String user_email, String user_password, double bet_money, double balance, double bet_amount) {
        this.userName = userName;
        this.user_email = user_email;
        this.user_password = user_password;
        this.bet_money = bet_money;
        this.balance = balance;
    }

    public double getBet_money() {
        return bet_money;
    }

    public void setBet_money(double bet_money) {
        this.bet_money = bet_money;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double bet_money;
    private double balance;

    public double getBet_amount() {
        return bet_amount;
    }

    public void setBet_amount(double bet_amount) {
        this.bet_amount = bet_amount;
    }

    private double bet_amount;


}
