package com.github.zipcodewilmington.testCasino.testGames.testYahtzee;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import static com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame.*;

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
//        newGame.add(newPlayer);
//        boolean expected = false;
//        ArrayList<Player> actual = newGame.getPlayers();
//        Assert.assertEquals(expected, actual.isEmpty());
    }

    @Test
    public void remove(){
//        newGame.add(newPlayer);
//        newGame.remove(newPlayer);
//        boolean expected = true;
//        ArrayList<Player> actual = newGame.getPlayers();
//        Assert.assertEquals(expected, actual.isEmpty());
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
        binData.add(0);
        binData.add(5);

        expected.add("Yahtzee");
        expected.add("Sixes");
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

    @Test
    public void testConvertArrayToArrayList() {
        String[] arr = new String[2];
        arr[0] = "Hello";
        arr[1] = "World";

        ArrayList<String> expected = new ArrayList<>();
        expected.add("Hello");
        expected.add("World");

        ArrayList<String> actual = convertArrayToArrayList(arr);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void  testAddRemainingDiceToBin() {
//        ArrayList<Integer> bin = new ArrayList<>();
//        bin.add(1);
//        bin.add(1);
//
//        ArrayList<Integer> roll = new ArrayList<>();
//        roll.add(2);
//        roll.add(2);
//        roll.add(2);
//
//        ArrayList<Integer> expected = new ArrayList<>();
//        expected.add(1);
//        expected.add(1);
//        expected.add(2);
//        expected.add(2);
//        expected.add(2);
//
//        ArrayList<Integer> actual = addRemainingDiceToBin(bin, roll);
//
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void  testAddDiceToBin() {
//        ArrayList<Integer> bin = new ArrayList<>();
//        bin.add(1);
//        bin.add(1);
//
//        ArrayList<Integer> roll = new ArrayList<>();
//        roll.add(2);
//        roll.add(2);
//        roll.add(2);
//
//        ArrayList<String> add = new ArrayList<>();
//        roll.add(2);
//
//        ArrayList<Integer> expected = new ArrayList<>();
//        expected.add(1);
//        expected.add(1);
//        expected.add(2);
//
//        ArrayList<Integer> actual = addDieToBin(bin, add, roll);
//
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testNewScoreCardAddsScores() {
        LinkedHashMap<String, Integer> actual = newScoreCard();
        actual.put("Ones", 3);

        LinkedHashMap<String, Integer> expected = newScoreCard();

        Assert.assertFalse(expected == actual);
    }

    @Test
    public void testDecipherChoice() {

    }

    @Test
    public void testBinData() {

    }


}
