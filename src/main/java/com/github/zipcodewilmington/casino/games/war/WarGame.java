package com.github.zipcodewilmington.casino.games.war;

import com.github.zipcodewilmington.casino.*;

import java.util.ArrayList;
import java.util.Scanner;

public class WarGame implements Game {
    Deck deck;
    ArrayList<Card> currentRound = new ArrayList<>();
    //  WarDealer
    Card card;
    WarPlayer player;
    WarDealer dealer;

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
        Scanner scanner = new Scanner(System.in);
        String playerInput = scanner.nextLine();
        deck.shuffle();
    /*    System.out.println("Let's play a game of War!\nEnter 1 to place a card. Enter 2 to quit game.");
        deal();
        while (true){

            if (player.hand.size() == 0){
                System.out.println("Dealer has won the game!");
                break;
            } else if (WarDealer.getHand() == 0) {
                System.out.println("Player has won the game!");
                break;
            }
            else{

                compareCards();
            }
*/
        }
    }
//add a print after round is completed and that lists the cards that winning player gained (fori that prints each toString)
/*

    public void compareCards(Card card1, Card card2){ //return 0 if dealer wins -1 if player wins
        //System.out.println("You placed a " + player.hand.get();
        int cardsPlayed = 0;
        //this persons hand[i + 1 +2]

        while (card1.getValue() == card2.getValue() ){
            System.out.println("You played " + card1 + " and dealer played " + card2 + "\nGo to War!");
            currentRound.add
            cardsPlayed += 2;
        }
        if (card1.getValue() > card2.getValue()){
            cardsPlayed += 2;
            System.out.println("You won the war and gained " + cardsPlayed + " cards.");
            break;

        }
        else {
            cardsPlayed += 2;

        }
    }
    public String printCardsWon(int cardsPlayed){

    }
    public int assignValue(Card card){
        return 0;
    }
    public void deal(){
        for (int i = 0; i <= 26; i++)
        dealer.addPlayerHand(deck.takeCard());
        player.addPlayerHand(deck.takeCard());
    }*/


