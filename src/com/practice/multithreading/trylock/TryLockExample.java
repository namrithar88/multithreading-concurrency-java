package com.practice.multithreading.trylock;

import com.practice.multithreading.accountmanagement.domain.Account;
import com.practice.multithreading.accountmanagement.domain.CheckingAccount;
import com.practice.multithreading.accountmanagement.domain.SavingsAccount;
import com.practice.multithreading.accountmanagement.factory.AccountOperationsServiceFactory;
import com.practice.multithreading.accountmanagement.service.AccountOperationsServiceTryLock;

public class TryLockExample {
    public void runExample() throws InterruptedException {

        Account checkingAccount = new CheckingAccount(4, 200.0);
        AccountOperationsServiceTryLock accountOperationsServiceTryLock = new AccountOperationsServiceTryLock();
        Thread backgroundThread = new Thread(() -> {
            accountOperationsServiceTryLock.deposit(100.0, checkingAccount);
        }, "Background Thread");

        Thread uiThread = new Thread(() -> {
            accountOperationsServiceTryLock.displayAccountBalance(checkingAccount);
        }, "UI Thread");

        backgroundThread.start();
        Thread.sleep(2000);
        uiThread.start();

        backgroundThread.join();
        uiThread.join();
    }
}
