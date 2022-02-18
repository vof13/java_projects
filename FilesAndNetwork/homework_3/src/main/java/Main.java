
public class Main {
    final static String PATH = "D:\\skilbox\\java_basics\\FilesAndNetwork\\files\\movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(PATH);
        System.out.println("Сумма расходов: " + movements.getExpenseSum() + " руб.");
        System.out.println("Сумма доходов: " + movements.getIncomeSum() + " руб.");

        System.out.println("Суммы расходов по организациям: ");
    }
}