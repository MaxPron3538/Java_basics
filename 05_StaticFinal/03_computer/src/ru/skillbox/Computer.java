package ru.skillbox;

public class Computer
{
   private final CPU cpu;
   private final RAM ram;
   private final HardDisk hardDisk;
   private final Keyboard keyboard;
   private final Screen screen;
   private  String name;
   private final String vendor;

   Computer(String vendor,String name,CPU cpu, RAM ram, HardDisk hardDisk, Keyboard keyboard, Screen screen)
   {
      this.vendor = vendor;
      this.name = name;
      this.cpu = cpu;
      this.ram = ram;
      this.hardDisk = hardDisk;
      this.keyboard = keyboard;
      this.screen = screen;
   }

   public double calculateTotalMass()
   {
      return cpu.getWeight() + ram.getWeight() + hardDisk.getWeight() + keyboard.getWeight() + screen.getWeight();
   }

   public String toString()
   {
      return "Computer - " + name + "\n" + "Vendor - " + vendor + "\n" + "CPU - " + cpu.toString() + "\n" + "RAM - " + ram.toString()
              + "\n" + "Hard Disk - " + hardDisk.toString() + "\n" + "Keyboard - " + keyboard.toString() + "\n" + "Screen - " + screen.toString();
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public String getVendor() {
      return vendor;
   }

   public CPU getCPU() {
      return cpu;
   }

   public RAM getRAM() {
      return ram;
   }

   public HardDisk getHardDisk() {
      return hardDisk;
   }

   public Keyboard getKeyboard() {
      return keyboard;
   }

   public Screen getScreen() {
      return screen;
   }
}
