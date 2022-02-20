import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите исходный адрес копирования: ");
//        String sourceDirectory = scanner.nextLine().trim();
//        System.out.println("Введите адрес назначения: ");
//        String destinationDirectory = scanner.nextLine().trim();
//
//        FileUtils.copyFolder(sourceDirectory, destinationDirectory);

        Path source = Paths.get("D:\\Драйв-М\\Я Такси\\КАДРЫ");
        Path target = Paths.get("D:\\NDA");
        Files.walkFileTree(source, new CopyingFileVisitor(source, target));
    }
}
