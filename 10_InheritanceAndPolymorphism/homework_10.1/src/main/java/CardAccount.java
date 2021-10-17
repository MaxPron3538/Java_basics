public class CardAccount extends BankAccount {
    // не забывайте, обращаться к методам и конструкторам родителя
    // необходимо используя super, например, super.put(10D);

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void take(double amountToTake)
    {
        double percentTax = amountToTake/100;
        amountToTake+=percentTax;

        super.take(amountToTake);
    }

    @Override
    public void put(double amountToPut)
    {
        super.put(amountToPut);
    }
}
