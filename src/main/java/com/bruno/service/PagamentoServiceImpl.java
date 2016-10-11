package com.bruno.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.filter.Filter;
import com.bruno.model.ho.SwPagamenti;
import com.bruno.model.response.Paging;
import com.bruno.model.response.PagingBean;
import com.bruno.model.response.RisultatiRicerca;
import com.bruno.model.wrapper.IWrapperFromHoToBo;

@Service
public class PagamentoServiceImpl implements IPagamentoService {
	
	private static final Logger log = LoggerFactory.getLogger(PagamentoServiceImpl.class);
	
	@Autowired
	IDBDaoService dBDaoService;
	
	@Autowired
	IWrapperFromHoToBo wrapper;

    @Override
    public RisultatiRicerca<PagamentiBo> getPagamenti(Filter filter,String baseUrl) throws InternalServerErrorException {
    	
    	Long totalRecord = null;
    	Paging paging = null;
    	PagingBean pagingBean = null;
    	
    	try{    	
	    	if(filter.getTotalRecords() == null)
	    		totalRecord = dBDaoService.getCount(filter, "SwPagamenti");
	    	else totalRecord = new Long(filter.getTotalRecords());
	    	pagingBean = new PagingBean(filter.getNumPagina(), totalRecord,filter.getFilterPaginator(),baseUrl);
	    	if(pagingBean.getPreviousPageLink() != null || pagingBean.getNextPageLink() != null)
	    		paging = new Paging(pagingBean.getPreviousPageLink(),pagingBean.getNextPageLink());
    	}catch(Exception e){
    		log.error(e.getMessage());
            throw new InternalServerErrorException();
    	}    	
        return new RisultatiRicerca<PagamentiBo>(totalRecord,getPagamentiList(filter,baseUrl),paging);
    }
    
    @Override
    public List<PagamentiBo> getPagamentiList(Filter filter,String baseUrl) throws InternalServerErrorException {
    	
    	List<PagamentiBo> pagamentiBo = null;
    	List<SwPagamenti> pagamentiList = null;
    	
    	try{    	
	    	pagamentiList = (List<SwPagamenti>) dBDaoService.getResourceList(filter, "SwPagamenti");
			if(!pagamentiList.isEmpty())
				pagamentiBo = wrapper.getPagamentiBo(pagamentiList,baseUrl,false);
    	}catch(Exception e){
    		log.error(e.getMessage());
            throw new InternalServerErrorException();
    	}
		return pagamentiBo;
    }
    
    @Override
    public RisultatiRicerca<PagamentiBo> getPagamento(String id,String baseUrl) throws InternalServerErrorException {

    	Long totalRecord = null;
    	List<PagamentiBo> pagamentiBo = null;
    	Paging paging = null;
    	
    	try{
	    	pagamentiBo = getPagamentoById(id,baseUrl);
	    	if(pagamentiBo == null)
	    		totalRecord = new Long("0");
	    	else totalRecord = new Long("1");
    	}catch(Exception e){
    		log.error(e.getMessage());
            throw new InternalServerErrorException();
    	}    	
        return new RisultatiRicerca<PagamentiBo>(totalRecord,pagamentiBo,paging);
    }
    
    @Override
    public List<PagamentiBo> getPagamentoById(String id,String baseUrl) throws InternalServerErrorException {
    	
    	List<PagamentiBo> pagamentiBo = null;
    	List<SwPagamenti> pagamentiList = null;
    	
    	try{
	    	pagamentiList = (List<SwPagamenti>) dBDaoService.genericquery("from SwPagamenti tab where tab.codicePagamento = '"+id+"'");
			if(!pagamentiList.isEmpty())
				pagamentiBo = wrapper.getPagamentiBo(pagamentiList, baseUrl,true);
    	}catch(Exception e){
    		log.error(e.getMessage());
            throw new InternalServerErrorException();
    	}		
		return pagamentiBo;
    }
}
