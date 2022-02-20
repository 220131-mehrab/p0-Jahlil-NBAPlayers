package com.revature.nbaplayers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NBARepository {
    private List<String> players;
    private File file;
    public NBARepository(String filename){
        this.players = new ArrayList<>();
        this.file = new File("src/main/resources/" + filename);
        load();
    }

    private void load() {
        try {
            Scanner scanner = new Scanner(this.file);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()){
                this.players.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<String> getPlayers() {
        return players;
    }
}
