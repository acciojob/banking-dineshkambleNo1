package com.driver;


public class Main {
    public static void main(String[] args) {
        /*
        A bank account can be used by various individuals or organizations for various reasons. Some different types of bank accounts are
         Savings account, Current account, Student account

         */

        SavingsAccount Dinesh = new SavingsAccount("Dinesh",25000,5000,8);

        System.out.println(Dinesh.getSimpleInterest(20));
        System.out.println(Dinesh.getCompoundInterest(8,20));
    }
}