package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CardPlayer;
import com.github.zipcodewilmington.casino.CasinoAccount;

public class BlackjackPlayer extends CardPlayer {
    private BlackjackHand hand;
    private String name;


//    public BlackjackPlayer() {
//        this.hand = new BlackjackHand();
//        this.name = String.valueOf(getPlayerNameFromCasinoAccount());
//
//    }

    public BlackjackPlayer(CasinoAccount casinoAccount) {
        super(casinoAccount);
        this.hand = new BlackjackHand();
        this.name = String.valueOf(casinoAccount);
    }

    public BlackjackHand getHand() {
        return this.hand;
    }

    public void setHand(BlackjackHand hand){
        this.hand = hand;
    }

    public String getName(){
        return this.name;
    }

    public void makeDecision(){

    }

    public boolean hasBlackjack(){
        if (this.getHand().calculateValue() ==21){
            return true;
        }
        else {
            return false;
        }
    }

    public void printHand(){
        System.out.println(this.name + "'s hand.");
        System.out.println(this.hand + " Valued at: " + this.hand.calculateValue());
    }
}


