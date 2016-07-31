package com.bruno.service.filejob;

import com.bruno.model.Pagamento;
import com.bruno.service.PagamentoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by roccobruno on 31/07/2016.
 */
@Component
public class FileJobPagamentiConsumer {

    private static final org.slf4j.Logger logger = LoggerFactory
            .getLogger(FileJobPagamentiConsumer.class);
    private boolean init = false;

    @Autowired
    private FileJobMessageComponents components;


    @Autowired
    private PagamentoService pagamentoService;

    private void consumeMessage(FileJobMessage message) {
        logger.info("receiving message " + message);
        //create file

        //fai la query in base a cio' che e' contenuto nel message
        //leggi i record a gruppi di 1000 or 10000
        List<Pagamento>  pagamenti = pagamentoService.getPagamento();

        //scrivi file

        //aggiorna il record di tipo FileJob , setta lo stato a 'fatto'

    }

    public void startConsumer() {
        if (!init) {
            components.getExecutor().submit(new Runnable() {
                @Override
                public void run() {

                    try {
                        while (true) {
                            Thread.sleep(10000);//solo per testare
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