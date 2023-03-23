package com.github.zipcodewilmington.testCasino.testGames.testSlots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestSlotsGame {

    @Test
    void testConstructor() {
        SlotsGame g = new SlotsGame();


        Assert.assertTrue(g instanceof SlotsGame);

    }

    @Test
    void testPull() {
        SlotsGame g = new SlotsGame();
        int[] expected = new int[3];

        int[] actual = g.pull();

        Assert.assertEquals(expected.length, actual.length);
    }

    @Test
    void testResults1(){
        SlotsGame g = new SlotsGame();
        int expected = 0;

        int actual = g.resolve(new int[]{3, 2, 8});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testResults2(){
        SlotsGame g = new SlotsGame();
        int expected = 10;

        int actual = g.resolve(new int[]{3,3,3});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testResults3() {
        SlotsGame g = new SlotsGame();
        int expected = 20;

        int actual = g.resolve(new int[]{3,6,9});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testAdd() {
        SlotsGame g = new SlotsGame();
        SlotsPlayer expected = new SlotsPlayer(new CasinoAccount());

        g.add(expected);

        ArrayList<Player> actual =  g.getPlayers();

        Assert.assertEquals(expected, actual.get(0));
    }

    @Test
    void testRemove() {
        SlotsGame g = new SlotsGame();
        SlotsPlayer player = new SlotsPlayer(new CasinoAccount());
        g.add(player);

        g.remove(player);
        ArrayList<Player> actual =  g.getPlayers();

        Assert.assertTrue(actual.size() == 0);
    }
}
