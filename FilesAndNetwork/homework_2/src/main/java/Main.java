import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите исходный адрес копирования: ");
        String sourceDirectory = scanner.nextLine().trim();
        System.out.println("Введите адрес назначения: ");
        String destinationDirectory = scanner.nextLine().trim();

        FileUtils.copyFolder(sourceDirectory, destinationDirectory);
    }
}
