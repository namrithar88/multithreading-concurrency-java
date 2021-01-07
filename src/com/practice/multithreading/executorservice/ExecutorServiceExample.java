package com.practice.multithreading.executorservice;

import com.practice.multithreading.accountmanagement.domain.Account;
import com.practice.multithreading.accountmanagement.domain.AccountOperation;
import com.practice.multithreading.accountmanagement.domain.CheckingAccount;
import com.practice.multithreading.accountmanagement.domain.SavingsAccount;
import com.practice.multithreading.executorservice.threadmanagement.RunnableTask;
import com.practice.multithreading.executorservice.threadmanagement.RunnableTaskCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Steps to create a ThreadPool/use ExecutorService:
 * 1) Create a ThreadPool using Executors
 * 2) Create task (Task will implement Runnable. Include the logic you want to run such as calling addOn method inside run())
 * 3) Call service.execute(task)
 */
public class ExecutorServiceExample {

    public void runExecutorServiceExampleSavingsAccount() {
        Account savingsAccount = new SavingsAccount(1, 500.0);

        //Create a list of account operations to be performed.
        List<AccountOperation> accountOperations = new ArrayList<>();
        accountOperations.add(new AccountOperation("deposit", 25.0, savingsAccount));
        accountOperations.add(new AccountOperation("withdraw", 100.0, savingsAccount));

        //Creating thread pool + using executors
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<RunnableTask> listOfTasks = RunnableTaskCreator.createRunnableTasks(accountOperations);
        for (RunnableTask task : listOfTasks) {
            service.execute(task);
        }
        service.shutdown();
    }

    public void runExecutorServiceExampleSavingsAndCheckingAccount() throws InterruptedException {
        Account savingsAccount = new SavingsAccount(1, 500.0);
        Account checkingAccount = new CheckingAccount(4, 200.0);

        //Create a list of account operations to be performed.
        List<AccountOperation> accountOperations = new ArrayList<>();
        accountOperations.add(new AccountOperation("deposit", 25.0, savingsAccount));
        accountOperations.add(new AccountOperation("withdraw", 100.0, savingsAccount));
        accountOperations.add(new AccountOperation("deposit", 25.0, checkingAccount));
        accountOperations.add(new AccountOperation("withdraw", 100.0, checkingAccount));

        //Creating thread pool + using executors
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<RunnableTask> listOfTasks = RunnableTaskCreator.createRunnableTasks(accountOperations);
        for (RunnableTask task : listOfTasks) {
            service.execute(task);
        }
        service.shutdown();
        Thread.currentThread().sleep(11000);
            System.out.println("Final account balance " + savingsAccount.getAccountType() + " - " + savingsAccount.getAccountBalance());
            System.out.println("Final account balance " + checkingAccount.getAccountType() + " - " + checkingAccount.getAccountBalance());
    }
}