package com.practice.multithreading.executorservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Steps to create a ThreadPool/use ExecutorService:
 * 1) Create a ThreadPool using Executors
 * 2) Create task (Task will implement Runnable. Include the logic you want to run such as calling addOn method inside run())
 * 3) Call service.execute(task)
 */
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
        //Alternatively, you can directly create the thread pool using new ThreadPoolExecutor()
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<RunnableTask> listOfTasks = RunnableTaskCreator.createListOfTasks(productCostList);
        for(RunnableTask task : listOfTasks) {
            service.execute(task);
        }
        service.shutdown();
    }
}