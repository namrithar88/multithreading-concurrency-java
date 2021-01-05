package com.practice.multithreading.dto;

import com.practice.multithreading.domain.MobileInformation;

import java.util.List;
import java.util.Map;

public class MobileStatsDTO {

    private Map<String, MobileInformation> mobileInformationList; // A map of MobileInfo, info provider such as Amazon, FB etc.

    public MobileStatsDTO(Map<String, MobileInformation> mobileInformationList) {
        this.mobileInformationList = mobileInformationList;
    }

    public Map<String, MobileInformation> getMobileInformationList() {
        return mobileInformationList;
    }

    public void setMobileInformationList(Map<String, MobileInformation> mobileInformationList) {
        this.mobileInformationList = mobileInformationList;
    }
}