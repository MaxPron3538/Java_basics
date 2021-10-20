public class LegalPerson extends Client
{
    @Override
    public double getAmount()
    {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut)
    {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake)
    {
        amountToTake += super.percentTax(amountToTake,1);
        super.take(amountToTake);
    }
}
