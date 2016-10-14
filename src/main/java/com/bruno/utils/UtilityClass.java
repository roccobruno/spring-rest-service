package com.bruno.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.bruno.exception.ControllerException;
import com.bruno.exception.FilterNotFoundException;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.exception.OrderByFieldNotFound;
import com.bruno.model.filter.Filter;

@Component
public class UtilityClass implements IUtilityClass, IResourceName, IFilterName {

//    @Value("${mopWs.numRecordsForPage}")
//    private Integer numeroDiRecord;
//
//    public Integer getNumeroDiRecord() {
//        return numeroDiRecord;
//    }
//
//    public void setNumeroDiRecord(Integer numeroDiRecord) {
//        this.numeroDiRecord = numeroDiRecord;
//    }

    private static final Logger log = LoggerFactory.getLogger(UtilityClass.class);
    
    public String getBaseUrl(HttpServletRequest request) throws InternalServerErrorException {
    	
    	StringBuilder builder = null;
    	
    	try{
	        builder = new StringBuilder(request.getRequestURL());
//	        builder.append("://").append(request.getServerName()).append(":").append(request.getServerPort()).append(request.getRequestURI());
	    }catch(Exception e){
	    	log.error(e.getMessage());
            throw new InternalServerErrorException();
	    }
        return builder.toString();
    }

    public int getResourceNameIntValue(String resourceName) throws InternalServerErrorException {

    	try{
	        if (resourceName.equalsIgnoreCase("pagamenti"))
	            return PAGAMENTI;
	        else if (resourceName.equalsIgnoreCase("impegni"))
	            return IMPEGNI;
    	}catch(Exception e){
    		log.error(e.getMessage());
            throw new InternalServerErrorException();
    	}
        return 0;
    }

    public int getFilterNameIntValue(String filterName) throws InternalServerErrorException {

    	try{
	        if (filterName.equalsIgnoreCase("cup"))
	            return CUP;
	        if (filterName.equalsIgnoreCase("cig"))
	            return CIG;
	        if (filterName.equalsIgnoreCase("soggetto"))
	            return SOGGETTO;
	        if (filterName.equalsIgnoreCase("formaGiuridica"))
	            return FORMAGIURIDICA;
	        if (filterName.equalsIgnoreCase("settore"))
	            return SETTORE;
	        if (filterName.equalsIgnoreCase("sottoSettore"))
	            return SOTTOSETTORE;
	        if (filterName.equalsIgnoreCase("categoria"))
	            return CATEGORIA;
	        if (filterName.equalsIgnoreCase("regione"))
	            return REGIONE;
	        if (filterName.equalsIgnoreCase("fonteCodLocaleProg"))
	            return FONTECODLOCALEPROG;
	        if (filterName.equalsIgnoreCase("dimensione"))
	            return DIMENSIONE;
	        if (filterName.equalsIgnoreCase("tipologiaLavori"))
	            return TIPOLOGIALAVORI;
	        if (filterName.equalsIgnoreCase("numRecords"))
	            return NUMRECORDS;
	        if (filterName.equalsIgnoreCase("ordinaPer"))
	            return ORDINAPER;
	        if (filterName.equalsIgnoreCase("numPagina"))
	            return NUMPAGINA;
	        if (filterName.equalsIgnoreCase("totalRecords"))
	            return TOTALRECORDS;
    	}catch(Exception e){
    		log.error(e.getMessage());
            throw new InternalServerErrorException();
    	}
        return 0;
    }

    public Filter checkAndCreateFilter(Map<String, String> allRequestParams, String resourceName) throws ControllerException {



//        System.out.print("ROCCO "+numeroDiRecord);
//
    	Filter filter = new Filter();

//    	Filter filter = new Filter(numeroDiRecord);

        Iterator<Map.Entry<String, String>> entryList = null;
        Entry entry = null;

        try {
            if (!allRequestParams.isEmpty()) {
                entryList = allRequestParams.entrySet().iterator();

                while (entryList.hasNext()) {
                    entry = entryList.next();
                    switch (getFilterNameIntValue(entry.getKey().toString())) {

                        case CUP:
                            filter.setCup((String) entry.getValue());
                            break;

                        case CIG:
                            filter.setCig((String) entry.getValue());
                            break;

//                        case SOGGETTO:
//                            filter.setSoggetto((String) entry.getValue());
//                            break;

//                        case FORMAGIURIDICA:
//                            filter.setFormaGiuridica((String) entry.getValue());
//                            break;

                        case SETTORE:
                            filter.setSettore((String) entry.getValue());
                            break;

                        case SOTTOSETTORE:
                            filter.setSottoSettore((String) entry.getValue());
                            break;

                        case CATEGORIA:
                            filter.setCategoria((String) entry.getValue());
                            break;

                        case REGIONE:
                            filter.setRegione((String) entry.getValue());
                            break;

                        case FONTECODLOCALEPROG:
                            filter.setFonteCodLocaleProg((String) entry.getValue());
                            break;

                        case DIMENSIONE:
                            filter.setDimensione((String) entry.getValue());
                            break;

                        case TIPOLOGIALAVORI:
                            filter.setTipologiaLavori((String) entry.getValue());
                            break;

                        case NUMRECORDS:
                            filter.setNumRecords(Integer.parseInt((String) entry.getValue()));
                            break;
                            
                        case NUMPAGINA:
                        	filter.setNumPagina(Integer.parseInt((String) entry.getValue()));
                            break;
                            
                        case TOTALRECORDS:
                        	filter.setTotalRecords(Integer.parseInt((String) entry.getValue()));
                            break;
                            
                        case ORDINAPER:
                        	String value = (String) entry.getValue();
                        	String[] splitValue = value.split(" ");
                        	if(splitValue.length > 1 && !(splitValue[1].equalsIgnoreCase("asc") || splitValue[1].equalsIgnoreCase("desc")))
                        		throw new OrderByFieldNotFound();
                        	if(checkValueOrderBy(resourceName,splitValue[0]))
                        		filter.setOrdinaPer((String) entry.getValue());
                        	else throw new OrderByFieldNotFound();
                            break;

                        default:
                            throw new FilterNotFoundException();
                    }
                }
            }

            return filter;
        } catch (FilterNotFoundException e) {
        	log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
        	log.error(e.getMessage());
            throw new InternalServerErrorException();
        }

    }
    
public boolean checkValueOrderBy(String resourceName,String value) throws InternalServerErrorException{
    	
	switch (getResourceNameIntValue(resourceName)) {
	
	case PAGAMENTI:
		
		return checkValueOrderByPagamenti(value);

	default:
		break;
	}
    	if(value.equalsIgnoreCase(value))
    		return true;
    	return false;
    }
    
    private boolean checkValueOrderByPagamenti(String value){
    	
    	if(value.equalsIgnoreCase("codLocProg"))
    		return true;
    	if(value.equalsIgnoreCase("dataPagamento"))
    		return true;
    	if(value.equalsIgnoreCase("codicePagamento"))
    		return true;
    	if(value.equalsIgnoreCase("tipologiaPagamento"))
    		return true;
    	if(value.equalsIgnoreCase("importo"))
    		return true;
    	if(value.equalsIgnoreCase("codiceCausale"))
    		return true;
    	if(value.equalsIgnoreCase("descrizioneCausale"))
    		return true;
    	if(value.equalsIgnoreCase("codiceGestionale"))
    		return true;
    	if(value.equalsIgnoreCase("descCodiceGestionale"))
    		return true;
    	if(value.equalsIgnoreCase("note"))
    		return true;

    	return false;
    }
    
    

}
