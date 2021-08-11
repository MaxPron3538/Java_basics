package ru.skillbox;

public final class HardDisk
{
    private final HardDiskType type;
    private final int memorySize;
    private final double weight;

    public HardDisk(HardDiskType type,int memorySize,double weight)
    {
        this.type = type;
        this.memorySize = memorySize;
        this.weight = weight;
    }

    public String toString()
    {
        return  "|" + "type: " + type + "|" + "\t" + "memory size GB: " + memorySize + "|" + "\t" + "weight gram: " + weight + "|";
    }

    public HardDiskType getType() {
        return type;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public double getWeight() {
        return weight;
    }
}
