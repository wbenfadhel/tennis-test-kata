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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Map<Integer, String> getPossibleScores() {
        return possibleScores;
    }

    public void setPossibleScores(Map<Integer, String> possibleScores) {
        this.possibleScores = possibleScores;
    }

    public String getCurrentGameStatus() {
        return currentGameStatus;
    }

    public void setCurrentGameStatus(String currentGameStatus) {
        this.currentGameStatus = currentGameStatus;
    }
}

