package ru.skillbox;

public class ArithmeticCalculator
{
   private int firstNumeric,secondNumeric;

   ArithmeticCalculator(int firstNumeric,int secondNumeric)
   {
     this.firstNumeric = firstNumeric;
     this.secondNumeric = secondNumeric;
   }

   public int calcculate(Operations operation)
   {
      switch (operation)
      {
          case ADD: return firstNumeric + secondNumeric;

          case SUBTRACT: return firstNumeric - secondNumeric;

          case MULTIPLY: return firstNumeric * secondNumeric;
      }
      return 1;
   }

   public int getFirstNumeric(){return firstNumeric;}

   public int getSecondNumeric(){return secondNumeric;}

   public void setFirstNumeric(int firstNumeric){ this.firstNumeric = firstNumeric;}

   public void setSecondNumeric(int secondNumeric){ this.secondNumeric = secondNumeric;}

}
