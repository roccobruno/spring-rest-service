package com.bruno.service.filejob;

import com.bruno.model.filter.Filter;
import com.bruno.utils.FileResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.transform.sax.SAXSource;
import java.util.List;

@Component
public class FileJobReprocessor {

    @Autowired
    private IFileJobService fileJobService;

    @Autowired
    private FileJobProducer producer;

    @Autowired
    private FileResourceUtil fileResourceUtil;

    public void processUnFinishedJobs() {

        List<FileJob> jobsInProgress = fileJobService.getJobsInProgress();
        for (FileJob jobInProgress : jobsInProgress) {
            String fileName = "PAGAMENTI_"+ Filter.getFilterFromJob(jobInProgress).getSoggetto()+ ".csv";
            //delete existing file
            fileResourceUtil.deleteFile(fileName);
            FileJobMessage message = new FileJobMessage(jobInProgress);
            producer.sendMessage(message);
        }

        System.out.println("JOBS processati n="+jobsInProgress.size());
    }
}
