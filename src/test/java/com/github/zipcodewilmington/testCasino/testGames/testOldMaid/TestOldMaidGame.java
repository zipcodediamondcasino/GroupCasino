package com.github.zipcodewilmington.testCasino.testGames.testOldMaid;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Game;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.Suit;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidGame;
import com.github.zipcodewilmington.casino.games.oldmaid.OldMaidPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static com.github.zipcodewilmington.casino.Number.*;

public class TestOldMaidGame {
    @Test
    public void testGetPlayers() {
        OldMaidGame game = new OldMaidGame();

        OldMaidPlayer player1 = new OldMaidPlayer(null);
        game.add(player1);

        ArrayList<Player> players = game.getPlayers();

        Assert.assertEquals(1, players.size());
        Assert.assertTrue(players.contains(player1));
    }


}
