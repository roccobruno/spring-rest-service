package com.bruno.service.filejob;

import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by roccobruno on 31/07/2016.
 */
@Component
public class FileJobMessageComponents {

    private final BlockingDeque<FileJobMessage> fileJobMessageBlockingDeque;
    private final ExecutorService executor;

    public FileJobMessageComponents() {
        this.executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());;
        this.fileJobMessageBlockingDeque = new LinkedBlockingDeque<FileJobMessage>();
    }

    public BlockingDeque<FileJobMessage> getFileJobMessageBlockingDeque() {
        return fileJobMessageBlockingDeque;
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
