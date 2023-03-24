package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.*;

import java.util.ArrayList;

public class BlackjackGame implements Game, BettingGame {
    private Deck deck, discarded;

    private BlackjackDealer dealer;
    private BlackjackPlayer player = new BlackjackPlayer(new CasinoAccount());
    private int wins, losses, pushes;

    public BlackjackGame(){
        deck = new Deck(true);
        discarded = new Deck();

        dealer = new BlackjackDealer();

        deck.shuffle();

    }
    @Override
    public void run() {

        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);


        player.getHand().takeCardFromDeck(deck);
        player.getHand().takeCardFromDeck(deck);


        dealer.printFirstHand();
        player.printHand();
    }


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

//    @Override
//    public void run() {
//
//        player.getHand().takeCardFromDeck(deck);
//        dealer.getHand().takeCardFromDeck(deck);
//        player.getHand().takeCardFromDeck(deck);
//        dealer.getHand().takeCardFromDeck(deck);
//
//        dealer.printFirstHand();
//        player.printHand();
//    }

    @Override
    public boolean bet(Player player, int amount, int minimum) {
        return false;
    }
}
