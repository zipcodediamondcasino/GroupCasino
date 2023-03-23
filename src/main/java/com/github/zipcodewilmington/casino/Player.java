package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;

public abstract class Player {

    CasinoAccount casinoAccount;

    Boolean playerTurn = false;

    public Player(CasinoAccount casinoAccount){
        this.casinoAccount = casinoAccount;
    }

    public String getPlayerNameFromCasinoAccount(){
        String playerName = casinoAccount.getName();
        return playerName;
    }

    public Boolean getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Boolean playerTurn) {
        this.playerTurn = playerTurn;
    }
    public CasinoAccount getCasinoAccount() {
        return this.casinoAccount;
    }

}
