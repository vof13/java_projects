package javaMain;
import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "D:\\java_projects\\skillbox\\java_basics\\AdvancedOOPFeatures\\homework_1\\data\\staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
        sortBySalaryAndAlphabet(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff, (o1, o2) -> o1.getSalary().compareTo(o2.getSalary()));
        staff.sort(((o1, o2) -> {
            if (o1.getSalary().equals(o2.getSalary())) {
                return o1.getName().compareTo(o2.getName());
            }
            return 0;
        }));

        for (Employee s: staff  ) {
            System.out.println(s);
        }
    }
}