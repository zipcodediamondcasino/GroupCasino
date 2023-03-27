package com.github.zipcodewilmington.testCasino.testGames.testSlots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class TestSlotsGame {

    @Test
    void testConstructor() {
        SlotsGame g = new SlotsGame();


        Assert.assertTrue(g instanceof SlotsGame);

    }

    @Test
    void testRun() {
        SlotsGame g = new SlotsGame();
        ArrayList<Player> expected = g.getPlayers();
        g.add(new SlotsPlayer(new CasinoAccount(500, "name", "password")));
        ByteArrayInputStream in = new ByteArrayInputStream("9\n1\n5\n2".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);

        g.run();

        Assert.assertEquals(g.getPlayers(), expected);
    }

    @Test
    void testPull() {
        SlotsGame g = new SlotsGame();
        int[] expected = new int[3];

        int[] actual = g.pull();

        Assert.assertEquals(expected.length, actual.length);
    }

    @Test
    void testGetPlayer(){
        SlotsGame g = new SlotsGame();
        SlotsPlayer expected = new SlotsPlayer(new CasinoAccount());
        g.add(expected);

        SlotsPlayer actual = (SlotsPlayer) g.getPlayers().get(0);

        Assert.assertEquals(actual, expected);
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
        int expected = 3;

        int actual = g.resolve(new int[]{3,3,3});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testResults3() {
        SlotsGame g = new SlotsGame();
        int expected = 18;

        int actual = g.resolve(new int[]{3,6,9});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testResults4() {
        SlotsGame g = new SlotsGame();
        int expected = 18;

        int actual = g.resolve(new int[]{9,6,3});

        Assert.assertEquals(expected,actual);
    }

    @Test
    void testResults5() {
        SlotsGame g = new SlotsGame();
        int expected = 4;

        int actual = g.resolve(new int[]{3,4,5});

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


        Assert.assertTrue(actual.get(0) == null);
    }

    @Test
    void testBet1(){
        SlotsGame g = new SlotsGame();
        SlotsPlayer p = new SlotsPlayer(new CasinoAccount(200, null,null));
        g.add(p);

        Assert.assertTrue(g.bet(p, 6, 5));
    }

    @Test
    void testBet2(){
        SlotsGame g = new SlotsGame();
        SlotsPlayer p = new SlotsPlayer(new CasinoAccount(200, null,null));
        g.add(p);

        Assert.assertFalse(g.bet(p, 250, 5));
    }
}
