package com.bruno.service.filejob;

import com.bruno.service.ServiceType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.bruno.model.filter.Filter;
import com.bruno.model.bo.Pagamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FileJobService implements IFileJobService {

    @Override
    public List<FileJob> getJobsInProgress() {
        return new ArrayList<FileJob>();
    }

    @Override
    public void saveJob(FileJob fileJob) {

    }

    @Value("${mopWs-istanza-nome}")
    private String nameInstance;

    @Override
    public void markJobAsDone(String jobId) {

    }

    public FileJob createJob(ServiceType type, Filter pagamentiFiltri) {
        //save into db if not already existing
        String fileName = type+"_"+UUID.randomUUID().toString()+ ".csv";
        return new FileJob(UUID.randomUUID().toString(),type,pagamentiFiltri.toJson(), "in-progress", fileName, nameInstance, new Date());
    }

    public FileJob getById(String id) {
        //leggi dal db il record
        return new FileJob(id,ServiceType.PAGAMENTI
                ,"", "in-progress", "", "", new Date());

    }
}
