package com.example.onlinebetapplication.Repository;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.onlinebetapplication.BetSingleton;
import com.example.onlinebetapplication.livegame_properties.Root1;
import com.example.onlinebetapplication.livegame_properties.Score;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Live_Game_Repository {
    private List<Root1> getLiveGames = new ArrayList<>();
    public void getAllLiveGames(String url, SaveLiveGameList saveLiveGameList){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            for(int i = 0; i < response.length(); i++){
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    Root1 root1 = new Root1();
                    root1.setSportTitle(jsonObject.getString("sport_title"));
                    root1.setSportKey(jsonObject.getString("sport_key"));
                    root1.setId(jsonObject.getString("id"));
                    root1.setHomeTeam(jsonObject.getString("home_team"));
                    Log.d("home_team", root1.getHomeTeam());
                    root1.setAwayTeam(jsonObject.getString("away_team"));
                    Log.d("away_team", root1.getAwayTeam());
                    root1.setCompleted(jsonObject.getBoolean("completed"));
                    root1.setLastUpdate(jsonObject.getString("last_update"));
                    root1.setCommenceTime(jsonObject.getString("commence_time"));
                    List<Score> scoreList = new ArrayList<>();
                    Score score = new Score();
                    score.setName(root1.getHomeTeam());
                    scoreList.add(score);
                    score.setName(root1.getAwayTeam());
                    scoreList.add(score);
                    root1.setScores(scoreList);
                    getLiveGames.add(root1);
                    Log.d("Hi", String.valueOf(getLiveGames.size()));
                    JSONArray jsonArray = jsonObject.getJSONArray("scores");
                    if(jsonObject.getJSONArray("scores") != null){
                        scoreList.clear();
                    }
                    for (int j = 0; j < jsonArray.length(); j++) {
                        Score score1 = new Score();
                        score1.setName(jsonArray.getJSONObject(j).getString("name"));
                        score1.setScore(jsonArray.getJSONObject(j).getString("score"));
                        scoreList.add(score1);
                        Log.d("score567", score.getScore() + " " + score.getName());
                    }
                    root1.setScores(scoreList);
                    Log.d("scoresize", scoreList.size() + "");
                    Log.d("score900", scoreList.get(0).getScore() + " " + scoreList.get(1).getScore());

                    Log.d("score467", String.valueOf(getLiveGames.get(i).getScores().get(0).getScore()));
                    getLiveGames.remove(i);
                    getLiveGames.add(root1);
                    Log.d("score4671", String.valueOf(getLiveGames.get(i).getScores().get(0).getScore()));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            saveLiveGameList.getLiveGameList(getLiveGames);
        }, error -> {
        });
        BetSingleton.getBetSingleton().addToRequestQueue(jsonArrayRequest);
    }
}
