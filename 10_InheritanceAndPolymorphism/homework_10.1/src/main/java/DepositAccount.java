import java.time.LocalDate;
import java.util.*;

public class DepositAccount extends BankAccount
{
    ArrayList<LocalDate> lastIncome = new ArrayList<>();

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut) {
        lastIncome.add(LocalDate.now());
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake)
    {
        if(lastIncome.size() > 1)
        {
            if (lastIncome.get(lastIncome.size()-1).getMonthValue() - lastIncome.get(lastIncome.size()-2).getMonthValue() >= 1)
            {
                super.take(amountToTake);
            }
         }
    }
}
