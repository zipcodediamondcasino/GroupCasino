package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.baccarat.BaccaratGame;
import com.github.zipcodewilmington.casino.games.baccarat.BaccaratPlayer;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidGame;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidPlayer;
import com.github.zipcodewilmington.casino.games.poker.PokerGame;
import com.github.zipcodewilmington.casino.games.poker.PokerPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeePlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

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
        accounts.add(new CasinoAccount(2000, "taco", "l+ratio"));
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            switch (arcadeDashBoardInput) {
                case "select-game":
                    if (current != null) {
                        selectGame(getGameSelectionInput().toUpperCase());
                    } else {
                        console.println("Please log in or create an account before playing");
                    }
                    break;
                case "create-account":
                    createAccount();
                    break;
                case "login":
                    login();
                    break;
                case "add-funds":
                    addFunds();
                    break;
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private void addFunds() {
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
            case "POKER":
                play(new PokerGame(), new PokerPlayer(current));
                break;
            case "BLACKJACK":
            case "BLACK JACK":
                play(new BlackjackGame(), new BlackjackPlayer(current));
                break;
            case "YAHTZEE":
                play(new YahtzeeGame(), new YahtzeePlayer(current));
                break;
            case "BACCARAT":
                play(new BaccaratGame(), new BaccaratPlayer(current));
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
                .append("\n\t[ create-account ], [ select-game ], [ drink ]")
                .toString());
    }

    private void drink(){
        console.println("Thank you for your purchase");
        current.setBalance(current.getBalance()-4);
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ]")
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
