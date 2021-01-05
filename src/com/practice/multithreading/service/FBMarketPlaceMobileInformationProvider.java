package com.practice.multithreading.service;

import com.practice.multithreading.domain.MobileInformation;

public class FBMarketPlaceMobileInformationProvider implements  MobileInformationProviderService{
    public MobileInformation provideMobileInformation(String name, String model) {

        try {
            //Some complicated operation such as accessing the DB - takes 1 sec.
            Thread.currentThread().sleep(1000);
            MobileInformation mobileInformationFB = new MobileInformation(569, name, 190.22, model, "2015", 18.4F);
            System.out.println("Inside FBMobileInformationProvider. Mobile info retrieved");
            return mobileInformationFB;
        } catch(InterruptedException ie) {
            return new MobileInformation();
        }
    }
}
