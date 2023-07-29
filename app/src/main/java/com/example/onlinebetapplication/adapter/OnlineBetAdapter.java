package com.example.onlinebetapplication.adapter;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinebetapplication.R;
import com.example.onlinebetapplication.game_properties.Root;
import com.example.onlinebetapplication.model.User_Information;
import com.example.onlinebetapplication.model.User_bet;
import com.example.onlinebetapplication.util.User_Information_View_Model;

import java.util.List;

public class OnlineBetAdapter extends RecyclerView.Adapter<OnlineBetAdapter.ViewHolder> {
    private List<Root> getGames;
    private long user_id;
    private Application application;
    private User_Information UserInformation;
    public OnlineBetAdapter(List<Root> getGames, long user_id, Application application, User_Information UserInformation){
        this.application = application;
        this.getGames = getGames;
        this.user_id = user_id;
        this.UserInformation = UserInformation;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_row, parent, false);
        return new ViewHolder(view);
    }
//bet atdiqdan sonra dayandir oyun elave elemeyi
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User_Information_View_Model user_information_view_model = new ViewModelProvider.AndroidViewModelFactory(application).create(User_Information_View_Model.class);

        if(getGames.get(position).getBookmakers().size() != 0){
            holder.league_name.setText(getGames.get(position).getSportTitle());
            holder.awayTeam.setText(getGames.get(position).getAwayTeam());
            holder.homeTeam.setText(getGames.get(position).getHomeTeam());
            holder.away_team_win_rate.setText(getGames.get(position).getBookmakers().get(0).getMarkets().get(0).getOutcomes().get(1).getPrice().toString());
            holder.home_team_win_rate.setText(getGames.get(position).getBookmakers().get(0).getMarkets().get(0).getOutcomes().get(0).getPrice().toString());
            if(getGames.get(position).getBookmakers().get(0).getMarkets().get(0).getOutcomes().size() < 3){
                holder.draw.setVisibility(View.GONE);
            }
            else{
                holder.draw.setVisibility(View.VISIBLE);
                holder.draw.setText(getGames.get(position).getBookmakers().get(0).getMarkets().get(0).getOutcomes().get(2).getPrice().toString());
            }
            int greyColor = Color.argb(100, 240,240,228);
            ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}}, new int[]{Color.BLUE, Color.rgb(255,92,0)});
            ColorStateList colorStateList2 = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}}, new int[]{Color.BLUE, greyColor});
            holder.home_team_win_rate.setBackgroundTintList(colorStateList2);
            holder.away_team_win_rate.setBackgroundTintList(colorStateList2);
            holder.draw.setBackgroundTintList(colorStateList2);
            holder.home_team_win_rate.setOnClickListener(v -> {
                if(holder.home_team_win_rate.getBackgroundTintList() == colorStateList){
                    holder.home_team_win_rate.setBackgroundTintList(colorStateList2);
                }
                else {
                    if(!(UserInformation.getBet_money() > 0.0 && UserInformation.getBet_amount() > 0.0)) {
                        User_bet user_bet = new User_bet();
                        user_bet.setHome_team(getGames.get(holder.getBindingAdapterPosition()).getHomeTeam());
                        user_bet.setAway_team(getGames.get(holder.getBindingAdapterPosition()).getAwayTeam());
                        user_bet.setPrice(getGames.get(holder.getBindingAdapterPosition()).getBookmakers().get(0).getMarkets().get(0).getOutcomes().get(0).getPrice());
                        user_bet.setLeague_name(getGames.get(holder.getBindingAdapterPosition()).getSportTitle());
                        user_bet.setCreator_ID(user_id);
                        user_bet.setTeam_that_money_has_been_put(1);
                        User_Information_View_Model.insertBet(user_bet);
                    }
                    holder.away_team_win_rate.setBackgroundTintList(colorStateList2);
                    holder.draw.setBackgroundTintList(colorStateList2);
                    holder.home_team_win_rate.setBackgroundTintList(colorStateList);
                }
            });
            holder.away_team_win_rate.setOnClickListener(v -> {
                if(holder.away_team_win_rate.getBackgroundTintList() == colorStateList) {
                    holder.away_team_win_rate.setBackgroundTintList(colorStateList2);
                }
                else{
                    if(!(UserInformation.getBet_money() > 0.0 && UserInformation.getBet_amount() > 0.0)) {
                        User_bet user_bet = new User_bet();
                        user_bet.setHome_team(getGames.get(holder.getBindingAdapterPosition()).getHomeTeam());
                        user_bet.setAway_team(getGames.get(holder.getBindingAdapterPosition()).getAwayTeam());
                        user_bet.setPrice(getGames.get(holder.getBindingAdapterPosition()).getBookmakers().get(0).getMarkets().get(0).getOutcomes().get(1).getPrice());
                        user_bet.setCreator_ID(user_id);
                        user_bet.setLeague_name(getGames.get(holder.getBindingAdapterPosition()).getSportTitle());
                        user_bet.setTeam_that_money_has_been_put(2);
                        User_Information_View_Model.insertBet(user_bet);
                    }
                    holder.draw.setBackgroundTintList(colorStateList2);
                    holder.home_team_win_rate.setBackgroundTintList(colorStateList2);
                    holder.away_team_win_rate.setBackgroundTintList(colorStateList);
                }
            });
            holder.draw.setOnClickListener(v -> {
                if(holder.draw.getBackgroundTintList() == colorStateList) {
                    holder.draw.setBackgroundTintList(colorStateList2);
                }
                else{
                    if(!(UserInformation.getBet_money() > 0.0 && UserInformation.getBet_amount() > 0.0)) {
                        User_bet user_bet = new User_bet();
                        user_bet.setLeague_name(getGames.get(holder.getBindingAdapterPosition()).getSportTitle());
                        user_bet.setHome_team(getGames.get(holder.getBindingAdapterPosition()).getHomeTeam());
                        user_bet.setAway_team(getGames.get(holder.getBindingAdapterPosition()).getAwayTeam());
                        user_bet.setCreator_ID(user_id);
                        user_bet.setPrice(getGames.get(holder.getBindingAdapterPosition()).getBookmakers().get(0).getMarkets().get(0).getOutcomes().get(2).getPrice());
                        user_bet.setTeam_that_money_has_been_put(0);//user_id qalib, yuxaridaki if qalib, delete qalib
                        User_Information_View_Model.insertBet(user_bet);
                    }
                    holder.away_team_win_rate.setBackgroundTintList(colorStateList2);
                    holder.home_team_win_rate.setBackgroundTintList(colorStateList2);
                    holder.draw.setBackgroundTintList(colorStateList);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return getGames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView homeTeam, awayTeam, league_name;
        private Button home_team_win_rate, away_team_win_rate, draw;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTeam = itemView.findViewById(R.id.home_team);
            awayTeam = itemView.findViewById(R.id.away_team);
            home_team_win_rate = itemView.findViewById(R.id.home_team_win_odd);
            away_team_win_rate = itemView.findViewById(R.id.away_team_win_odd);
            draw = itemView.findViewById(R.id.draw_odd);
            league_name = itemView.findViewById(R.id.sport_title);
        }
    }
}
