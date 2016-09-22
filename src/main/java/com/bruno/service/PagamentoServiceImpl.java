package com.bruno.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.dao.service.IDBDaoService;
import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.ResourceByIdNotFound;
import com.bruno.model.Filter;
import com.bruno.model.Pagamento;
import com.bruno.model.SwPagamenti;
import com.bruno.model.json.PagamentiJson;
import com.bruno.model.wrapper.WrapperToJson;

@Service
public class PagamentoServiceImpl implements IPagamentoService {
	
	private static final Logger log = LoggerFactory.getLogger(PagamentoServiceImpl.class);
	
	@Autowired
	IDBDaoService dBDaoService;
	
	@Autowired
	WrapperToJson wrapperToJson;	
	
    @Override
    public List<Pagamento> getPagamento() {
        List<Pagamento> pagamentoList = new ArrayList<Pagamento>();
        pagamentoList.add(new Pagamento("id1","desc1","2322"));
        pagamentoList.add(new Pagamento("id2","desc1","2322"));
        pagamentoList.add(new Pagamento("id3","desc1","2323"));
        return pagamentoList;
    }

    @Override
    public PagamentoRisultatiRicerca cercaPagamenti(String cig, Integer pageSize, Integer pageNumber) {
        List<Pagamento> pagamentoList = new ArrayList<Pagamento>();
//        if(cig!=null && cig.equalsIgnoreCase("2322"))
        pagamentoList.add(new Pagamento("id1","desc1","2322"));
//        if(cig!=null && cig.equalsIgnoreCase("2323"))
        pagamentoList.add(new Pagamento("id2","desc1","2323"));
//        if(cig!=null && cig.equalsIgnoreCase("2324"))
        pagamentoList.add(new Pagamento("id3","desc1","2324"));


        return new PagamentoRisultatiRicerca(10000,pagamentoList,pageNumber,pageSize);
    }
    
    public List<PagamentiJson> getPagamentiList(Filter filter) throws EmptyListResorceException {
    	
    	long count = dBDaoService.getCountValue("from SwPagamenti tab where tab.soggetto = '"+filter.getSoggetto()+"' ");
    	
    	List<SwPagamenti> pagamentiList = (List<SwPagamenti>) dBDaoService.getResourceList(filter, "SwPagamenti");
		if(pagamentiList.isEmpty())
			throw new EmptyListResorceException();				
		List<PagamentiJson> pagamentiJson = wrapperToJson.pagamenti(pagamentiList);
		
		return pagamentiJson;
    }
    
    public List<PagamentiJson> getPagamentoById(String id) throws ResourceByIdNotFound {
    	
    	List<SwPagamenti> pagamentiList = (List<SwPagamenti>) dBDaoService.genericquery("from SwPagamenti tab where tab.sequSwPagamento = "+id+"");
		if(pagamentiList.isEmpty())
			throw new ResourceByIdNotFound();				
		List<PagamentiJson> pagamentiJson = wrapperToJson.pagamenti(pagamentiList);
		
		return pagamentiJson;
    }
    
    


}
