package com.bruno.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;
import com.bruno.exception.BadRequestException;
import com.bruno.exception.ControllerException;
import com.bruno.exception.GestioneException;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.filter.Filter;
import com.bruno.model.response.RisultatiRicerca;
import com.bruno.model.response.RisultatoPagamenti;
import com.bruno.security.AuthenticationService;
import com.bruno.service.IPagamentoService;
import com.bruno.service.filejob.FileJob;
import com.bruno.service.filejob.FileJobMessage;
import com.bruno.service.filejob.FileJobPagamentiConsumer;
import com.bruno.service.filejob.FileJobProducer;
import com.bruno.service.filejob.FileJobService;
import com.bruno.utils.FileResourceUtil;
import com.bruno.utils.IDescRequestParam;
import com.bruno.utils.IUtilityClass;
import com.bruno.utils.MessageJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
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
    IUtilityClass utilityClass;
    
    @Autowired
    IPagamentoService pagamentoService;
    
    @Autowired
    AuthenticationService authenticationService;
    
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Restituisce un oggetto json composto da un campo 'totalRecords' che contiene il numero totale di record trovati, un campo 'results' che contiene una lista di oggetti di tipo 'Pagamenti', ed un oggetto di tipo 'paging', che contiene i links alle pagine precedente e successiva contenente i risultati! ",response = RisultatoPagamenti.class),
            @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Forbidden",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems",response = MessageJson.class)
    })
    @ApiOperation(value = "Lista di Record", notes = "La seguente api consente lo scarico dei dati dei pagamenti!")
    @RequestMapping(value = "/pagamenti", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object getPagamenti(HttpServletResponse response, HttpServletRequest request,
    											@ApiIgnore @RequestParam Map<String, String> allRequestParams,
    											@ApiParam(value = AUTHORIZATIONID)
    											@RequestHeader(value="authorization_id",required = false) String auth_id,
    											@ApiParam(value = CUP)
    											@RequestParam(value = "cup", required = false) String cup,
//    											@ApiParam(value = SOGGETTO)
//    											@RequestParam(value = "soggetto", required = false) String soggetto,
//    											@ApiParam(value = FORMAGIURIDICA)
//    											@RequestParam(value = "formaGiuridica", required = false) String formaGiuridica,
//    											@ApiParam(value = CIG)
//    											@RequestParam(value = "cig", required = false) String cig,   											
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
    											@RequestParam(value = "numRecords", required = false) String numRecords,
    											@ApiParam(value = NUMPAGINA)
												@RequestParam(value = "numPagina", required = false) String numPagina,
												@ApiParam(value = ORDINAPERPAGAMENTI)
												@RequestParam(value = "ordinaPer", required = false) String ordinaPer) throws UnsupportedEncodingException {
    
    	RisultatiRicerca<PagamentiBo> pagamentiBo = null;
    	
    	try {               	
        	pagamentiBo = pagamentoService.getPagamenti(utilityClass.checkAndCreateFilter(allRequestParams,"pagamenti"),utilityClass.getBaseUrl(request));
        }catch (ControllerException e) {
            log.error(e.getMessage());
            return gestioneException.gestisciException(e, response);
        }
    	GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
    	Gson gson = builder.setPrettyPrinting().create();      	
        return gson.toJson(pagamentiBo);
    }

    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Restituisce un oggetto json composto da un campo 'totalRecords' che contiene il numero totale di record trovati, un campo 'results' che contiene un oggetto di tipo 'Pagamenti', ed un oggetto di tipo 'paging', che contiene i links alle pagine precedente e successiva contenente i risultati! ",response = RisultatoPagamenti.class),
            @ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Forbidden",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found",response = MessageJson.class),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems",response = MessageJson.class)
    })
    @ApiOperation(value = "Singolo Record", notes = "La seguente api consente lo scarico dei dati del pagamento cha ha come chiave l'id passato come parametro!")
    @RequestMapping(value = "/pagamenti/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody Object getPagamento(HttpServletResponse response,HttpServletRequest request,
    										 @ApiParam(value = AUTHORIZATIONID)
											 @RequestHeader(value="authorization_id",required = false) String auth_id,
											 @ApiParam(value = ID,required = true) 
    										 @PathVariable("id") String id) throws BadRequestException {

    	RisultatiRicerca<PagamentiBo> pagamentiBo = null;

        try {        	       	
        	pagamentiBo = pagamentoService.getPagamento(id,utilityClass.getBaseUrl(request));
        }catch (NumberFormatException e) {
        	log.error(e.getMessage());
            return gestioneException.gestisciException(new BadRequestException(), response);
        } catch (ControllerException e) {
            log.error(e.getMessage());
            return gestioneException.gestisciException(e, response);
        }
        GsonBuilder builder = new GsonBuilder().disableHtmlEscaping();
    	Gson gson = builder.setPrettyPrinting().create();               
        return gson.toJson(pagamentiBo);         
    }

//    @ApiIgnore
//    @RequestMapping(value = "/pagam/file/job/{id}", method = RequestMethod.GET)
//    public @ResponseBody FileJob getFileJob(@PathVariable("id") String fileId) {
//        return fileJobService.getById(fileId);
//    }
    
    
//    @ApiResponses(value = {
////            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "Restituisce un oggetto json composto da un campo 'totalRecords' che contiene il numero totale di record trovati, un campo 'results' che contiene un oggetto di tipo 'Pagamenti', ed un oggetto di tipo 'paging', che contiene i links alle pagine precedente e successiva contenente i risultati! ",response = RisultatoPagamenti.class),
//    		@ApiResponse(code = HttpURLConnection.HTTP_CREATED, message = "Created",response = MessageJson.class),
//    		@ApiResponse(code = HttpURLConnection.HTTP_UNAUTHORIZED, message = "Unauthorized",response = MessageJson.class),
//            @ApiResponse(code = HttpURLConnection.HTTP_FORBIDDEN, message = "Forbidden",response = MessageJson.class),
//            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = "Not found",response = MessageJson.class),
//            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = "Internal server problems",response = MessageJson.class)
//    })
//    @ApiOperation(value = "Richiesta creazione file Pagamenti", notes = "La seguente api consente di creare una richiesta per la generazione di un file contenente i record dei pagamenti!")
    @ApiIgnore
    @RequestMapping(value = "/file/pagamenti", method = RequestMethod.POST,produces = "application/json",consumes = "application/json")
    public @ResponseBody FileJob generateFile(HttpServletResponse response,HttpServletRequest request,
    										  @ApiParam(value = AUTHORIZATIONID)
											  @RequestHeader(value="authorization_id",required = false) String authorization_id,
											  @RequestBody Filter paramsRicercaPagamenti) {

        FileJob fileJob = fileJobService.creteJob(paramsRicercaPagamenti);
        FileJobMessage message = new FileJobMessage(fileJob);

        consumer.startConsumer();
        producer.sendMessage(message);

        return fileJob;
    }

    @ApiIgnore
    @RequestMapping(value = "/file/pagamenti/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getFile(HttpServletResponse response, @PathVariable("id") String fileId) throws IOException {

        String pathDir = fileLocation + "/";
        this.fileResourceUtil.download("PAGAMENTI-" + fileId + ".csv", response, pathDir);

        return null;
    }
}
