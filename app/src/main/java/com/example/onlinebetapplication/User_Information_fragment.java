package com.example.onlinebetapplication;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.util.User_Information_View_Model;
import com.google.android.material.snackbar.Snackbar;


public class User_Information_fragment extends Fragment {
    private ImageView profilePicture;
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    int resultCode = result.getResultCode();
                    Intent intent = result.getData();
                    if(resultCode == RESULT_OK){
                        profilePicture.setImageURI(intent.getData());
                    }
                }
            });
    public User_Information_fragment() {
        // Required empty public constructor
    }
    public static User_Information_fragment newInstance() {
        User_Information_fragment fragment = new User_Information_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user__information_fragment, container, false);
        ImageView changeImage = view.findViewById(R.id.change_pp);
        ImageView exit = view.findViewById(R.id.exit_id);
        profilePicture = view.findViewById(R.id.profile_picture_id);
        Button saveButton = view.findViewById(R.id.save_button_id);
        EditText username = view.findViewById(R.id.username_id_txt);
        EditText email = view.findViewById(R.id.email_id_txt);
        EditText password = view.findViewById(R.id.password1_id);
        EditText repeatPassword = view.findViewById(R.id.password2_id);
        TextView balance = view.findViewById(R.id.balance_id);
        long user_id = this.getArguments().getLong("user_information");
        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()).create(User_Information_View_Model.class);
        user_information_view_model.get(user_id).observe(requireActivity(), new Observer<User_Information>() {
            @Override
            public void onChanged(User_Information user_information) {
                username.setText(user_information.getUserName());
                email.setText(user_information.getUser_email());
                password.setText(user_information.getUser_password());
                repeatPassword.setText(user_information.getUser_password());
                balance.setText(String.valueOf(user_information.getBalance()) + "$");
            }
        });
        exit.setOnClickListener(v -> getActivity().finish());

        final int[] counter = {0};

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter[0]++;
                user_information_view_model.get(user_id).observe(requireActivity(), new Observer<User_Information>() {
                    @Override
                    public void onChanged(User_Information user_information) {
                        Log.d("Password_match", password.getText().toString() + " " + repeatPassword.getText().toString());
                        if(counter[0] == 1 && (password.getText().toString().equals(repeatPassword.getText().toString()))) {
                            User_Information user_information1 = user_information;
                            user_information1.setUserName(username.getText().toString());
                            user_information1.setUser_password(password.getText().toString());
                            user_information1.setUser_email(email.getText().toString());
                            User_Information_View_Model.update(user_information1);
                            counter[0]--;
                            Snackbar.make(username, "Changes were saved", Snackbar.LENGTH_LONG).show();
                        }
                        else if(!(password.getText().toString().equals(repeatPassword.getText().toString()))){
                            counter[0]--;
                            Snackbar.make(username, "Passwords do not match with each-other!", Snackbar.LENGTH_LONG).show();
                        }

                    }
                });
            }
        });

        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                activityResultLauncher.launch(intent);
            }
        });

        return view;
    }
}