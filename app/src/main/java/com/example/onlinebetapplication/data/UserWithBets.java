package com.example.onlinebetapplication.data;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.model.User_bet;

import java.util.List;

public class UserWithBets {
    @Embedded public User_Information user;
    @Relation(
            parentColumn = "user_id", //It will match user_id and Creator_ID to see how many of them belong to same category
            entityColumn = "Creator_ID"
    )
    public List<User_bet> user_bets;
}
