package javaMain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javaMain.Employee;
import javaMain.Main;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DisplayName("Сортировка по заработной плате и алфавиту")
public class TestSortBySalaryAndAlphabet {

    @Test
    @DisplayName("Входные данные - staff.txt")
    void sort() {
        List<Employee> actualStaff = Employee.loadStaffFromFile("D:\\java_projects\\skillbox\\java_basics\\AdvancedOOPFeatures\\homework_1\\data\\staff.txt");
        List<Employee> expectedStaff = Employee.loadStaffFromFile("D:\\java_projects\\skillbox\\java_basics\\AdvancedOOPFeatures\\homework_1\\data\\sortedStaff.txt");
        Main.sortBySalaryAndAlphabet(actualStaff);
        assertIterableEquals(expectedStaff, actualStaff, "сортировка выполнена не по условию");
    }

}
