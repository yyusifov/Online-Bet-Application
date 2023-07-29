package com.example.onlinebetapplication.adapter;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinebetapplication.R;
import com.example.onlinebetapplication.data.UserWithBets;
import com.example.onlinebetapplication.model.User_bet;
import com.example.onlinebetapplication.util.User_Information_View_Model;

import java.util.List;

public class BetSaverAdapter extends RecyclerView.Adapter<BetSaverAdapter.ViewHolder>{
    private List<UserWithBets> userWithBets;
    private int user_id;
    public BetSaverAdapter(List<UserWithBets> userWithBets, int user_id) {
        this.userWithBets = userWithBets;
        this.user_id = user_id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bet_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(userWithBets.get(user_id).user_bets.get(position).getHome_team().length() > 13){

        }
        else{

        }
        holder.home_team.setText(userWithBets.get(user_id).user_bets.get(position).getHome_team());

        holder.away_team.setText(userWithBets.get(user_id).user_bets.get(position).getAway_team());
        holder.prediction.setText(String.valueOf(userWithBets.get(user_id).user_bets.get(position).getTeam_that_money_has_been_put()));
        holder.price.setText(String.valueOf(userWithBets.get(user_id).user_bets.get(position).getPrice()));
        holder.leagueName.setText(String.valueOf(userWithBets.get(user_id).user_bets.get(position).getLeague_name()));
        holder.deleteButton.setOnTouchListener((v, event) -> {
            User_Information_View_Model.deleteBet(userWithBets.get(user_id).user_bets.get(holder.getBindingAdapterPosition()));
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return userWithBets.get(user_id).user_bets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView home_team, away_team, prediction, price, leagueName;
        ImageButton deleteButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            leagueName = itemView.findViewById(R.id.league_id);
            home_team = itemView.findViewById(R.id.home_team_id);
            away_team = itemView.findViewById(R.id.away_team_id);
            prediction = itemView.findViewById(R.id.prediction_id);
            price = itemView.findViewById(R.id.price_id);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }
}
