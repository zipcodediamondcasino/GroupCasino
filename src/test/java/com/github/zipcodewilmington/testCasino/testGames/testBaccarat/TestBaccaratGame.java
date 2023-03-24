package com.github.zipcodewilmington.testCasino.testGames.testBaccarat;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.baccarat.BaccaratGame;
import com.github.zipcodewilmington.casino.games.baccarat.BaccaratPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestBaccaratGame {
    @Test
    public void testConstructor() {
        BaccaratGame g = new BaccaratGame();

        Assert.assertTrue(g instanceof BaccaratGame);
    }

    @Test
    public void testAdd() {
        BaccaratGame g = new BaccaratGame();
        BaccaratPlayer expected = new BaccaratPlayer(new CasinoAccount());
        
        g.add(expected);
        
        Assert.assertTrue(g.getPlayers().size() == 1);
    }

    @Test
    public void testRemove() {
        BaccaratGame g = new BaccaratGame();
        BaccaratPlayer player = new BaccaratPlayer(new CasinoAccount());
        g.add(player);
        
        g.remove(player);
        ArrayList<Player> actual = g.getPlayers();
        
        Assert.assertTrue(actual.get(0) == null);
    }

    @Test
    public void name() {

    }
}
