package com.atn.kata.services;

import com.atn.kata.domain.*;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class TennisGameServiceTest {

    @Autowired
    private TennisGameService tennisGameService;



    private Match initializeMatch(){
        Player player1= new Player("Player1",new ArrayList<>(),new ArrayList<>(),0,0);
        Player player2= new Player("Player2",new ArrayList<>(),new ArrayList<>(),0,0);
        List<Game> listGames= new ArrayList<>();
        List<Set>  listSets= new ArrayList<>();
        Match match =new Match(player1,player2,listGames,listSets);
        Game g = new Game(match);
        Set  s= new Set(match);
        match.getGames().add(g);
        match.getSets().add(s);
        return match;
    }

    private void printResult(Match match){
        System.out.println("Player 1:"+ match.getPlayer1().getName());
        System.out.println("Player 2:"+ match.getPlayer2().getName());
        System.out.println("Score :"+match.getFinalScore()+match.getScore("NOINT"));
        System.out.println("Current game status:"+ match.getLastGame().getCurrentGameStatus());
        System.out.println("Match Status: " +match.getMatchStatus());
        System.out.println(match);
    }


    @Test
    void firstCaseKataStatusTest(){
        //initialise match
        Match match=initializeMatch();
        //match begins
        // reproduce the first example of kata
        // simulate the first set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(3, match.getPlayer2(),match);
        match=addPoints(3, match.getPlayer1(),match);
        //simulate the second set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(5*3, match.getPlayer2(),match);
        match=addPoints(2*3, match.getPlayer1(),match);
        //similate the third set
        match=addPoints(4, match.getPlayer1(),match);
        match=addPoints(2, match.getPlayer2(),match);
        Assert.check("(15-30)".equals(match.getLastGame().getCurrentGameStatus()));
        Assert.check(MatchStatus.IN_PROGRESS.getValue().equals(match.getMatchStatus()));
        //Print match result
        printResult(match);
    }

    @Test
    void secondCaseKataDeuceTest(){
        //initialise match
        Match match=initializeMatch();
        //match begins
        // reproduce the first example of kata
        // simulate the first set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(3, match.getPlayer2(),match);
        match=addPoints(3, match.getPlayer1(),match);
        //simulate the second set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(5*3, match.getPlayer2(),match);
        match=addPoints(2*3, match.getPlayer1(),match);
        //simulate the third set
        match=addPoints(2, match.getPlayer1(),match);
        match=addPoints(2, match.getPlayer2(),match);
        match=addPoints(1, match.getPlayer1(),match);
        match=addPoints(1, match.getPlayer2(),match);

        Assert.check(GameStatus.DEUCE.getValue().equals(match.getLastGame().getCurrentGameStatus()));
        Assert.check(MatchStatus.IN_PROGRESS.getValue().equals(match.getMatchStatus()));
        //Print match result
        printResult(match);
    }

    @Test
    void thirdCaseKataAdvantageTest(){
        //initialise match
        Match match=initializeMatch();
        //match begins
        // reproduce the first example of kata
        // simulate the first set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(3, match.getPlayer2(),match);
        match=addPoints(3, match.getPlayer1(),match);
        //simulate the second set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(5*3, match.getPlayer2(),match);
        match=addPoints(2*3, match.getPlayer1(),match);
        //simulate the third set
        match=addPoints(2, match.getPlayer1(),match);
        match=addPoints(2, match.getPlayer2(),match);
        match=addPoints(1, match.getPlayer1(),match);

        Assert.check(GameStatus.ADVANTAGE.getValue().equals(match.getLastGame().getCurrentGameStatus()));
        Assert.check(MatchStatus.IN_PROGRESS.getValue().equals(match.getMatchStatus()));
        //Print match result
        printResult(match);
    }

    @Test
    void forthCaseKataPlayer1WinsTest(){
        //initialise match
        Match match=initializeMatch();
        //match begins
        // reproduce the first example of kata
        // simulate the first set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(3, match.getPlayer2(),match);
        match=addPoints(3, match.getPlayer1(),match);
        //simulate the second set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(5*3, match.getPlayer2(),match);
        match=addPoints(2*3, match.getPlayer1(),match);
        //simulate the third set
        match=addPoints(6*3, match.getPlayer1(),match);

        Assert.check(match.getMatchStatus().equals("Player1 "+MatchStatus.WINS.getValue()));
        //Print match result
        printResult(match);
    }


    @Test
    void fifthCaseKataPlayer2WinsTest(){
        //initialise match
        Match match=initializeMatch();
        //match begins
        // reproduce the first example of kata
        // simulate the first set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(3, match.getPlayer2(),match);
        match=addPoints(3, match.getPlayer1(),match);
        //simulate the second set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(5*3, match.getPlayer2(),match);
        match=addPoints(2*3, match.getPlayer1(),match);
        //simulate the third set
        match=addPoints(2*3, match.getPlayer1(),match);
        match=addPoints(6*3, match.getPlayer2(),match);
        //simulate fourth set
        match=addPoints(5*3, match.getPlayer1(),match);
        match=addPoints(7*3, match.getPlayer2(),match);
        //simulate fifth set
        match=addPoints(4*3, match.getPlayer1(),match);
        match=addPoints(6*3, match.getPlayer2(),match);
        Assert.check(match.getMatchStatus().equals("Player2 "+MatchStatus.WINS.getValue()));

        //Print match result
        printResult(match);
    }




    private Match addPoints(Integer numberOfPoints, Player player,Match match){
        for (int i = 0; i < numberOfPoints; i++) {
            match=tennisGameService.addPoint(match,player);
        }
        return match;
    }

}