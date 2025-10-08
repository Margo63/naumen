package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileSyncronizerImpl implements FileSyncronizer {

    @Override
    public void syncFiles(Path sourceDirPath, Path targetDirPath) {

        try {
            Files.walkFileTree(sourceDirPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path sourceFile, BasicFileAttributes attrs) throws IOException {
                    Path relative = sourceDirPath.relativize(sourceFile);
                    Path targetFile = targetDirPath.resolve(relative);
                    if (!Files.exists(targetFile) ||
                            Files.getLastModifiedTime(sourceFile).compareTo(Files.getLastModifiedTime(targetFile)) > 0) {
                        Files.createDirectories(targetFile.getParent());
                        Files.copy(sourceFile, targetFile, StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("current file: " + relative);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
