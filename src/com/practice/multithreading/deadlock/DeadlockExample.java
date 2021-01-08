package com.practice.multithreading.deadlock;

import com.practice.multithreading.accountmanagement.domain.Account;
import com.practice.multithreading.accountmanagement.domain.CheckingAccount;
import com.practice.multithreading.accountmanagement.domain.SavingsAccount;
import com.practice.multithreading.accountmanagement.factory.AccountOperationsServiceFactory;

public class DeadlockExample {
    public void runDeadlockExample() throws InterruptedException {
        Account savingsAccount = new SavingsAccount(1, 500.0);
        Account checkingAccount = new CheckingAccount(4, 200.0);

        Thread savingsToCheckingTransfer = new Thread(() -> {
            AccountOperationsServiceFactory.getInstance().transfer(100.0, savingsAccount, checkingAccount);
        });
        savingsToCheckingTransfer.setName("Savings - Checking Thread");

        Thread checkingToSavingsTransfer = new Thread(() -> {
            AccountOperationsServiceFactory.getInstance().transfer(200.0, checkingAccount, savingsAccount);
        });
        checkingToSavingsTransfer.setName("Checking - Savings Thread");

        //This example is for circular wait - savingsToCheckingTransfer is waiting for checkingToSavingsTransfer to release a resource and vice versa
        savingsToCheckingTransfer.start();
        checkingToSavingsTransfer.start();

        savingsToCheckingTransfer.join();
        checkingToSavingsTransfer.join();

        System.out.println("Final balance - checking " + checkingAccount.getAccountBalance());
        System.out.println("Final balance - savings " + savingsAccount.getAccountBalance());
    }
}
