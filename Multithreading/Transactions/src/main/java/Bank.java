import java.util.*;
import java.util.stream.Collectors;

public class Bank {

    Bank(){
        this.accounts = new HashMap<>();
    }

    private Map<String,Account> accounts;
    private final Random random = new Random();
    private static int sumOfTransfer = 50000;

    public synchronized boolean isFraud()
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        long balanceFromAccount = accounts.get(fromAccountNum).getMoney();
        long balanceToAccount = accounts.get(toAccountNum).getMoney();

        if(amount < balanceFromAccount) {
            if(amount > sumOfTransfer){
                try{
                    if (isFraud()) {
                        accounts.get(fromAccountNum).setBlockAccount(true);
                        accounts.get(toAccountNum).setBlockAccount(true);
                    }

                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            accounts.get(fromAccountNum).setMoney(balanceFromAccount - amount);
            accounts.get(toAccountNum).setMoney(balanceToAccount + amount);
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
