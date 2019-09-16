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

    public void setMatchStatus(Player player) {
        if(finalScore.size()>=3){
            this.matchStatus=player.getName()+" "+MatchStatus.WINS.getValue();
        }else {
            this.matchStatus = MatchStatus.IN_PROGRESS.getValue();
        }
    }

    public Game getLastGame(){
        return this.games.get(games.size()-1);
    }

    public Set getLastSet(){
        return this.sets.get(sets.size()-1);
    }

    public String getScore(String action){
        //init players for a new set
         String toReturn="("+player1.getGames().size()+"-"+player2.getGames().size()+")";
         if("INIT".equals(action)){
             player1.setWinnedGames(0);
             player2.setWinnedGames(0);
             player1.setGames(new ArrayList<>());
             player2.setGames(new ArrayList<>());}
        return toReturn;
    }

    public List<Set> getSets() {
        if(sets!= null){return sets;}
        else{return new ArrayList<>();
        }
    }

    public List<String> getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(List<String> finalScore) {
        this.finalScore = finalScore;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }


    public String getSetsAsString(){
        String result="";
        for (Set s:sets) {
            result=result+s.toString();
        }
        return result;
    }


    public Player getGameWinner(){
       int  winnedGames1=player1.getWinnedGames();
       int  winnedGames2= player2.getWinnedGames();
       if(winnedGames1>=6 || winnedGames2>=6){
           //tie break
           if(winnedGames1==7){return player1;}
           if(winnedGames2==7){return player2;}
           //deux points de différence
           if(winnedGames1-winnedGames2>=2){
               player1.setWinnedGames(0);
               player2.setWinnedGames(0);
               return player1;
           }else if(winnedGames2-winnedGames1>=2){
               player1.setWinnedGames(0);
               player2.setWinnedGames(0);
               return player2;
           }else{return null;}
       }
        return  null;
    }
}

