package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suit;

public class MainApplication {
    public static void main(String[] args) {
        Deck testDeck = new Deck(true);
        System.out.println(testDeck);

//        new Casino().run();
    }
}
