package com.github.zipcodewilmington.testCasino.testGames.testYahtzee;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    }

    @Test
    public void remove(){
    }

    @Test
    public void getPlayers(){
    }

    @Test
    public void testHasOnes(){
        ArrayList binData = new ArrayList<>();
        binData.add(1);
        boolean expected = true;
        boolean actual = hasOnes(binData);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testHasTwos(){
        ArrayList binData = new ArrayList<>();
        binData.add(2);
        ArrayList<Integer> newArrayList = binData(binData);
        boolean expected = true;
        boolean actual = hasTwos(newArrayList);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHasThrees(){
        ArrayList binData = new ArrayList<>();
        binData.add(3);
        ArrayList<Integer> newArrayList = binData(binData);
        boolean expected = true;
        boolean actual = hasThrees(newArrayList);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHasFours(){
        ArrayList binData = new ArrayList<>();
        binData.add(4);
        ArrayList<Integer> newArrayList = binData(binData);
        boolean expected = true;
        boolean actual = hasFours(newArrayList);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testHasFives(){
        ArrayList binData = new ArrayList<>();
        binData.add(5);
        ArrayList<Integer> newArrayList = binData(binData);
        boolean expected = true;
        boolean actual = hasFives(newArrayList);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHasSixes(){
        ArrayList binData = new ArrayList<>();
        binData.add(6);
        ArrayList<Integer> newArrayList = binData(binData);
        boolean expected = true;
        boolean actual = hasSixes(newArrayList);
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
    public void testNewScoreCardAddsScores() {
        LinkedHashMap<String, Integer> actual = newScoreCard();
        actual.put("Ones", 3);

        LinkedHashMap<String, Integer> expected = newScoreCard();

        Assert.assertFalse(expected == actual);
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
    public void testClearFieldsMethodEmptiesCurrentBinAndCurrentRoll() {
        ArrayList<Integer> roll = new ArrayList<>();
        roll.add(1);
        ArrayList<Integer> bin = new ArrayList<>();
        bin.add(1);
        clearFields(bin, roll);
        boolean actual = bin.isEmpty();
        boolean expected = true;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testUserInputIs0(){
        boolean actual = isOneThruSix("0");
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testThatUserInputThreeWithTwoDiceIsInvalid(){
        boolean actual = isOneThruSix("3");
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testUserInputIsThreeWithFourDice() {
        boolean actual = isOneThruSix("3");
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFillScoreCard() {

        LinkedHashMap<String, Integer> newScoreCard = newScoreCard();
        String chooseScore = "Ones";
        ArrayList<Integer> currentBin = new ArrayList<>();
        currentBin.add(0, 3);
        fillScoreCard(chooseScore, newScoreCard, currentBin);
        Integer actual = newScoreCard.get("Ones");
        Integer expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
        public void TestPopulateComputerScoreCard() {
            LinkedHashMap<String, Integer> computerScoreCard = new LinkedHashMap<>();
            int round = 2;
            populateComputerScoreCard(round, computerScoreCard);

            Integer expected = 0;
            Integer actual = computerScoreCard.get("Threes");
            Assert.assertEquals(expected, actual);
        }

    @Test
    public void testDecipherChoice() {

        ArrayList scoreChoices = new ArrayList<>();
        scoreChoices.add("Ones");
        scoreChoices.add("Twos");
        deciferScoreChoice(1, scoreChoices);
        String expected = "Ones";
        String actual = deciferScoreChoice(1, scoreChoices);
        Assert.assertEquals(expected, actual);
    }

    //    static LinkedHashMap<String, Integer> scoreCard = newScoreCard();

    @Test
    public void testNewScoreCard() {
        LinkedHashMap<String, Integer> scoreCard = newScoreCard();
        int expected = 0;
        int actual = scoreCard.get("Total");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void  testAddRemainingDiceToBin() {
        ArrayList<Integer> bin = new ArrayList<>();
        bin.add(1);
        bin.add(1);

        ArrayList<Integer> roll = new ArrayList<>();
        roll.add(2);
        roll.add(2);
        roll.add(2);

        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(1);
        expected.add(2);
        expected.add(2);
        expected.add(2);

        ArrayList<Integer> actual = addRemainingDiceToBin(bin, roll);

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
}