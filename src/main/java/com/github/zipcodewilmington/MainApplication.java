package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.Suits;

public class MainApplication {

    Deck testDeck = new Deck();
    Card aCard = new Card(Suits.CLUBS,);
    public static void main(String[] args) {
        new Casino().run();
    }
}
