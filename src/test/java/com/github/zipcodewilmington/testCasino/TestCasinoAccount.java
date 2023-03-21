package com.github.zipcodewilmington.testCasino;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.Assert;
import org.junit.Test;

public class TestCasinoAccount {

    @Test
    public void TestCasinoAccountConstructors(){
        CasinoAccount casinoAccount = new CasinoAccount(100.00, "Nina", "password");
        double expectedBalance = 100.00;
        String expectedName = "Nina";
        String expectedPassword = "password";
        double actualBalance = casinoAccount.getBalance();
        String actualName = casinoAccount.getName();
        String actualPassword = casinoAccount.getPassword();
        Assert.assertEquals(expectedBalance, actualBalance);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPassword, actualPassword);
    }
    @Test
    public void TestCasinoAccountNullaryConstructor(){
        CasinoAccount casinoAccount = new CasinoAccount();
        double expectedBalance = 0.00;
        String expectedName = "";
        String expectedPassword = "";
        double actualBalance = casinoAccount.getBalance();
        String actualName = casinoAccount.getName();
        String actualPassword = casinoAccount.getPassword();
        Assert.assertEquals(expectedBalance, actualBalance);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPassword, actualPassword);
    }
    @Test
    public void TestCasinoAccountConstructorWithNameAndPassword(){
        CasinoAccount casinoAccount = new CasinoAccount("Nina", "password");
        double expectedBalance = 0.00;
        String expectedName = "Nina";
        String expectedPassword = "password";
        double actualBalance = casinoAccount.getBalance();
        String actualName = casinoAccount.getName();
        String actualPassword = casinoAccount.getPassword();
        Assert.assertEquals(expectedBalance, actualBalance);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPassword, actualPassword);

    }
    @Test
    public void TestGetCasinoAccountName(){

    }
    @Test
    public void TestSetCasinoAccountName(){

    }
    @Test
    public void TestGetCasinoAccountPassword(){

    }
    @Test
    public void TestSetCasinoAccountPassword(){

    }
    @Test
    public void TestGetCasinoAccountBalance(){

    }
    @Test
    public void TestSetCasinoAccountBalance(){

    }
}
