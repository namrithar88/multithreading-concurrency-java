package com.practice.multithreading.accountmanagement.domain;

public abstract class Account {

    private Integer accountNo;
    private Double accountBalance;
    private String accountType;

    public Account(Integer accountNo, Double accountBalance) {
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double withdraw(Double amount) {
        Double currentBalance = this.accountBalance;
        this.accountBalance = currentBalance - amount;
        System.out.println(Thread.currentThread().getName() + " exiting withdraw");
        return this.accountBalance;
    }

    public Double deposit(Double amount) {
        Double currentBalance = this.accountBalance;
        try {
            Thread.currentThread().sleep(2000);
            System.out.println("Deposit delayed for 2 secs");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.accountBalance = currentBalance + amount;
        System.out.println(Thread.currentThread().getName() + " exiting deposit");
        return this.accountBalance;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }
}