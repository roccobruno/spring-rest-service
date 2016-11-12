package com.bruno.service.filejob;

import com.bruno.model.filter.Filter;
import com.bruno.service.ServiceType;

import java.util.List;

public interface IFileJobService {

    List<FileJob> getJobsInProgress();
    void saveJob(FileJob fileJob);
    void markJobAsDone(String jobId);
    FileJob createJob(ServiceType type, Filter pagamentiFiltri);
    FileJob getById(String id);

}
