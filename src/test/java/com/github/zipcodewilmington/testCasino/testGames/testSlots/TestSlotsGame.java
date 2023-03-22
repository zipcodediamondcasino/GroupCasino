package com.github.zipcodewilmington.testCasino.testGames.testSlots;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestSlotsGame {

    @Test
    void testConstructor() {
        SlotsPlayer expected = new SlotsPlayer();
        SlotsGame g = new SlotsGame(expected);

        ArrayList<Player> actual = g.getPlayers();

        Assert.assertEquals(expected, actual.get(0));

    }

    @Test
    void testPull() {
        SlotsGame g = new SlotsGame(new SlotsPlayer());
        int[] expected = new int[3];

        int[] actual = g.pull();

        Assert.assertEquals(expected.length, actual.length);
    }

    @Test
    void testResults1(){
        SlotsGame g = new SlotsGame(new SlotsPlayer());
        int expected = 0;

        int actual = g.resolve(new int[]{3, 2, 8});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testResults2(){
        SlotsGame g = new SlotsGame(new SlotsPlayer());
        int expected = 10;

        int actual = g.resolve(new int[]{3,3,3});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testResults3() {
        SlotsGame g = new SlotsGame(new SlotsPlayer());
        int expected = 20;

        int actual = g.resolve(new int[]{3,6,9});

        Assert.assertEquals(expected,actual);
    }


}
