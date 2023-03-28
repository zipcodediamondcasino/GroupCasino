package com.github.zipcodewilmington.casino.games.oldmaid;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.Suit;
import com.github.zipcodewilmington.casino.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OldMaidPlayer extends CardPlayer {
    public OldMaidPlayer(CasinoAccount casinoAccount) {
        super(casinoAccount);
    }
    ArrayList <OldMaidPlayer> OldMaidPlayers;
    Deck deck;
    ArrayList<Card> Hand;
    Card card;
    Number rank;

    public Card pickCard(ArrayList<Card> Hand) {
        Random random = new Random();
        int randomIndex = random.nextInt(Hand.size());
        return Hand.get(randomIndex);
    }

    // returns the same identical ArrayList but test fails :/
    public ArrayList<Card> matchCard(ArrayList<Card> Hand) {
        ArrayList<Card> removedMatches = new ArrayList<>();
        for (int i = 0; i < Hand.size() - 1; i++) {
            Card card1 = Hand.get(i);
            Number rank1 = card1.getRank();
            Card card2 = Hand.get(i + 1);
            Number rank2 = card2.getRank();
            if (rank1 == rank2) {
                removedMatches.add(card1);
                removedMatches.add(card2);
                i++;
            }
        }
        Hand.removeAll(removedMatches);
        ArrayList<Card> remainingCards = new ArrayList<>(Hand);
        return remainingCards;
    }

    public ArrayList<Card> shuffle(ArrayList<Card> Hand) {
        Collections.shuffle(Hand);
        return Hand;
    }
}

