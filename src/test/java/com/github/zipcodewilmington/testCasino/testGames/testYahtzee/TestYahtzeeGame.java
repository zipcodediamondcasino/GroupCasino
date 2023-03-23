package com.github.zipcodewilmington.testCasino.testGames.testYahtzee;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeeGame;
import com.github.zipcodewilmington.casino.games.yahtzee.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestYahtzeeGame {
    YahtzeeGame newGame;
    YahtzeePlayer newPlayer;

    @Before
    public void init(){
        newGame = new YahtzeeGame();
        newPlayer = new YahtzeePlayer(null);
    }

    @Test
    public void testConstructor() {
        Assert.assertTrue(newGame instanceof YahtzeeGame);
    }

    @Test
    public void testAdd(){
        newGame.add(newPlayer);
        boolean expected = false;
        ArrayList<Player> actual = newGame.getPlayers();
        Assert.assertEquals(expected, actual.isEmpty());
    }

    @Test
    public void remove(){
        newGame.add(newPlayer);
        newGame.remove(newPlayer);
        boolean expected = true;
        ArrayList<Player> actual = newGame.getPlayers();
        Assert.assertEquals(expected, actual.isEmpty());
    }

    @Test
    public void getPlayers(){
        newGame.add(newPlayer);
        ArrayList expected = null;
        ArrayList<Player> actual = newGame.getPlayers();
        Assert.assertEquals(expected, actual);
    }

}
