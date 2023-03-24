package com.github.zipcodewilmington.testCasino;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestCardPlayer {
    CasinoAccount Acc = new CasinoAccount();
    BlackjackPlayer blackjackPlayerActual = new BlackjackPlayer(Acc);
    @Test
    public void testGetHand(){
        //given
        blackjackPlayerActual.getHand().clear();
        Card card1 = new Card(Suit.HEARTS,  Number.THREE);
        Card card2 = new Card(Suit.HEARTS,  Number.FOUR);
        Card card3 = new Card(Suit.HEARTS,  Number.FIVE);
//        when
        blackjackPlayerActual.addPlayerHand(card1);
        blackjackPlayerActual.addPlayerHand(card2);
        blackjackPlayerActual.addPlayerHand(card3);


//        then
        ArrayList<Card> expected = new ArrayList<>();
        expected.add(card1);
        expected.add(card2);
        expected.add(card3);

        Assert.assertEquals(expected, blackjackPlayerActual.getHand());
    }
    @Test
    public void testAddPlayerHand(){
      //  blackjackPlayerActual.clearHand();

//        given
        Card card1 = new Card(Suit.HEARTS,  Number.THREE);
        Card card2 = new Card(Suit.HEARTS,  Number.FOUR);
        Card card3 = new Card(Suit.HEARTS,  Number.FIVE);
//        when
        blackjackPlayerActual.addPlayerHand(card1);
        blackjackPlayerActual.addPlayerHand(card2);
        blackjackPlayerActual.addPlayerHand(card3);
//        then
        ArrayList<Card> expected = new ArrayList<>();
        expected.add(card1);
        expected.add(card2);
        expected.add(card3);

        Assert.assertEquals(expected, blackjackPlayerActual.getHand());
    }

}
