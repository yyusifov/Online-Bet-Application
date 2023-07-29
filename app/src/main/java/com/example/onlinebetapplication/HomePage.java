package com.example.onlinebetapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.onlinebetapplication.Repository.Game_Repository;
import com.example.onlinebetapplication.Repository.SaveGameList;
import com.example.onlinebetapplication.adapter.BetSaverAdapter;
import com.example.onlinebetapplication.adapter.OnlineBetAdapter;
import com.example.onlinebetapplication.data.UserWithBets;
import com.example.onlinebetapplication.game_properties.Root;
import com.example.onlinebetapplication.model.User_bet;
import com.example.onlinebetapplication.util.User_Information_View_Model;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class HomePage extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bottomNavigationView = findViewById(R.id.bottom_nav_bar);

        long user_id = getIntent().getLongExtra("user information", 10);

        Bundle bundle = new Bundle();

        bundle.putLong("user_information", user_id);

        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(User_Information_View_Model.class);
        user_information_view_model.getUserWithBets().observe(this, new Observer<List<UserWithBets>>() {
            @Override
            public void onChanged(List<UserWithBets> userWithBets) {
                for (int i = 0; i < userWithBets.size(); i++) {
                    if(user_id == userWithBets.get(i).user.getUserID()){
                        bundle.putInt("user information1", i);
                    }
                }
            }
        });


        LiveGames_fragment liveGames_fragment = LiveGames_fragment.newInstance();
        liveGames_fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_Container,liveGames_fragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.live_games){

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_Container,liveGames_fragment).commit();

            }
            else if(item.getItemId() == R.id.live_score){

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_Container, Live_Score_fragment.newInstance()).commit();

            }
            else if(item.getItemId() == R.id.user_bets){
                User_Bets_fragment user_bets_fragment = User_Bets_fragment.newInstance();
                user_bets_fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_Container, user_bets_fragment).commit();


            }
            else if(item.getItemId() == R.id.user_info){

                User_Information_fragment user_information_fragment = User_Information_fragment.newInstance();
                user_information_fragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_Container, user_information_fragment).commit();


            }
            return true;
        });

    }
}