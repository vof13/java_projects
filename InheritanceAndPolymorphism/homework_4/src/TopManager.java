package src;

public class TopManager implements Employee{
    private int salary = 50000;
    private Company company;

    public TopManager (Company company){
        this.company = company;

    }

    @Override
    public int getMonthSalary() {
        int income = company.getIncome();
        if (income > 1_000_000) {
            return (int) (salary*1.5);
        }
        return salary;

    }
}
