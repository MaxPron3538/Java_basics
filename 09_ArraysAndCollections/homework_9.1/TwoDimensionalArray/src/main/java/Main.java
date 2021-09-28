import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив

        while (true){
            System.out.println("Введите размер крестика(Должно быть нечетным):");
            Scanner in = new Scanner(System.in);
            int size = in.nextInt();
            if (size % 2 == 0) {
                System.out.println("Четное значение!");
                continue;
            }

            char[][] arraySymbol = TwoDimensionalArray.getTwoDimensionalArray(size);

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(arraySymbol[i][j]);
                }
                System.out.println();
            }
        }
    }
}
