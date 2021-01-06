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
                Double costBook = 50.0;
                System.out.println("Calculating total cost for book " + costBook);
                System.out.println("Book - total cost: " + addOnCalculator.calculateAddOn(costBook));
            });

            //Create Thread2 - calculate the add on for a mobile phone costing 300$
            Thread phoneAddOnCalculatorThread = new Thread(() -> {
                Double costMobile = 300.0;
                System.out.println("Calculating total cost for mobile phone " + costMobile);
                System.out.println("Mobile phone - total cost: " + addOnCalculator.calculateAddOn(costMobile));
            });
            bookAddOnCalculatorThread.setName("Stalling thread");
            addOnCalculatorThreads.add(bookAddOnCalculatorThread);
            addOnCalculatorThreads.add(phoneAddOnCalculatorThread);
            return addOnCalculatorThreads;
    }
}