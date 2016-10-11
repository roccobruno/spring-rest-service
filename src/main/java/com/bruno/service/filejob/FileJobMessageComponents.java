package com.bruno.service.filejob;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

@Component
public class FileJobMessageComponents {

    private final BlockingDeque<FileJobMessage> fileJobMessageBlockingDeque;
    private final ExecutorService executor;

    public FileJobMessageComponents(@Value("${mopWs.number.thread}")
                                    Integer numOfThread) {
        this.executor = Executors.newFixedThreadPool(numOfThread);
        this.fileJobMessageBlockingDeque = new LinkedBlockingDeque<FileJobMessage>();
    }

    public BlockingDeque<FileJobMessage> getFileJobMessageBlockingDeque() {
        return fileJobMessageBlockingDeque;
    }

    public ExecutorService getExecutor() {
        return executor;
    }
}
