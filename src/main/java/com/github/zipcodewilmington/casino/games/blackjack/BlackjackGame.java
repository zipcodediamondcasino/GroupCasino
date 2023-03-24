package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackHand;


import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame implements Game, BettingGame {
    BlackjackPlayer player;
    int pool;
    BlackjackHand playerHand = new BlackjackHand();
    BlackjackHand dealerHand = new BlackjackHand();

    @Override
    public void add(Player player) {
        this.player = (BlackjackPlayer) player;
    }


    //
    @Override
    public void remove(Player player) {
        if (this.player == player) {
            this.player = null;
        }

    }

    //
    @Override
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> player = new ArrayList<>();
        player.add(this.player);
        return player;
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        String command;
        int val;
        while (true) {
            System.out.println("Would you like to play Blackjack?\n1 Yes\n2 leave");
            command = in.next().trim();
            if (command.equals("1")) {
                try {
                    System.out.println("Please enter how much you would like to wager?");
                    val = in.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number\n");
                    continue;
                }
                if (bet(this.player, val, 5)) {
                    this.player.getCasinoAccount().setBalance(this.player.getCasinoAccount().getBalance());
                    gameStart();
                }
            } else if (command.equals("2")) {
                remove(this.player);
                break;
            } else {
                System.out.println("Please enter a valid command");
            }
        }
    }

    @Override
    public boolean bet(Player player, int amount, int minimum) {
        if (amount < minimum) {
            System.out.println("$5 is the minimum bet.");
            return false;
        } else {
            player.getCasinoAccount().setBalance(player.getCasinoAccount().getBalance() - amount);
            this.pool = amount;
            return true;
        }
    }


    private void gameStart() {
        Scanner in = new Scanner(System.in);
        int val;
        String command;
        Deck deck = new Deck(true);
        deck.shuffle();
        playerHand.takeCardFromDeck(deck);
        dealerHand.takeCardFromDeck(deck);
        playerHand.takeCardFromDeck(deck);
        dealerHand.takeCardFromDeck(deck);
        System.out.println("Your cards: " + playerHand + " valued at: " + playerHand.calculateValue());
        System.out.println("Dealer's first card: " + dealerHand.getCard(0) + " and the other one is hidden");
        System.out.println("Would you like to hit?\n1: Hit\n2: Stay");
        command = in.next().trim();
        while (command.equals("1") && playerHand.calculateValue() < 21) {
            playerHand.takeCardFromDeck(deck);
            System.out.println("Your cards: " + playerHand + " valued at: " + playerHand.calculateValue());
        }
            if (playerHand.calculateValue() > 21) {
            System.out.println("BUST!\nYou Lose!");
        }
    }
}


