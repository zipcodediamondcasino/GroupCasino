package com.github.zipcodewilmington.testCasino.testGames.testSlots;

import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.jupiter.api.Test;

public class TestSlotsGame {

    @Test
    void testConstructor() {
        SlotsPlayer expected = new SlotsPlayer();
        SlotsGame g = new SlotsGame(expected);


    }
}
