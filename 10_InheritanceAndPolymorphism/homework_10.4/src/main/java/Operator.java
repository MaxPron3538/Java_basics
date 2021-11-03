
public class Operator extends Employer
{
    Company company = new Company();

    Operator(double salaryRate) {

        if(salaryRate >= 0){
            position = positionEmployer.EMPLOYER_OPERATOR;
            salary+=salaryRate;
        }
    }

    @Override
    public double getMonthSalary(){
        return salary;
    }
}
