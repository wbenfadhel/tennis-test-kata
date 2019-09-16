package com.atn.kata.domain;

public class Set {

    private Match match;
    private Player player1;
    private Player player2;
    private String currentSetStatus;

    public Set(Match match) {
        this.match = match;

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

    public String getCurrentSetStatus() {
        return currentSetStatus;
    }

    public void setCurrentSetStatus(String currentSetStatus) {
        this.currentSetStatus = currentSetStatus;
    }
}
