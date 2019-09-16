package com.atn.kata.domain;

public enum GameStatus {
    DEUCE("Deuce"),ADVANTAGE("Advantage"),WINNED("Winned"),START("Start");

    private String value;

    GameStatus(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }
}
