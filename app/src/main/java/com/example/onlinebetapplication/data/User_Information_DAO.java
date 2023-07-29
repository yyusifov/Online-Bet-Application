package com.example.onlinebetapplication.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.model.User_bet;

import java.util.List;

@Dao
public interface User_Information_DAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(User_Information user_information);
    @Delete
    void delete(User_Information user_information);
    @Query("Select * from User_Information Where User_Information.user_id == :id")
    LiveData<User_Information> get(long id);
    @Query("Select * from User_Information Order by User_Information.user_name")
    LiveData<List<User_Information>> getAll();
    @Query("Delete from User_Information")
    void deleteAll();
    @Update
    void update(User_Information user_information);
    @Transaction
    @Query("SELECT * FROM User_Information")
    LiveData<List<UserWithBets>> getUsersWithBets();
    @Delete
    void deleteBet(User_bet user_bet);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertBet(User_bet user_bet);
}
