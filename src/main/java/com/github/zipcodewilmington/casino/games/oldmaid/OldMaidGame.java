package com.github.zipcodewilmington.casino.games.oldmaid;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;
import java.util.Collections;

public class OldMaidGame implements Game {
    ArrayList<OldMaidPlayer> OldMaidPlayers;
    Deck deck;

    ArrayList<Card> Hand;

//    public Card pickCard(ArrayList<Card>){
//        return null;
//    }

//    public ArrayList<Card> matchCard(ArrayList<Card>){
//
//    }

    public ArrayList<Card> shuffle(ArrayList<Card> Hand){
      Collections.shuffle(Hand);
      return Hand;
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

    private class Cardplayer {
    }
}
