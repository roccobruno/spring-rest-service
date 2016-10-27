package com.bruno.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bruno.model.bo.Pagamento;
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
//	    		totalRecord = dBDaoService.getCount(filter, "SwPagamenti");
	    		totalRecord = 1000l;
	    	else totalRecord = new Long(filter.getTotalRecords());
	    	pagingBean = new PagingBean(filter.getNumPagina(), totalRecord,filter.getFilterPaginator(),baseUrl);
	    	if(pagingBean.getPreviousPageLink() != null || pagingBean.getNextPageLink() != null)
	    		paging = new Paging(pagingBean.getPreviousPageLink(),pagingBean.getNextPageLink());
    	}catch(Exception e){
    		log.error(e.getMessage());
            throw new InternalServerErrorException();
    	}    	
//        return new RisultatiRicerca<PagamentiBo>(totalRecord,getPagamentiList(filter,baseUrl),paging);
		return fakeResults(paging);
    }


    private RisultatiRicerca fakeResults(Paging paging)  {
		ArrayList<PagamentiBo> pagamentiBos = new ArrayList<PagamentiBo>();
		for (int i = 0; i < 10; i++) {
			pagamentiBos.add(getPagamento(i));
		}
		return new RisultatiRicerca<PagamentiBo>(1000l, pagamentiBos,paging);
	}

	private PagamentiBo getPagamento(int i) {
		PagamentiBo pagamentiBo = new PagamentiBo();
		pagamentiBo.setCodiceCausale("codice casuale "+i);
		pagamentiBo.setCodiceGestionale("codice gets"+i);
		pagamentiBo.setCodicePagamento("codice pagamento"+i);
		pagamentiBo.setDataPagamento(new Date());
		pagamentiBo.setDescCodiceGestionale("desc"+i);
		pagamentiBo.setDescrizioneCausale("desc casuale"+i );
		pagamentiBo.setImporto(new BigDecimal("10").add(new BigDecimal(i)));
		pagamentiBo.setNote("note"+i);
		pagamentiBo.setTipologiaPagamento("tipo"+i);
		pagamentiBo.setCodLocProg("codlogpro"+i);
		return pagamentiBo;
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
	public List<PagamentiBo> getPagamentiListMock(Filter filter, String baseUrl) throws InternalServerErrorException {
		ArrayList<PagamentiBo> pagamentiBos = new ArrayList<PagamentiBo>();
		for (int i = 0; i < 10; i++) {
			pagamentiBos.add(getPagamento(i));
		}
		return pagamentiBos;
	}

	@Override
	public Long countRecords(Filter filter) throws InternalServerErrorException {
		return 1000l; //TODO only for testing
//		return dBDaoService.getCount(filter,"SwPagamenti");
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
