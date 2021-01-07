package com.practice.multithreading.executorservice.threadmanagement;

import com.practice.multithreading.accountmanagement.domain.AccountOperation;

import java.util.ArrayList;
import java.util.List;

public class RunnableTaskCreator {

    public static List<RunnableTask> taskList = new ArrayList<>();

    public static List<RunnableTask> createRunnableTasks(List<AccountOperation> accountOperationsList) {
        accountOperationsList.forEach((AccountOperation accountOperation) -> {
            taskList.add(new RunnableTask(accountOperation.getOperation(), accountOperation.getAmount(), accountOperation.getAccount()));
        });
        return taskList;
    }
}