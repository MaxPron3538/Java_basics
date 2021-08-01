package ru.skillbox;

class Dimensions
{
   private final double height;
   private final double width;
   private final double length;

   Dimensions(double height,double width,double length)
   {
     this.height = height;
     this.width = width;
     this.length = length;
   }

   public double calculateVolume()
   {
     return height * width * length;
   }
   public String print()
   {
       return "Height: " + height + "\t" + "Width: " + width + "\t" + "Length: " + length;
   }

   double getHeight(){return height;}

   double getWidth(){return width;}

   double getLength(){return length;}
}

public class Goods
{
    private final Dimensions dimensions;
    private final double weight;
    private final int deliveryAddress;
    private final boolean possibleToFlip;
    private final String registrationNumber;
    private final boolean fragileGoods;

    Goods(Dimensions dimensions,double weight,int deliveryAddress,boolean possibleToFlip,String registrationNumber,boolean fragileGoods)
    {
        this.dimensions = dimensions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.possibleToFlip = possibleToFlip;
        this.registrationNumber = registrationNumber;
        this.fragileGoods = fragileGoods;
    }

    Goods changePropertyOfWeight(double weight)
    {
        return new Goods(dimensions,weight,deliveryAddress,possibleToFlip,registrationNumber,fragileGoods);
    }

    Goods changePropertyOfDimensions(Dimensions dimensions)
    {
        return new Goods(dimensions,weight,deliveryAddress,possibleToFlip,registrationNumber,fragileGoods);
    }

    Goods changePropertyOfAddress(int deliveryAddress)
    {
        return new Goods(dimensions,weight,deliveryAddress,possibleToFlip,registrationNumber,fragileGoods);
    }

    public void print(Dimensions dimensions)
    {
        System.out.println("Dimensions: " + dimensions.print() + "\n" + "weight: " + weight + "\n" + "delivery address: " + deliveryAddress + "\n" + "possible To Flip: " + possibleToFlip + "\n" + "registration Number: " + registrationNumber + "\n" + "fragile goods: " + fragileGoods);
    }

    Dimensions getDimensions(){return dimensions;}

    double getWeight(){return weight;}

    int getDeliveryAddress(){return deliveryAddress;}

    boolean getPossibleToFlip(){return possibleToFlip;}

    String getRegistrationNumber(){return registrationNumber;}

    boolean getFragileGoods(){return fragileGoods;}

}
