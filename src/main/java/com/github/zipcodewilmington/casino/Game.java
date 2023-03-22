package com.github.zipcodewilmington.casino;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public interface Game extends Runnable {
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    void add(Player player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    void remove(Player player);

    /**
     * 
     * @return list of players
     */
    ArrayList<Player> getPlayers();

    /**
     * specifies how the game will run
     */
    void run();
}
