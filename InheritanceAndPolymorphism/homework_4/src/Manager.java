package src;

public class Manager implements Employee{

    private int salary = 40000;
    private int sales;

    public Manager() {
        sales = (int) (Math.random() * (140000-115000) + 115000);
        salary += sales*0.05;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }


    public int getSales() {
        return sales;
    }
}
