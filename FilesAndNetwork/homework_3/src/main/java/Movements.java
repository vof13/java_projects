import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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

    private String getNameOrganization (Transactions transaction) {
        String operationInfo =  transaction.getOperationInfo();
        int beginIndex = operationInfo.indexOf('/')+1;
        if (beginIndex == 0) {
            beginIndex = operationInfo.indexOf('\\')+1;
        }
        int endIndex = operationInfo.indexOf("  ", beginIndex);
       return operationInfo.substring(beginIndex, endIndex);
    }

    public void IncomeSharing() {
        Map<String, Double> incomeSharing;

        incomeSharing = transactionsList.stream()
                .collect(Collectors.toMap(
                        this::getNameOrganization,
                        Transactions::getIncomeAndExpense,
                        Double::sum));

        for (Map.Entry entry : incomeSharing.entrySet()
        ) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }

    }

    public void ExpenseSharing() {
        Map<String, Double> expenseSharingMap = new HashMap<>();
        for (Transactions transaction : transactionsList
        ) {
            String nameOrganization = getNameOrganization(transaction);
            double expense = transaction.getIncomeAndExpense();

            if (expenseSharingMap.containsKey(nameOrganization) && expense < 0) {
                double value = expenseSharingMap.get(nameOrganization) + (-expense);
                expenseSharingMap.put(nameOrganization, value);
            } else if (expense < 0) {
                expenseSharingMap.put(nameOrganization, -expense);
            }
        }

        for (Map.Entry entry : expenseSharingMap.entrySet()
        ) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }


}