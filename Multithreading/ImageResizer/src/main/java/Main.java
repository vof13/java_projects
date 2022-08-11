import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class Main {
    private static final int newWidth = 300;


    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\User\\Desktop\\sourceFolder";
        String dstFolder = "C:\\Users\\User\\Desktop\\targetFolder";
        long start = System.currentTimeMillis();
        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();
        List<File[]> listFiles = getListFilesToThread(files);

        listFiles.stream()
                .map((e) -> new ImageResizer(e, newWidth, dstFolder, start))
                .forEach(Thread::start);
    }

    private static ArrayList<File[]> getListFilesToThread(File[] files) {
        int numberImage = files.length;
        ArrayList<File[]> listFiles = new ArrayList<>();
        int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество ядер: " + coreCount);
        int wholePart = numberImage / coreCount;
        int devisionPart = numberImage % coreCount;
        int indexStart = 0;
        for (int i = 1; i <= coreCount; i++) {
            if (devisionPart > 0) {
                File[] filesToThread = new File[wholePart + 1];
                System.arraycopy(files, indexStart, filesToThread, 0, filesToThread.length);
                listFiles.add(filesToThread);
                devisionPart--;
                indexStart += wholePart + 1;
            } else {
                File[] filesToThread = new File[numberImage - listFiles.size() * (wholePart + 1)];
                System.arraycopy(files, indexStart, filesToThread, 0, filesToThread.length);
                listFiles.add(filesToThread);
            }
        }
        return listFiles;
    }
}
// Один поток 3676ms
// Восемь ядер 1026-1467ms