package com.practice.multithreading.executorservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public void runExecutorServiceExample() {

        //Create a list of product names + cost. We will use ExecutorService to calculate the total cost for these products
        Map<String, Double> productCostList = new HashMap<>();
        productCostList.put("Book", 50.0);
        productCostList.put("Mobile", 300.0);
        productCostList.put("Shirt", 80.0);
        productCostList.put("Blender", 40.0);
        productCostList.put("Dish washer", 330.0);
        productCostList.put("Knives", 20.0);
        productCostList.put("TV", 250.0);
        productCostList.put("Curtain", 7.0);
        productCostList.put("Faucet", 15.0);
        productCostList.put("Glasses", 23.0);

        //Create executor + thread pool
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Task> listOfTasks = TaskCreator.createListOfTasks(productCostList);
        for(Task task : listOfTasks) {
            service.execute(task);
        }
        service.shutdown();
    }
}