public class IndividualBusinessman extends Client
{
    @Override
    public double getAmount()
    {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut)
    {
        if(amountToPut < 1000)
        {
            amountToPut -= super.percentTax(amountToPut, 1);
        }
        if(amountToPut >= 1000)
        {
           amountToPut -= super.percentTax(amountToPut,0.5);
        }
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake)
    {
        super.take(amountToTake);
    }
}
