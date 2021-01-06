package com.practice.multithreading.future;

import com.practice.multithreading.racecondition.AmazonAddOnCalculator;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Double> {

    AmazonAddOnCalculator amazonAddOnCalculator = new AmazonAddOnCalculator();
    private Double cost;

    public CallableTask(Double cost) {
        this.cost = cost;
    }

    @Override
    public Double call() throws Exception {
        return amazonAddOnCalculator.calculateAddOn(cost);
    }
}
