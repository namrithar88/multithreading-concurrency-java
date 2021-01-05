package com.practice.multithreading.service;

import com.practice.multithreading.domain.MobileInformation;

public interface MobileInformationProviderService {
    public MobileInformation provideMobileInformation(String name, String model);
}