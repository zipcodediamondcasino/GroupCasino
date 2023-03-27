package com.github.zipcodewilmington.testCasino.testGames.testYahtzee;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Test;

public class TestYahtzeePlayer {

    @Test
    public void TestYahtzeePlayerConstructor() {
        CasinoAccount newAccount = new CasinoAccount(100.00, "Nina", "password");
        YahtzeePlayer newPlayer = new YahtzeePlayer(newAccount);
        String expected = newAccount.getName();
        String actual = newPlayer.getPlayerNameFromCasinoAccount();
        Assert.assertEquals(expected, actual);
    }
}
