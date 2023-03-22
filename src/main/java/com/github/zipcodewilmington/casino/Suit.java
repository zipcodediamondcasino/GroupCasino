package com.github.zipcodewilmington.casino;

public enum Suit {
    DIAMONDS ("Diamonds"),
    SPADES("Spades"),
    CLUBS("Clubs"),
    HEARTS("Hearts");

    public String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String toString(){
        return suitName;
    }
}

