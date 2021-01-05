package com.practice.multithreading.domain;

public class MobileInformation {

    private Integer id;
    private String name;
    private Double cost;
    private String model;
    private String year;
    private Float discount;

    public MobileInformation() {
    }

    public MobileInformation(Integer id, String name, Double cost, String model, String year, Float discount) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.model = model;
        this.year = year;
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
