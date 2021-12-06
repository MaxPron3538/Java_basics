import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);

        sortBySalaryAndAlphabet(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        Comparator<Employee> comparator = Comparator.comparing(o1 -> o1.getSalary());
        comparator = comparator.thenComparing(o2 -> o2.getName());

        Collections.sort(staff,comparator);

        staff.forEach(System.out::println);
    }
}