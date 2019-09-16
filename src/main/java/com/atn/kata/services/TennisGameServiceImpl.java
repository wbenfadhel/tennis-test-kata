package com.atn.kata.services;


import com.atn.kata.domain.Game;
import com.atn.kata.domain.GameStatus;
import com.atn.kata.domain.Match;
import com.atn.kata.domain.Player;
import org.springframework.stereotype.Service;

@Service
public class TennisGameServiceImpl implements TennisGameService {

    private Match match;




      @Override
      public Match addPoint(Match match, Player player){

        //add point to player
        Game lastGame= match.getLastGame();
        lastGame.incrementPlayer(player);
        //one of the players has won the game
        //add the game to the object player than increment player's winned Set
        if(GameStatus.WINNED.getValue().equals(lastGame.getCurrentGameStatus())){
          player.getGames().add(lastGame);
          Integer winnedGames=player.getWinnedGames();
          winnedGames++;
          player.setWinnedGames(winnedGames);
          //open another game
          Game g = new Game(match);
          match.getGames().add(g);
          //check if the player won the game
          if(match.getGameWinner()!=null){
            //check if player wins the match
            match.getFinalScore().add(match.getScore("INIT"));
            match.setMatchStatus(player);
          };
        }

        return lastGame.getMatch();
      }

















}
