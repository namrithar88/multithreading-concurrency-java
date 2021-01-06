package com.practice.multithreading.future;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * Steps to create a ThreadPool/use Future:
 * 1) Create a ThreadPool using Executors
 * 2) Create task (Task will implement Callable. Include the logic you want to run such as calling addOn method inside call())
 * 3) Call service.submit(task). It will return a Future object that will hold the result
 * 4) Get the result using Future.get(). Note that this is a blocking operation. So if the result is not ready yet, the main thread will be blocked until the result is ready.
 */
public class FutureExample {

    public void runFutureExample() {
        List<Future> futures = new ArrayList<>();

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
        List<CallableTask> callableTaskList = CallableTaskCreator.createTasks(productCostList);
        callableTaskList.forEach((CallableTask task) -> {
            futures.add(service.submit(task));
            //service.submit will return a future which is an object that holds the value returned from call()
        });

        //Do any unrelated processing on the main thread here

        //future.get() is a blocking operation. So the main thread will stall till value is got from the future.
        for(Future<Double> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }
}