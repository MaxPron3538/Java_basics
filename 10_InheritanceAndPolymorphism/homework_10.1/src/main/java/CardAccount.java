public class CardAccount extends BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    public double percentTax(double amountToTake)
    {
        return amountToTake/100;
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public boolean take(double amountToTake)
    {
        amountToTake+=percentTax(amountToTake);
        return super.take(amountToTake);
    }

    @Override
    public void put(double amountToPut)
    {
        super.put(amountToPut);
    }

    @Override
    public boolean send(BankAccount receiver,double amount)
    {
        amount+=percentTax(amount);
        return super.send(receiver,amount);
    }
}
