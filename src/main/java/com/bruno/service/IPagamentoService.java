package com.bruno.service;

import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.ResourceByIdNotFound;
import com.bruno.model.Filter;
import com.bruno.model.Pagamento;
import com.bruno.model.json.PagamentiJson;

import java.util.List;

public interface IPagamentoService {

    public List<Pagamento> getPagamento();
    public List<PagamentiJson> getPagamentoById(String id) throws  ResourceByIdNotFound;
    public List<PagamentiJson> getPagamentiList(Filter filter) throws EmptyListResorceException;
    public PagamentoRisultatiRicerca cercaPagamenti(String cig, Integer pageSize, Integer pageNumber);
}
