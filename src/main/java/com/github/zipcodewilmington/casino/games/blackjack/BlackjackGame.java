package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.*;


import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackGame implements Game, BettingGame {
    private Deck deck, discarded;

    private BlackjackDealer dealer;
    private BlackjackPlayer player = new BlackjackPlayer(new CasinoAccount());
    private int wins, losses, pushes;


    @Override
    public void run() {
//        Scanner in = new Scanner(System.in);
//        String command;
//        int val;
//        while (true) {
//            System.out.println("Welcome to Blackjack! Would you like to play?\n1: yes\n2: no");
//            command = in.next().trim();
//            if (command.equals("1")) {
//                try {
//                    System.out.println("How much would you like to wager?");
//                    val = in.nextInt();
//                } catch (NumberFormatException e) {
//                    System.out.println("Please enter a nu,ber\n");
//                    continue;
                }
//            }
//        }
//    }


//                if (bet(this.player.getCasinoAccount().setBalance(this.player.getCasinoAccount().getBalance() + resolve(pull)))
//        }
//    }

    //        dealer.getHand().takeCardFromDeck(deck);
//        dealer.getHand().takeCardFromDeck(deck);
//
//
//        player.getHand().takeCardFromDeck(deck);
//        player.getHand().takeCardFromDeck(deck);
//
//
//        dealer.printFirstHand();
//        player.printHand();
//    }
//
//
    @Override
    public void add(Player player) {

    }

    //
    @Override
    public void remove(Player player) {

    }

    //
    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

//    @Override
//    public void run() {
////
////        player.getHand().takeCardFromDeck(deck);
////        dealer.getHand().takeCardFromDeck(deck);
////        player.getHand().takeCardFromDeck(deck);
////        dealer.getHand().takeCardFromDeck(deck);
////
////        dealer.printFirstHand();
////        player.printHand();
////    }
//
        @Override
        public boolean bet (Player player,int amount, int minimum){
            return false;
        }
    }
//}
