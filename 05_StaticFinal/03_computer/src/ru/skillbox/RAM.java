package ru.skillbox;

public final class RAM
{
    private final TypeRAM type;
    private final int volumeMemory;
    private final double weight;

    public RAM(TypeRAM type,int volumeMemory,double weight)
    {
        this.type = type;
        this.volumeMemory = volumeMemory;
        this.weight = weight;
    }

    public String toString()
    {
        return "|" + "type: " + type + "|" + "\t" + "volume memory GB: " + volumeMemory + "|" + "\t" + "weight gram: " + weight + "|";
    }

    public TypeRAM getType() {
        return type;
    }

    public int getVolume() {
        return volumeMemory;
    }

    public double getWeight() {
        return weight;
    }
}
