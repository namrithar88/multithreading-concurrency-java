package com.practice.multithreading.executorservice;

import com.practice.multithreading.racecondition.AmazonAddOnCalculator;

public class Task implements Runnable {
    private String productName;
    private Double cost;

    public Task(String productName, Double cost) {
        this.productName = productName;
        this.cost = cost;
    }

    AmazonAddOnCalculator addOnCalculator = new AmazonAddOnCalculator();

    public void run() {
        System.out.println(this.productName + " - " + cost + " - " + addOnCalculator.calculateAddOn(cost));
    }
}