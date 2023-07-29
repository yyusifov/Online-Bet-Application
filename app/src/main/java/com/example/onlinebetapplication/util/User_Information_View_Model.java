package com.example.onlinebetapplication.util;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.onlinebetapplication.data.UserWithBets;
import com.example.onlinebetapplication.data.User_Information_Repository;
import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.model.User_bet;

import java.util.List;

public class User_Information_View_Model extends AndroidViewModel {
    public static User_Information_Repository user_information_repository;
    private LiveData<List<User_Information>> all;
    public User_Information_View_Model(@NonNull Application application) {
        super(application);
        user_information_repository = new User_Information_Repository(application);
    }
    public LiveData<User_Information> get(long userId){
        return user_information_repository.get(userId);
    }
    public LiveData<List<User_Information>> getAll(){
        all = user_information_repository.getAll();
        return all;
    }
    public static void delete(User_Information user_information){
        user_information_repository.delete(user_information);
    }
    public static void insertUser(User_Information user_information){
        user_information_repository.insertUser(user_information);
    }
    public static void insertBet(User_bet user_bet){
        user_information_repository.insertBet(user_bet);
    }
    public static void update(User_Information user_information){
        user_information_repository.update(user_information);
    }
    public static void deleteAll(){
        user_information_repository.deleteAll();
    }
    public LiveData<List<UserWithBets>> getUserWithBets(){
        return user_information_repository.getUserWithBets();
    }
    public static void deleteBet(User_bet user_bet){
        user_information_repository.deleteBet(user_bet);
    }
}
