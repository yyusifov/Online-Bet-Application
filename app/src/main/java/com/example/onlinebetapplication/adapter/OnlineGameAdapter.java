package com.example.onlinebetapplication.adapter;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinebetapplication.R;
import com.example.onlinebetapplication.livegame_properties.Root1;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class OnlineGameAdapter extends RecyclerView.Adapter<OnlineGameAdapter.ViewHolder> {
    List<Root1> getLiveGames;
    public OnlineGameAdapter(List<Root1> getLiveGames){
        this.getLiveGames = getLiveGames;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.livescore_row,parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("Team name:", getLiveGames.get(position).getHomeTeam());
        if(getLiveGames.get(position).getCompleted() == false){
            if(getLiveGames.get(position).getScores().get(0).getScore() == null || getLiveGames.get(position).getScores().get(1).getScore() == null){
                holder.home_team.setTextColor(Color.rgb(255,0,0));
                holder.away_team.setTextColor(Color.rgb(255,0,0));
                holder.home_team_score.setTextColor(Color.rgb(255,0,0));
                holder.away_team_score.setTextColor(Color.rgb(255,0,0));
                holder.container1.setStrokeColor(Color.rgb(255,92,0));
                holder.container2.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.BLUE, Color.rgb(255,92,0)}));
                holder.home_team.setText(getLiveGames.get(position).getHomeTeam());
                holder.away_team.setText(getLiveGames.get(position).getAwayTeam());
                holder.home_team_score.setText("");
                holder.away_team_score.setText("");
            }
            else{
                holder.home_team.setTextColor(Color.rgb(114,199,84));
                holder.away_team.setTextColor(Color.rgb(114,199,84));
                holder.home_team_score.setTextColor(Color.rgb(114,199,84));
                holder.away_team_score.setTextColor(Color.rgb(114,199,84));
                holder.container1.setStrokeColor(Color.rgb(66,255,0));
                holder.container2.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.BLUE, Color.rgb(66,255,0)}));
                holder.home_team.setText(getLiveGames.get(position).getHomeTeam());
                holder.home_team_score.setText(String.valueOf(getLiveGames.get(position).getScores().get(0).getScore()));
                holder.away_team.setText(getLiveGames.get(position).getAwayTeam());
                holder.away_team_score.setText(getLiveGames.get(position).getScores().get(1).getScore());
            }
        }
        else {
            Log.d("Team name1:", getLiveGames.get(position).getHomeTeam());
            holder.home_team.setTextColor(Color.rgb(0,0,0));
            holder.away_team.setTextColor(Color.rgb(0,0,0));
            holder.home_team_score.setTextColor(Color.rgb(0,0,0));
            holder.away_team_score.setTextColor(Color.rgb(0,0,0));
            holder.container1.setStrokeColor(Color.rgb(108,108,108));
            holder.container2.setBackgroundTintList(new ColorStateList(new int[][]{new int[]{-android.R.attr.state_enabled}, new int[]{android.R.attr.state_enabled}},new int[]{Color.BLUE, Color.rgb(108,108,108)}));
            holder.home_team.setText(getLiveGames.get(position).getHomeTeam());
            holder.home_team_score.setText(String.valueOf(getLiveGames.get(position).getScores().get(0).getScore()));
            holder.away_team.setText(getLiveGames.get(position).getAwayTeam());
            holder.away_team_score.setText(String.valueOf(getLiveGames.get(position).getScores().get(1).getScore()));
        }
    }

    @Override
    public int getItemCount() {
        return getLiveGames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView home_team, away_team, home_team_score, away_team_score;
        private CardView container2;
        private MaterialCardView container1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            container1 = itemView.findViewById(R.id.container1);
            container2 = itemView.findViewById(R.id.container2);
            home_team = itemView.findViewById(R.id.hm_team_id);
            away_team = itemView.findViewById(R.id.wy_team_id);
            home_team_score = itemView.findViewById(R.id.hm_score_id);
            away_team_score = itemView.findViewById(R.id.wy_score_id);
        }
    }
}
