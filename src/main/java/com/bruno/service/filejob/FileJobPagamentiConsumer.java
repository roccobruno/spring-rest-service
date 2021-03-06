package com.bruno.service.filejob;

import com.bruno.model.Pagamento;
import com.bruno.service.PagamentoService;
import com.bruno.utils.FileResourceUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roccobruno on 31/07/2016.
 */
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
    private PagamentoService pagamentoService;

    private void consumeMessage(final FileJobMessage message) throws InterruptedException {
        components.getExecutor().submit(new Runnable() {
            @Override
            public void run() {
                logger.info("receiving message " + message);
                //fai la query in base a cio' che e' contenuto nel message
                //leggi i record a gruppi di 1000 or 10000
                List<Pagamento> pagamenti = pagamentoService.getPagamento();
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
