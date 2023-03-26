package com.github.zipcodewilmington.testCasino.testGames.testBaccarat;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.baccarat.BaccaratGame;
import com.github.zipcodewilmington.casino.games.baccarat.BaccaratPlayer;
import org.junit.Assert;
import org.junit.Test;

public class TestBaccaratPlayer {

    @Test
    public void testConstructor() {
        BaccaratPlayer expected = new BaccaratPlayer(new CasinoAccount());

        Assert.assertTrue(expected instanceof BaccaratPlayer);
    }

    @Test
    public void name() {

    }
}
