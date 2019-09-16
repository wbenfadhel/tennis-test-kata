package com.atn.kata.domain;

public class Set {

    private Match match;
    private Player player1;
    private Player player2;
    private String currentSetStatus;

    public Set(Match match) {
        this.match = match;
        this.player1=match.getPlayer1();
        this.player2=match.getPlayer2();
        match.getPlayer1().setSetScore(0);
        match.getPlayer2().setSetScore(0);
        this.currentSetStatus="start";
    }

    public void incrementPlayer(Player player){
        int setScore=player.getSetScore();
        setScore++;
        if(player.equals(player1)){player1.setSetScore(setScore);}
        else{player2.setSetScore(setScore);}
        getCurrentSetStatus();
    }


    @Override
    public String toString() {
        return  "("+player1.getSetScore() +"-"+player2.getSetScore()+")";

    }

    public String getCurrentSetStatus(){
        int setScore1= player1.getSetScore();
        int setScore2= player2.getSetScore();

        if(setScore1>=6 || setScore2>=6){
            if(Math.abs(setScore2-setScore1)==0){
                currentSetStatus="deuce";
            }else if(Math.abs(setScore2-setScore1)==1){
                currentSetStatus="advantage";
            }else {
                currentSetStatus="closed";
            }
        }else{
            currentSetStatus="("+setScore1+"-"+setScore2+")";
        }

        return currentSetStatus;

    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
