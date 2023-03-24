package com.github.zipcodewilmington.testCasino.testGames.testPoker;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Number;
import com.github.zipcodewilmington.casino.Suit;
import com.github.zipcodewilmington.casino.games.poker.PokerDealer;
import com.github.zipcodewilmington.casino.games.poker.PokerPlayer;
import org.junit.Assert;

import java.util.ArrayList;

public class TestPokerGame {

    CasinoAccount playerAcc = new CasinoAccount();
    CasinoAccount dealerAcc = new CasinoAccount();
    PokerDealer pokerDealerTest = new PokerDealer(dealerAcc);
    PokerPlayer pokerPlayerTest = new PokerPlayer(playerAcc);


  /*  public void testFold(){
        boolean actual = pokerPlayerTest.fold();

        Assert.assertTrue(actual);
    }
  /*  public void testCheck(){ //boolean
        boolean actual = pokerPlayerTest.check();

       Assert.assertFalse(actual);
    } */
    //I don't think check exists in 5 card stud
    public void testBet(){


    }
/*
    public void testCompareHands(){ //runs hands through if statments and assigns values then compares values


        Card card1 = new Card(Suit.HEARTS,  Number.THREE);
        Card card2 = new Card(Suit.HEARTS,  Number.FOUR);
        Card card3 = new Card(Suit.HEARTS,  Number.FIVE);
        Card card4 = new Card(Suit.HEARTS,  Number.SIX);
        Card card5 = new Card(Suit.HEARTS,  Number.SEVEN);
//        when
        pokerDealerTest.addPlayerHand(card1);
        pokerDealerTest.addPlayerHand(card2);
        pokerDealerTest.addPlayerHand(card3);
        pokerDealerTest.addPlayerHand(card4);
        pokerDealerTest.addPlayerHand(card5);


        Card card6 = new Card(Suit.SPADES,  Number.TWO);
        Card card7 = new Card(Suit.SPADES,  Number.THREE);
        Card card8 = new Card(Suit.CLUBS,  Number.FOUR);
        Card card9 = new Card(Suit.CLUBS,  Number.FIVE);
        Card card10 = new Card(Suit.CLUBS,  Number.SIX);
//        when
        pokerPlayerTest.addPlayerHand(card6);
        pokerPlayerTest.addPlayerHand(card7);
        pokerPlayerTest.addPlayerHand(card8);
        pokerPlayerTest.addPlayerHand(card9);
        pokerPlayerTest.addPlayerHand(card10);

        int actual = pokerPlayerTest.compareHands();
        int expected = pokerDealerTest.compareHands();


        Assert.assertTrue(expected < actual);
    }  */
    public void testSwitch(){

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
    }
}
