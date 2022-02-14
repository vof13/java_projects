import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки:");
        String path = scanner.nextLine();
        System.out.println("Размер папки " + path + " составляет "
                + makeReadebleFormat(FileUtils.calculateFolderSize(path)));


//        "C:\\Program Files\\Git";


    }

    private static String makeReadebleFormat(long sizeInBytes) {
        DecimalFormat formattedDouble = new DecimalFormat("#0.0");
        if (sizeInBytes <= 1024) {
            return sizeInBytes + " Б";
        } else if (sizeInBytes <= 1024 * 1024) {
            return formattedDouble.format((double) sizeInBytes / 1024) + " Кб";
        } else if (sizeInBytes <= 1024 * 1024 * 1024) {
            return formattedDouble.format((double) sizeInBytes / (1024 * 1024)) + " Мб";
        } else if (sizeInBytes <= (1024L * 1024 * 1024 * 1024)) {
            return formattedDouble.format((double) sizeInBytes / (1024 * 1024 * 1024)) + " Гб";
        } else {
            return formattedDouble.format ((double) sizeInBytes / (1024L * 1024 * 1024 * 1024)) + " Тб";
        }

    }
}
