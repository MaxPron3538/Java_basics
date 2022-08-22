import java.util.*;
import java.util.stream.Collectors;

public class Bank {

    Bank(){
        this.accounts = new HashMap<>();
    }

    private Map<String,Account> accounts;
    private final Random random = new Random();
    private static int sumOfTransfer = 50000;
    private static final Object lockThread = new Object();

    public synchronized boolean isFraud()
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    private void doTransfer(Account fromAccount,Account toAccount, long amount){
        long balanceFromAccount = fromAccount.getMoney();
        long balanceToAccount = toAccount.getMoney();

        if (amount < balanceFromAccount) {
            if (amount > sumOfTransfer) {
                try {
                    if (isFraud()) {
                        fromAccount.setBlockAccount(true);
                        toAccount.setBlockAccount(true);
                    }

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            fromAccount.setMoney(balanceFromAccount - amount);
            toAccount.setMoney(balanceToAccount + amount);
        }
    }


    public void transferInHighlyConcurrent(String fromAccountNum, String toAccountNum, long amount) {

        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        synchronized (lockThread) {
            synchronized (fromAccount){
                synchronized (toAccount){
                    doTransfer(fromAccount,toAccount,amount);
                }
            }
        }
    }

    public synchronized void addAccount(String accNumber,long balance){
        if (balance > 0) {
            accounts.put(accNumber, new Account(String.valueOf(accNumber), balance));
        }
    }

    public long getBalance(String accountNum){
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts(){
        List<Long> listBalance = accounts.values().stream().map(s -> s.getMoney()).collect(Collectors.toList());
        return listBalance.stream().mapToLong(Long::longValue).sum();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
