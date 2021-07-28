package ru.skillbox;

public class Elevator
{
    public int minFloor;
    public int currentFloor = 1;
    public int maxFloor;

    Elevator(int minFloor,int maxFloor)
    {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    int getCurrentFloor()
    {
       return currentFloor;
    }

    void moveDown()
    {
      currentFloor = currentFloor - 1;
    }

    void  moveUp()
    {
      currentFloor = currentFloor + 1;
    }

    void move(int floor)
    {
       if(floor > maxFloor | floor < minFloor)  System.out.println("Error: Incorrect data,please try again!");

       else
       {
           while (true)
           {
               if (currentFloor == floor){ System.out.println("We are arrived!");  return; }

               if (floor > currentFloor) moveUp();

               if (floor < currentFloor) moveDown();

               System.out.println("The current floor is - " + currentFloor);
           }
       }
    }
}
