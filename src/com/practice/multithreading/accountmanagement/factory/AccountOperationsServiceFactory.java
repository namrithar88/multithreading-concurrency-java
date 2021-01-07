package com.practice.multithreading.accountmanagement.factory;

import com.practice.multithreading.accountmanagement.service.AccountOperationsService;

public class AccountOperationsServiceFactory {

    private static AccountOperationsService accountOperationsService;

    private AccountOperationsServiceFactory() {}

    synchronized public static AccountOperationsService getInstance() {
            if (accountOperationsService == null) {
                accountOperationsService = new AccountOperationsService();
            }
            return accountOperationsService;
    }
}