package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;

public abstract class Player {

    CasinoAccount casinoAccount;
    /**
     * @return the `ArcadeAccount` used to log into the `Arcade` system to play this game
     */
    CasinoAccount getArcadeAccount() {

        return null;
    }

    <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
