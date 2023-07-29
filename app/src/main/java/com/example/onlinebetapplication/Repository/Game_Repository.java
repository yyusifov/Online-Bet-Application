package com.example.onlinebetapplication.Repository;



import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;

import com.android.volley.toolbox.JsonArrayRequest;

import com.example.onlinebetapplication.BetSingleton;
import com.example.onlinebetapplication.game_properties.Bookmaker;
import com.example.onlinebetapplication.game_properties.Market;
import com.example.onlinebetapplication.game_properties.Outcome;
import com.example.onlinebetapplication.game_properties.Root;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Game_Repository {
    private List<Root> allGames = new ArrayList<>();
    public void getAllGames(String url, SaveGameList saveGameList){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++){
                    try {
                        JSONObject jsonObjectRequest = response.getJSONObject(i);
                        Root root = new Root();
                        root.setSportTitle(jsonObjectRequest.getString("sport_title"));
                        root.setCommenceTime(jsonObjectRequest.getString("commence_time"));
                        root.setHomeTeam(jsonObjectRequest.getString("home_team"));
                        root.setAwayTeam(jsonObjectRequest.getString("away_team"));
                        root.setId(jsonObjectRequest.getString("id"));
                        root.setSportKey(jsonObjectRequest.getString("sport_key"));
                        JSONArray jsonArray = jsonObjectRequest.getJSONArray("bookmakers");
                        List<Bookmaker> getBookmakers = new ArrayList<>();
                        for(int j = 0; j < jsonArray.length(); j++){
                            Bookmaker bookmaker = new Bookmaker();
                            List<Market> marketList = new ArrayList<>();
                            JSONArray jsonArray1 = jsonArray.getJSONObject(j).getJSONArray("markets");
                            for(int h = 0; h < jsonArray1.length(); h++){
                                Market market = new Market();
                                List<Outcome> outcomes = new ArrayList<>();
                                JSONArray jsonArray2 = jsonArray1.getJSONObject(h).getJSONArray("outcomes");
                                for(int k = 0; k < jsonArray2.length(); k++) {
                                    Outcome outcome = new Outcome();
                                    Log.d("Club name", "" + jsonArray2.getJSONObject(k).getString("name"));
                                    Log.d("Bet rate", "" + jsonArray2.getJSONObject(k).getString("price"));
                                    outcome.setName(jsonArray2.getJSONObject(k).getString("name"));
                                    outcome.setPrice(jsonArray2.getJSONObject(k).getDouble("price"));
                                    outcomes.add(outcome);
                                }
                                market.setOutcomes(outcomes);
                                marketList.add(market);
                            }
                            bookmaker.setMarkets(marketList);
                            getBookmakers.add(bookmaker);
                        }
                        root.setBookmakers(getBookmakers);
                        allGames.add(root);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                saveGameList.getGameList(allGames);
            }
        }, error -> {}
        );
        BetSingleton.getBetSingleton().addToRequestQueue(jsonArrayRequest);
    }
}
