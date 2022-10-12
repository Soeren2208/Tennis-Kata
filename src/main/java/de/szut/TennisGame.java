package de.szut;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    String servicePlayer;
    String returnPlayer;
    int pointsServicePlayer;
    int pointsReturnPlayer;

    private Map<Integer, String> scoreMap;

    public TennisGame(String playerToServe, String playerToReturn){
        this.servicePlayer = playerToServe;
        this.returnPlayer = playerToReturn;
        this.pointsServicePlayer = 0;
        this.pointsReturnPlayer = 0;
        this.scoreMap = new HashMap<Integer, String>();
        fillScoreMap();
    }

    private void fillScoreMap(){
        this.scoreMap.put(0, "love");
        this.scoreMap.put(1, "15");
        this.scoreMap.put(2, "30");
        this.scoreMap.put(3, "40");
    }

    public String getResult() {
        String result = translateScore();
        return result;
    }

    private String translateScore() {
        String result="";
        if(this.pointsServicePlayer==0 && this.pointsReturnPlayer==0){
            result = "Love all";
        }
        else{
            result = this.scoreMap.get(this.pointsServicePlayer) + " " + this.scoreMap.get(this.pointsReturnPlayer);
        }
        return result;

    }

    public void makePoint(String playerName) {
        if(playerName.equals(this.servicePlayer)){
            this.pointsServicePlayer++;
        }
        else if(playerName.equals(this.returnPlayer)){
            this.pointsReturnPlayer++;
        }
        else{
            throw new IllegalArgumentException("Wrong playername!");
        }
    }
}
