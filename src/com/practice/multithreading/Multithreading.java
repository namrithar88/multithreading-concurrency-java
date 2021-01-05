package com.practice.multithreading;

import com.practice.multithreading.domain.MobileInformation;
import com.practice.multithreading.dto.MobileStatsDTO;
import com.practice.multithreading.service.AmazonMobileInformationProvider;
import com.practice.multithreading.service.FBMarketPlaceMobileInformationProvider;
import com.practice.multithreading.service.MobileInformationProviderService;
import com.practice.multithreading.thread.MobileInformationProviderThread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Multithreading {
    public static void main(String args[]) throws InterruptedException {

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
        });
    }
}