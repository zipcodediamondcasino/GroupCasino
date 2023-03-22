package com.github.zipcodewilmington.casino;

public enum Number {
    ACE ("Ace", 11),
    TWO ("Two", 2),
    THREE ("Three", 3),
    FOUR ("Four", 4),
    FIVE ("Five", 5),
    SIX ("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN ("Queen",10),
    KING("King",10);

     public String rankName;

     public int rankValue;




    Number(String rankName,int  rankValue) {
        this.rankValue = rankValue;
        this.rankName = rankName;


    }

    public String toString(){
        return rankName;
    }

}
