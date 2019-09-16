package com.atn.kata.domain;


import java.util.ArrayList;
import java.util.List;

public class Match {

      private List<Game> games;
      private List<Set> sets;
      private Player player1;
      private Player player2;
      private String matchStatus;
      private List<String> finalScore= new ArrayList<>();

    public Match(Player player1, Player player2,List<Game> games, List<Set> sets) {
        this.player1 = player1;
        this.player2 = player2;
        this.games=games;
        this.sets=sets;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
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

    public String getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.matchStatus = matchStatus;
    }

    public List<String> getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(List<String> finalScore) {
        this.finalScore = finalScore;
    }
}

