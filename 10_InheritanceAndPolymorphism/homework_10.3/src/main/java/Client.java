public abstract class Client {

    private double amountOnAccount;

    public double percentTax(double amount,double percent)
    {
        return amount*percent/100;
    }

    public double getAmount()
    {
        return amountOnAccount;
    }

    public void put(double amountToPut)
    {
        if(amountToPut > 0)
        {
            amountOnAccount += amountToPut;
        }
    }

    public void take(double amountToTake)
    {
        if(amountOnAccount > amountToTake)
        {
            amountOnAccount-= amountToTake;
        }
    }

}
