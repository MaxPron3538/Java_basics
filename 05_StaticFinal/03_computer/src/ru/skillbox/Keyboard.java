package ru.skillbox;

public final class Keyboard
{
    private final KeyboardType type;
    private final boolean backlight;
    private final double weight;

    public Keyboard(KeyboardType type,boolean backlight,double weight)
    {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }

    public String toString()
    {
        return  "|" + "type: " + type + "|" + "\t" + "backlight: " + backlight + "|" + "\t" + "weight gram: " + weight + "|";
    }

    public KeyboardType getType() {
        return type;
    }

    public boolean getBackType() {
        return backlight;
    }

    public double getWeight() {
        return weight;
    }
}
