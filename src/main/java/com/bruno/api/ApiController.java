package com.bruno.api;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bruno.db.manager.IManagerDb;
import com.bruno.exception.GestioneException;
import com.bruno.model.FilePagamentiFiltri;
import com.bruno.model.wrapper.WrapperToJson;
import com.bruno.service.PagamentoRisultatiRicerca;
import com.bruno.service.PagamentoService;
import com.bruno.service.filejob.FileJob;
import com.bruno.service.filejob.FileJobMessage;
import com.bruno.service.filejob.FileJobPagamentiConsumer;
import com.bruno.service.filejob.FileJobProducer;
import com.bruno.service.filejob.FileJobService;
import com.bruno.utils.FileResourceUtil;

@Controller
@RequestMapping("/api/v1.0")
public class ApiController {
	
	private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private PagamentoService pagamentoService;

    @Value("${cartella.files.pagamenti}")
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
    private WrapperToJson wrapperToJson;
    
    @Autowired
    private IManagerDb managerDb;
    
    @Autowired
    GestioneException gestioneException;


//    @RequestMapping(method = RequestMethod.GET)
//    public @ResponseBody
//    List<Pagamento> getPagamenti() {
//       return  pagamentoService.getPagamento();
//    }
    
//    @RequestMapping(method = RequestMethod.GET)
//    public @ResponseBody List<PagamentoJson> getPagamenti() {
//    	
//    	List<SwPagamenti> pagamentiList = null;
//    	List<PagamentoJson> pagamentiJsonList = null;
//    	
//    	try{
//    		pagamentiList = managerDb.getPagamenti();        	
//        	pagamentiJsonList = wrapperToJson.pagamenti(pagamentiList);
//    	}catch(Exception e){
//    		gestioneException.gestisciException(e);
//    	}    	
//    	return pagamentiJsonList;
//    }
    
    @RequestMapping(value = "/{resourse}" ,method = RequestMethod.GET)
    public @ResponseBody Object getPagamenti(@PathVariable("resourse") String resourse) {
    	
    	Object risorsaList = null;
    	
    	try{
    		risorsaList = managerDb.getRisorsaList(resourse);       	
    	}catch(Exception e){
    		gestioneException.gestisciException(e);
    	}    	
    	return risorsaList;
    }

    @RequestMapping(value = "/search" ,method = RequestMethod.GET)
    public @ResponseBody
    PagamentoRisultatiRicerca cercaPagamenti(@RequestParam(value = "cig", required = false) String cig,
                                             @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                             @RequestParam(value = "pageNumber", required = true) Integer pageNumber) {
        System.out.print("cig -"+cig);
        return  pagamentoService.cercaPagamenti(cig,pageSize,pageNumber);
    }


    @RequestMapping(value = "/file/job/{id}" ,method = RequestMethod.GET)
    public @ResponseBody
    FileJob getFileJob(@PathVariable("id") String fileId) {
        return  fileJobService.getById(fileId);
    }

    @RequestMapping(value = "/file/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<byte[]>
     getFile(HttpServletResponse resp, @PathVariable("id") String fileId) throws IOException {

        String directoryurl = fileLocation
                + "/";
        this.fileResourceUtil.download(
                "PAGAMENTI-"+fileId+".csv", resp, directoryurl);

        return  null;
    }



    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public @ResponseBody
    FileJob generateFile(@RequestBody FilePagamentiFiltri paramsRicercaPagamenti) {

        FileJob fileJob = fileJobService.creteJob(paramsRicercaPagamenti);
        FileJobMessage message = new FileJobMessage(fileJob);

        consumer.startConsumer();
        producer.sendMessage(message);

        return fileJob;
    }





}