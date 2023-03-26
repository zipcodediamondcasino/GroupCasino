package com.github.zipcodewilmington.testCasino.testGames.testCoinFlip;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.coinflip.CoinFlipGame;
import com.github.zipcodewilmington.casino.games.coinflip.CoinFlipPlayer;
import com.github.zipcodewilmington.casino.games.poker.PokerDealer;
import com.github.zipcodewilmington.casino.games.poker.PokerPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestCoinFlipGame {
    @Test
    public void testConstructor(){
        CoinFlipGame g = new CoinFlipGame();

        Assert.assertTrue(g instanceof  CoinFlipGame);
    }
    @Test
    public void testGetPlayer(){
        CoinFlipGame g = new CoinFlipGame();
        CoinFlipPlayer expected = new CoinFlipPlayer (new CasinoAccount());
        g.add(expected);

        CoinFlipPlayer actual = (CoinFlipPlayer) g.getPlayers().get(0);

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testAdd(){
        CoinFlipGame g = new CoinFlipGame();
        CoinFlipPlayer expected = new CoinFlipPlayer (new CasinoAccount());
        g.add(expected);

        ArrayList<Player> actual = g.getPlayers();

        Assert.assertEquals(expected, actual.get(0));

    }
    @Test
    public void testRemove(){
        CoinFlipGame g = new CoinFlipGame();
        CoinFlipPlayer player = new CoinFlipPlayer (new CasinoAccount());
        g.add(player);

        g.remove(player);
        ArrayList<Player> actual = g.getPlayers();

        Assert.assertTrue(actual.get(0) == null);

    }
    @Test
    public void testBet1(){
        CoinFlipGame g = new CoinFlipGame();
        CoinFlipPlayer p = new CoinFlipPlayer(new CasinoAccount(200, null, null));
        g.add(p);

        Assert.assertTrue((g.bet(p, 6, 1)));
    }
    @Test
    public void testBet2(){
        CoinFlipGame g = new CoinFlipGame();
        CoinFlipPlayer p = new CoinFlipPlayer(new CasinoAccount(200, null, null));
        g.add(p);

        Assert.assertFalse((g.bet(p, 250, 1)));
    }
}
