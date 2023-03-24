package com.github.zipcodewilmington;


import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackHand;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidDealer;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidGame;

import java.util.logging.Handler;

public class MainApplication {
    public static void main(String[] args) {
//        new Casino().run();
        new OldMaidGame().run();
    }
}
