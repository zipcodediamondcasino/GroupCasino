package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;

import java.util.ArrayList;

public class BlackjackHand {
    private ArrayList<Card> hand;

    public BlackjackHand(){
        hand = new ArrayList<Card>();
    }

    public void takeCardFromDeck(Deck deck){
        hand.add(deck.takeCard());
    }

    public String toString(){
        String output = "";
        for (Card card : hand){
            output += card + " - ";
        }
        return output;
    }

    public int calculateValue(){
        int value = 0;
        int aceCount = 0;

        for (Card card : hand){
            value += card.getValue();
            if (card.getValue() == 11){
                aceCount ++;
            }
        }
        if (value > 21 && aceCount >0){
            while (aceCount >0 && value >21){
                aceCount --;
                value-=10;
            }
        }
        return value;
    }

    public Card getCard(int index){
        return hand.get(index);
    }

    public void clear() {
    }
}
