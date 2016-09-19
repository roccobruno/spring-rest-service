package com.bruno.db.manager;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.service.IDBDaoService;
import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.ResourceNotFoundException;
import com.bruno.model.Filter;
import com.bruno.model.SwImpegni;
import com.bruno.model.SwPagamenti;
import com.bruno.model.json.ImpegniJson;
import com.bruno.model.json.PagamentiJson;
import com.bruno.model.wrapper.WrapperToJson;
import com.bruno.utils.IUtilityClass;
import com.bruno.utils.IResourceName;


@Service
public class ManagerDbImpl implements IManagerDb,IResourceName {

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
    public Object getRisorsaList(String resourceName, Filter filter) throws Exception {
    	
    	List<Object> risorsaList = null;
    	int resourceNameInt = 1;
    	
    	try{
    		switch (utilityClass.getResourceNameIntValue(resourceName)) {
    		
			case PAGAMENTI:
//				List<SwPagamenti> pagamentiList = (List<SwPagamenti>) iDBDaoService.genericquery("from SwPagamenti where rownum <= 10");
//				Fare la count per vedere il numero dei records
//				Do il numero alla routine di paginazione
				List<SwPagamenti> pagamentiList = (List<SwPagamenti>) iDBDaoService.getResourceList(filter, "SwPagamenti");
				if(pagamentiList.isEmpty())
					throw new EmptyListResorceException();				
				List<PagamentiJson> pagamentiJson = wrapperToJson.pagamenti(pagamentiList);
				
				return pagamentiJson;
			
			case IMPEGNI:
				
				List<SwImpegni> impegniList = (List<SwImpegni>) iDBDaoService.genericquery("from SwImpegni where rownum <= 10");
				
				List<ImpegniJson> impegniJson = wrapperToJson.impegni(impegniList);
				
				return impegniJson;

			default:
				throw new ResourceNotFoundException();				
			}
    	}catch(EmptyListResorceException e){
    		throw new EmptyListResorceException();
    	}catch(ResourceNotFoundException e){
    		throw new ResourceNotFoundException();
    	}catch(Exception e){
    		throw new Exception(e);
    	}
    }
}
