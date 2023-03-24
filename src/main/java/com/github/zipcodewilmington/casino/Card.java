package com.github.zipcodewilmington.casino;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suit;
public class Card {

    private Suit suit;
    private Number rank;


    public Card(Suit suit, Number rank) {
        this.suit = suit;
        this.rank = rank;
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

    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }
}
