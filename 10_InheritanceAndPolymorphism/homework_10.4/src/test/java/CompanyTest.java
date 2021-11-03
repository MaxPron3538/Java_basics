
import net.sf.saxon.expr.Component;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompanyTest {

    private static final String notExpectedSumMessage = "Невозмо нанять сотрудника из за недостатка бюджета";

    private Company company;
    private List<Employer> listEmployers = new LinkedList<>();

    @BeforeEach
    public void setUp() {
        company = new Company();
    }

    @Test
    @DisplayName("Метод put, Попытка добавить  менеджера")
    void putManager() {
        Manager manager = new Manager(25000);
        assertEquals(true,company.hire(manager), notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод put, Попытка добавить оператора")
    void putOperator() {
        Operator operator = new Operator(15000);
        assertEquals(true, company.hire(operator), notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод put, Попытка добавить топ менеджера")
    void putTopManager() {
        TopManager topManager = new TopManager(30000);
        assertEquals(true, company.hire(topManager), notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод put, Попытка добавить сотрудников больше чем позволяет бюджет")
    void put() {
        Manager manager = new Manager(25000);
        Operator operator1 = new Operator(15000);
        TopManager topManager = new TopManager(30000);
        Operator operator2 = new Operator(15000);
        company.hire(manager);
        company.hire(operator1);
        company.hire(topManager);
        company.hire(operator2);
        assertEquals(false, company.hire(new Operator(15000)), notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод put, Попытка добавить множество работников компании")
    void putEveryEmployer(){
        assertEquals(true,company.hireAll(),notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод create, Попытка создать компанию с множеством работников")
    void createCompanyWithListEmployers(){
        double sumSalary = 0,income = 5600000;

        for (int i = 0;i < 180;i++) {

           if(i < 80) {
              listEmployers.add(new Manager(25000));
              sumSalary += listEmployers.get(i).getMonthSalary();
           }

           listEmployers.add(new Operator(15000));
           sumSalary += listEmployers.get(i).getMonthSalary();

           if(i < 10) {
              listEmployers.add(new TopManager(30000));
              sumSalary += listEmployers.get(i).getMonthSalary();
          }
        }
        assertEquals(true,AvailableNumberOfWorkers.checkForTheAmountOfWages(listEmployers,income), notExpectedSumMessage);
    }

    @Test
    @DisplayName("Метод get, Попытка получить отсортированый список работников по возростанию")
    void getTop(){
        double income = 400000;

        listEmployers = new LinkedList<>();
        listEmployers.add(new Operator(15000));
        listEmployers.add(new TopManager(30000));
        listEmployers.add(new Manager(22000));
        listEmployers.add(new Operator(16000));
        listEmployers.add(new Manager(24000));
        listEmployers.add(new TopManager(21000));
        listEmployers.add(new TopManager(18000));
        listEmployers.add(new Operator(15000));
        listEmployers.add(new Manager(24000));
        listEmployers.add(new Operator(27000));

        company = new Company(listEmployers,income,50000,40000,60000);

        listEmployers = listEmployers.stream().sorted().collect(Collectors.toList());
        List<Employer> sortedListCompany = company.getTopSalaryStaff(0,8);

        for(int i = 0;i < sortedListCompany.size();i++)
        {
            assertEquals(listEmployers.get(i).salary,sortedListCompany.get(i).salary, notExpectedSumMessage);
        }
    }

    @Test
    @DisplayName("Метод get, Попытка получить отсортированый список работников по убывнию")
    void getLowest(){
        double income = 400000;

        listEmployers = new LinkedList<>();
        listEmployers.add(new Operator(15000));
        listEmployers.add(new TopManager(30000));
        listEmployers.add(new Manager(22000));
        listEmployers.add(new Operator(16000));
        listEmployers.add(new Manager(24000));
        listEmployers.add(new TopManager(21000));
        listEmployers.add(new TopManager(18000));
        listEmployers.add(new Operator(15000));
        listEmployers.add(new Manager(24000));
        listEmployers.add(new Operator(27000));

        company = new Company(listEmployers,income,50000,40000,60000);

        Collections.sort(listEmployers,Collections.reverseOrder());
        List<Employer> sortedListCompany = company.getTopSalaryStaff(0,8);

        for(int i = 0;i < sortedListCompany.size();i++)
        {
            assertEquals(listEmployers.get(i).salary,sortedListCompany.get(i).salary, notExpectedSumMessage);
        }
    }

    @Test
    @DisplayName("Метод delete, Попытка удалить работника компании")
    public void deleteEmployer(){
        double income = 200000;

        listEmployers = new LinkedList<>();

        Operator operator1 = new Operator(15000);
        TopManager topManager = new TopManager(30000);
        Manager manager1 = new Manager(22000);
        Operator operator2 = new Operator(16000);
        Manager manager2 = new Manager(24000);

        listEmployers.add(operator1);
        listEmployers.add(topManager);
        listEmployers.add(manager1);
        listEmployers.add(manager2);

        company = new Company(listEmployers,income,40000,30000,50000);

        assertEquals(true,company.fire(topManager), notExpectedSumMessage);
    }
}