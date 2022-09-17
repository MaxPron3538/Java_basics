import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((Employee e1, Employee e2) -> {
            int compSalary = e1.getSalary().compareTo(e2.getSalary());
            if(compSalary == 0){
                return e1.getName().compareTo(e2.getName());
            }
            return compSalary;
        });
    }
}