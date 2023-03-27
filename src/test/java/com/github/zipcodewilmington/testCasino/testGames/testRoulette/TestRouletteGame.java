package com.github.zipcodewilmington.testCasino.testGames.testRoulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestRouletteGame {

    @Test
    public void testConstructor() {
        RouletteGame g = new RouletteGame();

        Assert.assertTrue(g instanceof RouletteGame);
    }

    @Test
    public void testRun() {
        RouletteGame g = new RouletteGame();
        ArrayList<Player> expected = g.getPlayers();
        g.add(new RoulettePlayer(new CasinoAccount(500, "name", "password")));


        ByteArrayInputStream in = new ByteArrayInputStream("2\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        g.run();

        Assert.assertEquals(g.getPlayers(), expected);
    }

    @Test
    public void testRun2() {
        RouletteGame g = new RouletteGame();
        ArrayList<Player> expected = g.getPlayers();
        g.add(new RoulettePlayer(new CasinoAccount(500, "name", "password")));


        ByteArrayInputStream in = new ByteArrayInputStream("1\n5\nred\n2".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        g.run();

        Assert.assertEquals(g.getPlayers(), expected);
    }


    @Test
    public void testCall1() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("straight\n5\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "straight";

        String actual = g.call();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCall2() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("corner\n36\ncorner\n1\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "corner";

        String actual = g.call();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCall3() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("odd\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "odd";

        String actual = g.call();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCall4() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("dozen1\ndozen2\ndozen3\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "dozen";

        Assert.assertEquals(expected,g.call());
        Assert.assertEquals(expected,g.call());
        Assert.assertEquals(expected,g.call());
    }

    @Test
    public void testCall5() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("column1\ncolumn2\ncolumn3\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "column";

        Assert.assertEquals(expected,g.call());
        Assert.assertEquals(expected,g.call());
        Assert.assertEquals(expected,g.call());
    }

    @Test
    public void testCall6() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("split\n1\n2\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "split";

        String actual = g.call();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCall7() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("line\n3\nline\n1".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "line";

        String actual = g.call();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCall8() {
        RouletteGame g = new RouletteGame();
        ByteArrayInputStream in = new ByteArrayInputStream("street\n1\n".getBytes());
        IOConsole con = new IOConsole(AnsiColor.BLUE, in, System.out);
        g.setCon(con);
        String expected = "street";

        String actual = g.call();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetPlayer() {
        RouletteGame g = new RouletteGame();
        RoulettePlayer expected = new RoulettePlayer(new CasinoAccount());
        g.add(expected);

        RoulettePlayer actual = (RoulettePlayer) g.getPlayers().get(0);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testAddPlayer() {
        RouletteGame g = new RouletteGame();
        RoulettePlayer player = new RoulettePlayer(new CasinoAccount());

        g.add(player);
        ArrayList<Player> actual = g.getPlayers();

        Assert.assertTrue(actual.size() == 1);
    }

    @Test
    public void testRemove() {
        RouletteGame g = new RouletteGame();
        RoulettePlayer player = new RoulettePlayer(new CasinoAccount());
        g.add(player);

        g.remove(player);
        ArrayList<Player> actual = g.getPlayers();

        Assert.assertNull(actual.get(0));
    }

    @Test
    public void testBet() {
        RouletteGame g = new RouletteGame();
        RoulettePlayer player = new RoulettePlayer(new CasinoAccount(200,null,null));

        Assert.assertTrue(g.bet(player, 5, 5));
        Assert.assertFalse(g.bet(player, 300, 5));
        Assert.assertFalse(g.bet(player, 1, 5));
    }

    @Test
    public void testSpin() {
        RouletteGame g = new RouletteGame();

        int actual = g.spin();

        Assert.assertTrue(actual < 38 && actual > -1);

    }

    @Test
    public void testResults() {
        RouletteGame g = new RouletteGame();

        Assert.assertEquals(36, g.result(1, "straight", new ArrayList<>(Collections.singleton(28))));
        Assert.assertEquals(18, g.result(37, "split", new ArrayList<>(Arrays.asList(1,2))));
        Assert.assertEquals(12, g.result(37, "street", new ArrayList<>(Arrays.asList(1,2,3))));
        Assert.assertEquals(9, g.result(37, "corner", new ArrayList<>(Arrays.asList(1,2,4,5))));
        Assert.assertEquals(6, g.result(37, "line", new ArrayList<>(Arrays.asList(1,2,3,4,5,6))));
        Assert.assertEquals(3, g.result(37, "dozen", new ArrayList<>(Arrays.asList(1,2,4,5,6,7,8,9,10,11,12))));
        Assert.assertEquals(2, g.result(37, "black", new ArrayList<>(Arrays.asList(1,2,4,5))));
        Assert.assertEquals(2, g.result(36, "red", new ArrayList<>(Arrays.asList(1,2,4,5))));
        Assert.assertEquals(2, g.result(35, "high", new ArrayList<>(Arrays.asList(1,2,4,5))));
        Assert.assertEquals(2, g.result(37, "low", new ArrayList<>(Arrays.asList(1,2,4,5))));
        Assert.assertEquals(2, g.result(37, "even", new ArrayList<>(Arrays.asList(1,2,4,5))));
        Assert.assertEquals(2, g.result(35, "odd", new ArrayList<>(Arrays.asList(1,2,4,5))));
    }
}
