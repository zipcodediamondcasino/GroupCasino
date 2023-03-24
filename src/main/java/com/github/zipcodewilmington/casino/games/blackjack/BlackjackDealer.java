package com.github.zipcodewilmington.casino.games.blackjack;


import com.github.zipcodewilmington.casino.Dealer;

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

    public void printFirstHand(){
        System.out.println("The dealer's hand looks like this: ");
        System.out.println(getHand().getCard(0));
        System.out.println("The second card is face down");
    }
}
