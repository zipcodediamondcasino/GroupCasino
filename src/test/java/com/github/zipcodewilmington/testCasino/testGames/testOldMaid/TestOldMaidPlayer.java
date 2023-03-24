package com.github.zipcodewilmington.testCasino.testGames.testOldMaid;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Suit;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static com.github.zipcodewilmington.casino.Number.*;

public class TestOldMaidPlayer {

    @Test
    public void testPickCard(){
        ArrayList<Card> Hand = new ArrayList<>();
        Hand.add(new Card(Suit.HEARTS, TEN));
        Hand.add(new Card(Suit.SPADES, FIVE));
        Hand.add(new Card(Suit.SPADES, SIX));
        Hand.add(new Card(Suit.SPADES, SEVEN));
        Hand.add(new Card(Suit.HEARTS, FIVE));

        CasinoAccount Cas = new CasinoAccount();
        OldMaidPlayer old = new OldMaidPlayer(Cas);
        Card actual = old.pickCard(Hand);

        Assert.assertNotNull(actual);
    }

//    @Test
//    public void testMatchCard(){
//        ArrayList<Card> Hand = new ArrayList<>();
//        Hand.add(new Card(Suit.SPADES, SIX));
//        Hand.add(new Card(Suit.SPADES, SEVEN));
//        Hand.add(new Card(Suit.HEARTS, TEN));
//        Hand.add(new Card(Suit.SPADES, FIVE));
//        Hand.add(new Card(Suit.HEARTS, FIVE));
//
//        ArrayList<Card> expectedRemaining = new ArrayList<>();
//        expectedRemaining.add(new Card(Suit.SPADES, SIX));
//        expectedRemaining.add(new Card(Suit.SPADES, SEVEN));
//        expectedRemaining.add(new Card(Suit.HEARTS, TEN));
//
//        CasinoAccount Cas = new CasinoAccount();
//        OldMaidPlayer old = new OldMaidPlayer(Cas);
//        ArrayList<Card> actualRemaining = old.matchCard(Hand);
//
//        Assert.assertEquals(expectedRemaining, actualRemaining);
//    }

    @Test
    public void testShuffle(){
        ArrayList<Card> Hand = new ArrayList<>();

        Collections.shuffle(Hand);

        Assert.assertEquals(Hand, Hand);
    }
}
