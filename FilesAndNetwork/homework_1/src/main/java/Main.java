import javax.annotation.processing.FilerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите путь до папки:");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        String massage = "Размер папки " + path + " составляет ";

        long space = FileUtils.calculateFolderSize(path);

        if (space > Math.pow(1024, 3)) {
            System.out.println(massage + String.format("%,.3f", space / Math.pow(1024, 3)) + "Гб");
            return;
        }
        if (space > Math.pow(1024, 2)) {
            System.out.println(massage + String.format("%,.3f", space / Math.pow(1024, 2)) + " Мб");
            return;
        }
        if (space > 1024) {
            System.out.println(massage + String.format("%,.3f", space / Math.pow(1024, 1)) + " Кб");

        } else System.out.println(massage + space + " байт");

    }
}
