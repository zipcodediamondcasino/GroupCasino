package com.github.zipcodewilmington.casino.games.yahtzee;

import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;
import java.util.*;

public class YahtzeeGame implements Game {

    static Scanner scanner = new Scanner(System.in);
    static LinkedHashMap<String, Integer> scoreCard = newScoreCard();
    //Current round out of 13
    static int round = 1;
    //Array list of the values of each dice for current roll
    static ArrayList<Integer> currentRoll = new ArrayList<>();
    //Array list of dice that have been placed in bin
    static ArrayList<Integer> currentBin = new ArrayList<>();
    //How many dice are available to roll
    static int activeDice = 5;
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

        //Until 13 rounds have been completed, run game
        while (round <= 13) {
            //Print current round
            beginRound(round);
            //Player rolls and bins dice until 3 rolls have been reached
            playerSequence(activeDice, currentRoll, currentBin);
            //Takes bin and converts it into data structure that getScoreChoices methods can comprehend
            ArrayList<Integer> currentScore = binData(currentBin);
            //Score choices that the player has based on the dice in their bin
            ArrayList<String> presentChoices = getScoreChoices(currentScore);
            //Prints possible score choices to user
            printScoreChoices(presentChoices);
            askPlayerToChooseScoreSlot();
            int userScoreChoice = scanner.nextInt();
            String choice = deciferScoreChoice(userScoreChoice, presentChoices);
            System.out.println("Choice: " + choice);
            fillScoreCard(choice, scoreCard, currentBin);
            //Clears fields to be used by next player
            clearFields(currentBin, currentRoll);
            //Increments round
            round++;
        }
    }

    public static void clearFields(ArrayList<Integer> currentBin, ArrayList<Integer> currentRoll) {
        currentBin.clear();
        currentRoll.clear();
    }

    public static void playerSequence(int activeDice, ArrayList<Integer> currentRoll, ArrayList<Integer> currentBin){
        //How many rolls the player has left in this turn
        int rollCount = 0;

            while (currentBin.size() < 5)

                if (rollCount == 0 || rollCount == 1) {
                    //Prompt user to roll
                    askPlayerToRoll();
                    //Takes user input
                    int userInputRoll = scanner.nextInt();
                    //Processes user input
                    currentRoll = processUserInput(userInputRoll, activeDice);
                    //Ask player which dice they would like to place into bin
                    askPlayerToBinDice();
                    //Takes user input
                    String[] addToBinArray = scanner.next().split("");
                    //Converts into array list
                    ArrayList<String> addToBin = convertArrayToArrayList(addToBinArray);
                    //Adds selected dice into bin
                    currentBin = addDieToBin(currentBin, addToBin, currentRoll);
                    //Keeps track of how many dice are in play
                    activeDice = 5 - currentBin.size();
                    //Increments roll count
                    rollCount++;
                    //Displays current bin
                    System.out.println("Current Bin: " + currentBin);
                } else if (rollCount == 2) {
                    askPlayerToRoll();
                    int userInputRoll = scanner.nextInt();
                    currentRoll = processUserInput(userInputRoll, activeDice);
                    String[] addToBinArray = new String[currentRoll.size()];
                    ArrayList<String> addToBin = convertArrayToArrayList(addToBinArray);
                    for (int i = 0; i < addToBin.size(); i++) {
                        addToBin.set(i, currentRoll.get(i).toString());
                    }
                    currentBin = (addRemainingDiceToBin(currentBin, currentRoll));
                    activeDice = 5 - currentBin.size();
                    rollCount++;
                    System.out.println("Current Bin: " + currentBin);
                }
            }

    public static ArrayList<String> convertArrayToArrayList(String[] arr) {
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            stringList.add(arr[i]);
        }
        return stringList;
    }

    public static int diceRoll() {
        double roll = (Math.random() * (6 - 1) + 1);
        return (int)Math.round(roll);
    }

    public static ArrayList<Integer> roll(int activeDice){
        ArrayList<Integer> currentRoll = new ArrayList<>();
        for (int i = 1; i <= activeDice; i++) {
            currentRoll.add(diceRoll());
        }
        printRoll(currentRoll);
        return currentRoll;
    }

    public static void printRoll(ArrayList<Integer> currentRoll) {
        for (int i = 0; i < currentRoll.size(); i++) {
            System.out.println(i + 1 + " - [" + currentRoll.get(i) + "]");
        }
    }

    public static void printScoreChoices(ArrayList<String> scoreChoices) {
        for (int i = 0; i < scoreChoices.size(); i++) {
            System.out.println(i + 1 + " - [" + scoreChoices.get(i) + "]");
        }
    }
    public static ArrayList<Integer> addRemainingDiceToBin(ArrayList<Integer> currentBin, ArrayList<Integer> currentRoll){
        for (int i = 0; i < currentRoll.size() - 1; i++) {
            currentBin.add(currentRoll.get(i));
        }
        return currentBin;
    }

    public static ArrayList<Integer> addDieToBin(ArrayList<Integer> currentBin, ArrayList<String> binned, ArrayList<Integer> currentRoll) {

        for (int i = 0; i < binned.size(); i++) {
                currentBin.add(currentRoll.get(Integer.parseInt(binned.get(i)) - 1));
        }
        return currentBin;
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

    public static void askPlayerToChooseScoreSlot() {
        System.out.println("\nWhich would you like to chose?\n");
    }

    public static ArrayList<Integer> processUserInput(int userInput, int activeDice) {
        if (userInput == 1 || userInput == 2) {
            return roll(activeDice);
        } else {
            System.out.println("\nYou feel lucky.\n");
            return roll(activeDice);
        }
    }

    //SCORING

    public static LinkedHashMap<String, Integer> newScoreCard() {
        LinkedHashMap<String, Integer> newHashMap = new LinkedHashMap<>();
        newHashMap.put("Ones", null);
        newHashMap.put("Twos", null);
        newHashMap.put("Threes", null);
        newHashMap.put("Fours", null);
        newHashMap.put("Fives", null);
        newHashMap.put("Sixes", null);
        newHashMap.put("Three of a Kind", null);
        newHashMap.put("Four of a Kind", null);
        newHashMap.put("Full House", null);
        newHashMap.put("Small Straight", null);
        newHashMap.put("Large Straight", null);
        newHashMap.put("Yahtzee", null);
        newHashMap.put("Chance", null);
        newHashMap.put("Total", 0);

        return newHashMap;
    }

    public static String deciferScoreChoice(int score, ArrayList<String> scoreChoices){
        String choice = "Chance";
        for (int i = 1; i < scoreChoices.size(); i++){
            if (score == i) {
                choice = scoreChoices.get(i - 1);
            }
        }
        return choice;
    }

    public static void fillScoreCard(String choice, LinkedHashMap<String, Integer> scoreCard, ArrayList<Integer> bin) {

        if (choice.equals("Ones")) {
            scoreCard.put(choice, Integer.parseInt(bin.get(0).toString()));
            scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(0).toString()));
        } else if (choice.equals("Twos")){
            scoreCard.put(choice, Integer.parseInt(bin.get(1).toString()) * 2);
            scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(1).toString()) * 2);
        } else if (choice.equals("Threes")){
            scoreCard.put(choice, Integer.parseInt(bin.get(2).toString()) * 3);
            scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(2).toString()) * 3);
        } else if (choice.equals("Fours")){
            scoreCard.put(choice, Integer.parseInt(bin.get(3).toString()) * 4);
            scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(3).toString()) * 4);
        } else if (choice.equals("Fives")){
            scoreCard.put(choice, Integer.parseInt(bin.get(4).toString()) * 5);
            scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(4).toString()) * 5);
        } else if (choice.equals("Sixes")){
            scoreCard.put(choice, Integer.parseInt(bin.get(5).toString()) * 6);
            scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(5).toString()) * 6);
        } else if (choice.equals("Three of a Kind")){
            for (int i = 0; i < bin.size(); i++) {
                if (Integer.parseInt(bin.get(i).toString()) >= 3){
                    scoreCard.put(choice, (i+1) * 3);
                    scoreCard.put("Total", scoreCard.get("Total") + (i+1) * 3);
                }
            }
        } else if (choice.equals("Four of a Kind")){
            for (int i = 0; i < bin.size(); i++) {
                if (Integer.parseInt(bin.get(i).toString()) >= 4){
                    scoreCard.put(choice, (i+1) * 4);
                    scoreCard.put("Total", scoreCard.get("Total") + (i+1) * 4);
                }
            }
        } else if (choice.equals("Full House")){
            scoreCard.put(choice, 25);
            scoreCard.put("Total", scoreCard.get("Total") + 25);
        }else if (choice.equals("Small Straight")){
            scoreCard.put(choice, 30);
            scoreCard.put("Total", scoreCard.get("Total") + 30);
        } else if (choice.equals("Large Straight")){
            scoreCard.put(choice, 40);
            scoreCard.put("Total", scoreCard.get("Total") + 40);
        } else if (choice.equals("Yahtzee")){
            scoreCard.put(choice, 50);
            scoreCard.put("Total", scoreCard.get("Total") + 50);
        } else if (choice.equals("Chance")){
            int roundScore = Integer.parseInt(bin.get(0).toString()) +
                    Integer.parseInt(bin.get(1).toString()) +
                    Integer.parseInt(bin.get(2).toString()) +
                    Integer.parseInt(bin.get(3).toString()) +
                    Integer.parseInt(bin.get(4).toString());
            scoreCard.put(choice, roundScore);
            scoreCard.put("Total", scoreCard.get("Total") + roundScore);
        }
        System.out.println(choice);
        System.out.println(scoreCard);
    }

    public static ArrayList<Integer> binData(ArrayList<Integer> bin) {

        ArrayList<Integer> binData = new ArrayList<>();

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

    public static boolean hasOnes(ArrayList<Integer> binData) {
        boolean hasOnes = false;
            if (!binData.get(0).equals(0)) {
                hasOnes = true;
        }
        return hasOnes;
    }

    public static boolean hasTwos(ArrayList<Integer> binData) {
        boolean hasTwos = false;
        if (!binData.get(1).equals(0)) {
            hasTwos = true;
        }
        return hasTwos;
    }

    public static boolean hasThrees(ArrayList<Integer> binData) {
        boolean hasThrees = false;
        if (!binData.get(2).equals(0)) {
            hasThrees = true;
        }
        return hasThrees;
    }

    public static boolean hasFours(ArrayList<Integer> binData) {
        boolean hasFours = false;
        if (!binData.get(3).equals(0)) {
            hasFours = true;
        }
        return hasFours;
    }

    public static boolean hasFives(ArrayList<Integer> binData) {
        boolean hasFives = false;
        if (!binData.get(4).equals(0)) {
            hasFives = true;
        }
        return hasFives;
    }

    public static boolean hasSixes(ArrayList<Integer> binData) {
        boolean hasSixes = false;
        if (!binData.get(5).equals(0)) {
            hasSixes = true;
        }
        return hasSixes;
    }

    public static boolean isThreeOfAKind(ArrayList<Integer> binData) {
        boolean isThreeOfAKind = false;
        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(3)) {
                isThreeOfAKind = true;
            }
        }
        return isThreeOfAKind;
    }

    public static boolean isFourOfAKind(ArrayList<Integer> binData) {
        boolean isFourOfAKind = false;
        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(4)) {
                isFourOfAKind = true;
            }
        }
        return isFourOfAKind;
    }

    public static boolean isYahtzee(ArrayList<Integer> binData) {
        boolean isYahtzee = false;
        for (int i = 0; i < binData.size(); i++){
            if (binData.get(i).equals(5)) {
                isYahtzee = true;
            }
        }
        return isYahtzee;
    }
    public static boolean isFullHouse(ArrayList<Integer> binData) {
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

        if (hasTwoOfAKind && hasThreeOfAKind) {
            isFullHouse = true;
        }

        return isFullHouse;
    }

    public static boolean isSmallStraight(ArrayList<Integer> binData) {
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
    public static boolean isLargeStraight(ArrayList<Integer> binData) {
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

    public static ArrayList<String> getScoreChoices(ArrayList<Integer> binData) {
        ArrayList<String> scoreChoices = new ArrayList<>();

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