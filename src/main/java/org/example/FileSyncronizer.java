package org.example;

import java.nio.file.Path;

public interface FileSyncronizer {
    void syncFiles(Path source, Path target);
}
