package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();


        // найм сотрудников
        for (int i = 0 ; i < 10; i++) {
            company.hire(new Operator());
        }
        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            workers.add(new Manager());
            if (i%2 == 0) {
                workers.add(new TopManager(company));
            }
        }
        company.hireAll(workers);

        printEmployees(company);

        //удаление 50% сотрудников
        List<Employee> employees = company.getEmployees();
        for (int i = 0; i < employees.size()/2; i++) {
                company.fire(employees.get(i));
        }

        System.out.println("Доход компании: " + company.getIncome());
        System.out.println("Количество сотрудников после увольнения: " + company.getEmployees().size());

        printEmployees(company);

    }


    private static void printEmployees (Company company) {
        System.out.println("20% самых высоких зарплат: ");
        List<Employee> TopSalaryStaff =  company.getTopSalaryStaff((int) ((company.getEmployees().size())*0.2));
        for (Employee e: TopSalaryStaff ) {
                System.out.println(e.getMonthSalary());
            }

        System.out.println("10% самых низких зарплат: ");
        List<Employee> LowSalaryStaff =  company.getLowestSalaryStaff((int) ((company.getEmployees().size())*0.1));
        for (Employee e: LowSalaryStaff
        ) {
            System.out.println(e.getMonthSalary());
        }
    }
}
