package com.example.onlinebetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.onlinebetapplication.databinding.ActivityMainBinding;
import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.util.User_Information_View_Model;

public class Signup_activity extends AppCompatActivity {
    private ImageView back;
    private EditText fullName_user, email_user, password_user;
    private ImageButton fullName_user_icon, email_user_icon, password_user_icon;
    private Button sign_up_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sign_up_button = findViewById(R.id.Sign_Up_Button);
        fullName_user = findViewById(R.id.Full_name);
        email_user = findViewById(R.id.user_email);
        password_user = findViewById(R.id.user_password);
        fullName_user_icon = findViewById(R.id.fullname_imagebutton);
        email_user_icon = findViewById(R.id.email_imagebutton);
        back = findViewById(R.id.back_id1);
        password_user_icon = findViewById(R.id.password_imagebutton);
        int paddingLeft = 48;
        int paddingLeft2 = 15;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        FrameLayout.LayoutParams layoutParams1 = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        float density = getResources().getDisplayMetrics().density;
        int paddingDp = (int)(paddingLeft * density);
        int paddingDp2 = (int)(paddingLeft2 * density);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fullName_user.setOnTouchListener((v, event) -> {
            layoutParams1.leftMargin = paddingDp;
            if(email_user.getText().toString().isEmpty()){
                email_user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                email_user.setLayoutParams(layoutParams1);
                email_user.setHint("E-mail");
                email_user_icon.setVisibility(View.VISIBLE);
            }
            if(password_user.getText().toString().isEmpty()){
                password_user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                password_user.setLayoutParams(layoutParams1);
                password_user.setHint("Password");
                password_user_icon.setVisibility(View.VISIBLE);
            }
            layoutParams.leftMargin = paddingDp2;
            fullName_user.setLayoutParams(layoutParams);
            fullName_user.setHint("");
            fullName_user_icon.setVisibility(View.GONE);
            fullName_user.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            return false;
        });
        email_user.setOnTouchListener((v, event) -> {
            layoutParams1.leftMargin = paddingDp;
            if(password_user.getText().toString().isEmpty()){
                password_user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                password_user.setLayoutParams(layoutParams1);
                password_user.setHint("Password");
                password_user_icon.setVisibility(View.VISIBLE);
            }
            if(fullName_user.getText().toString().isEmpty()){
                fullName_user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                fullName_user.setLayoutParams(layoutParams1);
                fullName_user.setHint("Username");
                fullName_user_icon.setVisibility(View.VISIBLE);
            }
            layoutParams.leftMargin = paddingDp2;
            email_user.setLayoutParams(layoutParams);
            email_user.setHint("");
            email_user_icon.setVisibility(View.GONE);
            email_user.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            return false;
        });
        password_user.setOnTouchListener((v, event) -> {
            layoutParams1.leftMargin = paddingDp;
            if(email_user.getText().toString().isEmpty()){
                email_user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                email_user.setLayoutParams(layoutParams1);
                email_user.setHint("E-mail");
                email_user_icon.setVisibility(View.VISIBLE);
            }
            if(fullName_user.getText().toString().isEmpty()){
                fullName_user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                fullName_user.setLayoutParams(layoutParams1);
                fullName_user.setHint("Username");
                fullName_user_icon.setVisibility(View.VISIBLE);
            }
            layoutParams.leftMargin = paddingDp2;
            password_user.setLayoutParams(layoutParams);
            password_user.setHint("");
            password_user_icon.setVisibility(View.GONE);
            password_user.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            return false;
        });
        sign_up_button.setOnClickListener(v -> {
            if(!fullName_user.getText().toString().isEmpty() && !email_user.getText().toString().isEmpty() && !password_user.getText().toString().isEmpty()){
                User_Information user_information = new User_Information();
                user_information.setUser_email(email_user.getText().toString());
                user_information.setUserName(fullName_user.getText().toString());
                user_information.setUser_password(password_user.getText().toString());
                user_information.setBalance(1000.0);
                User_Information_View_Model.insertUser(user_information);
                Intent intent = new Intent();
                setResult(1001, intent);
                finish();
            }
            else{
                Toast.makeText(getApplicationContext(), "None of above fields can be left empty!", Toast.LENGTH_LONG).show();
            }
        });


    }
}