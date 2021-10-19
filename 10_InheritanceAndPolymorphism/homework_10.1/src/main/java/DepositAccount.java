import java.time.LocalDate;
import java.util.*;

public class DepositAccount extends BankAccount
{
    private LocalDate lastIncome;

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void put(double amountToPut)
    {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    public boolean take(double amountToTake)
    {
         if (LocalDate.now().getMonthValue() - lastIncome.getMonthValue() > 0 | LocalDate.now().getYear() - lastIncome.getYear() > 0) {
            return super.take(amountToTake);
         }
         return false;
    }

    @Override
    public boolean send(BankAccount receiver,double amount)
    {
        if(take(amount))
        {
            return super.send(receiver,amount);
        }
        return false;
    }
}
