package com.bruno.model.wrapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.bruno.model.SwPagamenti;
import com.bruno.model.json.PagamentoJson;

@Component
public class WrapperToJson {
	
	public List<PagamentoJson> pagamenti(List<SwPagamenti> pagamenti){
		
		List<PagamentoJson> pagamentiJsonList = new ArrayList<PagamentoJson>();
		
		PagamentoJson pagJson = null;
		for(SwPagamenti p:pagamenti){
			pagJson = p.wrapperToJson();
			pagamentiJsonList.add(pagJson);
		}
		return pagamentiJsonList;		
	}
}
