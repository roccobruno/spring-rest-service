package com.bruno.model.wrapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.bruno.model.bo.ImpegniJson;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.ho.SwImpegni;
import com.bruno.model.ho.SwPagamenti;

@Component
public class WrapperToJson {
	
	public List<PagamentiBo> pagamenti(List<SwPagamenti> pagamentiList){
		
		List<PagamentiBo> pagamentoList = new ArrayList<PagamentiBo>();
		
		PagamentiBo pagJson = null;
		for(SwPagamenti p:pagamentiList){
			pagJson = p.wrapperToJson();
			pagamentoList.add(pagJson);
		}
		return pagamentoList;		
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
