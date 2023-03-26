package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackHand;

import java.util.ArrayList;

public class CardPlayer extends Player {

    ArrayList<Card> hand = new ArrayList<>();
    public CardPlayer(CasinoAccount casinoAccount) {
        super(casinoAccount);
    }


    public ArrayList<Card> getHand(){
        return this.hand;
    }
    public ArrayList<Card> addPlayerHand(Card card){
        hand.add(card);
        return this.hand;
    }
}


