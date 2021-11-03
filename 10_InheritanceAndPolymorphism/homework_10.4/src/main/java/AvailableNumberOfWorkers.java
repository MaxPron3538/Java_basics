import java.util.List;

public class AvailableNumberOfWorkers
{
    public static boolean checkForTheAmountOfWages(List<Employer> listEmployers,double employerSalary)
    {
        for(Employer employer : listEmployers) {
            employerSalary-=employer.salary;
        }
        if(employerSalary >=0) {
           return true;
        }
        return false;
    }
}
