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
import com.bruno.model.wrapper.IWrapperFromHoToBo;
import com.bruno.model.wrapper.WrapperFromHoToBoImpl;

@Service
public class PagamentoServiceImpl implements IPagamentoService {
	
	private static final Logger log = LoggerFactory.getLogger(PagamentoServiceImpl.class);
	
	@Autowired
	IDBDaoService dBDaoService;
	
	@Autowired
	IWrapperFromHoToBo wrapper;	
	
    @Override
    public List<PagamentiBo> getPagamentiList(Filter filter,String baseUrl) throws EmptyListResorceException {
    	
    	List<PagamentiBo> pagamentiBo = null;
    	
    	List<SwPagamenti> pagamentiList = (List<SwPagamenti>) dBDaoService.getResourceList(filter, "SwPagamenti");
		if(!pagamentiList.isEmpty())
			pagamentiBo = wrapper.getPagamentiBo(pagamentiList,baseUrl,false);
		
		return pagamentiBo;
    }

    @Override
    public RisultatiRicerca<PagamentiBo> getPagamenti(Filter filter,String baseUrl) throws EmptyListResorceException {

    	Long totalRecord = null;
    	if(filter.getTotalRecords() == null)
    		totalRecord = dBDaoService.getCount(filter, "SwPagamenti");
    	else totalRecord = new Long(filter.getTotalRecords());

        return new RisultatiRicerca<PagamentiBo>(totalRecord,getPagamentiList(filter,baseUrl),new Paging(filter.getNumPagina(), filter.getNumRecords(), totalRecord,filter.getFilterPaginator(),baseUrl));
    }

    public List<PagamentiBo> getPagamentoById(String id,String baseUrl) throws ResourceByIdNotFound {
    	
    	List<PagamentiBo> pagamentiBo = null;
    	
    	List<SwPagamenti> pagamentiList = (List<SwPagamenti>) dBDaoService.genericquery("from SwPagamenti tab where tab.sequSwPagamento = "+id+"");
		if(!pagamentiList.isEmpty())
			pagamentiBo = wrapper.getPagamentiBo(pagamentiList, baseUrl,true);
		
		return pagamentiBo;
    }
    
    @Override
    public RisultatiRicerca<PagamentiBo> getPagamento(String id,String baseUrl) throws EmptyListResorceException, ResourceByIdNotFound {

    	Long totalRecord = null;
    	List<PagamentiBo> pagamentiBo = getPagamentoById(id,baseUrl);
    	if(pagamentiBo == null)
    		totalRecord = new Long("0");
    	else totalRecord = new Long("1");
    	
        return new RisultatiRicerca<PagamentiBo>(totalRecord,pagamentiBo,new Paging(1, 1, totalRecord,null,baseUrl));
    }
}
