package com.practice.multithreading.service;

import com.practice.multithreading.domain.MobileInformation;

public class AmazonMobileInformationProvider implements  MobileInformationProviderService {
    public MobileInformation provideMobileInformation(String name, String model) {

        try {
            //Some complicated operation such as accessing the DB - takes 20 sec.
            Thread.currentThread().sleep(20000);
            MobileInformation mobileInformationAmazon = new MobileInformation(100, name, 200.17, model, "2015", 10F);
            System.out.println("Inside AmazonMobileInformationProvider. Mobile info retrieved");
            return mobileInformationAmazon;
        } catch(InterruptedException ie) {
            return new MobileInformation();
        }
    }
}