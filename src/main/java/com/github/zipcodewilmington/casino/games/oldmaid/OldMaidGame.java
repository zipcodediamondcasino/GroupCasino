package com.github.zipcodewilmington.casino.games.oldmaid;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.*;

import java.sql.SQLOutput;
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

        ArrayList<Player> player = new ArrayList<>();
        player.add(this.player);
        return player;
    }

//        OldMaidPlayer oldPlayer = new OldMaidPlayer(this.CasinoAccount);
//        ArrayList<Player> OldMaidPlayers = new ArrayList<>();
//        OldMaidPlayers.add(oldPlayer);
//        return OldMaidPlayers;

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
                System.out.println("Beginning of Run of the Old Maid Card Game" + "\n");
                gameStart();
            } else if (command.equals("2")) {
                remove(this.player);
                new Casino().run();
            } else {
                System.out.println("Please enter a valid command" + "\n");
            }
            break;
        }
    }

    public void gameStart() {
        Card OldMaid = new Card(Suit.SPADES, QUEEN);
        OldMaidDealer dealer = new OldMaidDealer();
        OldMaidPlayer player = new OldMaidPlayer(CasinoAccount);
        dealer.makeShuffle();
        dealer.dealCards();
        ArrayList<Card> dealerHand = dealer.getDealerHand();
//        dealerHand = dealer.setDealerHand();
        ArrayList<Card> playerHand = dealer.getPlayerHand();
        System.out.println("The cards are being dealt. This is your hand: " + playerHand + "\n");
//        playerHand = dealer.setPlayerHand();
        while (dealerHand.size() > 1 && playerHand.size() > 1 ) {
            // player picks card and card gets removed from dealerHand
            Card cardPPick = player.pickCard(dealerHand);
            String playTurn = "It is your turn to pick from the dealer's hand." +
                    "This is the card you picked: ";
            System.out.println(playTurn + cardPPick + "\n");
            System.out.println("It will be added to your hand.\n");
            playerHand.add(cardPPick);
            dealerHand.remove(cardPPick);

            String match = "You have a pair! Here is your pair(s)!\n";
            player.matchCard(playerHand);

//             dealer picks and card gets removed from playerHand
            String dealTurn = "It is the dealer's turn to pick from your hand.";
            System.out.println(dealTurn);
            Card cardDPick = dealer.pickCard(playerHand);
            dealerHand.add(cardDPick);
            String dealRemove = "The card will be removed from your hand.\n";
            System.out.printf(dealRemove);
            playerHand.remove(cardPPick);

            dealer.matchCard(dealerHand);

//            if (dealer.matchCard(dealerHand).isEmpty() && player.matchCard(playerHand).size() == 1
//                    && playerHand.contains(OldMaid)) {
////                System.out.println("You lost. The dealer has won!\n");
//                System.out.println("You have ended up with Old Maid and have lost. Better luck next time.\n");
//            } else if (player.matchCard(playerHand).isEmpty() && dealer.matchCard(dealerHand).size() == 1
//                    && dealerHand.contains(OldMaid)) {
//                System.out.println("Congratulations, you won! The dealer ended up with Old Maid card.\n");
//            } else
            if (playerHand.isEmpty() && !dealerHand.isEmpty() && dealerHand.contains(OldMaid)) {
                System.out.println("Congratulations, you won! The dealer ended up with Old Maid card.\n");
            } else if (dealerHand.isEmpty() && !playerHand.isEmpty() && playerHand.contains(OldMaid)) {
                System.out.println("You have ended up with Old Maid and have lost. Better luck next time.\n");
            }
        } System.out.println("This is the dealer's hand: " + dealerHand + "\n");
        System.out.println("This is your hand: " + playerHand);
    }
}
