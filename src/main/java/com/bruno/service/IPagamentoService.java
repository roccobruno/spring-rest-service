package com.bruno.service;

import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.ResourceByIdNotFound;
import com.bruno.model.bo.Filter;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.bo.Pagamento;
import com.bruno.model.bo.RisultatiRicerca;
import java.util.List;

public interface IPagamentoService {

	public RisultatiRicerca<PagamentiBo> getPagamento(String id,String baseUrl) throws EmptyListResorceException,ResourceByIdNotFound;
    public List<PagamentiBo> getPagamentoById(String id,String baseUrl) throws  ResourceByIdNotFound;
    public List<PagamentiBo> getPagamentiList(Filter filter,String baseUrl) throws EmptyListResorceException;
    public RisultatiRicerca<PagamentiBo> getPagamenti(Filter filter,String baseUrl) throws EmptyListResorceException;
}
