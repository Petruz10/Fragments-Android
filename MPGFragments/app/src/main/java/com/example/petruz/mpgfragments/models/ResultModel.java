package com.example.petruz.mpgfragments.models;

/**
 * Created by Petruz on 22/10/17.
 */

public class ResultModel
{
    private double milage;
    private double gasPrice;
    private double MPG;

    public ResultModel()
    {

    }

    public double getMPG() {
        return this.MPG;
    }

    public void setMPG(double MPG) {
        this.MPG = MPG;
    }

    public double getMilage() {
        return this.milage;
    }

    public void setMilage(double milage) {
        this.milage = milage;
    }

    public double getGasPrice() {
        return this.gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

}
