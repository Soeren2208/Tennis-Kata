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
        this.scoreMap = new HashMap<>();
        fillScoreMap();
    }

    private void fillScoreMap(){
        this.scoreMap.put(0, "love");
        this.scoreMap.put(1, "15");
        this.scoreMap.put(2, "30");
        this.scoreMap.put(3, "40");
    }

    public String getResult() {
        return translateScore();
    }

    private String translateScore() {
        String result;
        if(isDraw()){
            result = this.scoreMap.get(this.pointsServicePlayer)+ " all";
        }
        else if(isWin()){
            result = "Game " + getWinPlayerName();
        }
        else{
            result = this.scoreMap.get(this.pointsServicePlayer) + " " + this.scoreMap.get(this.pointsReturnPlayer);
        }
        return result;
    }

    private String getWinPlayerName() {
        if(this.pointsServicePlayer> this.pointsReturnPlayer){
            return this.servicePlayer;
        }
        else{
            return this.returnPlayer;
        }
    }

    private boolean isDraw(){
        return this.pointsServicePlayer == this.pointsReturnPlayer && this.pointsServicePlayer<=3;
    }

    private boolean isWin(){
        return this.pointsServicePlayer ==4 && this.pointsReturnPlayer<3 || this.pointsServicePlayer <3 && this.pointsReturnPlayer==4;
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
