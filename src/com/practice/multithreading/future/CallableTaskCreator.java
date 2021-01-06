package com.practice.multithreading.future;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CallableTaskCreator {
    static List<CallableTask> taskList = new ArrayList<>();

    public static List<CallableTask> createTasks(Map<String, Double> productCostList) {
        for(Map.Entry<String, Double> productCost : productCostList.entrySet()) {
            taskList.add(new CallableTask(productCost.getValue()));
        }
        return taskList;
    }
}
