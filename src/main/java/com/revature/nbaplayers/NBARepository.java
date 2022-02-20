package com.revature.nbaplayers;

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
}
