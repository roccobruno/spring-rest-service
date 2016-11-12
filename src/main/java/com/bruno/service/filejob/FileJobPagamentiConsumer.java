package com.bruno.service.filejob;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.filter.Filter;
import com.bruno.service.IPagamentoService;
import com.bruno.utils.FileResourceUtil;

import javax.annotation.PostConstruct;

@Component
public class FileJobPagamentiConsumer {

	private static final Logger log = LoggerFactory.getLogger(FileJobPagamentiConsumer.class);
       
    private boolean init = false;

    @Value("${mopWs.cartella.files.pagamenti}")
    private String fileLocation;

    @Value("${mopWs.numRecordsForPage}")
    private Integer numeroDiRecord;


    public Integer getNumeroDiRecord() {
        return numeroDiRecord;
    }

    public void setNumeroDiRecord(Integer numeroDiRecord) {
        this.numeroDiRecord = numeroDiRecord;
    }

    @Autowired
    private FileJobMessageComponents components;

    @Autowired
    private FileResourceUtil fileResourceUtil;


    @Autowired
    private IPagamentoService pagamentoService;
    

    private void consumeMessage(final FileJobMessage message) throws InterruptedException {
    	
        components.getExecutor().submit(new Runnable() {
        	
            @Override
            public void run() {
                log.info("receiving message " + message);
                
                List<PagamentiBo> pagamenti = null;
                String header = null;

                    Filter filterFromMessage = Filter.getFilterFromJob(message.getFileJob());

				try {


                    long totalNumberOfRecords = pagamentoService.countRecords(filterFromMessage);
                    int totalNumberOfPages = getTotalNumberOfPages(totalNumberOfRecords,numeroDiRecord);

                    log.info("Writing totalNumbeOfPages "+totalNumberOfPages);
                    for (int i = 0; i < totalNumberOfPages; i++) {
                        //scrivo una pagina alla volta
                        filterFromMessage.setNumPagina(i);
                        pagamenti = pagamentoService.getPagamentiListMock(filterFromMessage,"");//TODO cambia metodo , usa quello reale che legge dal DB
                        List<String> fileContent = createFileContent(pagamenti);
                        fileResourceUtil.createOAggiornaFile(fileContent,
                                "PAGAMENTI_"+filterFromMessage.getSoggetto()+ ".csv",
                                fileLocation,PagamentiBo.getCsvFileHeader());


                    }

	                //TODO aggiornare il record di tipo FileJob , settare lo stato a 'fatto'
				} catch (InternalServerErrorException e) {
					log.info("Error in writing file er: "+e.getMessage());
				}               
            }


        });
    }

    private List<String> createFileContent(List<PagamentiBo> pagamenti) {

        List<String> fileContent = new ArrayList<String>();
        for (PagamentiBo pagamentiBo : pagamenti) {
            fileContent.add(pagamentiBo.toFileLine());
        }
        return fileContent;
    }

    private int getTotalNumberOfPages(long totalNumerOfRecords, int numOfRecordsPerPage) {
       return  (int) Math.ceil (totalNumerOfRecords/numOfRecordsPerPage);
    }



    @PostConstruct
    public void startConsumer() {
        if (!init) {
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
            init = true;
        }
    }
}
