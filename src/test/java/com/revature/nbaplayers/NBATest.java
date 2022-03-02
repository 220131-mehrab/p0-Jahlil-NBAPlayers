package com.revature.nbaplayers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NBATest {
    FileManipulator nba = new FileManipulator("nba2021advanced.csv");
    List<String> players = new ArrayList<>();

    private void load(){
        Scanner scanner = new Scanner(this.nba.getFile());
        scanner.useDelimiter("\n");
        while (scanner.hasNext()){
            this.players.add(scanner.next());
        }
    }

    public String getPlayer(String name){
        String result = new String();
        for (String player : this.players){
            if (player.contains(name)){
                result = player;
            }
        }
        return result;
    }
}
