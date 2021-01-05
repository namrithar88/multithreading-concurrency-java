package com.practice.multithreading.thread;

import com.practice.multithreading.domain.MobileInformation;
import com.practice.multithreading.service.MobileInformationProviderService;

public class MobileInformationProviderThread extends Thread {

    private MobileInformation mobileInformation;
    private MobileInformationProviderService mobileInformationProviderService;

    public MobileInformationProviderThread(MobileInformationProviderService mobileInformationProviderService) {
        this.setMobileInformationProviderService(mobileInformationProviderService);
    }

    @Override
    public void run() {
        this.mobileInformation = this.mobileInformationProviderService.provideMobileInformation("Samsung", "S15");
    }

    public MobileInformation getMobileInformation() {
        return this.mobileInformation;
    }

    public void setMobileInformationProviderService(MobileInformationProviderService mobileInformationProviderService) {
        this.mobileInformationProviderService = mobileInformationProviderService;
    }
}