package com.bruno.service.filejob;

import com.bruno.service.ServiceType;

import java.util.Date;

public class FileJob {

    private final String id;
    private final ServiceType type;//dice il tipo di record , ex - pagamenti
    private final String config;// json contenente i filtri della query
    private final String status;// stato del job -- CREATED - INPROGESS - DONE
    private final String fileName;// nome del file da generare o generato
    private final String generatorName; // nome dell istanza che che sta lavorando
    private final Date created = new Date(); // quando il job e' stato creato
    private final Date lastUpdated; // quando lo stato del job e' stato aggiornato



    public FileJob(String id, ServiceType type, String config, String status, String fileName, String generatorName, Date lastUpdated) {
        this.id = id;
        this.type = type;
        this.config = config;
        this.status = status;
        this.fileName = fileName;
        this.generatorName = generatorName;
        this.lastUpdated = lastUpdated;
    }


    public String getId() {
        return id;
    }

    public String getConfig() {
        return config;
    }

    public String getFileName() {
        return fileName;
    }

    public Date getCreated() {
        return created;
    }

    public ServiceType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "FileJob{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", config='" + config + '\'' +
                ", status='" + status + '\'' +
                ", fileName='" + fileName + '\'' +
                ", generatorName='" + generatorName + '\'' +
                '}';
    }
}
