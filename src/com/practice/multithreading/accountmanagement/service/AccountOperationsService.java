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
}