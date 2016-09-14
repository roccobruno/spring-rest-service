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
        pagamentoList.add(new Pagamento("id3","desc1","2323"));
        return pagamentoList;
    }

    @Override
    public PagamentoRisultatiRicerca cercaPagamenti(String cig, Integer pageSize, Integer pageNumber) {
        List<Pagamento> pagamentoList = new ArrayList<Pagamento>();
//        if(cig!=null && cig.equalsIgnoreCase("2322"))
        pagamentoList.add(new Pagamento("id1","desc1","2322"));
//        if(cig!=null && cig.equalsIgnoreCase("2323"))
        pagamentoList.add(new Pagamento("id2","desc1","2323"));
//        if(cig!=null && cig.equalsIgnoreCase("2324"))
        pagamentoList.add(new Pagamento("id3","desc1","2324"));


        return new PagamentoRisultatiRicerca(10000,pagamentoList,pageNumber,pageSize);
    }


}
