package com.practice.multithreading.racecondition;

import java.util.ArrayList;
import java.util.List;

public class ThreadCreator {
    public List<Thread> createThreads() {
        //Create calculator object - to be shared by all threads
        AmazonAddOnCalculator addOnCalculator = new AmazonAddOnCalculator();

        List<Thread> addOnCalculatorThreads = new ArrayList<Thread>();

            //Create Thread1 - calculate the add on for a book costing 50$
            Thread bookAddOnCalculatorThread = new Thread(() -> {
                Double cost = 50.0;
                addOnCalculator.setProductCost(cost);
                System.out.println("Calculating add on for book " + cost);
                //Thread 1 unexpectedly gets delayed by 20 secs due to some long running operation
                try {
                    Thread.currentThread().sleep(20000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted exception in " + Thread.currentThread().getName());
                    e.printStackTrace();
                    return;
                }
                System.out.println("Book - cost: " + addOnCalculator.getProductCost());
                System.out.println("Book - delivery charge: " + addOnCalculator.getDeliveryCharge());
                System.out.println("Book - tax: " + addOnCalculator.getTax());
                System.out.println("Book - discount: " + addOnCalculator.getDiscount());
            });

            //Create Thread2 - calculate the add on for a mobile phone costing 300$
            Thread phoneAddOnCalculatorThread = new Thread(() -> {
                Double cost = 300.0;
                addOnCalculator.setProductCost(cost);
                System.out.println("Calculating add on for mobile phone " + cost);
                System.out.println("Mobile phone - cost: " + addOnCalculator.getProductCost());
                System.out.println("Mobile phone - delivery charge: " + addOnCalculator.getDeliveryCharge());
                System.out.println("Mobile phone - tax: " + addOnCalculator.getTax());
                System.out.println("Mobile phone - discount: " + addOnCalculator.getDiscount());
            });
            addOnCalculatorThreads.add(phoneAddOnCalculatorThread);
            addOnCalculatorThreads.add(bookAddOnCalculatorThread);
            return addOnCalculatorThreads;
    }
}