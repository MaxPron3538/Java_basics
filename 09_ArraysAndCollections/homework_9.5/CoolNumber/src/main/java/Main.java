import java.nio.charset.StandardCharsets;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {


        List<String> coolNumbers = CoolNumbers.generateCoolNumbers().stream().sorted().collect(Collectors.toList());
        String number = CoolNumbers.numbersCar.get(2500);
        long time = 0;

        long startTime = System.nanoTime();
        boolean resultBruteForceSearch = CoolNumbers.bruteForceSearchInList(coolNumbers,number);
        long endTime = System.nanoTime();
        time = endTime - startTime;

        System.out.print("Поиск перебором: ");
        if(resultBruteForceSearch) System.out.println("Номер найден, поиск занял " + time);
        else System.out.println("Номер не найден");

        List<String> sortCoolNumbers = coolNumbers.stream().sorted().collect(Collectors.toList());

        startTime = System.nanoTime();
        boolean resultBinarySearch = CoolNumbers.binarySearchInList(sortCoolNumbers,number);
        endTime = System.nanoTime();
        time = endTime - startTime;

        System.out.print("Бинарный поиск: ");
        if(resultBinarySearch) System.out.println("Номер найден, поиск занял " + time);
        else System.out.println("Номер не найден");

        HashSet<String> heshCoolNumbers = new HashSet<>();
        heshCoolNumbers.addAll(coolNumbers);

        startTime = System.nanoTime();
        boolean resultSearchInHashSet = CoolNumbers.searchInHashSet(heshCoolNumbers,number);
        endTime = System.nanoTime();
        time = endTime - startTime;

        System.out.print("поиск в HashSet: ");
        if(resultSearchInHashSet) System.out.println("Номер найден, поиск занял " + time);
        else System.out.println("Номер не найден");

        TreeSet<String> treeCoolNumbers = new TreeSet<>();
        treeCoolNumbers.addAll(coolNumbers);

        startTime = System.nanoTime();
        boolean resultSearchInTreeSet = CoolNumbers.searchInTreeSet(treeCoolNumbers,number);
        endTime = System.nanoTime();
        time = endTime - startTime;

        System.out.print("поиск в TreeSet: ");
        if(resultSearchInTreeSet) System.out.println("Номер найден, поиск занял " +time);
        else System.out.println("Номер не найден");
    }

}
