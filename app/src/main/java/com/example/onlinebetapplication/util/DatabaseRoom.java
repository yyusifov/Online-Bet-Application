package com.example.onlinebetapplication.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.onlinebetapplication.data.User_Information_DAO;
import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.model.User_bet;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User_Information.class, User_bet.class}, version = 1, exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {
public static final int number_of_threads = 4;
public abstract User_Information_DAO userInformationDao();
public static volatile DatabaseRoom databaseRoom;
public static ExecutorService database_Writer_Executor = Executors.newFixedThreadPool(number_of_threads);
public static DatabaseRoom getInstance(Context context){
    if(databaseRoom == null){
        synchronized (DatabaseRoom.class){
            if(databaseRoom == null){
                databaseRoom = Room.databaseBuilder(context.getApplicationContext(), DatabaseRoom.class, "Database").build();            }
        }
    }
    return databaseRoom;
}
public static final RoomDatabase.Callback RoomDatabaseCallBack = new RoomDatabase.Callback(){
    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        database_Writer_Executor.execute(() -> {
            User_Information_DAO user_information_dao = databaseRoom.userInformationDao();
            user_information_dao.deleteAll();
        });
    }
};
}
