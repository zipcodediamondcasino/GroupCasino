package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    double balance;
    String name;
    String password;

    public CasinoAccount(double balance, String name, String password) {
        this.balance = balance;
        this.name = name;
        this.password = password;
    }

    public CasinoAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public CasinoAccount() {
        this.balance = 0.00;
        this.name = "";
        this.password = "";
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public void setName(String newName) {
        this.name = newName;
    }
