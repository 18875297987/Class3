package com.wei.web.entity;

public class User2 {
    private Double weight;
    private Double hight;

    public User2() {
    }

    public User2(Double weight, Double hight) {
        this.weight = weight;
        this.hight = hight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHight() {
        return hight;
    }

    public void setHight(Double hight) {
        this.hight = hight;
    }

    @Override
    public String toString() {
        return "User2{" +
                "weight=" + weight +
                ", hight=" + hight +
                '}';
    }
}
