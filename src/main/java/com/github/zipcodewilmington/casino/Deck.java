package com.github.zipcodewilmington.casino;
import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> deck;

    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if (makeDeck){
            for (Suits suit : Suits.values()) {
                for (Number rank : Number.values()) {
                    deck.add(new Card(rank, suit));
                }
            }
        }
    }

    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while (deck.size()>0){
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            shuffled.add(deck.get(cardToPull));
            deck.remove(cardToPull);
        }
        deck = shuffled;
    }

    public void addCard(Card card){
        deck.add(card);
    }
    public void deckFiftyTwo(boolean makeDeck){
        if (makeDeck){
            for (Suits suit : Suits.values()) {
                for (Number rank : Number.values()) {
                    deck.add(new Card(rank, suit));
                }
            }
        }
    }
    public void shuffled(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while (deck.size()>0){
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            shuffled.add(deck.get(cardToPull));
        }
        deck = shuffled;
    }
}//testing new commit


