package com.revature.nbaplayers;

public class App {
    public static void main(String[] args){
        NBARepository nbaRepository = new NBARepository("nba2021advanced.csv");
        NBAService nbaService = new NBAService(nbaRepository);
        //PlayerService nbaPlayers = new PlayerService(nbaRepository);
        NBAServer server = new NBAServer(nbaService);
    }
}
