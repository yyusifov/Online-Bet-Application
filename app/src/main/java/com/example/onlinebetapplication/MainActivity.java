package com.example.onlinebetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.onlinebetapplication.Repository.Game_Repository;
import com.example.onlinebetapplication.Repository.SaveGameList;
import com.example.onlinebetapplication.databinding.ActivityMainBinding;
import com.example.onlinebetapplication.game_properties.Root;
import com.example.onlinebetapplication.util.User_Information_View_Model;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(MainActivity.this.getApplication()).create(User_Information_View_Model.class);
        activityMainBinding.logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login_activity.class);
                startActivity(intent);
            }
        });

        activityMainBinding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup_activity.class);
                startActivity(intent);
            }
        });

    }
}