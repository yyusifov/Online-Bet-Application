package com.example.onlinebetapplication;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class BetSingleton extends Application {
    private static BetSingleton betSingleton;
    private RequestQueue requestQueue;

    public synchronized static BetSingleton getBetSingleton(){
        return betSingleton;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if(betSingleton == null){
            betSingleton = this;
        }
    }
}
