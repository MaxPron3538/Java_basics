
public abstract class Employer implements Employee,Comparable<Employer>
{
    @Override
    public double getMonthSalary() {
        return salary;
    }

    @Override
    public void setBonus(double bonus) {
    }

    public int compareTo(Employer employer){

        return Double.compare(salary,employer.salary);
    }
    positionEmployer position;
    protected double salary;
}
