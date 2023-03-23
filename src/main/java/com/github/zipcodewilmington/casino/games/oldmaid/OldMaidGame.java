package com.github.zipcodewilmington.casino.games.oldmaid;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class OldMaidGame implements Game {
    ArrayList<OldMaidPlayer> OldMaidPlayers;
    Deck deck;
    ArrayList<Card> Hand;

    public Card pickCard(ArrayList<Card> Hand) {
        Random random = new Random();
        int randomIndex = random.nextInt(Hand.size());
        return Hand.get(randomIndex);
    }

    public ArrayList<Card> matchCard(ArrayList<Card> Hand) {
        ArrayList<Card> removedMatches = new ArrayList<>();
        for (int i = 0; i < Hand.size() - 1; i++) {
            Card card1 = Hand.get(i);
            Card card2 = Hand.get(i + 1);
            if (card1.equals(card2)) {
                removedMatches.add(card1);
                removedMatches.add(card2);
                i++; // skip the next card since it has already been removed
            }
        }
        Hand.removeAll(removedMatches);
        ArrayList<Card> remainingCards = new ArrayList<>(Hand);
        return remainingCards;
    }

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
