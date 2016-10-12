package com.bruno.service.filejob;

import com.bruno.model.filter.Filter;

import java.util.List;

public interface IFileJobService {

    List<FileJob> getJobsInProgress();
    void saveJob(FileJob fileJob);
    void markJobAsDone(String jobId);
    FileJob creteJob(Filter pagamentiFiltri);
    FileJob getById(String id);

}
