package com.example.onlinebetapplication.data;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.model.User_bet;
import com.example.onlinebetapplication.util.DatabaseRoom;

import java.util.List;

public class User_Information_Repository {
    private final User_Information_DAO userInformationDao;
    public User_Information_Repository(Application application){
        DatabaseRoom databaseRoom = DatabaseRoom.getInstance(application.getApplicationContext());
        userInformationDao = databaseRoom.userInformationDao();
        }
    public LiveData<List<User_Information>> getAll() {
        return userInformationDao.getAll();
    }
    public LiveData<User_Information> get(long userId){
        return userInformationDao.get(userId);
    }
    public void insertUser(User_Information user_information){
        DatabaseRoom.database_Writer_Executor.execute(new Runnable() {
            @Override
            public void run() {
                userInformationDao.insertUser(user_information);
            }
        });
    }
    public void insertBet(User_bet user_bet){
        DatabaseRoom.database_Writer_Executor.execute(new Runnable() {
            @Override
            public void run() {
                userInformationDao.insertBet(user_bet);
            }
        });
    }
    public void delete(User_Information user_information){
        DatabaseRoom.database_Writer_Executor.execute(new Runnable() {
            @Override
            public void run() {
                userInformationDao.delete(user_information);
            }
        });
    }
    public void deleteAll(){
        DatabaseRoom.database_Writer_Executor.execute(new Runnable() {
            @Override
            public void run() {
                userInformationDao.deleteAll();
            }
        });
    }
    public void update(User_Information user_information){
        DatabaseRoom.database_Writer_Executor.execute(new Runnable() {
            @Override
            public void run() {
                userInformationDao.update(user_information);
            }
        });
    }
    public LiveData<List<UserWithBets>> getUserWithBets(){
        return userInformationDao.getUsersWithBets();
    }
    public void deleteBet(User_bet user_bet){
        DatabaseRoom.database_Writer_Executor.execute(new Runnable() {
            @Override
            public void run() {
                userInformationDao.deleteBet(user_bet);
            }
        });
    }
}
