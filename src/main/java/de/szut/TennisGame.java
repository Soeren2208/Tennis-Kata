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

        if(isWin()){
            result = "Game " + getPlayerNameWhoscoredMore();
        }
        else if(isDeuce()){
            result = "Deuce";
        }
        else if(isDraw()){
            result = this.scoreMap.get(this.pointsServicePlayer)+ " all";
        }
        else if(isAdvantage()){
            result = "Advantage "+ getPlayerNameWhoscoredMore();
        }
        else{
            result = this.scoreMap.get(this.pointsServicePlayer) + " " + this.scoreMap.get(this.pointsReturnPlayer);
        }
        return result;
    }

    private boolean isAdvantage(){
        return Math.abs(this.pointsServicePlayer - this.pointsReturnPlayer)==1 && this.pointsServicePlayer>=3;
    }

    private boolean isDeuce() {
        return this.pointsServicePlayer == this.pointsReturnPlayer && this.pointsServicePlayer>=3;
    }

    private String getPlayerNameWhoscoredMore() {
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
        return isWinAfterAdvantage() || isNormalWin();
    }

    private boolean isWinAfterAdvantage() {
        return Math.abs(this.pointsServicePlayer - this.pointsReturnPlayer) >=2 && (this.pointsServicePlayer >=4 || this.pointsReturnPlayer>=4);
    }

    private boolean isNormalWin() {
        return this.pointsServicePlayer ==4 && this.pointsReturnPlayer <=2 || (this.pointsServicePlayer <=2 && this.pointsReturnPlayer ==4);
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
