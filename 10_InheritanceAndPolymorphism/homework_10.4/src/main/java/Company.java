import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

enum positionEmployer {
    EMPLOYER_MANAGER,
    EMPLOYER_OPERATOR,
    EMPLOYER_TOPMANAGER
}

public class Company
{
   private double income;
   private double employerSalary;

   private double salaryManager = 25000;
   private double salaryOperator = 20000;
   private double salaryTopManager = 30000;

   private List<Employer> listEmployers = new LinkedList<>();

   public Company() {

       income = Math.random() * (140000 - 115000) + 115000;
       employerSalary = income * 0.6;
   }

   public Company(List<Employer> listEmployers,double income,double salaryManager,double salaryOperator,double salaryTopManager) {

       employerSalary = income * 0.6;
       if (AvailableNumberOfWorkers.checkForTheAmountOfWages(listEmployers,employerSalary)){
           this.income = income;
           this.listEmployers = listEmployers;
       }
       this.salaryManager = salaryManager;
       this.salaryOperator = salaryOperator;
       this.salaryTopManager = salaryTopManager;
   }

   public boolean hire(Employer employer) {

       double bonus;

       if(employerSalary >= 30000) {

           switch (employer.position) {

               case EMPLOYER_MANAGER:{
                   bonus = income * 0.05;
                   employer.setBonus(bonus);
                   employerSalary -= salaryManager - bonus;
               }
               case EMPLOYER_OPERATOR: {
                   employerSalary -= salaryOperator;
               }
               case EMPLOYER_TOPMANAGER: {
                   if (income > 10000000) {
                       bonus = salaryTopManager + employer.getMonthSalary() * 1.5;
                       employer.setBonus(bonus);
                       employerSalary -= salaryTopManager - bonus;
                   }
               }
           }
           listEmployers.add(employer);
           return true;
       }
       return false;
   }

   public boolean hireAll() {

       Manager manager = new Manager(salaryManager);
       Operator operator = new Operator(salaryOperator);
       TopManager topManager = new TopManager(salaryTopManager);

        employerSalary-=manager.getMonthSalary()-operator.getMonthSalary()-topManager.getMonthSalary();

        if (employerSalary >= 0)
        {
            double bonusManager = income * 0.05,bonusTopManager = salaryTopManager + topManager.getMonthSalary() * 0.5;

            manager.setBonus(bonusManager);
            topManager.setBonus(bonusTopManager);

            List<Employer> allEmployers = Arrays.asList(manager,operator,topManager);
            listEmployers.addAll(allEmployers);

            return true;
        }
       return false;
   }

   List<Employer> getTopSalaryStaff(int start,int count) {
       if(listEmployers.size() >= count && count >= 0) {
           Collections.sort(listEmployers);
           List<Employer> sortedEmployersTop = listEmployers.subList(start,count);
           return sortedEmployersTop;
       }
       return null;
   }

   List<Employer> getLowestSalaryStaff(int start,int count){
      if(listEmployers.size() >= count && count >= 0) {
          Collections.sort(listEmployers,Collections.reverseOrder());
          List<Employer> sortedEmployersLow = listEmployers.subList(start,count);
          return sortedEmployersLow;
      }
      return  null;
   }

   public boolean fire(Employer employer){

      return listEmployers.remove(employer);
   }

   public double getSalaryManager() {
       return salaryManager;
   }

   public double getSalaryOperator() {
       return salaryOperator;
   }

   public double getSalaryTopManager() {
       return salaryTopManager;
   }

   public void setSalaryManager(double salaryManager) {
       this.salaryManager = salaryManager;
   }

   public void setSalaryOperator(double salaryOperator) {
       this.salaryOperator = salaryOperator;
   }

   public void setSalaryTopManager(double salaryTopManager) {
       this.salaryTopManager = salaryTopManager;
   }

   public double getIncome(){
      return  income;
   }
}
