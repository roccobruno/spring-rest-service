package com.bruno.service.filejob;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileJobProducer {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileJobProducer.class);

    @Autowired
    private FileJobMessageComponents components;

    public void sendMessage(final FileJobMessage message) {

        components.getExecutor().submit(new Runnable() {
            @Override
            public void run() {

                logger.info("submitting message "+message);
                components.getFileJobMessageBlockingDeque().push(message);
            }
        });

    }



}
