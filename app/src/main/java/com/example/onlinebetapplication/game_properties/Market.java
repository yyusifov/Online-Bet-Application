package com.example.onlinebetapplication.game_properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Market {
    private String key;
    private String lastUpdate;
    private List<Outcome> outcomes = new ArrayList<Outcome>();
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public List<Outcome> getOutcomes() {
        return outcomes;
    }
    public void setOutcomes(List<Outcome> outcomes) {
        this.outcomes = outcomes;
    }
}
