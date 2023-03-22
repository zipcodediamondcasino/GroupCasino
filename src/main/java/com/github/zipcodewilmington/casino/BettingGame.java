package com.github.zipcodewilmington.casino;

public interface BettingGame {

    /**
     * Makes the bet taking the money from the player assuming they have the amount
     * @param player the player who is betting
     * @param amount the amount to be bet
     * @param minimum the minimum amount a player can bet
     * @return false if the player does not have the funds
     */
    public boolean bet(Player player, int amount, int minimum);
}
