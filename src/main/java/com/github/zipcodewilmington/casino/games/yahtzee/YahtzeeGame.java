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
                //Add rest of dice to bin
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

    public static boolean isThreeOfAKind(ArrayList bin) {
        boolean isThreeOfAKind = false;
        for (int i = 0; i < bin.size(); i++){
            if (bin.get(i).equals(3)) {
                isThreeOfAKind = true;
            }
        }
        return isThreeOfAKind;
    }

    public static boolean isFourOfAKind(ArrayList bin) {
        boolean isFourOfAKind = false;
        for (int i = 0; i < bin.size(); i++){
            if (bin.get(i).equals(3)) {
                isFourOfAKind = true;
            }
        }
        return isFourOfAKind;
    }

    public static boolean isYahtzee(ArrayList bin) {
        boolean isYahtzee = false;
        for (int i = 0; i < bin.size(); i++){
            if (bin.get(i).equals(5)) {
                isYahtzee = true;
            }
        }
        return isYahtzee;
    }
    public static boolean isFullHouse(ArrayList bin) {
        boolean hasThreeOfAKind = false;
        boolean hasTwoOfAKind = false;
        boolean isFullHouse = false;

        for (int i = 0; i < bin.size(); i++){
            if (bin.get(i).equals(3)) {
                hasThreeOfAKind = true;
            } else if (bin.get(i).equals(3)){
                hasTwoOfAKind = true;
            }
        }

        if (hasTwoOfAKind == true && hasThreeOfAKind == true) {
            isFullHouse = true;
        }

        return isFullHouse;
    }

    public static boolean isSmallStraight(ArrayList bin) {
        boolean isSmallStraight = false;

        if (bin.get(0).equals(1)) {
            if (bin.get(1).equals(1) && bin.get(2).equals(1) && bin.get(3).equals(1)) {
                isSmallStraight = true;
            }
        } else if (bin.get(1).equals(1)) {
            if (bin.get(2).equals(1) && bin.get(3).equals(1) && bin.get(4).equals(1)) {
                isSmallStraight = true;
            }
        } else if (bin.get(2).equals(1)) {
            if (bin.get(3).equals(1) && bin.get(4).equals(1) && bin.get(5).equals(1)) {
                isSmallStraight = true;
            }
        }

        return isSmallStraight;
    }
    public static boolean isLargeStraight(ArrayList bin) {
        boolean isLargeStraight = false;

        if (bin.get(0).equals(1)) {
            if (bin.get(1).equals(1) && bin.get(2).equals(1) && bin.get(3).equals(1) && bin.get(4).equals(1)) {
                isLargeStraight = true;
            }
        } else if (bin.get(1).equals(1)) {
            if (bin.get(2).equals(1) && bin.get(3).equals(1) && bin.get(4).equals(1) && bin.get(4).equals(1)) {
                isLargeStraight = true;
            }
        }

        return isLargeStraight;
    }

}
