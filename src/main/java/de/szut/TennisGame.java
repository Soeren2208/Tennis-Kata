package de.szut;

public class TennisGame {

    String servicePlayer;
    String returnPlayer;
    int pointsServicePlayer;
    int pointsReturnPlayer;

    public TennisGame(String playerToServe, String playerToReturn){
        this.servicePlayer = playerToServe;
        this.returnPlayer = playerToReturn;
        this.pointsServicePlayer = 0;
        this.pointsReturnPlayer = 0;
    }

    public String getResult() {
        String result = "Love all";
        if(this.pointsServicePlayer==1 && this.pointsReturnPlayer==0){
            result = "15 love";
        }
        return result;
    }

    public void makePoint(String playerName) {
        if(playerName.equals(this.servicePlayer)){
            this.pointsServicePlayer++;
        }
    }
}
