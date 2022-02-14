import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long sizeInBytes = 0;
        try {
            File dir = new File(path);
            sizeInBytes = calculateSizeInBytes(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sizeInBytes;

    }

    private static Long calculateSizeInBytes(File dir) {
        if (dir.isFile()) {
            return dir.length();
        }

        long sum = 0;
        File[] files = dir.listFiles();
        for (File file : files
        ) {
            sum += calculateSizeInBytes(file);
        }
        return sum;
    }


}
