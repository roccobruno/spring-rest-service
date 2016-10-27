package com.bruno.service.filejob;

import org.springframework.stereotype.Service;
import com.bruno.model.filter.Filter;
import com.bruno.model.bo.Pagamento;

import java.util.List;
import java.util.UUID;

@Service
public class FileJobService implements IFileJobService {

    @Override
    public List<FileJob> getJobsInProgress() {
        return null;
    }

    @Override
    public void saveJob(FileJob fileJob) {

    }

    @Override
    public void markJobAsDone(String jobId) {

    }

    public FileJob creteJob(Filter pagamentiFiltri) {
        //save into db if not already existing
       return new FileJob(UUID.randomUUID().toString(),Pagamento.class.toString(),pagamentiFiltri.toJson(), "in-progress");
    }

    public FileJob getById(String id) {
        //leggi dal db il record
        return new FileJob(id,Pagamento.class.toString(),"", "in-progress");

    }
}
