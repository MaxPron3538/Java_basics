public class BankAccount
{
  private double bankAmount;

  public double getAmount(){
    //TODO: реализуйте метод и удалите todo
    // верните значение количества денег не счету
    return bankAmount;
  }

  public void put(double amountToPut){
    //TODO: реализуйте метод и удалите todo
    // метод зачисляет деньги на счет
    if(amountToPut > 0)
    {
      bankAmount += amountToPut;
    }
  }

  public void take(double amountToTake){
    //TODO: реализуйте метод и удалите todo
    // метод списывает деньги со счета
    if(amountToTake < bankAmount)
    {
      bankAmount -= amountToTake;
    }
  }
}
