package com.bruno.model.wrapper;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.bruno.model.bo.ImpegniBo;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.ho.SwImpegni;
import com.bruno.model.ho.SwPagamenti;

@Component
public class WrapperFromHoToBoImpl implements IWrapperFromHoToBo{
	
	public List<PagamentiBo> getPagamentiBo(List<SwPagamenti> pagamentiList,String baseUrl, boolean isSelf){
		
		List<PagamentiBo> pagamentoList = new ArrayList<PagamentiBo>();
		
		PagamentiBo pagBo = null;
		for(SwPagamenti p:pagamentiList){
			pagBo = new PagamentiBo();
			pagBo.setCodLocProg(p.getCodLocProg());
			pagBo.setCodicePagamento(p.getCodicePagamento());
			pagBo.setDataPagamento(p.getDataPagamento());
			pagBo.setImporto(p.getImporto());
			pagBo.setTipologiaPagamento(p.getTipologiaPagamento());
			pagBo.setCodiceCausale(p.getCodiceCausale());
			pagBo.setDescrizioneCausale(p.getDescrizioneCausale());
			pagBo.setCodiceGestionale(p.getCodiceGestionale());
			pagBo.setDescCodiceGestionale(p.getDescCodiceGestionale());
			pagBo.setNote(p.getNote());	
			pagBo.getMetadata().getLinks().setSelf(isSelf ? baseUrl : baseUrl+"/"+p.getSequSwPagamento());
			pagamentoList.add(pagBo);
		}
		return pagamentoList;		
	}
	
//	public List<ImpegniJson> impegni(List<SwImpegni> impegniList){
//		
//		List<ImpegniJson> impegniJsonList = new ArrayList<ImpegniJson>();
//	
//		ImpegniJson impJson = null;
//		for(SwImpegni p:impegniList){
////			impJson = p.wrapperToJson();
//			impegniJsonList.add(impJson);
//		}
//		return impegniJsonList;
//	}
}
