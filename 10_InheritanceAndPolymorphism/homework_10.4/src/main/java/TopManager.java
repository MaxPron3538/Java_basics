
public class TopManager extends Employer {

    Company company = new Company();

    TopManager(double salaryRate)
    {
        if(salaryRate >= 0) {
            position = positionEmployer.EMPLOYER_TOPMANAGER;
            salary += salaryRate;
        }
    }

    @Override
    public void setBonus(double bonus) {
        if(bonus >= 0)
        salary+=bonus;
    }

    @Override
    public double getMonthSalary() {
        return salary;
    }
}
