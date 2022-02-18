import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Movements {
    private static List<Transactions> transactionsList;

    public Movements(String pathMovementsCsv) {
        transactionsList = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Path.of(pathMovementsCsv));
            for (int i = 1; i < lines.size(); i++) {
                String[] components = lines.get(i).split(",", 7);
                transactionsList.add(new Transactions(
                        components[0],
                        components[1],
                        components[2],
                        (LocalDate.parse(components[3], DateTimeFormatter.ofPattern("dd.MM.yy"))),
                        components[4],
                        components[5],
                        components[6]
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getExpenseSum() {
        double result = transactionsList.stream()
                .mapToDouble(Transactions::getIncomeAndExpense)
                .filter(expense -> expense <= 0).sum();
        return -result;

    }
    public double getIncomeSum() {
        return transactionsList.stream()
                .mapToDouble(Transactions::getIncomeAndExpense)
                .filter(income -> income > 0).sum();
    }


}