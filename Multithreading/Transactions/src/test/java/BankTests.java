import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Проверка метода перевода средств в многопоточной среде")
public class BankTests {

    private Bank bank;
    private List<String> listNumOfAccount;

    @BeforeEach
    void beforeEach(){
         bank = new Bank();
         listNumOfAccount = new ArrayList<>();

         for (int i = 0; i < 10000; i++) {
             int accNumber = (int) (1000000 + Math.random() * 10000000);
             bank.addAccount(String.valueOf(accNumber), 100000);
             listNumOfAccount.add(String.valueOf(accNumber));
         }
    }

    @Test
    public void testOfSynchronizedAddAccount() {
        List<Thread> threads = new ArrayList<>();
        Bank exampleBank = new Bank();
        for (int j = 0; j < 100;j++) {
            threads.add(new Thread(() -> {
                String accNumber = String.valueOf((int) (1000000 * Math.random() * 100000000));
                exampleBank.addAccount(accNumber, 10000);
                assertTrue(exampleBank.getAccounts().containsKey(accNumber));
            }));
        }
        threads.forEach(Thread::start);
    }

    @Test
    public void testOfTransferInHighlyConcurrent(){
        List<Thread> threads = new ArrayList<>();
        long sumOfTransfer = 3000;

        for(int i = 0;i < 1000;i++){
            final int count = i;
            threads.add(new Thread(() -> {
                String numFromAccount = listNumOfAccount.get(count);
                String numToAccount = listNumOfAccount.get(listNumOfAccount.size()-count-1);

                long expectedBalanceFrom = bank.getBalance(numFromAccount)-sumOfTransfer;
                long expectedBalanceTo = bank.getBalance(numToAccount)+sumOfTransfer;
                bank.transfer(numFromAccount,numToAccount,sumOfTransfer);

                assertEquals(expectedBalanceFrom,bank.getBalance(numFromAccount));
                assertEquals(expectedBalanceTo,bank.getBalance(numToAccount));
            }));
        }
        threads.forEach(Thread::start);
    }

    @Test
    public void testOfTransferWithFraudTransaction(){
        List<Thread> threads = new ArrayList<>();
        long sumOfTransfer = 58000;

        for(int i = 0;i < 10000;i++){
            final int count = i;
            threads.add(new Thread(() -> {
                String numFromAccount = listNumOfAccount.get(count);
                String numToAccount = listNumOfAccount.get(listNumOfAccount.size()-count-1);

                long expectedBalanceFrom = bank.getBalance(numFromAccount);
                long expectedBalanceTo = bank.getBalance(numToAccount);
                bank.transfer(numFromAccount,numToAccount,sumOfTransfer);

                if(bank.getAccounts().get(numFromAccount).getBlockAccount()) {
                    assertEquals(expectedBalanceFrom, bank.getBalance(numFromAccount));
                    assertEquals(expectedBalanceTo, bank.getBalance(numToAccount));
                }
            }));
        }
        threads.forEach(s -> s.start());
    }

}
