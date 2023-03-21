package com.github.zipcodewilmington.casino;
import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
    }

    public void addCard(Card card){
        deck.add(card);
    }

    public String toString() {
        String output = "";

        for (Card card : deck) {
            output += card;
            output += "\n";
        }
        return output;

    }
}
