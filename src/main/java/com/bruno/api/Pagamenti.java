package com.bruno.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.io.IOException;
import java.net.HttpURLConnection;
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
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.filter.FilePagamentiFiltri;
import com.bruno.model.response.RisultatiRicerca;
import com.bruno.model.response.RisultatoPagamenti;
import com.bruno.service.IPagamentoService;
import com.bruno.service.filejob.FileJob;
import com.bruno.service.filejob.FileJobMessage;
import com.bruno.service.filejob.FileJobPagamentiConsumer;
import com.bruno.service.filejob.FileJobProducer;
import com.bruno.service.filejob.FileJobService;
import com.bruno.utils.FileResourceUtil;
import com.bruno.utils.IDescRequestParam;
import com.bruno.utils.MessageJson;
import com.bruno.utils.UtilityClass;

@RestController
@RequestMapping("/api/v1.0")
public class Pagamenti implements IDescRequestParam{

    private static final Logger log = LoggerFactory.getLogger(Pagamenti.class);

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
    
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Restituisce un oggetto json composto da un campo 'totalRecords' che contiene il numero totale di record trovati, un campo 'results' che contiene una lista di oggetti di tipo 'Pagamenti', ed un oggetto di tipo 'paging', che contiene i links alle pagine precedente e successiva contenente i risultati! ",response = RisultatoPagamenti.class),
            @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Unauthorized",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems",response = MessageJson.class)
    })
    @ApiOperation(value = "Pagamenti", notes = "La seguente api consente lo scarico dei dati dei pagamenti!")
    @RequestMapping(value = "/pagamenti", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Object getPagamenti(HttpServletResponse response, HttpServletRequest request,
    											@ApiIgnore @RequestParam Map<String, String> allRequestParams,
    											@ApiParam(value = CUP)
    											@RequestParam(value = "cup", required = false) String cup,
    											@ApiParam(value = CIG)
    											@RequestParam(value = "cig", required = false) String cig,   											
    											@ApiParam(value = SETTORE)
    											@RequestParam(value = "settore", required = false) String settore,
    											@ApiParam(value = SOTTOSETTORE)
    											@RequestParam(value = "sottoSettore", required = false) String sottoSettore,
    											@ApiParam(value = CATEGORIA)
    											@RequestParam(value = "categoria", required = false) String categoria,
    											@ApiParam(value = REGIONE)
    											@RequestParam(value = "regione", required = false) String regione,
    											@ApiParam(value = FONTECODLOCALEPROG)
    											@RequestParam(value = "fonteCodLocaleProg", required = false) String fonteCodLocaleProg,
    											@ApiParam(value = DIMENSIONE)
    											@RequestParam(value = "dimensione", required = false) String dimensione,
    											@ApiParam(value = TIPOLOGIALAVORI)
    											@RequestParam(value = "tipologiaLavori", required = false) String tipologiaLavori,
    											@ApiParam(value = NUMRECORDS)
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

    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Restituisce un oggetto json composto da un campo 'totalRecords' che contiene il numero totale di record trovati, un campo 'results' che contiene un oggetto di tipo 'Pagamenti', ed un oggetto di tipo 'paging', che contiene i links alle pagine precedente e successiva contenente i risultati! ",response = RisultatoPagamenti.class),
            @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Unauthorized",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems",response = MessageJson.class)
    })
    @ApiOperation(value = "Pagamenti", notes = "La seguente api consente lo scarico dei dati del pagamento cha ha come chiave l'id passato come parametro!")
    @ApiIgnore
    @RequestMapping(value = "/pagamenti/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Object getPagamento(@ApiParam(value = ID) @PathVariable("id") String id,HttpServletResponse response,	HttpServletRequest request) {

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
