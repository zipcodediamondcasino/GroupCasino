package com.github.zipcodewilmington.casino.games.oldmaid;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import static com.github.zipcodewilmington.casino.Number.QUEEN;

public class OldMaidGame implements Game {
    OldMaidPlayer player;
    CasinoAccount CasinoAccount;
    ArrayList<Card> Hand;

    @Override
    public void add(Player player) {
        this.player = (OldMaidPlayer) player;

    }

    @Override
    public void remove(Player player) {
        if (this.player == player){
            this.player = null;
        }
    }

    @Override
    public ArrayList<Player> getPlayers() {
//        OldMaidPlayer oldPlayer = new OldMaidPlayer(this.CasinoAccount);
//        ArrayList<Player> OldMaidPlayers = new ArrayList<>();
//        OldMaidPlayers.add(oldPlayer);
//        return OldMaidPlayers;
        ArrayList<Player> player = new ArrayList<>();
        player.add(this.player);
        return player;
    }

    public void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String command;
        System.out.println("Would you like to play Old Maid?\n1: Yes\n2: leave");
        command = scan.next().trim();
        if (command.equals("1")) {
            System.out.println("Beginning of Run of the Old Maid Card Game");
        } else if (command.equals("2")) {
            remove(this.player);
        } else {
            System.out.println("Please enter a valid command");
        }
        OldMaidGame game = new OldMaidGame();
        game.run();
    }
    @Override
    public void run() {
        OldMaidDealer.deckShuffle();
        OldMaidDealer.dealCards();
        ArrayList<Card> dealerHand = new ArrayList<>();
        dealerHand = OldMaidDealer.setDealerHand();
        ArrayList<Card> playerHand = new ArrayList<>();
        playerHand = OldMaidDealer.setPlayerHand();
        while (dealerHand.size() > 1 && playerHand.size() > 1) {
            OldMaidPlayer.pickCard(dealerHand);
            OldMaidPlayer.matchCard(playerHand);
            OldMaidDealer.pickCard(playerHand);
            OldMaidDealer.matchCard(dealerHand);
        }
        Card OldMaid = new Card(Suit.SPADES,QUEEN);
        if (dealerHand.size() == 1 && dealerHand.contains(OldMaid)){
            System.out.println("Congratulations, you won. The dealer ended up with Old Maid card.");
        } else if (playerHand.size() == 1 && playerHand.contains(OldMaid)){
            System.out.println("You have ended up with Old Maid and have lost. Better luck next time.");
        }
    }



}
