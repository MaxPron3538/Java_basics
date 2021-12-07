import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {

        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        staff.sort(Comparator.comparing((Employee employee) -> employee.getSalary())
                .thenComparing(employee1 -> employee1.getName()));
    }
}