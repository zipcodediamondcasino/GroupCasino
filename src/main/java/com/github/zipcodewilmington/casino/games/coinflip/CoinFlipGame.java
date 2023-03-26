package com.github.zipcodewilmington.casino.games.coinflip;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;


import java.util.ArrayList;
import java.util.Scanner;

public class CoinFlipGame implements Game {

    CoinFlipPlayer player;
    int pool;
    String fli;

    @Override
    public void add(Player player) {
this.player = (CoinFlipPlayer) player;
    }

    @Override
    public void remove(Player player) {
        if (this.player == player) {
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
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play) {
            System.out.println("How much would you like to bet on a coin flip?");
            int playerBet = scanner.nextInt();
            bet(this.player, playerBet, 1);
            System.out.println("Heads or Tails?");
            String playerGuess = scanner.next();
            displayResult(playerGuess);
            if (playerGuess.equals(fli)) {
                this.player.getCasinoAccount().setBalance((this.player.getCasinoAccount().getBalance() + (playerBet * 2)));
            }
            System.out.println("\nWould you like to stay or leave?");
            String stayOrLeave = scanner.next();
            if (stayOrLeave.equals( "leave")){
                play = false;
            }
        }
    }
    public boolean bet(Player player, int amount, int minimum) {
        if (amount < minimum) {
            System.out.println("$1 is the minimum bet");
            return false;
        } else if (amount > player.getCasinoAccount().getBalance()) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            player.getCasinoAccount().setBalance(player.getCasinoAccount().getBalance() - amount);
            this.pool = amount;
            return true;
        }
    }
    public void displayResult(String playerGuess) {
        this.fli = flip();
        if (playerGuess.equals(fli)) {
            System.out.println("It was " + fli + ".\nYou Win!");
        } else {
            System.out.println("It was " + fli + ".\nBetter luck next time.");
        }
    }
    public String flip() {
        int result = (int) (Math.random() * 2);
        if (result == 1) {
            return "Heads";
        }
            else {
                return "Tails";
        }
    }
}

