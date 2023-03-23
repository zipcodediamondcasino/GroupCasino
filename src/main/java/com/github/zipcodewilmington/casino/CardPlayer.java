package com.github.zipcodewilmington.casino;

import java.util.ArrayList;

public class CardPlayer extends Player {

    ArrayList<Card> hand;
    public CardPlayer(CasinoAccount casinoAccount) {
        super(casinoAccount);
    }
}
