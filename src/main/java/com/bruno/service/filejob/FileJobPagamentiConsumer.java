package com.bruno.service.filejob;

import com.bruno.exception.EmptyListResorceException;
import com.bruno.model.bo.Filter;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.bo.Pagamento;
import com.bruno.service.IPagamentoService;
import com.bruno.utils.FileResourceUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileJobPagamentiConsumer {

    private static final org.slf4j.Logger logger = LoggerFactory
            .getLogger(FileJobPagamentiConsumer.class);
    private boolean init = false;

    @Value("${cartella.files.pagamenti}")
    private String fileLocation;

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
                logger.info("receiving message " + message);
                //fai la query in base a cio' che e' contenuto nel message
                //leggi i record a gruppi di 1000 or 10000
                List<PagamentiBo> pagamenti = null;
				try {
					pagamenti = pagamentoService.getPagamentiList(new Filter());
				} catch (EmptyListResorceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                List<String> fileContent = new ArrayList<String>();
                for (int i = 0; i < pagamenti.size(); i++) {
                    fileContent.add(pagamenti.get(i).toFileLine());
                }

                //scrivi file
                fileResourceUtil.createFile(fileContent, "PAGAMENTI-" + message.getFileJob().getId() + ".csv", fileLocation);

                //aggiorna il record di tipo FileJob , setta lo stato a 'fatto'
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
