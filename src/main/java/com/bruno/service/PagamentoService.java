package com.bruno.service;

import com.bruno.model.Pagamento;

import java.util.List;

public interface PagamentoService {

    public List<Pagamento> getPagamento();
    public PagamentoRisultatiRicerca cercaPagamenti(String cig, Integer pageSize, Integer pageNumber);
}
