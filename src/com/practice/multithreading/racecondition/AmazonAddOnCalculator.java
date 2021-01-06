package com.practice.multithreading.racecondition;

public class AmazonAddOnCalculator {

    private Double productCost;

    public void setProductCost(Double productCost) {
        //System.out.println("Setting product cost to " + productCost);
        this.productCost = productCost;
    }

    public Double getProductCost() {
        return this.productCost;
    }

    public Double getDeliveryCharge() {
        return (0.1) * this.productCost;
    }

    public Double getTax() {
        return (0.15) * this.productCost;
    }

    public Double getDiscount() {
        return (0.20) * this.productCost;
    }
}