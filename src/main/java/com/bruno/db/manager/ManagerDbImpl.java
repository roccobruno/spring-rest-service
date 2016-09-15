package com.bruno.db.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.model.SwImpegni;
import com.bruno.model.SwPagamenti;
import com.bruno.model.json.ImpegniJson;
import com.bruno.model.json.PagamentiJson;
import com.bruno.model.wrapper.WrapperToJson;
import com.bruno.utils.IUtilityClass;
import com.bruno.utils.RESOURCE_NAME_CONSTANTS;
import com.bruno.utils.ResourceName;

@Service
public class ManagerDbImpl implements IManagerDb,ResourceName {

    private static final Logger log = LoggerFactory.getLogger(ManagerDbImpl.class);
    
    @Autowired
    IDBDaoService iDBDaoService;
    
    @Autowired
    WrapperToJson wrapperToJson;
    
    @Autowired
    IUtilityClass utilityClass;
    
    @Override
    public List<Object> getPagamenti() {
    	
    	String query = "tab.codLocProg,tab.dataPagamento,tab.codicePagamento,tab.tipologiaPagamento,tab.importo,tab.codiceCausale, tab.descrizioneCausale,tab.codiceGestionale,tab.descCodiceGestionale,tab.note";
        
        List<Object> pagamentiList = (List<Object>) iDBDaoService.genericquery("from SwPagamenti tab where rownum <= 10");

        return pagamentiList;
    }
    
    @Override
    public Object getRisorsaList(String resourceName) throws Exception {
    	
    	List<Object> risorsaList = null;
    	int resourceNameInt = 1;
    	
    	try{
    		switch (utilityClass.getResourceNameInt(resourceName)) {
    		
			case PAGAMENTI:
				List<SwPagamenti> pagamentiList = (List<SwPagamenti>) iDBDaoService.genericquery("from SwPagamenti where rownum <= 10");
				
				List<PagamentiJson> pagamentiJson = wrapperToJson.pagamenti(pagamentiList);
				
				return pagamentiJson;
			
			case IMPEGNI:
				
				List<SwImpegni> impegniList = (List<SwImpegni>) iDBDaoService.genericquery("from SwImpegni where rownum <= 10");
				
				List<ImpegniJson> impegniJson = wrapperToJson.impegni(impegniList);
				
				return impegniJson;

			default:
				
				break;
			}
    	}catch(Exception e){
    		throw new Exception(e);
    	}
        return risorsaList;
    }
}
