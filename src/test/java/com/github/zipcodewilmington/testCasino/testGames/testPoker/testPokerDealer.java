package com.github.zipcodewilmington.testCasino.testGames.testPoker;

import com.github.zipcodewilmington.casino.CardPlayer;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.poker.PokerDealer;
import com.github.zipcodewilmington.casino.games.poker.PokerPlayer;

public class testPokerDealer {
    CasinoAccount dealerAcc = new CasinoAccount();
    CasinoAccount playerAcc = new CasinoAccount();
    PokerPlayer pokerPlayer = new PokerPlayer(playerAcc);
    PokerDealer pokerDealer = new PokerDealer(dealerAcc);

}
