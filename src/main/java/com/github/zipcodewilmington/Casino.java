package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.coinflip.CoinFlipGame;
import com.github.zipcodewilmington.casino.games.coinflip.CoinFlipPlayer;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidGame;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidPlayer;
import com.github.zipcodewilmington.casino.games.poker.PokerGame;
import com.github.zipcodewilmington.casino.games.poker.PokerPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeePlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private ArrayList<CasinoAccount> accounts = new ArrayList<>();
    private CasinoAccount current;

    @Override
    public void run() {
        String arcadeDashBoardInput;
        load();
        //accounts.add(new CasinoAccount(100000, "root", "admin"));
        //CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do{
            arcadeDashBoardInput = getLoginAccount();
            switch (arcadeDashBoardInput) {
                case "login":
                    login();
                    break;
                case "create-account":
                    createAccount();
                    break;
                default:
                    console.println("Please enter a valid command");
            }

        }while(current == null);
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            switch (arcadeDashBoardInput) {
                case "select-game":
                    selectGame(getGameSelectionInput().toUpperCase());
                    break;
                case "add-funds":
                    addFunds();
                    break;
                case "check-funds":
                    checkFunds();
                    break;
                case "drink":
                        drink();
                        break;
                case "logout":
                    console.println("Thanks for coming!");
                    break;
                default:
                    console.println("Please enter a valid command");
            }
        } while (!"logout".equals(arcadeDashBoardInput));
        save();
    }

    public void save(){
        try {
            FileOutputStream fo = new FileOutputStream("src/main/java/com/github/zipcodewilmington/utils/accounts.txt");
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(accounts);
            out.close();
            fo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(){
        try {
            FileInputStream fi = new FileInputStream("src/main/java/com/github/zipcodewilmington/utils/accounts.txt");
            ObjectInputStream in = new ObjectInputStream(fi);
            accounts = (ArrayList<CasinoAccount>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private String getLoginAccount() {
        return console.getStringInput(new StringBuilder()
                .append("\nWelcome to the login portal!\n")
                .append("Please select:")
                .append("\n\t[ login ], [create-account ]")
                .toString());
    }

    private void addFunds() {
        current.setBalance(current.getBalance() +
                console.getIntegerInput("How much do you want to add to your account"));
    }

    private void checkFunds(){
        console.println("You have $" + current.getBalance() + " in your account.");
    }

    private void selectGame(String gameSelectionInput) {
        switch(gameSelectionInput){
            case "SLOTS":
                play(new SlotsGame(), new SlotsPlayer(current));
                break;
            case "OLDMAID":
            case "OLD MAID":
                play(new OldMaidGame(), new OldMaidPlayer(current));
                break;
      //      case "POKER":
       //         play(new PokerGame(), new PokerPlayer(current));
       //         break;
            case "BLACKJACK":
            case "BLACK JACK":
                play(new BlackjackGame(), new BlackjackPlayer(current));
                break;
            case "YAHTZEE":
                play(new YahtzeeGame(), new YahtzeePlayer(current));
                break;
    //        case "BACCARAT":
     //           play(new BaccaratGame(), new BaccaratPlayer(current));
    //            break;
            case "COIN FLIP":
                play(new CoinFlipGame(), new CoinFlipPlayer(current));
                break;
            case "ROULETTE":
                play(new RouletteGame(), new RoulettePlayer(current));
                break;
            default:
                String errorMessage = "[ %s ] is an invalid game selection";
                throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
        }
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n[ select-game ], [ add-funds ], [ check-funds ], [ drink ], [ logout ]")
                .toString());
    }

    private void drink(){
        console.println("Thank you for your purchase");
        current.setBalance(current.getBalance()-4);
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nWelcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n[ SLOTS ], [ OLD MAID ], [ BLACKJACK ], [ COIN FLIP ], [ YAHTZEE ], [ ROULETTE ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        Game game = (Game)gameObject;
        Player player = (Player)playerObject;
        game.add(player);
        game.run();
    }

    private void createAccount(){
        console.println("Welcome to the account-creation screen.");
        String accountName = console.getStringInput("Enter your account name:");
        String accountPassword = console.getStringInput("Enter your account password:");
        CasinoAccount newAccount = new CasinoAccount(0, accountName, accountPassword);
        accounts.add(newAccount);
        current = newAccount;
    }

    private void login(){
        console.println("Welcome to the account-creation screen.");
        String accountName = console.getStringInput("Enter your account name:");
        String accountPassword = console.getStringInput("Enter your account password:");
        for(CasinoAccount c : accounts){
            if(c.getName().equals(accountName)){
                if(c.getPassword().equals(accountPassword)){
                    current = c;
                    return;
                }
            }
        }
        console.println("Invalid login credentials");
    }
}
