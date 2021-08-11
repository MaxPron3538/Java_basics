package ru.skillbox;

import java.math.BigDecimal;

public class Main
{
    public static void main(String[] args)
    {
        BigDecimal bigD = new BigDecimal("3.00E4");

        CPU cpu = new CPU(bigD,4,"Intel",50);

        RAM ram = new RAM(TypeRAM.DDR3,8,100);

        HardDisk hardDisk = new HardDisk(HardDiskType.HDD,1000,1000);

        Keyboard keyboard = new Keyboard(KeyboardType.MechanicalKeyboard,true,700);

        Screen screen = new Screen(30,TypeScreen.TN,5000);

        Computer computer = new Computer("Dell","Dell Vostro 3588",cpu,ram,hardDisk,keyboard,screen);

        System.out.println(computer.toString());
    }
}
