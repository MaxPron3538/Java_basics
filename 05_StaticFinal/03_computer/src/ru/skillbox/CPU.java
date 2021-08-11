package ru.skillbox;

import java.math.BigDecimal;

public final class CPU
{
    private  BigDecimal frequency;
    private final int numberOfCores;
    private final String vendor;
    private final double weight;

    public CPU(BigDecimal frequency,int numberOfCores,String vendor,double weight)
    {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.vendor = vendor;
        this.weight = weight;
    }

    public String toString()
    {
        return "|" + "frequency hertz: " + frequency + "|" + "\t" + "number of cores: " + numberOfCores + "|" + "\t" + "vendor: " + vendor +  "|" + "\t" + "weight gram: " + weight + "|";
    }

    public void setFrequency(BigDecimal frequency) {
        this.frequency = frequency;
    }

    public BigDecimal getFrequency() {
        return frequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public String getVendor() {
        return vendor;
    }

    public double getWeight() {
        return weight;
    }
}
