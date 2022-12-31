package com.driver;

import java.util.Stack;

public class CurrentAccount extends BankAccount{
    //consists of Uppercase English characters only
    String tradeLicenseId;

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000.0);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance < 5000.0) { throw  new Exception("Insufficient Balance");}

        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid ------> isValidId() bana alag se // AABBBBCCCC
        // if no two consecutive characters are same
        // If the license Id is valid, do nothing


    }


}
