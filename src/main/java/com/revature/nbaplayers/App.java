package com.revature.nbaplayers;

import com.revature.nbaplayers.repository.NBARepository;
import com.revature.nbaplayers.server.NBAServer;
import com.revature.nbaplayers.service.NBAService;

public class App {
    public static void main(String[] args){
        NBARepository nbaRepository = new NBARepository("nba2021advanced.csv");
        NBAService nbaService = new NBAService(nbaRepository);
        NBAServer server = new NBAServer(nbaService);
    }
}
