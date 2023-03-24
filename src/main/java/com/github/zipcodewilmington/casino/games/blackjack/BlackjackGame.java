package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.BettingGame;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.Game;

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
            System.out.println("Would you like to play Blackjack?\n1: Yes\n2: leave");
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
                    this.player.getCasinoAccount().setBalance(this.player.getCasinoAccount().getBalance()+winnings());
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
        String command;
        Deck deck = new Deck(true);
        starNewGame(deck);

        while (true) {
            if (playerHand.calculateValue() == 21 && dealerHand.calculateValue() < 21) {
                System.out.println("You hit Blackjack! You're automatically a winner!");
                winnings();
                run();
            } else if (playerHand.calculateValue() == 21 && dealerHand.calculateValue() == 21) {
                System.out.println("It\'s a tie! Nobody wins..");
                run();
            } else if (dealerHand.calculateValue() == 21) {
                System.out.println("Dealer has hit Blackjack. Sorry you lose!");
                run();
            }else if (dealerHand.calculateValue() > 21 ) {
                System.out.println("Dealer bust!");
                System.out.println("You win");
                run();
            } else if (playerHand.calculateValue() > 21 ) {
                System.out.println("You lose");
                run();
            }

            System.out.println("Would you like to hit?\n1: Hit\n2: Stay");
            command = in.next().trim();
            if (command.equals("1")) {
                playerHand.takeCardFromDeck(deck);
                if (command.equals("2") && dealerHand.calculateValue() <17){
                    dealerHand.takeCardFromDeck(deck);
                    System.out.println("Dealer's cards: " +dealerHand + " valued at: " +dealerHand.calculateValue());
                }
                System.out.println("Your cards: " + playerHand + " valued at: " + playerHand.calculateValue());
            } else {
                System.out.println("Dealer's cards: " +dealerHand + " valued at: " +dealerHand.calculateValue());}

                while (dealerHand.calculateValue() < 17) {
                    System.out.println("Dealer hits.");
                    dealerHand.takeCardFromDeck(deck);
                    System.out.println("Dealer's cards: " +dealerHand + " valued at: " +dealerHand.calculateValue());
                }
                if (dealerHand.calculateValue() > playerHand.calculateValue() && dealerHand.calculateValue() <=21) {
                    System.out.println("Sorry you lose!");
                    run();
                } else if (dealerHand.calculateValue() == playerHand.calculateValue()) {
                    System.out.println("Dealer's cards: " +dealerHand + " valued at: " +dealerHand.calculateValue());
                    System.out.println("It\'s a tie! Nobody wins..");

                }else {
                    System.out.println("You win!");
                    winnings();
                }
                run();
            }
        }


    private void starNewGame(Deck deck) {

        playerHand = new BlackjackHand();
        dealerHand = new BlackjackHand();
        deck.shuffle();

        playerHand.takeCardFromDeck(deck);
        dealerHand.takeCardFromDeck(deck);
        playerHand.takeCardFromDeck(deck);
        dealerHand.takeCardFromDeck(deck);

        System.out.println("Your cards: " + playerHand + " valued at: " + playerHand.calculateValue());
        System.out.println("Dealer's first card: " + dealerHand.getCard(0) + " and the other one is hidden");

    }

    private int winnings(){
        this.player.getCasinoAccount().setBalance(this.player.getCasinoAccount().getBalance() + (pool *2));

        return 0;
    }
}
