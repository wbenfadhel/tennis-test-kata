package com.atn.kata.domain;


import java.util.HashMap;
import java.util.Map;

public class Game {

    private Player player1;
    private Player player2;
    private  Match match;


    private Map<Integer,String> possibleScores= new HashMap<>();
    private String currentGameStatus;

    public Game(Match match) {
        this.match = match;
        this.player1=match.getPlayer1();
        this.player2=match.getPlayer2();
        match.getPlayer1().setScore(0);
        match.getPlayer2().setScore(0);
        this.currentGameStatus=GameStatus.START.getValue();
    }

    public void incrementPlayer(Player player){
        Integer score=player.getScore();
        score=incrementScore(score);
        if(player.equals(player1)){player1.setScore(score);}
        else{player2.setScore(score);}
        getCurrentGameStatus();
    }

    public String getCurrentGameStatus(){
        Integer score1= player1.getScore();
        Integer score2= player2.getScore();

        if(score1>=40 || score2>=40){
            if(Math.abs(score2-score1)==0){
                currentGameStatus=GameStatus.DEUCE.getValue();
            }else if(Math.abs(score2-score1)==10){
                currentGameStatus=GameStatus.ADVANTAGE.getValue();
            }else {
                currentGameStatus=GameStatus.WINNED.getValue();
            }
        }else{
            currentGameStatus="("+score1+"-"+score2+")";
        }

        return currentGameStatus;

    }

    private Integer incrementScore(Integer score){
        switch (score){
            case 0: score=15; break;
            case 15:score=30; break;
            case 30:score=40; break;
            case 40: score=50; break;
            case 50: score=60; break;
        }
        return score;
    }

    public void getPossibleScores(){
        possibleScores.put(0,"0");
        possibleScores.put(1,"15");
        possibleScores.put(2,"30");
        possibleScores.put(3,"40");
    }



    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public void getWinnerOfTheGame(){

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

