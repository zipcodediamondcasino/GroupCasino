package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suit;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackDealer;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackHand;

public class MainApplication {
    public static void main(String[] args) {
        new BlackjackGame().run();
//        new Casino().run();
    }
}
