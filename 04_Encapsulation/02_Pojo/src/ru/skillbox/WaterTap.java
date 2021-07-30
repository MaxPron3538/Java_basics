package ru.skillbox;

public class WaterTap
{
    private int hotWater = 70;
    private int coldWater = 10;
    private int warmWater;

    WaterTap(int warmWater)
    {
       this.warmWater = warmWater;
    }

    public int getHotWater(){return hotWater;}

    public int getColdWater(){return coldWater;}

    public int getWarmWater(){return warmWater;}

    public void setHotWater(int hotWater)
    {
        this.hotWater = hotWater;
    }

    public void setColdWater(int coldWater)
    {
        this.coldWater = coldWater;
    }

    public void setWarmWater(int warmWater)
    {
       this.warmWater = warmWater;
    }
}
