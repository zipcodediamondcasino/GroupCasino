package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.BettingGame;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class RouletteGame implements Game, BettingGame {
    Integer[] wheel = new Integer[]{0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1, 0, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35, 14, 2};
    String[] calls = new String[]{"straight", "split", "street", "column", "dozen", "odd", "even", "red", "black", "low", "high"};
    Player player;
    int pool;
    ArrayList<Integer> valid = new ArrayList<>();


    @Override
    public boolean bet(Player player, int amount, int minimum) {
        if (amount < minimum) {
            System.out.println("$5 is the minimum bet");
            return false;
        } else if (amount > player.getCasinoAccount().getBalance()) {
            System.out.println("Insufficient funds");
            return false;
        } else {
            player.getCasinoAccount().setBalance(player.getCasinoAccount().getBalance() - amount);
            this.pool = amount;
            return true;
        }
    }

    @Override
    public void add(Player player) {
        this.player = player;
    }

    @Override
    public void remove(Player player) {
        if (this.player == player) {
            this.player = null;
        }
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return new ArrayList<>(Collections.singleton(player));
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        String command;
        String call;
        int val;
        while (true) {
            System.out.println("Welcome: would you like to spin the roulette?\n1: spin\n2: leave");
            command = in.next().trim();
            in.nextLine();
            if (command.equals("1")) {
                try {
                    System.out.println("Please enter how much you would like to bet");
                    val = in.nextInt();
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a number\n");
                    continue;
                }
                if(bet(this.player, val, 5)){
                    call = call();
                    double bal = this.player.getCasinoAccount().getBalance();
                    this.player.getCasinoAccount().setBalance(bal + pool*(result(spin(), call, valid)) );
                }
                pool = 0;
            } else if (command.equals("2")) {
                remove(this.player);
                break;
            } else {
                System.out.println("Please enter a valid command");
            }
        }
    }

    public int spin() {
        int result = (int) (Math.random() * 38);
        System.out.printf("\n~~The roulette landed on %d!~~\n\n", wheel[result]);
        return result;
    }

    public String call(){
        Scanner in = new Scanner(System.in);
        String val;
        int num;
        int num2;
        if(valid != null){
            valid.clear();
        }

        System.out.println("/------------------------------------------------------------------------------------\\ \n" +
                "| R: 3 | B: 6 | R: 9 | R:12 | B:15 | R:18 | R:21 | B:24 | R: 27 | R:30 | B:33 | R:36 | column 3\n" +
                "|------+------+------+------+------+------+------+------+-------+------+------+------|\n" +
                "| B: 2 | R: 5 | B: 8 | B:11 | R:14 | B:17 | B:20 | R:23 | B: 26 | B:29 | R:32 | B:35 | column 2\n" +
                "|------+------+------+------+------+------+------+------+-------+------+------+------|\n" +
                "| R: 1 | B: 4 | R: 7 | R:10 | B:13 | R:16 | R:19 | B:22 | R: 25 | R:28 | B:31 | R:34 | column 1\n" +
                "|---------------------------+---------------------------+----------------------------|\n" +
                "|            dozen1         |          dozen2           |           dozen3           |\n" +
                "|---------------------------+---------------------------+----------------------------|\n" +
                "|     low      |    even    |     red     |     black   |     odd      |     high    |\n" +
                "\\------------------------------------------------------------------------------------/\n");
        do{
            System.out.println("What would you like to call? additional calls not listed street: row of 3   split: pair of adjacent numbers\n" +
                    "straight: one specific number   corner: four numbers around the same point (+)  line: both sides of a row\n");
            val = in.next().trim().toLowerCase();
            switch(val) {
                case "straight":
                    System.out.println("What number do you want");
                    try{
                        num = in.nextInt();
                        valid.add(num);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                return val;
                case "split":
                    System.out.println("Please pick two adjacent numbers");
                    try{
                        num = in.nextInt();
                        System.out.println("Enter the second");
                        num2 = in.nextInt();
                        valid.add(num);
                        valid.add(num2);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                    return val;
                case "street":
                    System.out.println("Enter the bottom number of the street you want");
                    try{
                        num = in.nextInt();
                        valid.add(num);
                        valid.add(num+1);
                        valid.add(num+2);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                    return val;

                case "corner":
                    System.out.println("Pick the top right corner you want");
                    try{
                        num = in.nextInt();
                        valid.add(num);
                        valid.add(num+3);
                        valid.add(num-1);
                        valid.add(num+2);
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                    return val;

                case "line":
                    System.out.println("Pick the bottom left of the line you want");
                    try{
                        num = in.nextInt();
                        for (int i = 0; i < 6; i++) {
                            valid.add(num+i);
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter a valid number");
                        continue;
                    }
                    return val;

                case "column1":
                    for (int i = 0; i < 12; i++) {
                        valid.add(1+3*i);
                    }
                    return "column";
                case "column2":
                    for (int i = 0; i < 12; i++) {
                        valid.add(2+3*i);
                    }
                    return "column";
                case "column3":
                    for (int i = 0; i < 12; i++) {
                        valid.add(3+3*i);
                    }
                    return "column";
                case "dozen1":
                    for (int i = 0; i < 12; i++) {
                        valid.add(i);
                    }
                    return "dozen";
                case "dozen2":
                    for (int i = 0; i < 12; i++) {
                        valid.add(12+i);
                    }
                    return "dozen";
                case "dozen3":
                    for (int i = 0; i < 12; i++) {
                        valid.add(24+i);
                    }
                    return "dozen";

                case "odd":
                case "even":
                case "red":
                case "black":
                case "low":
                case "high":
                    valid.add(-1);
                    return val;
                default:
                    System.out.println("Please enter a valid bet");
            }
        }while(true);
    }

    public int result(int segment, String call, ArrayList<Integer> nums){
        switch(call){
            case "straight":
                return (Objects.equals(wheel[segment], nums.get(0))) ? 36 : 0;
            case "split":
                return (nums.contains(wheel[segment])) ? 18 : 0;
            case "street":
                return (nums.contains(wheel[segment])) ? 12 : 0;
            case "corner":
                return (nums.contains(wheel[segment])) ? 9 : 0;
            case "line":
                return (nums.contains(wheel[segment])) ? 6 : 0;
            case "column":
            case "dozen":
                return (nums.contains(wheel[segment])) ? 3 : 0;
            case "odd":
                return (wheel[segment]%2 == 1) ? 2 : 0;
            case "even":
                return (wheel[segment]%2 == 0 && wheel[segment] != 0) ? 2 : 0;
            case "red":
                return (segment % 2 == 0 && wheel[segment] != 0) ? 2 : 0;
            case "black":
                return (segment % 2 == 1 && wheel[segment] != 0) ? 2 : 0;
            case "low":
                return (wheel[segment] < 19 && wheel[segment] != 0) ? 2 : 0;
            case "high":
                return (wheel[segment] > 18) ? 2 : 0;
        }
        return 0;
    }
}