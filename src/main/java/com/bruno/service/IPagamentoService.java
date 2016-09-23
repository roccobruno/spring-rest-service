package com.bruno.service;

import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.ResourceByIdNotFound;
import com.bruno.model.bo.Filter;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.bo.Pagamento;
import com.bruno.model.bo.RisultatiRicerca;
import java.util.List;

public interface IPagamentoService {

    public List<PagamentiBo> getPagamentoById(String id) throws  ResourceByIdNotFound;
    public List<PagamentiBo> getPagamentiList(Filter filter) throws EmptyListResorceException;
    public RisultatiRicerca<PagamentiBo> getPagamenti(String resourceName,Filter filter) throws EmptyListResorceException;
}
