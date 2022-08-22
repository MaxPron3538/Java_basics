import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args){

        Bank bank = new Bank();
        ArrayList<Thread> threads = new ArrayList<>();
        List<String> listNumOfAccount = new ArrayList<>();
        int numOfThread = 10000;

        for (int i = 0; i < numOfThread; i++) {
           int accNumber = (int)(1000000 + Math.random() * 10000000);
           bank.addAccount(String.valueOf(accNumber), 10000);
           listNumOfAccount.add(String.valueOf(accNumber));
        }

        for(int i = 0;i < 100;i++) {
            threads.add(new Thread(() -> {
                int numFromAcc = (int)(Math.random() * listNumOfAccount.size());
                int numToAcc = (int)(Math.random() * listNumOfAccount.size());
                bank.transferInHighlyConcurrent(listNumOfAccount.get(numFromAcc),listNumOfAccount.get(numToAcc),2000);
            }));
        }

        //Todo: DeadLook imitation

        for(int i = 0;i < numOfThread;i++) {
            final int leftCount = i;
            final int rightCount = numOfThread-1-i;

            threads.add(new Thread(() -> {
                bank.transferInHighlyConcurrent(listNumOfAccount.get(leftCount), listNumOfAccount.get(rightCount), 2000);
            }));
            threads.add(new Thread(() -> {
                bank.transferInHighlyConcurrent(listNumOfAccount.get(leftCount),listNumOfAccount.get(rightCount),2000);
            }));
        }
        threads.forEach(s -> s.start());
    }
}
