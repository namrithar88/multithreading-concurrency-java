package com.practice.multithreading.racecondition;

public class AmazonAddOnCalculator {

    private Double productCost;

    public Double calculateAddOn(Double productCost) {
        synchronized (this) {
            this.setProductCost(productCost);
            return this.getProductCost() + this.getDeliveryCharge() + this.getTax() - this.getDiscount();
        }
    }

    public void setProductCost(Double productCost) {
            this.productCost = productCost;
    }

    public Double getProductCost() {
            return this.productCost;
    }

    public Double getDeliveryCharge() {
            return (0.1) * this.productCost;
    }

    public Double getTax() {
        //Threads unexpectedly get delayed by 20 secs due to some long running operation
            try {
                Thread.currentThread().sleep(20000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted exception in " + Thread.currentThread().getName());
                e.printStackTrace();
            }
            return (0.15) * this.productCost;
    }

    public Double getDiscount() {
           return (0.20) * this.productCost;
    }
}