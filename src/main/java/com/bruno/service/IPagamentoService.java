package com.bruno.service;

import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.filter.Filter;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.response.RisultatiRicerca;
import java.util.List;

public interface IPagamentoService {

	public RisultatiRicerca<PagamentiBo> getPagamento(String id,String baseUrl) throws InternalServerErrorException;
    public List<PagamentiBo> getPagamentoById(String id,String baseUrl) throws InternalServerErrorException;
    public List<PagamentiBo> getPagamentiList(Filter filter,String baseUrl) throws InternalServerErrorException;
    public RisultatiRicerca<PagamentiBo> getPagamenti(Filter filter,String baseUrl) throws InternalServerErrorException;
}
