package com.bruno.db.manager;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.ResourceByIdNotFound;
import com.bruno.exception.ResourceNotFoundException;
import com.bruno.model.Filter;
import com.bruno.model.SwImpegni;
import com.bruno.model.json.ImpegniJson;
import com.bruno.model.json.PagamentiJson;
import com.bruno.model.json.PagamentiProva;
import com.bruno.model.json.PagamentoProva;
import com.bruno.model.wrapper.WrapperToJson;
import com.bruno.service.IPagamentoService;
import com.bruno.utils.IResourceName;
import com.bruno.utils.IUtilityClass;

@Service
public class ManagerDbImpl implements IManagerDb,IResourceName {

    private static final Logger log = LoggerFactory.getLogger(ManagerDbImpl.class);
    
    @Autowired
    IDBDaoService iDBDaoService;
    
    @Autowired
    WrapperToJson wrapperToJson;
    
    @Autowired
    IUtilityClass utilityClass;
    
    @Autowired
    IPagamentoService pagamentoService;
    
    @Override
    public Object getRisorsaList(String resourceName, Filter filter) throws Exception {
    	
    	List<Object> risorsaList = null;
    	int resourceNameInt = 1;
    	
    	try{
    		switch (utilityClass.getResourceNameIntValue(resourceName)) {
    		
			case PAGAMENTI:

				List<PagamentiJson> pagamentiJson = pagamentoService.getPagamentiList(filter);				
				return pagamentiJson;
			
			case IMPEGNI:
				
				List<SwImpegni> impegniList = (List<SwImpegni>) iDBDaoService.getResourceList(filter, "SwImpegni");
				if(impegniList.isEmpty())
					throw new EmptyListResorceException();
				
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
    
    @Override
    public Object getRisorsaById(String resourceName, String id) throws Exception {
    	
    	List<PagamentoProva> pagamentiList = new ArrayList<PagamentoProva>();
    	
    	try{
    		switch (utilityClass.getResourceNameIntValue(resourceName)) {
    		
			case PAGAMENTI:

				List<PagamentiJson> pagamentiJson = pagamentoService.getPagamentoById(id);				
//				return new PagamentiProva(pagamentiList.add(pagamentiJson));

			default:
				throw new ResourceNotFoundException();				
			}
    	}catch(ResourceByIdNotFound e){
    		throw new ResourceByIdNotFound();
    	}catch(ResourceNotFoundException e){
    		throw new ResourceNotFoundException();
    	}catch(Exception e){
    		throw new Exception(e);
    	}
    }
}
