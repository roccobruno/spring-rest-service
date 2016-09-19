package com.bruno.model.wrapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.bruno.model.SwImpegni;
import com.bruno.model.SwPagamenti;
import com.bruno.model.json.ImpegniJson;
import com.bruno.model.json.PagamentiJson;


@Component
public class WrapperToJson {
	
	public List<PagamentiJson> pagamenti(List<SwPagamenti> pagamentiList){
		
		List<PagamentiJson> pagamentiJsonList = new ArrayList<PagamentiJson>();
		
		PagamentiJson pagJson = null;
		for(SwPagamenti p:pagamentiList){
			pagJson = p.wrapperToJson();
			pagamentiJsonList.add(pagJson);
		}
		return pagamentiJsonList;		
	}
	
	public List<ImpegniJson> impegni(List<SwImpegni> impegniList){
		
		List<ImpegniJson> impegniJsonList = new ArrayList<ImpegniJson>();
	
		ImpegniJson impJson = null;
		for(SwImpegni p:impegniList){
//			impJson = p.wrapperToJson();
			impegniJsonList.add(impJson);
		}
		return impegniJsonList;
	}
}
