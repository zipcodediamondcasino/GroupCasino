package com.github.zipcodewilmington.casino.games.yahtzee;

import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;
import java.util.*;

public class YahtzeeGame implements Game {

    static Scanner scanner = new Scanner(System.in);
    static LinkedHashMap<String, Integer> scoreCard = newScoreCard();
    static LinkedHashMap<String, Integer> playerTwoScoreCard = newScoreCard();
    static int round = 1;
    static ArrayList<Integer> currentRoll = new ArrayList<>();
    static ArrayList<Integer> currentBin = new ArrayList<>();
    static int activeDice = 5;
    static int rollCount = 0;
    ArrayList<Player> players;
    @Override
    public void add(Player player) {;}
    @Override
    public void remove(Player player) {;}
    @Override
    public ArrayList<Player> getPlayers() {return null;}
    @Override
    public void run() {
        while (round <= 13) {
            if (round > 1) {
                System.out.println("Would you like to continue to play?\n1 - Yes\n2 - No");
                String playOrLeave = scanner.next();
                if (playOrLeave.equals("2")) {
                    break;
                }
            }

            System.out.println("\nROUND: " + round + "\n\n");

            while (currentBin.size() < 5) {

                System.out.println("What would you like to do?\n\n1 - [Gently Toss Dice]\n2 - [Throw Dice Vigorously]\n3 - [Shake Dice]\n");
                processUserInputRoll();
                ArrayList<Integer> roll = roll(activeDice);

                //DISPLAY EACH DICE USER ROLLED
                for (int i = 0; i < roll.size(); i++) {
                    System.out.println(i + 1 + " - [" + roll.get(i) + "]");
                }

                if (rollCount == 2) {
                    String[] addToBinArray = new String[roll.size()];
                    ArrayList<String> addToBin = convertArrayToArrayList(addToBinArray);
                    for (int i = 0; i < addToBin.size(); i++) {
                        addToBin.set(i, roll.get(i).toString());
                    }
                    currentBin = (addRemainingDiceToBin(currentBin, roll));
                } else {
                    System.out.println("\nWhat dice would you like to place in your bin? If none, enter 0.\n");
                    ArrayList<String> addToBin = processUserInputBin();
                    currentBin = addDieToBin(currentBin, addToBin, roll);
                    rollCount++;
                }
                activeDice = 5 - currentBin.size();
                System.out.println("Current Bin: " + currentBin);
            }

            ArrayList<Integer> currentScore = binData(currentBin);
            ArrayList<String> presentChoices = getScoreChoices(currentScore);

            //DISPLAY ALL POSSIBLE SCORE SLOT CHOICES
            for (int i = 0; i < presentChoices.size(); i++) {
                System.out.println(i + 1 + " - [" + presentChoices.get(i) + "]");
            }

            System.out.println("\nWhich would you like to chose?\n");
            int userScoreChoice = scanner.nextInt();
            String choice = deciferScoreChoice(userScoreChoice, presentChoices);
            System.out.println("\nChoice: " + choice + " \n");
            fillScoreCard(choice, scoreCard, currentScore);
            System.out.println("\nYour Score Card: " + scoreCard + "\n");
            populateComputerScoreCard(round, playerTwoScoreCard);
            System.out.println("\nPlayer 2 Score Card: " + playerTwoScoreCard + "\n");
            clearFields(currentBin, currentRoll);
            round++;
        }
        rollCount = 0;
        System.out.println("\nFINAL SCORE:\nYour Score Card: " + scoreCard + "\n\nYour Score Card: " + playerTwoScoreCard);
        clearFields(currentBin, currentRoll);
    }

