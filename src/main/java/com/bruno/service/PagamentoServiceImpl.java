package com.bruno.service;

import com.bruno.model.Pagamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PagamentoServiceImpl implements PagamentoService {
    @Override
    public List<Pagamento> getPagamento() {
        List<Pagamento> pagamentoList = new ArrayList<Pagamento>();
        pagamentoList.add(new Pagamento("id1","desc1","2322"));
        pagamentoList.add(new Pagamento("id2","desc1","2322"));
        pagamentoList.add(new Pagamento("id3","desc1","2322"));
        return pagamentoList;
    }
}
