package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();


        // найм 250 сотрудников
        for (int i = 0 ; i < 180; i++) {
            company.hire(new Operator());
        }
        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            workers.add(new Manager());
            if (i%8 == 0) {
                workers.add(new TopManager());
            }
        }
        company.hireAll(workers);

        printEmployees(company);

        //удаление 50% сотрудников
        List<Employee> employees = company.getEmployees();
        for (int i = 0; i < employees.size()/2; i++) {
                company.fire(employees.get(i));
        }
        System.out.println("Количество сотрудников после увольнения: " + company.getEmployees().size());

        printEmployees(company);

    }


    private static void printEmployees (Company company) {
        //15 самых высоких зарплаты
        List<Employee> TopSalaryStaff =  company.getTopSalaryStaff(15);
        for (Employee e: TopSalaryStaff ) {
                System.out.println(e.getMonthSalary());
            }

        //10 самых низких зарплат
        List<Employee> LowSalaryStaff =  company.getLowestSalaryStaff(10);
        for (Employee e: LowSalaryStaff
        ) {
            System.out.println(e.getMonthSalary());
        }
    }
}
