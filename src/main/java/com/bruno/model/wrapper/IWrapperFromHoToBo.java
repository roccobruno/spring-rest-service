package com.bruno.model.wrapper;

import java.util.List;

import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.ho.SwPagamenti;

public interface IWrapperFromHoToBo {
	
	List<PagamentiBo> getPagamentiBo(List<SwPagamenti> pagamentiList,String baseUrl, boolean isSelf);

}
