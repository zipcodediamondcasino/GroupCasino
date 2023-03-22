package com.github.zipcodewilmington.casino;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suit;
public class Card {

    private Suit suit;
    private Number rank;


    public Card(Number rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getValue() {
        return rank.rankValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Number getRank() {
        return rank;
    }

    public String toString() {
        return ("[" + rank + " of " + suit + "] (" + this.getValue() + ")");
    }
}
