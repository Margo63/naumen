package org.example;

import java.nio.file.*;
import java.util.concurrent.*;

public class Task5 implements Task, TaskRunner {
    private String sourceDir = "src/source";
    private String targetDir = "src/target";
    private int size = 1;
    private ScheduledExecutorService exec;
    private ScheduledFuture<?> sync;
    private volatile boolean isRunning = false;

    public void run() {

        start();
        try{
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        stop();
    }
    private void sync(){
        if (!isRunning) return;

        Path sourceDirPath = Paths.get(sourceDir);
        Path targetDirPath = Paths.get(targetDir);
        FileSyncronizer fileSyncronizer = new FileSyncronizerImpl();
        fileSyncronizer.syncFiles(sourceDirPath, targetDirPath);
        fileSyncronizer.syncFiles(targetDirPath, sourceDirPath);
    }

    @Override
    public void start() {
        if (isRunning) return;
        isRunning = true;
        exec = Executors.newScheduledThreadPool(size);
        size++;
        sync = exec.scheduleWithFixedDelay(this::sync, 0, 10, TimeUnit.SECONDS);
        System.out.println("start");
    }

    @Override
    public void stop() {
        if (!isRunning) return;
        isRunning = false;
        sync.cancel(true);
        exec.shutdownNow();
        System.out.println("stop");
    }
}