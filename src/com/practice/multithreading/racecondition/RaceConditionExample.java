package com.practice.multithreading.racecondition;

import java.util.List;

public class RaceConditionExample {
    public void runExample() {
        ThreadCreator threadCreator = new ThreadCreator();
        ThreadExecutor threadExecutor = new ThreadExecutor();

        List<Thread> addOnCalculatorThreads = threadCreator.createThreads();
        threadExecutor.executeThreads(addOnCalculatorThreads);
    }
}
