package com.github.zipcodewilmington.testCasino;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestDeck {

    @Test
    public void testConstructor() {
        Deck deck = new Deck(true); //idk why this is bool, it just fails if you don't say true lol
        int expected = 52;

        int actual = deck.getDeck().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testToString() {
        Deck deck = new Deck(true);

        String expected = "[Ace of Diamonds] (11)\n" +
                "[Two of Diamonds] (2)\n" +
                "[Three of Diamonds] (3)\n" +
                "[Four of Diamonds] (4)\n" +
                "[Five of Diamonds] (5)\n" +
                "[Six of Diamonds] (6)\n" +
                "[Seven of Diamonds] (7)\n" +
                "[Eight of Diamonds] (8)\n" +
                "[Nine of Diamonds] (9)\n" +
                "[Ten of Diamonds] (10)\n" +
                "[Jack of Diamonds] (10)\n" +
                "[Queen of Diamonds] (10)\n" +
                "[King of Diamonds] (10)\n" +
                "[Ace of Spades] (11)\n" +
                "[Two of Spades] (2)\n" +
                "[Three of Spades] (3)\n" +
                "[Four of Spades] (4)\n" +
                "[Five of Spades] (5)\n" +
                "[Six of Spades] (6)\n" +
                "[Seven of Spades] (7)\n" +
                "[Eight of Spades] (8)\n" +
                "[Nine of Spades] (9)\n" +
                "[Ten of Spades] (10)\n" +
                "[Jack of Spades] (10)\n" +
                "[Queen of Spades] (10)\n" +
                "[King of Spades] (10)\n" +
                "[Ace of Clubs] (11)\n" +
                "[Two of Clubs] (2)\n" +
                "[Three of Clubs] (3)\n" +
                "[Four of Clubs] (4)\n" +
                "[Five of Clubs] (5)\n" +
                "[Six of Clubs] (6)\n" +
                "[Seven of Clubs] (7)\n" +
                "[Eight of Clubs] (8)\n" +
                "[Nine of Clubs] (9)\n" +
                "[Ten of Clubs] (10)\n" +
                "[Jack of Clubs] (10)\n" +
                "[Queen of Clubs] (10)\n" +
                "[King of Clubs] (10)\n" +
                "[Ace of Hearts] (11)\n" +
                "[Two of Hearts] (2)\n" +
                "[Three of Hearts] (3)\n" +
                "[Four of Hearts] (4)\n" +
                "[Five of Hearts] (5)\n" +
                "[Six of Hearts] (6)\n" +
                "[Seven of Hearts] (7)\n" +
                "[Eight of Hearts] (8)\n" +
                "[Nine of Hearts] (9)\n" +
                "[Ten of Hearts] (10)\n" +
                "[Jack of Hearts] (10)\n" +
                "[Queen of Hearts] (10)\n" +
                "[King of Hearts] (10)\n";

        String actual = deck.toString();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testTakeCard() {
        Deck deck = new Deck(true);
        int expected = 51;

        Card card = deck.takeCard();

        int actual = deck.getDeck().size();

        Assert.assertEquals(expected, actual);
        Assert.assertTrue(card instanceof Card);
    }

    @Test
    public void testShuffle() {
        Deck deck = new Deck(true);
        ArrayList<Card> notExpected = deck.getDeck();

        deck.shuffle();

        ArrayList<Card> actual = deck.getDeck();

        Assert.assertNotEquals(notExpected,actual);
    }
}
