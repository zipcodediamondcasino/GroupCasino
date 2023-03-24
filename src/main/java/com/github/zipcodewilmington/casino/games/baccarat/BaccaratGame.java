package com.github.zipcodewilmington.casino.games.baccarat;

import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;

public class BaccaratGame implements Game {
    ArrayList<Player> players = new ArrayList<>();


    @Override
    public void add(Player player) {
        players.add(player);
    }

    @Override
    public void remove(Player player) {
        players.remove(player);
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return players;
    }

    @Override
    public void run() {

    }
}
