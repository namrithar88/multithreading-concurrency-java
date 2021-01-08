package com.practice.multithreading.accountmanagement.service;

import com.practice.multithreading.accountmanagement.domain.Account;

import java.util.concurrent.locks.ReentrantLock;

public class AccountOperationsServiceTryLock {

    ReentrantLock lockObj = new ReentrantLock();

    public Double withdraw(Double amount, Account from) {
        if(lockObj.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " entered withdraw.");
            return from.withdraw(amount);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " waiting for lock.");
            return 0.0;
        }
    }

    public Double deposit(Double amount, Account to) {
        if(lockObj.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " entered deposit.");
            return to.deposit(amount);
        }
        else {
            System.out.println(Thread.currentThread().getName() + " waiting for lock.");
            return 0.0;
        }
    }

    public void displayAccountBalance(Account of) {
        //Usually if a thread is waiting for a lock, it is in suspended state. If you use tryLock, the thread does not go to suspended state.
        //lockObj.tryLock() returns true if lock is available, false otherwise. So you can code what you want to do if the lock is not available in the else part.
        //lockObj.tryLock() is useful where you do not want the thread to block if the lock is not available.
        if(lockObj.tryLock()) {
            System.out.println("Displaying account balance of " + of.getAccountNo() + " " + of.getAccountType() + " : " + of.getAccountBalance());
        }
        else {
            System.out.println("Some other thread is modifying the account. Balance may be incorrect : " + of.getAccountBalance());
        }
    }
}