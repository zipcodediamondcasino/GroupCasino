package com.github.zipcodewilmington.casino;
import java.util.ArrayList;
public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();

    }

    //making it Deck(true) gives you a 52 card deck
    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if (makeDeck){
            for (Suit suit : Suit.values()){
                for (Number rank : Number.values()){
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }


    //example after making a new deck calling newDeck.shuffle shuffles cards
    public void shuffle(){
        ArrayList<Card> shuffled = new ArrayList<Card>();
        while(deck.size()>0){
            int cardToPull = (int)(Math.random()*(deck.size()-1));
            shuffled.add(deck.get(cardToPull));
            deck.remove(cardToPull);
        }
        deck = shuffled;
    }//lol

    public void addCard(Card card){
        deck.add(card);
        }

    public String toString(){
        String output = "";

        for (Card card : deck){
            output += card;
            output+="\n";
        }
        return output;
    }


}//testing new commit


