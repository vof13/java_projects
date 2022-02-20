import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyingFileVisitor extends SimpleFileVisitor {
    private final Path source;
    private final Path target;

    public CopyingFileVisitor(Path source, Path target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Processing directory: " + dir);
        Path targetPath = target.resolve(source.relativize((Path) dir));
        if (!targetPath.toFile().exists()) {
            Files.createDirectory(targetPath);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Copying file " +  file);
        Path targetPath = target.resolve(source.relativize((Path) file));
        Files.copy((Path) file, targetPath, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }
}
