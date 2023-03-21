package com.github.zipcodewilmington.casino;

public enum Suits {
    DIAMONDS ("Diamonds"),
    SPADES("Spades"),
    CLUBS("Clubs"),
    HEARTS("Hearts");

    private final String suitText;

    Suits(String suitText) {
        this.suitText = suitText;
    }

    public String printSuit(){
        return suitText;
    }
}

