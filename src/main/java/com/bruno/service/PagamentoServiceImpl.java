package com.bruno.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.ResourceByIdNotFound;
import com.bruno.model.bo.Filter;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.bo.Paging;
import com.bruno.model.bo.RisultatiRicerca;
import com.bruno.model.ho.SwPagamenti;
import com.bruno.model.wrapper.WrapperToJson;

@Service
public class PagamentoServiceImpl implements IPagamentoService {
	
	private static final Logger log = LoggerFactory.getLogger(PagamentoServiceImpl.class);
	
	@Autowired
	IDBDaoService dBDaoService;
	
	@Autowired
	WrapperToJson wrapperToJson;	
	
    @Override
    public List<PagamentiBo> getPagamentiList(Filter filter) throws EmptyListResorceException {
    	
    	List<SwPagamenti> pagamentiList = (List<SwPagamenti>) dBDaoService.getResourceList(filter, "SwPagamenti");
		if(pagamentiList.isEmpty())
			throw new EmptyListResorceException();				
		List<PagamentiBo> pagamentiJson = wrapperToJson.pagamenti(pagamentiList);
		
		return pagamentiJson;
    }

    @Override
    public RisultatiRicerca<PagamentiBo> getPagamenti(String resourceName, Filter filter) throws EmptyListResorceException {

        Long totalRecord = dBDaoService.getCount(filter, "SwPagamenti");

        return new RisultatiRicerca<PagamentiBo>(totalRecord,getPagamentiList(filter),new Paging(resourceName,filter.getNumPagina(), filter.getNumRecords(), totalRecord,filter.getFilterPaginator()));
    }

    public List<PagamentiBo> getPagamentoById(String id) throws ResourceByIdNotFound {
    	
    	List<SwPagamenti> pagamentiList = (List<SwPagamenti>) dBDaoService.genericquery("from SwPagamenti tab where tab.sequSwPagamento = "+id+"");
		if(pagamentiList.isEmpty())
			throw new ResourceByIdNotFound();				
		List<PagamentiBo> pagamentiJson = wrapperToJson.pagamenti(pagamentiList);
		
		return pagamentiJson;
    }
}
