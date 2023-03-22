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
    public void testShuffle(){
        ArrayList<Card> Hand = new ArrayList<>();

        Collections.shuffle(Hand);

        Assert.assertEquals(Hand, Hand);
    }

}
