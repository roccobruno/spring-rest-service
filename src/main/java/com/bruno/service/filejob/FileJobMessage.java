package com.bruno.service.filejob;

import java.util.Date;

/**
 * Created by roccobruno on 31/07/2016.
 */
public class FileJobMessage {

    private final FileJob fileJob;
    private final Date created;


    public FileJobMessage(FileJob fileJob) {
        this.fileJob = fileJob;
        created = new Date();
    }


    public Date getCreated() {
        return created;
    }

    public FileJob getFileJob() {
        return fileJob;
    }

    @Override
    public String toString() {
        return "FileJobMessage{" +
                "fileJob=" + fileJob +
                ", created=" + created +
                '}';
    }
}

