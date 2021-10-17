import java.time.LocalDate;

public class Main
{
    public static void main(String[] args)
    {
        CardAccount account = new CardAccount();
        account.put(10000);
        System.out.println(account.getAmount());
        account.take(2000);
        System.out.println(account.getAmount());

        LocalDate date = LocalDate.of(2021,9,10);
        LocalDate now = LocalDate.now();
        int period = now.getDayOfMonth() - date.getDayOfMonth();
        System.out.println(period);

    }

}
