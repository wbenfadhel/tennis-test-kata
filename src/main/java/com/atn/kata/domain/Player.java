package com.atn.kata.domain;


import java.util.List;
import java.util.Objects;


public class Player {


        private String name;
        private List<Game> games;
        private List<Set> sets;
        private int score;
        private int setScore;
        private int winnedGames;
        private int winnedSets;

        public Player(String name, List<Game> games,List<Set> sets, int score,int setScore) {
                this.name = name;
                this.games = games;
                this.sets=sets;
                this.score = score;
                this.setScore=setScore;
        }

        public int getScore() {
                return score;
        }

        public void setScore(int score) {
                this.score = score;
        }
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public List<Game> getGames() {
                return games;
        }

        public void setGames(List<Game> games) {
                this.games = games;
        }


        public int getWinnedGames() {
                return winnedGames;
        }

        public void setWinnedGames(int winnedGames) {
                this.winnedGames = winnedGames;
        }

        public int getWinnedSets() {
                return winnedSets;
        }

        public void setWinnedSets(int winnedSets) {
                this.winnedSets = winnedSets;
        }

        public List<Set> getSets() {
                return sets;
        }

        public void setSets(List<Set> sets) {
                this.sets = sets;
        }

        public int getSetScore() {
                return setScore;
        }

        public void setSetScore(int setScore) {
                this.setScore = setScore;
        }

        public boolean isWinner(){
                return this.getWinnedSets()>=3;
        }



        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Player player = (Player) o;
                return Objects.equals(name, player.name) &&
                        Objects.equals(games, player.games);
        }

        @Override
        public int hashCode() {
                return Objects.hash(name, games);
        }
}

