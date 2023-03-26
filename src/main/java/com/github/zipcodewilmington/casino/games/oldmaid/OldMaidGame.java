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
        OldMaidGame game = new OldMaidGame();
        run();
    }
    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Would you like to play Old Maid?\n1: Yes\n2: leave");
            command = in.next().trim();
            if (command.equals("1")) {
                System.out.println("Beginning of Run of the Old Maid Card Game");
                gameStart();
            } else if (command.equals("2")) {
                remove(this.player);
            } else {
                System.out.println("Please enter a valid command");
            }
            break;
        }
    }
    public void gameStart(){
        OldMaidDealer dealer = new OldMaidDealer();
        OldMaidPlayer player = new OldMaidPlayer(CasinoAccount);
        dealer.makeShuffle();
        dealer.dealCards();
        ArrayList<Card> dealerHand = dealer.getDealerHand();
//        dealerHand = dealer.setDealerHand();
        ArrayList<Card> playerHand = dealer.getPlayerHand();
//        playerHand = dealer.setPlayerHand();
        while (dealerHand.size() > 1 && playerHand.size() > 1) {
            // player picks card and card gets removed from dealerHand
            Card cardPPick = player.pickCard(dealerHand);
            playerHand.add(cardPPick);
            dealerHand.remove(cardPPick);
            player.matchCard(playerHand);

            // dealer picks and card gets removed from playerHand
            Card cardDPick = dealer.pickCard(playerHand);
            dealerHand.add(cardDPick);
            playerHand.remove(cardPPick);
            dealer.matchCard(dealerHand);

            Card OldMaid = new Card(Suit.SPADES,QUEEN);
            if (dealerHand.size() == 1 && dealerHand.contains(OldMaid)){
                System.out.println("Congratulations, you won. The dealer ended up with Old Maid card.");
            } else if (playerHand.size() == 1 && playerHand.contains(OldMaid)){
                System.out.println("You have ended up with Old Maid and have lost. Better luck next time.");
            }
        }
    }
}
