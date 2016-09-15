package com.bruno.db.manager;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.model.Swpagamenti;
import com.bruno.model.json.PagamentoJson;
import com.bruno.model.wrapper.WrapperToJson;
import com.bruno.utils.RESOURCE_NAME_CONSTANTS;

@Service
public class ManagerDbImpl implements IManagerDb {

    private static final Logger log = LoggerFactory.getLogger(ManagerDbImpl.class);
    
    @Autowired
    IDBDaoService iDBDaoService;
    
    @Autowired
    WrapperToJson wrapperToJson;
    
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
    		switch (resourceNameInt) {
			case 1:
				List<Swpagamenti> pagamentiList = (List<Swpagamenti>) iDBDaoService.genericquery("from Swpagamenti where rownum <= 10");
				
				List<PagamentoJson> pagamentiJson = wrapperToJson.pagamenti(pagamentiList);
				
				return pagamentiJson;

			default:
				break;
			}
    	}catch(Exception e){
    		throw new Exception(e);
    	}
        return risorsaList;
    }
}
