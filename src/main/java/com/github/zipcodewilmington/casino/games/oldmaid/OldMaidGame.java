package com.github.zipcodewilmington.casino.games.oldmaid;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;

public class OldMaidGame implements Game {
    ArrayList<OldMaidPlayer> OldMaidPlayers;
    Deck deck;

    public Card pickCard(ArrayList<Card>){
        return null;
    }

    public ArrayList<Card> matchCard(ArrayList<Card>){
        return null;
    }

    public ArrayList<Card> shuffle(ArrayList<Card>){
        return null;
    }
    @Override
    public void add(Player player) {

    }

    @Override
    public void remove(Player player) {

    }

    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

    @Override
    public void run() {

    }
}
