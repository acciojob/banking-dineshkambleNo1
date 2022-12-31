package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {

    }

    public double getBalance() {
        return balance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        if(SumOfDigits(digits) == sum){

            // agar sumofdigits ka sum agar barabar hoga sum k tabhhi
            // me accno generate karunga nhi toh exception

            String genAccNo = generateStringFromDigits(digits);
            return genAccNo;
        }

        else {
            throw new Exception("Account Number can not be generated");
        }
    }

    public int  SumOfDigits(int no){
        int sumOfDigits = 0;

        while(no > 0)
        {
            int digit = no%10;
            sumOfDigits += digit;

            no /= 10;
        }

        return sumOfDigits;
    }

    public String generateStringFromDigits(int no){

        String generteAccNo = "";

        while(no > 0)
        {
            int digit = no%10;
            generteAccNo += digit;

            no /= 10;
        }

        return generteAccNo;
    }

    public void deposit(double amount) {
        //Deposit an amount to the account.
        //add amount to balance

        this.balance = this.balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        //Withdraw an amount from the account.
        // Remember to throw "Insufficient Balance" exception,
        // if the remaining amount would be less than minimum balance.

        if(( this.balance -  amount )< minBalance)
        {

            throw new Exception("Insufficient Balance");

        }

        else{
            this.balance = this.balance - amount;
        }

    }

}