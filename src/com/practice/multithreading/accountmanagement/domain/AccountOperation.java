package com.practice.multithreading.accountmanagement.domain;

public class AccountOperation {

    private String operation;
    private Double amount;
    private Account account;

    public AccountOperation(String operation, Double amount, Account account) {
        this.operation = operation;
        this.amount = amount;
        this.account = account;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}