package ru.skillbox;

public class Computer
{
   private CPU cpu;
   private RAM ram;
   private HardDisk hardDisk;
   private Keyboard keyboard;
   private Screen screen;
   private final String name;
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

   public void setCpu(CPU cpu) {
      this.cpu = cpu;
   }

   public void setRam(RAM ram) {
      this.ram = ram;
   }

   public void setHardDisk(HardDisk hardDisk) {
      this.hardDisk = hardDisk;
   }

   public void setKeyboard(Keyboard keyboard) {
      this.keyboard = keyboard;
   }

   public void setScreen(Screen screen) {
      this.screen = screen;
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
