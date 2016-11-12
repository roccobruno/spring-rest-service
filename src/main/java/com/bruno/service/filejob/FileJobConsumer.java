package com.bruno.service.filejob;

import java.util.ArrayList;
import java.util.List;

import com.bruno.model.RecordBO;
import com.bruno.service.IDBServiceContainer;
import com.bruno.service.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.filter.Filter;
import com.bruno.utils.FileResourceUtil;

import javax.annotation.PostConstruct;

@Component
    public class FileJobConsumer {

	private static final Logger log = LoggerFactory.getLogger(FileJobConsumer.class);
       
    @Value("${mopWs.numRecordsForPage}")
    private Integer numeroDiRecord;

    @Autowired
    IDBServiceContainer idbServiceContainer;

    @Autowired
    private FileJobMessageComponents components;

    @Autowired
    private FileResourceUtil fileResourceUtil;



    

    private void consumeMessage(final FileJobMessage message) throws InterruptedException {
    	
        components.getExecutor().submit(new Runnable() {
        	
            @Override
            public void run() {
                log.info("receiving message " + message);
                
                List<RecordBO> recordBOs = null;
                String header = null;

                    Filter filterFromMessage = Filter.getFilterFromJob(message.getFileJob());
                    IService service = idbServiceContainer.getService(message.getFileJob().getType());

				try {
                    long totalNumberOfRecords = service.countRecords(filterFromMessage);
                    int totalNumberOfPages = getTotalNumberOfPages(totalNumberOfRecords, numeroDiRecord);

                    log.info("Writing totalNumbeOfPages "+totalNumberOfPages);
                    for (int i = 0; i < totalNumberOfPages; i++) {
                        //scrivo una pagina alla volta
                        filterFromMessage.setNumPagina(i);

                        recordBOs = service.getRecords(filterFromMessage,"");

                        List<String> fileContent = createFileContent(recordBOs);

                        fileResourceUtil.createOAggiornaFile(fileContent,
                                message.getFileJob().getFileName(),
                                service.getFilesFolderLocation(), service.getCsvFileHeader());


                    }

	                //TODO aggiornare il record di tipo FileJob , settare lo stato a 'DONE'
				} catch (InternalServerErrorException e) {
					log.info("Error in writing file er: "+e.getMessage());
				}               
            }


        });
    }

    private List<String> createFileContent(List<RecordBO> records) {

        List<String> fileContent = new ArrayList<String>();
        for (RecordBO record : records) {
            fileContent.add(record.toFileLine());
        }
        return fileContent;
    }

    private int getTotalNumberOfPages(long totalNumerOfRecords, int numOfRecordsPerPage) {
       return  (int) Math.ceil (totalNumerOfRecords/numOfRecordsPerPage);
    }



    @PostConstruct
    public void startConsumer() {
            components.getExecutor().submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            consumeMessage(components.getFileJobMessageBlockingDeque().take());
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}
