package com.github.zipcodewilmington.casino.games.coinflip;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;


import java.util.ArrayList;
import java.util.Scanner;

public class CoinFlipGame implements Game {
    static Scanner scanner = new Scanner(System.in);
    CasinoAccount acc = new CasinoAccount();
    CoinFlipPlayer player = new CoinFlipPlayer(acc);


    @Override
    public void add(Player player) {

    }

    @Override
    public void remove(Player player) {

    }

    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

    @Override
    public void run() {
        boolean play = true;
        while (play) {
            System.out.println("How much would you like to bet on a coin flip?");
            int playerBet = scanner.nextInt();
            System.out.println("Heads or Tails?");
            String playerGuess = scanner.next();
            displayResult(playerGuess);
            System.out.println("\nWould you like to stay or leave?");
            String stayOrLeave = scanner.next();
            if (stayOrLeave.equals( "leave")){
                play = false;
            }
        }


    }

    public void bet() {

    }
    public void displayResult(String playerGuess) {
        String fli = flip();
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

