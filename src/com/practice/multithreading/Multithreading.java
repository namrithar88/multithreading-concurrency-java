package com.practice.multithreading;

import com.practice.multithreading.deadlock.DeadlockExample;
import com.practice.multithreading.executorservice.ExecutorServiceExample;
import com.practice.multithreading.racecondition.RaceConditionExample;

public class Multithreading {
    public static void main(String args[]) throws InterruptedException {
/*
        MobileInformationProviderService mobileInfoProviderAmazon = new AmazonMobileInformationProvider();
        MobileInformationProviderService mobileInfoProviderFB = new FBMarketPlaceMobileInformationProvider();
        List<Thread> mobileInfoProviderThreads = new ArrayList<>();

        MobileInformationProviderThread amazonInfoProviderThread = new MobileInformationProviderThread(mobileInfoProviderAmazon);

        MobileInformationProviderThread fbInfoProviderThread = new MobileInformationProviderThread(mobileInfoProviderFB);

        amazonInfoProviderThread.setName("Amazon info provider");
        fbInfoProviderThread.setName("FB info provider");

        mobileInfoProviderThreads.add(amazonInfoProviderThread);
        mobileInfoProviderThreads.add(fbInfoProviderThread);

        for(Thread mobileInfoProviderThread : mobileInfoProviderThreads) {
            mobileInfoProviderThread.start();
        }

        for(Thread mobileInfoProviderThread : mobileInfoProviderThreads) {
            mobileInfoProviderThread.join();
        }

        Map<String, MobileInformation> mobileInformationMap = new HashMap<>();
        mobileInformationMap.put("Amazon", amazonInfoProviderThread.getMobileInformation());
        mobileInformationMap.put("FB", fbInfoProviderThread.getMobileInformation());
        MobileStatsDTO mobileStatsDTO = new MobileStatsDTO(mobileInformationMap);

        //Printing values in MobileStatsDTO
        mobileStatsDTO.getMobileInformationList().forEach((infoProvider, mobileInformation) -> {
            System.out.println(" INFO PROVIDER " + infoProvider);
            System.out.println(" COST " + mobileInformation.getCost() + " DISCOUNT " + mobileInformation.getDiscount());
        });*/

        //System.out.println("Race condition");
        //RaceConditionExample raceConditionExample = new RaceConditionExample();
        //raceConditionExample.runExample();

        //System.out.println("Executor service");
        //ExecutorServiceExample executorServiceExample = new ExecutorServiceExample();
        //executorServiceExample.runExecutorServiceExampleSavingsAndCheckingAccount();

        //System.out.println("Future example");
        //FutureExample futureExample = new FutureExample();
        //futureExample.runFutureExample();

        System.out.println("Deadlock example");
        DeadlockExample deadlockExample = new DeadlockExample();
        deadlockExample.runDeadlockExample();
    }
}