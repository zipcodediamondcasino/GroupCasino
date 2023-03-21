package com.github.zipcodewilmington.casino;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suits;
public class Card {

    private Suits suit;
    private Number rank;


    public Card(Number rank, Suits suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit(){
        return suit.printSuit();
    }

    public int getRank(){
        return rank.getRank();
    }
}
