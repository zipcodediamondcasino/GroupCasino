package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.BettingGame;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

public class RouletteGame implements Game, BettingGame {
    Integer[] wheel = new Integer[]{0, 28, 9, 26, 30, 11, 7, 20, 32, 17, 5, 22, 34, 15, 3, 24, 36, 13, 1, 0, 27, 10, 25, 29, 12, 8, 19, 31, 18, 6, 21, 33, 16, 4, 23, 35, 14, 2};
    Player player;
    int pool;
    ArrayList<Integer> valid = new ArrayList<>();
    IOConsole con = new IOConsole(AnsiColor.BLUE, System.in, System.out);


    @Override
    public boolean bet(Player player, int amount, int minimum) {
        if (amount < minimum) {
            con.println("$5 is the minimum bet");
            return false;
        } else if (amount > player.getCasinoAccount().getBalance()) {
            con.println("Insufficient funds");
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
        String command;
        String call;
        while (true) {
            //con.println("Welcome: would you like to spin the roulette?\n1: spin\n2: leave");
            command = con.getStringInput("Welcome: would you like to spin the roulette?\n1: spin\n2: leave");
            if (command.equals("1")) {
                if(bet(this.player, con.getIntegerInput("Please enter how much you would like to bet"), 5)){
                    call = call();
                    double bal = this.player.getCasinoAccount().getBalance();
                    this.player.getCasinoAccount().setBalance(bal + pool*(result(spin(), call, valid)) );
                }
                pool = 0;
            } else if (command.equals("2")) {
                remove(this.player);
                break;
            } else {
                con.println("Please enter a valid command");
            }
        }
    }

    public int spin() {
        int result = (int) (Math.random() * 38);
        con.print("\n~~The roulette landed on %d!~~\n\n", wheel[result]);
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

        con.println("/------------------------------------------------------------------------------------\\ \n" +
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
            val = con.getStringInput("What would you like to call? additional calls not listed street: row of 3   split: pair of adjacent numbers\n" +
                    "straight: one specific number   corner: four numbers around the same point (+)  line: both sides of a row\n").trim().toLowerCase();
            switch(val) { //this is some of the nastiest code I've written in my life - seth
                case "straight":
                    valid.add(con.getIntegerInput("What number do you want"));
                return val;
                case "split":
                    num = con.getIntegerInput("Please pick two adjacent numbers");
                    num2 = con.getIntegerInput("Enter the second");
                    if(Math.abs(num - num2) != 3 && Math.abs(num - num2) != 1){
                        con.println("Please enter adjacent numbers");
                        continue;
                    }
                    valid.add(num);
                    valid.add(num2);
                    return val;
                case "street":
                    num = con.getIntegerInput("Enter the bottom number of the street you want");
                    valid.add(num);
                    valid.add(num+1);
                    valid.add(num+2);
                    return val;
                case "corner":
                    num = con.getIntegerInput("Pick the top left corner you want");
                    if(num%3 ==1 || num>33){
                        con.println("Please enter a valid corner");
                    }
                    valid.add(num);
                    valid.add(num+3);
                    valid.add(num-1);
                    valid.add(num+2);
                    return val;

                case "line":
                    num = con.getIntegerInput("Pick the bottom left of the line you want");
                    if(num%3 != 1){
                        con.println("Please pick a valid line");
                        continue;
                    }
                    for (int i = 0; i < 6; i++) {
                        valid.add(num+i);
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
                    con.println("Please enter a valid bet");
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