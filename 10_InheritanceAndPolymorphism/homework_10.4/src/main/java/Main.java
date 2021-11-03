import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args)
    {
        List<Employer> listEmployers = new LinkedList<>();
        int ammount = 0;

        for(int i = 0;i < 30;i++){
            double salary = Math.random() * (40000 - 15000) + 15000;
            listEmployers.add(new Operator(salary));
            ammount += salary;
        }
        for(int i = 0;i < 20;i++){
            double salary = Math.random() * (70000 - 20000) + 20000;
            listEmployers.add(new Manager(salary));
            ammount += salary;
        }
        for(int i = 0;i < 10;i++){
            double salary = Math.random() * (90000 - 40000) + 40000;
            listEmployers.add(new TopManager(salary));
            ammount += salary;
        }
        Company company = new Company(listEmployers,ammount*2,70000,40000,90000);
        List<Employer> copyListEmployers = company.getTopSalaryStaff(45,60);

        System.out.println("Top Employers Salary:");

        for(Employer employer : copyListEmployers){
            System.out.println(employer.salary);
        }

        copyListEmployers = company.getTopSalaryStaff(0,30);

        System.out.println("Lowest Employers Salary:");

        for(Employer employer : copyListEmployers){
            System.out.println(employer.salary);
        }

        for(int i = 0;i < 30;i++)
        {
            company.fire(listEmployers.get((int)Math.random() * 60));
        }

        copyListEmployers = company.getTopSalaryStaff(15,30);

        System.out.println("Top Employers Salary:");

        for(Employer employer : copyListEmployers)
        {
            System.out.println(employer.salary);
        }

        copyListEmployers = company.getTopSalaryStaff(0,30);

        System.out.println("Lowest Employers Salary:");

        for(Employer employer : copyListEmployers)
        {
            System.out.println(employer.salary);
        }

    }
}
