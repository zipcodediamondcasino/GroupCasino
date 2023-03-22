package com.github.zipcodewilmington.testCasino;

import com.github.zipcodewilmington.casino.CardPlayer;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPlayer {
    CasinoAccount Acc;
    Player player;
    @Before
    public void Init(){
        Acc = new CasinoAccount();
        player = new CardPlayer(Acc);
    }

    @Test
    public void testGetPlayerNameFromCasinoAccount(){
//        given
        String expected = "";
//        when
        String actual = player.getPlayerNameFromCasinoAccount();
//        then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetPlayerTurn(){
        Boolean actual = player.getPlayerTurn();
//        then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSetPlayerTurn(){
//        given
        Boolean playerTurn = true;
//        when
        player.setPlayerTurn(playerTurn);
        Boolean actual = player.getPlayerTurn();
//        then
        Assert.assertTrue(actual);
    }

}
