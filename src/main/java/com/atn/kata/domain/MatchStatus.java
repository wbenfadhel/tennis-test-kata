package com.atn.kata.domain;

public enum MatchStatus {
    WINS("wins"),IN_PROGRESS("In progress");

    private String value;

    MatchStatus(String value){
        this.value=value;
    }

    public String getValue(){
        return this.value;
    }
}
