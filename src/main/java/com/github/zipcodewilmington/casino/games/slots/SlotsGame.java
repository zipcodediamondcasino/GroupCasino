package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.BettingGame;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements Game, BettingGame {

    SlotsPlayer player;
    int pool;

    @Override
    public void add(Player player) {
        this.player = (SlotsPlayer) player;
    }

    @Override
    public void remove(Player player) {

    }

    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> player = new ArrayList<>();
        player.add(this.player);
        return player;
    }

    @Override
    public void run() {

    }

    @Override
    public boolean bet(Player player, int amount, int minimum) {
        return false;
    }

    public int resolve(int[] ints) {
        return 0;
    }

    public int[] pull() {
        return null;
    }
}
