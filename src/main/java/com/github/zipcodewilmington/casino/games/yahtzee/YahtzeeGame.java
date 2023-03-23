package com.github.zipcodewilmington.casino.games.yahtzee;

import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;
import java.util.*;

public class YahtzeeGame implements Game {

    static Scanner scanner = new Scanner(System.in);
    @Override
    public void add(Player player) {

    }

    @Override
    public void remove(Player player) {

    }

    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

    @Override
    public void run() {
    }

    public static void main(String[] args) {
        int round = 13;
        int rollCount = 3;
        ArrayList currentRoll = new ArrayList<>();
        ArrayList currentBin = new ArrayList<>();
        int activeDice = 5;
        ArrayList roundScore = new ArrayList<>();


        while (round <= 13) {
            beginRound(round);
            playerSequence(rollCount, activeDice, currentRoll, currentBin);
            ArrayList currentScore = binData(currentBin);
            ArrayList presentChoices = getScoreChoices(currentScore);
            System.out.println(presentChoices);
            clearFields(rollCount, currentBin, currentRoll);
            round++;
        }
    }

    public static void clearFields(int rollCount, ArrayList currentBin, ArrayList currentRoll) {
        rollCount = 3;
        currentBin.clear();
        currentRoll.clear();
    }

    public static void playerSequence(int rollCount, int activeDice, ArrayList currentRoll,ArrayList currentBin){
        while (rollCount > 0 || activeDice > 0) {

            if (rollCount != 1) {
                askPlayerToRoll();
                int userInputRoll = scanner.nextInt();
                currentRoll = processUserInput(userInputRoll, activeDice);
                askPlayerToBinDice();
                String[] addToBin = scanner.next().split("");
                currentBin = addDieToBin(currentBin, addToBin, currentRoll);
                activeDice = 5 - currentBin.size();
                rollCount--;
                System.out.println("Current Bin: " + currentBin);
            } else {
                askPlayerToRoll();
                int userInputRoll = scanner.nextInt();
                currentRoll = processUserInput(userInputRoll, activeDice);
                String[] addToBin = new String[currentRoll.size()];
                for (int i = 0; i < addToBin.length; i++){
                    addToBin[i] = currentRoll.get(i).toString();
                }
                currentBin = (addDieToBin(currentBin, addToBin, currentRoll));
                rollCount--;
                System.out.println("Current Bin: " + currentBin);
            }
        }
    }

    public static int diceRoll() {
        double roll = (Math.random() * (6 - 1) + 1);
        return (int)Math.round(roll);
    }

    public static ArrayList roll(int activeDice){
        ArrayList<Integer> currentRoll = new ArrayList<>();
        for (int i = 1; i <= activeDice; i++) {
            currentRoll.add(diceRoll());
        }
        printRoll(currentRoll);
        return currentRoll;
    }

    public static void printRoll(ArrayList currentRoll) {
        for (int i = 0; i < currentRoll.size(); i++) {
            System.out.println(i + 1 + " - [" + currentRoll.get(i) + "]");
        }
    }

    public static ArrayList addDieToBin(ArrayList currentBin, String[] binned, ArrayList currentRoll) {
        ArrayList addToBin = currentBin;
        for (int i = 0; i < binned.length; i++) {
            if (currentRoll.contains(currentRoll.get(Integer.parseInt(binned[i]) - 1))) {
                addToBin.add(currentRoll.get(Integer.parseInt(binned[i]) - 1));
            }
        }
        return addToBin;
    }

    public static void beginRound(int round) {
        System.out.println("ROUND: " + round + "\n\n");
    }

    public static void askPlayerToRoll() {
        System.out.println("What would you like to do?\n\n" +
                "1 - [Gently Toss Dice]\n2 - [Throw Dice Vigorously]\n3 - [Shake Dice]\n");
    }
    public static void askPlayerToBinDice() {
        System.out.println("\nWhat dice would you like to place in your bin? If none, enter 0.\n");
    }

    public static ArrayList processUserInput(int userInput, int activeDice) {
        if (userInput == 1 || userInput == 2) {
            return roll(activeDice);
        } else {
            System.out.println("\nYou feel lucky.\n");
            return roll(activeDice);
        }
    }

    //SCORING

    public static ArrayList binData(ArrayList bin) {

        ArrayList binData = new ArrayList<>();

        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int sixCount = 0;

        for (int i = 0; i < bin.size(); i++) {
            if (bin.get(i).equals(1)) {
                oneCount++;
            } else if (bin.get(i).equals(2)) {
                twoCount++;
            } else if (bin.get(i).equals(3)) {
                threeCount++;
            } else if (bin.get(i).equals(4)) {
                fourCount++;
            } else if (bin.get(i).equals(5)) {
                fiveCount++;
            } else if (bin.get(i).equals(6)) {
                sixCount++;
            }
        }

        binData.add(oneCount);
        binData.add(twoCount);
        binData.add(threeCount);
        binData.add(fourCount);
        binData.add(fiveCount);
        binData.add(sixCount);

        return binData;
    }

