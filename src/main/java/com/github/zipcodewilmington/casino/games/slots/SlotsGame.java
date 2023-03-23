package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.BettingGame;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;
import java.util.Random;

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
        if(this.player == player){
            this.player = null;
        }
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
        if(amount < minimum){
            return false;
        }else if(amount>player.casinoAccount.getBalance()){
            return false;
        }else{
            player.casinoAccount.setBalance(player.casinoAccount.getBalance()-amount);
            this.pool = amount;
            return true;
        }
    }

    public int resolve(int[] ints) {
        
        return 0;
    }

    public int[] pull() {
        Random rand = new Random();
        int slot1 = 0;
        int slot2 = 0;
        int slot3 = 0;

        try {
            for (int i = 35; i <= 100; i++) {
                Thread.sleep(80);
                if (i < 66) {
                    slot1 = rand.nextInt(9) + 1;

                }
                if (i < 80) {
                    slot2 = rand.nextInt(9) + 1;
                }
                slot3 = rand.nextInt(9) + 1;
                System.out.print("[" + slot1 + "]" + "[" + slot2 + "]" + "[" + slot3 + "]\r");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}

