package com.github.viniciusboos.hrpayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable {
    private static final long serialVersionUID = 1l;

    private String name;
    private Double dailyincome;
    private Integer days;

    public Payment(String name, Double dailyincome, Integer days) {
        this.name = name;
        this.dailyincome = dailyincome;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyincome() {
        return dailyincome;
    }

    public void setDailyincome(Double dailyincome) {
        this.dailyincome = dailyincome;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public double getTotal() {
        return days * dailyincome;
    }
}
