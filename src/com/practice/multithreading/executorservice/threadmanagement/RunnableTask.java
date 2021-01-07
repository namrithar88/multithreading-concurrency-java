package com.practice.multithreading.executorservice.threadmanagement;

import com.practice.multithreading.accountmanagement.domain.Account;
import com.practice.multithreading.accountmanagement.factory.AccountOperationsServiceFactory;
import com.practice.multithreading.accountmanagement.service.AccountOperationsService;

public class RunnableTask implements Runnable {

    private String operation;
    private Double amount;
    private Account account;

    public RunnableTask(String operation, Double amount, Account account) {
        this.operation = operation;
        this.amount = amount;
        this.account = account;
    }

    //AccountOperationsService accountOperationsService = new AccountOperationsService();

    @Override
    public void run() {
        switch(operation) {
            case "withdraw" : System.out.println("Account balance  after withdrawing : " + AccountOperationsServiceFactory.getInstance().withdraw(this.amount, this.account));
                                break;
            case "deposit" : System.out.println("Account balance " + this.account.getAccountNo() + " after deposit : " + AccountOperationsServiceFactory.getInstance().deposit(this.amount, this.account));
                                break;
        }
    }
}
