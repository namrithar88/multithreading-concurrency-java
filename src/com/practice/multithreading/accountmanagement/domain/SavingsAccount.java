package com.practice.multithreading.accountmanagement.domain;

public class SavingsAccount extends Account {

    public SavingsAccount(Integer accountNo, Double accountBalance) {
        super(accountNo, accountBalance);
        super.setAccountType("Savings");
    }
}