    public static boolean hasOnes(ArrayList binData) {
        boolean hasOnes = false;
            if (!binData.get(0).equals(0)) {
                hasOnes = true;
        }
        return hasOnes;
    }

    public static boolean hasTwos(ArrayList binData) {
        boolean hasTwos = false;
        if (!binData.get(1).equals(0)) {
            hasTwos = true;
        }
        return hasTwos;
    }

    public static boolean hasThrees(ArrayList binData) {
        boolean hasThrees = false;
        if (!binData.get(2).equals(0)) {
            hasThrees = true;
        }
        return hasThrees;
    }

    public static boolean hasFours(ArrayList binData) {
        boolean hasFours = false;
        if (!binData.get(3).equals(0)) {
            hasFours = true;
        }
        return hasFours;
    }

    public static boolean hasFives(ArrayList binData) {
        boolean hasFives = false;
        if (!binData.get(4).equals(0)) {
            hasFives = true;
        }
        return hasFives;
    }

    public static boolean hasSixes(ArrayList binData) {
        boolean hasSixes = false;
        if (!binData.get(5).equals(0)) {
            hasSixes = true;
        }
        return hasSixes;
    }

    public static boolean isThreeOfAKind(ArrayList binData) {
        boolean isThreeOfAKind = false;
        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(3)) {
                isThreeOfAKind = true;
            }
        }
        return isThreeOfAKind;
    }

    public static boolean isFourOfAKind(ArrayList binData) {
        boolean isFourOfAKind = false;
        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(4)) {
                isFourOfAKind = true;
            }
        }
        return isFourOfAKind;
    }

    public static boolean isYahtzee(ArrayList binData) {
        boolean isYahtzee = false;
        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(5)) {
                isYahtzee = true;
            }
        }
        return isYahtzee;
    }
    public static boolean isFullHouse(ArrayList binData) {
        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;
        boolean isFullHouse = false;

        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(2)){
                hasTwoOfAKind = true;
            }
        }

        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(3)) {
                hasThreeOfAKind = true;
            }
        }

        if (hasTwoOfAKind == true && hasThreeOfAKind == true) {
            isFullHouse = true;
        }

        return isFullHouse;
    }

    public static boolean isSmallStraight(ArrayList binData) {
        boolean isSmallStraight = false;

        if (binData.get(0).equals(1)) {
            if (binData.get(1).equals(1) && binData.get(2).equals(1) && binData.get(3).equals(1)) {
                isSmallStraight = true;
            }
        } else if (binData.get(1).equals(1)) {
            if (binData.get(2).equals(1) && binData.get(3).equals(1) && binData.get(4).equals(1)) {
                isSmallStraight = true;
            }
        } else if (binData.get(2).equals(1)) {
            if (binData.get(3).equals(1) && binData.get(4).equals(1) && binData.get(5).equals(1)) {
                isSmallStraight = true;
            }
        }

        return isSmallStraight;
    }
    public static boolean isLargeStraight(ArrayList binData) {
        boolean isLargeStraight = false;

        if (binData.get(0).equals(1)) {
            if (binData.get(1).equals(1) && binData.get(2).equals(1) && binData.get(3).equals(1) && binData.get(4).equals(1)) {
                isLargeStraight = true;
            }
        } else if (binData.get(1).equals(1)) {
            if (binData.get(2).equals(1) && binData.get(3).equals(1) && binData.get(4).equals(1) && binData.get(4).equals(1)) {
                isLargeStraight = true;
            }
        }

        return isLargeStraight;
    }

    public static ArrayList getScoreChoices(ArrayList binData) {
        ArrayList scoreChoices = new ArrayList<>();

        if (isYahtzee(binData)) { scoreChoices.add("Yahtzee"); }
        if (isLargeStraight(binData)) { scoreChoices.add("Large Straight"); }
        if (isSmallStraight(binData)) { scoreChoices.add("Small Straight"); }
        if (isThreeOfAKind(binData)) { scoreChoices.add("Three of a Kind"); }
        if (isFourOfAKind(binData)) { scoreChoices.add("Four of a Kind"); }
        if (isFullHouse(binData)) { scoreChoices.add("Full House"); }
        if (hasOnes(binData)) { scoreChoices.add("Ones"); }
        if (hasTwos(binData)) { scoreChoices.add("Twos"); }
        if (hasThrees(binData)) { scoreChoices.add("Threes"); }
        if (hasFours(binData)) { scoreChoices.add("Fours"); }
        if (hasFives(binData)) { scoreChoices.add("Fives"); }
        if (hasSixes(binData)) { scoreChoices.add("Sixes"); }

        scoreChoices.add("Chance");

        return scoreChoices;

    }

}
