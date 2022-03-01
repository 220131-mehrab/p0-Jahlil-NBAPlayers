package com.revature.nbaplayers.repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NBARepository {
    private List<String> players;
    private InputStream file;

    public NBARepository(String filename){
        this.players = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
        load();
    }

    private void load() {
        Scanner scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()){
            this.players.add(scanner.next());
        }
    }

    public List<String> getPlayers() {
        return players;
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

    public List<String> getTeam(String teamName){
        List<String> result = new ArrayList<>();
        for (String player : this.players){
            if (player.contains(teamName)){
                result.add(player);
            }
        }
        return result;
    }

    public List<String> getPositions(String positionName){
        List<String> result = new ArrayList<>();
        for (String player : this.players){
            if (player.contains(positionName)){
                result.add(player);
            }
        }
        return result;
    }
}
