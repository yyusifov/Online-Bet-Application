package com.example.onlinebetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.util.User_Information_View_Model;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Login_activity extends AppCompatActivity {
    private EditText username, password;
    public static User_Information user_information;
    private ImageView back;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(User_Information_View_Model.class);
        username = findViewById(R.id.username_txt);
        password = findViewById(R.id.password_txt);
        login = findViewById(R.id.log_IN_button);
        back = findViewById(R.id.back_id);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        float density = getResources().getDisplayMetrics().density;
        int paddingLeft = (int) (15.0 * density);
        username.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                username.setPadding(paddingLeft,0,0,0);
                username.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                if(password.getText().toString().isEmpty()){
                    password.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    password.setHint("Password");
                }
                username.setHint("");
                return false;
            }
        });

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(username.getText().toString().isEmpty()){
                    username.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                    username.setHint("Username or E-mail");

                }
                password.setPadding(paddingLeft,0,0,0);
                password.setHint("");
                password.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                return false;
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    user_information_view_model.getAll().observe(Login_activity.this, new Observer<List<User_Information>>() {
                        @Override
                        public void onChanged(List<User_Information> user_informations) {
                            int counter = 0;
                            if(user_informations.size() > 0) {
                                for (int i = 0; i < user_informations.size(); i++) {
                                    if (username.getText().toString().equals(user_informations.get(i).getUserName()) &&
                                            password.getText().toString().equals(user_informations.get(i).getUser_password())) {
                                        user_information = user_informations.get(i);
                                        Intent intent = new Intent(Login_activity.this, HomePage.class);
                                        intent.putExtra("user information", user_information.getUserID());
                                        startActivity(intent);
                                        counter++;
                                    }
                                    if (counter == 0) {
                                        Snackbar.make(username, "This account does not exist", Snackbar.LENGTH_LONG).show();
                                    }
                                }
                            }
                            else{
                                    Snackbar.make(username, "This account does not exist", Snackbar.LENGTH_LONG).show();
                                }
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Username or/and password cannot be empty", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}