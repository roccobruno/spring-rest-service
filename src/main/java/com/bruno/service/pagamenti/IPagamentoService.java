package com.bruno.service.pagamenti;

import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.filter.Filter;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.response.RisultatiRicerca;
import com.bruno.service.IService;

import java.util.List;

public interface IPagamentoService extends IService<PagamentiBo> {

	 RisultatiRicerca<PagamentiBo> getPagamento(String id,String baseUrl) throws InternalServerErrorException;
     List<PagamentiBo> getPagamentoById(String id,String baseUrl) throws InternalServerErrorException;
     List<PagamentiBo> getPagamentiList(Filter filter,String baseUrl) throws InternalServerErrorException;
     List<PagamentiBo> getPagamentiListMock(Filter filter,String baseUrl) throws InternalServerErrorException;
     RisultatiRicerca<PagamentiBo> getPagamenti(Filter filter,String baseUrl) throws InternalServerErrorException;
}
