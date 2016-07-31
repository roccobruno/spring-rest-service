package com.bruno.service.filejob;

/**
 * Created by roccobruno on 31/07/2016.
 */
public class FileJob {

    private final String id;
    private final String type;
    private final String config;
    private final String status;


    public FileJob(String id, String type, String config, String status) {
        this.id = id;
        this.type = type;
        this.config = config;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getConfig() {
        return config;
    }

    @Override
    public String toString() {
        return "FileJob{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", config='" + config + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
