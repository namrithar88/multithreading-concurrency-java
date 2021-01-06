package com.practice.multithreading.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RunnableTaskCreator {
    static List<RunnableTask> taskList = new ArrayList<>();

    public static List<RunnableTask> createListOfTasks(Map<String, Double> productCostList) {
        for(Map.Entry<String, Double> productCost: productCostList.entrySet()) {
            taskList.add(new RunnableTask(productCost.getKey(), productCost.getValue()));
        }
	return taskList;
    }
}