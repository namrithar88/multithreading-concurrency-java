package com.practice.multithreading.racecondition;

import java.util.List;

public class ThreadExecutor {
    public void executeThreads(List<Thread> addOnCalculatorThreads) {
    try {
        for(Thread addOnCalculatorThread : addOnCalculatorThreads) {
            addOnCalculatorThread.start();
        }

        for(Thread addOnCalculatorThread : addOnCalculatorThreads) {
            //Current thread goes into waiting state until the child threads complete.
            addOnCalculatorThread.join();
        }
    } catch(InterruptedException ie) {
        System.out.println("Interrupted exception in " + Thread.currentThread().getName());
        ie.printStackTrace();
        return;
    }
    }
}