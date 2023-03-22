package com.github.zipcodewilmington.testCasino.testGames.testOldMaid;

import com.github.zipcodewilmington.casino.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class TestOldMaidGame {

    @Before
    public void Init(){
        ArrayList<Card> Hand = new ArrayList<>();
    }

    @Test
    public void testMatchCard(){
        ArrayList<Card> Hand = new ArrayList<>();
        Hand.add(new Card("Hearts", 3));

        ArrayList<Card> expectedRemoved = new ArrayList<>();

        ArrayList<Card> expectedRemaining = new ArrayList<>();

        ArrayList<Card> actualRemoved = matchCard(hand);

        Assert.assertEquals(expectedRemoved, actualRemoved);

    }

    @Test
    public void testShuffle(){
        ArrayList<Card> Hand = new ArrayList<>();

        Collections.shuffle(Hand);

        Assert.assertEquals(Hand, Hand);
    }
}
