package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.CardPlayer;
import com.github.zipcodewilmington.casino.CasinoAccount;

import java.util.ArrayList;

public class WarPlayer extends CardPlayer {
    public WarPlayer(CasinoAccount casinoAccount) {
        super(casinoAccount);
    }
    ArrayList<Card> hand;

}
