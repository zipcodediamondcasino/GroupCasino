package com.github.zipcodewilmington.testCasino.testGames.testYahtzee;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame.getScoreChoices;

public class TestYahtzeeGame {
    YahtzeeGame newGame;
    YahtzeePlayer newPlayer;

    @Before
    public void init(){
        newGame = new YahtzeeGame();
        newPlayer = new YahtzeePlayer(null);
    }

    @Test
    public void testConstructor() {
        Assert.assertTrue(newGame instanceof YahtzeeGame);
    }

    @Test
    public void testAdd(){
        newGame.add(newPlayer);
        boolean expected = false;
        ArrayList<Player> actual = newGame.getPlayers();
        Assert.assertEquals(expected, actual.isEmpty());
    }

    @Test
    public void remove(){
        newGame.add(newPlayer);
        newGame.remove(newPlayer);
        boolean expected = true;
        ArrayList<Player> actual = newGame.getPlayers();
        Assert.assertEquals(expected, actual.isEmpty());
    }

    @Test
    public void getPlayers(){
        newGame.add(newPlayer);
        ArrayList expected = null;
        ArrayList<Player> actual = newGame.getPlayers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetScoreChoicesForSmallStraight(){
        ArrayList expected = new ArrayList();
        ArrayList binData = new ArrayList<>();
        binData.add(1);
        binData.add(1);
        binData.add(1);
        binData.add(1);
        binData.add(0);
        binData.add(0);

        expected.add("Small Straight");
        expected.add("Ones");
        expected.add("Twos");
        expected.add("Threes");
        expected.add("Fours");
        expected.add("Chance");
        ArrayList actual = getScoreChoices(binData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetScoreChoicesForLargeStraight(){
        ArrayList expected = new ArrayList();
        ArrayList binData = new ArrayList<>();
        binData.add(1);
        binData.add(1);
        binData.add(1);
        binData.add(1);
        binData.add(1);
        binData.add(0);

        expected.add("Large Straight");
        expected.add("Small Straight");
        expected.add("Ones");
        expected.add("Twos");
        expected.add("Threes");
        expected.add("Fours");
        expected.add("Fives");
        expected.add("Chance");
        ArrayList actual = getScoreChoices(binData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetScoreChoicesForYahtzee(){
        ArrayList expected = new ArrayList();
        ArrayList binData = new ArrayList<>();
        binData.add(0);
        binData.add(0);
        binData.add(0);
        binData.add(0);
        binData.add(5);
        binData.add(0);

        expected.add("Yahtzee");
        expected.add("Fives");
        expected.add("Chance");
        ArrayList actual = getScoreChoices(binData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetScoreChoicesForThreeOfAKind(){
        ArrayList expected = new ArrayList();
        ArrayList binData = new ArrayList<>();
        binData.add(0);
        binData.add(0);
        binData.add(0);
        binData.add(3);
        binData.add(0);
        binData.add(0);

        expected.add("Three of a Kind");
        expected.add("Fours");
        expected.add("Chance");
        ArrayList actual = getScoreChoices(binData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetScoreChoicesForFourOfAKind(){
        ArrayList expected = new ArrayList();
        ArrayList binData = new ArrayList<>();
        binData.add(0);
        binData.add(0);
        binData.add(0);
        binData.add(4);
        binData.add(0);
        binData.add(0);

        expected.add("Four of a Kind");
        expected.add("Fours");
        expected.add("Chance");
        ArrayList actual = getScoreChoices(binData);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetScoreChoicesForFullHouse(){
        ArrayList expected = new ArrayList();
        ArrayList binData = new ArrayList<>();
        binData.add(0);
        binData.add(0);
        binData.add(2);
        binData.add(3);
        binData.add(0);
        binData.add(0);

        expected.add("Three of a Kind");
        expected.add("Full House");
        expected.add("Threes");
        expected.add("Fours");
        expected.add("Chance");
        ArrayList actual = getScoreChoices(binData);
        Assert.assertEquals(expected, actual);
    }
}
