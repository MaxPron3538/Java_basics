import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        Bank bank = new Bank();
        ArrayList<Thread> threads = new ArrayList<>();
        List<String> listNumOfAccount = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
           int accNumber = (int)(1000000 + Math.random() * 10000000);
           bank.addAccount(String.valueOf(accNumber), 10000);
           listNumOfAccount.add(String.valueOf(accNumber));
        }

        for(int i = 0;i < 100;i++) {
            threads.add(new Thread(() -> {
                int numFromAcc = (int)(Math.random() * listNumOfAccount.size());
                int numToAcc = (int)(Math.random() * listNumOfAccount.size());
                bank.transfer(listNumOfAccount.get(numFromAcc),listNumOfAccount.get(numToAcc),2000);
            }));
        }
        threads.forEach(s -> s.start());
    }
}
