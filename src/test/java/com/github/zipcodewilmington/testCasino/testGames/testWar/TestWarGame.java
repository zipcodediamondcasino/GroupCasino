package com.github.zipcodewilmington.testCasino.testGames.testWar;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suit;
import com.github.zipcodewilmington.casino.games.poker.PokerDealer;
import com.github.zipcodewilmington.casino.games.poker.PokerPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
public class TestWarGame {
    CasinoAccount playerAcc = new CasinoAccount();
    CasinoAccount dealerAcc = new CasinoAccount();
    PokerDealer warDealerTest = new PokerDealer(dealerAcc);
    PokerPlayer warPlayerTest = new PokerPlayer(playerAcc);
/*
    @Test
    public void testDeal(){
        Card card1 = new Card(Suit.SPADES,  Number.TWO);
        Card card2 = new Card(Suit.SPADES,  Number.THREE);
        Card card3 = new Card(Suit.CLUBS,  Number.FOUR);
        Card card4 = new Card(Suit.CLUBS,  Number.FIVE);
        Card card5 = new Card(Suit.CLUBS,  Number.SIX);
//        when
        pokerPlayerTest.addPlayerHand(card1);
        pokerPlayerTest.addPlayerHand(card2);
        pokerPlayerTest.addPlayerHand(card3);
        pokerPlayerTest.addPlayerHand(card4);
        pokerPlayerTest.addPlayerHand(card5);

        ArrayList<Card> actual = pokerPlayerTest.getHand();


        Card card6 = new Card(Suit.HEARTS,  Number.THREE);
        Card card7 = new Card(Suit.HEARTS,  Number.FOUR);
        Card card8 = new Card(Suit.HEARTS,  Number.FIVE);
        Card card9 = new Card(Suit.HEARTS,  Number.SIX);
        Card card10 = new Card(Suit.HEARTS,  Number.SEVEN);
//        when
        pokerDealerTest.addPlayerHand(card6);
        pokerDealerTest.addPlayerHand(card7);
        pokerDealerTest.addPlayerHand(card8);
        pokerDealerTest.addPlayerHand(card9);
        pokerDealerTest.addPlayerHand(card10);
        ArrayList<Card> expected = pokerDealerTest.getHand();

        Assert.assertEquals(expected.size(), actual.size());



    }*/
}
