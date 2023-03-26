package com.github.zipcodewilmington.casino.games.blackjack;

public class BlackjackDealer {
    private BlackjackHand hand;
    private String name;

    public BlackjackDealer() {
        this.name = "Dealer";

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


}