    // SYSTEM OUT METHODS
    public static void processUserInputRoll(){
        boolean userInputValid = false;

        do {
            String userInput = scanner.next();
            switch (userInput) {
                case "1":
                case "2":
                    userInputValid = true;
                    break;
                case "3":
                    userInputValid = true;
                    System.out.println("\nYou feel lucky.\n");
                default:
                    System.out.println("Please enter a valid command");
            }
        } while (!userInputValid);
    }
    public static ArrayList<String> processUserInputBin(){
        boolean userInputValid = false;
        ArrayList<String> validUserInput = new ArrayList<>();

        do {
            String[] userInput = scanner.next().split("");
            for (int i = 0; i < userInput.length; i++) {
                if (isOneThruSix(userInput[i])) {
                    validUserInput = convertArrayToArrayList(userInput);
                    userInputValid = true;
                    break;
                };
            }
            if (userInputValid == false) {
                System.out.println("Invalid command");
            }
        } while (!userInputValid);
        return validUserInput;
    }
    //GAME FUNCTIONALITY
    public static boolean isOneThruSix(String a){
        boolean jawn = false;

        if (a.equals("0")){
            jawn = true;
        } else if (a.equals("1")) {
            jawn = true;
        } else if (a.equals("2")){
            jawn = true;
        } else if (a.equals("3")){
            jawn = true;
        } else if (a.equals("4")){
            jawn = true;
        } else if (a.equals("5")){
            jawn = true;
        }
        return jawn;
    }
    public static void clearFields(ArrayList<Integer> currentBin, ArrayList<Integer> currentRoll) {
        currentBin.clear();
        currentRoll.clear();
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
        return currentRoll;
    }
    public static ArrayList<Integer> addRemainingDiceToBin(ArrayList<Integer> currentBin, ArrayList<Integer> currentRoll){
        for (int i = 0; i < currentRoll.size(); i++) {
            currentBin.add(currentRoll.get(i));
        }
        return currentBin;
    }
    public static ArrayList<Integer> addDieToBin(ArrayList<Integer> currentBin, ArrayList<String> binned, ArrayList<Integer> currentRoll) {
        if (currentRoll.size() < binned.size()) {
            System.out.println("Invalid Input: No dice were placed into bin.");
        } else if (!binned.get(0).equals("0")){
            for (int i = 0; i < binned.size(); i++) {
                currentBin.add(currentRoll.get(Integer.parseInt(binned.get(i)) - 1));
            }
        }
        return currentBin;
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
        switch (choice) {
            case "Ones":
                scoreCard.put(choice, Integer.parseInt(bin.get(0).toString()));
                scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(0).toString()));
                break;
            case "Twos":
                scoreCard.put(choice, Integer.parseInt(bin.get(1).toString()) * 2);
                scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(1).toString()) * 2);
                break;
            case "Threes":
                scoreCard.put(choice, Integer.parseInt(bin.get(2).toString()) * 3);
                scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(2).toString()) * 3);
                break;
            case "Fours":
                scoreCard.put(choice, Integer.parseInt(bin.get(3).toString()) * 4);
                scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(3).toString()) * 4);
                break;
            case "Fives":
                scoreCard.put(choice, Integer.parseInt(bin.get(4).toString()) * 5);
                scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(4).toString()) * 5);
                break;
            case "Sixes":
                scoreCard.put(choice, Integer.parseInt(bin.get(5).toString()) * 6);
                scoreCard.put("Total", scoreCard.get("Total") + Integer.parseInt(bin.get(5).toString()) * 6);
                break;
            case "Three of a Kind":
                for (int i = 0; i < bin.size(); i++) {
                    if (Integer.parseInt(bin.get(i).toString()) >= 3) {
                        scoreCard.put(choice, (i + 1) * 3);
                        scoreCard.put("Total", scoreCard.get("Total") + (i + 1) * 3);
                    }
                }
                break;
            case "Four of a Kind":
                for (int i = 0; i < bin.size(); i++) {
                    if (Integer.parseInt(bin.get(i).toString()) >= 4) {
                        scoreCard.put(choice, (i + 1) * 4);
                        scoreCard.put("Total", scoreCard.get("Total") + (i + 1) * 4);
                    }
                }
                break;
            case "Full House":
                scoreCard.put(choice, 25);
                scoreCard.put("Total", scoreCard.get("Total") + 25);
                break;
            case "Small Straight":
                scoreCard.put(choice, 30);
                scoreCard.put("Total", scoreCard.get("Total") + 30);
                break;
            case "Large Straight":
                scoreCard.put(choice, 40);
                scoreCard.put("Total", scoreCard.get("Total") + 40);
                break;
            case "Yahtzee":
                scoreCard.put(choice, 50);
                scoreCard.put("Total", scoreCard.get("Total") + 50);
                break;
            case "Chance":
                int roundScore = Integer.parseInt(bin.get(0).toString()) +
                        Integer.parseInt(bin.get(1).toString()) +
                        Integer.parseInt(bin.get(2).toString()) +
                        Integer.parseInt(bin.get(3).toString()) +
                        Integer.parseInt(bin.get(4).toString());
                scoreCard.put(choice, roundScore);
                scoreCard.put("Total", scoreCard.get("Total") + roundScore);
                break;
        }
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
    public static void populateComputerScoreCard(int round, LinkedHashMap<String, Integer> playerTwoScoreCard){

        switch (round) {
            case 12:
                playerTwoScoreCard.put("Ones", 3);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 3);
                break;
            case 8:
                playerTwoScoreCard.put("Twos", 4);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 4);
                break;
            case 2:
                playerTwoScoreCard.put("Threes", 0);
                break;
            case 7:
                playerTwoScoreCard.put("Fours", 8);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 8);
                break;
            case 10:
                playerTwoScoreCard.put("Fives", 15);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 15);
                break;
            case 11:
                playerTwoScoreCard.put("Sixes", 12);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 12);
                break;
            case 1:
                playerTwoScoreCard.put("Three of a Kind", 9);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 9);
                break;
            case 4:
                playerTwoScoreCard.put("Four of a Kind", 12);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 12);
                break;
            case 13:
                playerTwoScoreCard.put("Full House", 25);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 25);
                break;
            case 3:
                playerTwoScoreCard.put("Small Straight", 30);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 30);
                break;
            case 9:
                playerTwoScoreCard.put("Large Straight", 0);
                break;
            case 5:
                playerTwoScoreCard.put("Yahtzee", 50);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 50);
                break;
            case 6:
                playerTwoScoreCard.put("Chance", 14);
                playerTwoScoreCard.put("Total", playerTwoScoreCard.get("Total") + 14);
                break;
        }
    }
}