package com.practice.multithreading.accountmanagement.service;

import com.practice.multithreading.accountmanagement.domain.Account;

public class AccountOperationsService {

    Object lock = new Object();

    public Double withdraw(Double amount, Account from) {
        synchronized(from) {
            System.out.println(Thread.currentThread().getName() + " entered withdraw.");
            return from.withdraw(amount);
    }}

    public Double deposit(Double amount, Account to) {
        synchronized(to) {
            System.out.println(Thread.currentThread().getName() + " entered deposit.");
            return to.deposit(amount);
    }}

    public void transfer(Double amount, Account from, Account to) {
        if(from.hashCode() < to.hashCode()) {
            synchronized (from) {
                System.out.println(Thread.currentThread().getName() + " acquired a lock on " + from.getAccountType() + " waiting for a lock on " + to.getAccountType());
            synchronized (to) {
                System.out.println(Thread.currentThread().getName() + " acquired a lock on " + from.getAccountType() + " and " + to.getAccountType());
                from.withdraw(amount);
                to.deposit(amount);
                }
            }}
        else{
                synchronized (to) {
                    System.out.println(Thread.currentThread().getName() + " acquired a lock on " + from.getAccountType() + " waiting for a lock on " + to.getAccountType());
                    synchronized (from) {
                        System.out.println(Thread.currentThread().getName() + " acquired a lock on " + from.getAccountType() + " and " + to.getAccountType());
                        from.withdraw(amount);
                        to.deposit(amount);
                    }
                }
            }
    }
}