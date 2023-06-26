import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class Loader {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Runnable thread1 = () -> {
            try {
                buildAndWriteCarNumber(1,500,"res/numbers1.txt");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Runnable thread2 = () -> {
            try {
                buildAndWriteCarNumber(500,1000,"res/numbers2.txt");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Thread run1 = new Thread(thread1);
        Thread run2 = new Thread(thread2);
        run1.start();
        run2.start();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    public static void buildAndWriteCarNumber(int init,int finish,String path) throws Exception {
        int regionCode = 199;
        PrintWriter writer = new PrintWriter(path);
        String region = padNumber(regionCode, 2);
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        for (int number = init; number < finish; number++) {
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
            writer.write(builder.toString());
        }
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
