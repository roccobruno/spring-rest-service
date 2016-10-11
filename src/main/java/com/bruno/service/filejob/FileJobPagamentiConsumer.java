package com.bruno.service.filejob;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import com.bruno.utils.FormatUtility;

@Component
public class FileJobPagamentiConsumer {

	private static final Logger log = LoggerFactory.getLogger(FileJobPagamentiConsumer.class);
       
    private boolean init = false;

    @Value("${mopWs.cartella.files.pagamenti}")
    private String fileLocation;

    @Autowired
    private FileJobMessageComponents components;

    @Autowired
    private FileResourceUtil fileResourceUtil;


    @Autowired
    private IPagamentoService pagamentoService;
    
    @Autowired
    private Filter filter;

    private void consumeMessage(final FileJobMessage message) throws InterruptedException {
    	
        components.getExecutor().submit(new Runnable() {
        	
            @Override
            public void run() {
                log.info("receiving message " + message);
                
                List<PagamentiBo> pagamenti = null;
                String header = null;
                List<String> fileContent = new ArrayList<String>();

				try {
					pagamenti = pagamentoService.getPagamentiList(filter,"");
					header = pagamenti.get(0).getCsvFileHeader();
					
					for (int i = 0; i < pagamenti.size(); i++) {
	                    fileContent.add(pagamenti.get(i).toFileLine());
	                }

	                //scrivi file
//	                fileResourceUtil.createFile(fileContent, "PAGAMENTI-"+filter.getSoggetto()+"-"+new Date()+message.getFileJob().getId() + ".csv", fileLocation,header);
					fileResourceUtil.createFile(fileContent, "PAGAMENTI_"+filter.getSoggetto()+"_"+FormatUtility.formattaDataToString2("dd-MM-yyyy",new Date()) + ".csv", fileLocation,header);
	                //aggiornare il record di tipo FileJob , settare lo stato a 'fatto'
				} catch (InternalServerErrorException e) {
					log.error(e.getMessage());			
				} catch (ParseException e) {
					log.error(e.getMessage());	
				}               
                
            }
        });
    }

    public void startConsumer() {
        if (!init) {
            components.getExecutor().submit(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
//                            Thread.sleep(10000);//solo per testare
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
