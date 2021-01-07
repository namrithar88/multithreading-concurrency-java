package com.practice.multithreading.accountmanagement.domain;

public class CheckingAccount extends Account {

    public CheckingAccount(Integer accountNo, Double accountBalance) {
        super(accountNo, accountBalance);
        super.setAccountType("Checking");
    }
}