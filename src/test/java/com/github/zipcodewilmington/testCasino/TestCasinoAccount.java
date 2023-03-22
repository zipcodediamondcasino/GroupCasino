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
        Assert.assertEquals(expectedBalance, actualBalance, -1);
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
        Assert.assertEquals(expectedBalance, actualBalance, -1);
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
        Assert.assertEquals(expectedBalance, actualBalance, -1);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPassword, actualPassword);

    }
    @Test
    public void TestGetCasinoAccountName(){
        CasinoAccount casinoAccount = new CasinoAccount(0.00, "Nina", null);
        String expected = "Nina";
        String actual = casinoAccount.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestSetCasinoAccountName(){
        CasinoAccount casinoAccount = new CasinoAccount(0.00, "Nina", null);
        casinoAccount.setName("Ciaffi");
        String expected = "Ciaffi";
        String actual = casinoAccount.getName();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestGetCasinoAccountPassword(){
        CasinoAccount casinoAccount = new CasinoAccount(0.0, null, "password");
        String expected = "password";
        String actual = casinoAccount.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestSetCasinoAccountPassword(){
        CasinoAccount casinoAccount = new CasinoAccount(0.00, null, "password");
        casinoAccount.setPassword("password1");
        String expected = "password1";
        String actual = casinoAccount.getPassword();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void TestGetCasinoAccountBalance(){

    }
    @Test
    public void TestSetCasinoAccountBalance(){
        CasinoAccount casinoAccount = new CasinoAccount(0.00, null, null);
        casinoAccount.setBalance(100.00);
        double expected = 100.00;
        double actual = casinoAccount.getBalance();
        Assert.assertEquals(expected, actual, -1);
    }
}