package com.practice.multithreading.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaskCreator {
    static List<Task> taskList = new ArrayList<>();

    public static List<Task> createListOfTasks(Map<String, Double> productCostList) {
        for(Map.Entry<String, Double> productCost: productCostList.entrySet()) {
            taskList.add(new Task(productCost.getKey(), productCost.getValue()));
        }
	return taskList;
    }
}