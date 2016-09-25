package com.bruno.api;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import com.bruno.exception.GeneralException;
import com.bruno.exception.GestioneException;
import com.bruno.model.bo.FilePagamentiFiltri;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.bo.RisultatiRicerca;
import com.bruno.service.IPagamentoService;
import com.bruno.service.filejob.FileJob;
import com.bruno.service.filejob.FileJobMessage;
import com.bruno.service.filejob.FileJobPagamentiConsumer;
import com.bruno.service.filejob.FileJobProducer;
import com.bruno.service.filejob.FileJobService;
import com.bruno.utils.FileResourceUtil;
import com.bruno.utils.UtilityClass;

@RestController
@RequestMapping("/api/v1.0")
public class PagamentiController {

    private static final Logger log = LoggerFactory.getLogger(PagamentiController.class);

    @Value("${mopWs.cartella.files.pagamenti}")
    private String fileLocation;

    @Autowired
    private FileJobProducer producer;

    @Autowired
    private FileJobPagamentiConsumer consumer;

    @Autowired
    private FileResourceUtil fileResourceUtil;

    @Autowired
    private FileJobService fileJobService;

    @Autowired
    GestioneException gestioneException;

    @Autowired
    UtilityClass utilityClass;
    
    @Autowired
    IPagamentoService pagamentoService;
   
    @RequestMapping(value = "/pagamenti", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Object getPagamenti(HttpServletResponse response, HttpServletRequest request,
    											@ApiIgnore @RequestParam Map<String, String> allRequestParams,
    											@RequestParam(value = "cup", required = false) String cup,
    											@RequestParam(value = "cig", required = false) String cig,
    											@RequestParam(value = "soggetto", required = true) String soggetto,
    											@RequestParam(value = "formaGiuridica", required = false) String formaGiuridica,
    											@RequestParam(value = "settore", required = false) String settore,
    											@RequestParam(value = "sottoSettore", required = false) String sottoSettore,
    											@RequestParam(value = "categoria", required = false) String categoria,
    											@RequestParam(value = "fonteCodLocaleProg", required = false) String fonteCodLocaleProg,
    											@RequestParam(value = "dimensione", required = false) String dimensione,
    											@RequestParam(value = "tipologiaLavori", required = false) String tipologiaLavori,
    											@RequestParam(value = "numRecords", required = false) String numRecords) {
    	
    	RisultatiRicerca<PagamentiBo> pagamentiBo = null;
        
        try {        	
        	pagamentiBo = pagamentoService.getPagamenti(utilityClass.checkAndCreateFilter(allRequestParams),utilityClass.getBaseUrl(request));
        } catch (GeneralException e) {
            log.error(e.getMessage());
            return gestioneException.gestisciException(e, response);
        }
        return pagamentiBo;

    }

    @RequestMapping(value = "/pagamenti/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Object getPagamento(@PathVariable("id") String id,HttpServletResponse response,	HttpServletRequest request) {

    	RisultatiRicerca<PagamentiBo> pagamentiBo = null;

        try {
        	pagamentiBo = pagamentoService.getPagamento(id,utilityClass.getBaseUrl(request));
        } catch (GeneralException e) {
            log.error(e.getMessage());
            return gestioneException.gestisciException(e, response);
        }
        return pagamentiBo;
    }

    @ApiIgnore
    @RequestMapping(value = "/file/job/{id}", method = RequestMethod.GET)
    public @ResponseBody FileJob getFileJob(@PathVariable("id") String fileId) {
        return fileJobService.getById(fileId);
    }

    @ApiIgnore
    @RequestMapping(value = "/file/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(HttpServletResponse resp, @PathVariable("id") String fileId) throws IOException {

        String directoryurl = fileLocation
                + "/";
        this.fileResourceUtil.download(
                "PAGAMENTI-" + fileId + ".csv", resp, directoryurl);

        return null;
    }

    @ApiIgnore
    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public @ResponseBody FileJob generateFile(@RequestBody FilePagamentiFiltri paramsRicercaPagamenti) {

        FileJob fileJob = fileJobService.creteJob(paramsRicercaPagamenti);
        FileJobMessage message = new FileJobMessage(fileJob);

        consumer.startConsumer();
        producer.sendMessage(message);

        return fileJob;
    }


}
