
public class Manager extends Employer
{
    Company company = new Company();

    Manager(double salaryRate)
    {
       if(salaryRate >= 0){
           position = positionEmployer.EMPLOYER_MANAGER;
           salary += salaryRate;
       }
    }

    @Override
    public void setBonus(double bonus){
       if(bonus >= 0) {
           salary += bonus;
       }
    }

    @Override
    public double getMonthSalary(){
        return salary;
    }
}
