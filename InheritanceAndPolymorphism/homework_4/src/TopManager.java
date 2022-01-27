package src;

public class TopManager implements Employee{
    private int salary = 50000;

    public TopManager (){

    }

    @Override
    public int getMonthSalary() {
        int income = new Company().getIncome();
        if (income > 10000000) {
            return (int) (salary*1.5);
        }
        return salary;

    }
}
