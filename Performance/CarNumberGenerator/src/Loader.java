import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<PrintWriter> listWriter = new ArrayList<>();
        List<String> listNumbers = new LinkedList<>();
        listWriter.add(new PrintWriter("res/numbers1.txt"));
        listWriter.add(new PrintWriter("res/numbers2.txt"));

        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        int regionCode = 199;
        String region = padNumber(regionCode, 2);

        for (int number = 1; number < 1000; number++) {
            StringBuilder builder = new StringBuilder();
            String padNum = padNumber(number, 3);

            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        builder.append(firstLetter);
                        builder.append(padNum);
                        builder.append(secondLetter);
                        builder.append(thirdLetter);
                        builder.append(region);
                        builder.append("\n");
                    }
                }
            }
            listNumbers.add(builder.toString());
        }

        Runnable thread1 = () -> {
            for (int i = 0;i < 500;i++){
                listWriter.get(0).write(listNumbers.get(i));
            }
        };

        Runnable thread2 = () -> {
            for (int i = 500;i < 999;i++){
                listWriter.get(1).write(listNumbers.get(i));
            }
        };

        Thread run1 = new Thread(thread1);
        Thread run2 = new Thread(thread2);
        run1.start();
        run2.start();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();

        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;
    }
}
