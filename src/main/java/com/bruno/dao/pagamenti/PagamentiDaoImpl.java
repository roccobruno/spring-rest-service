package com.bruno.dao.pagamenti;

import com.bruno.dao.DBDaoImpl;
import com.bruno.model.Pagamento;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

@Repository
public  class PagamentiDaoImpl extends DBDaoImpl<Pagamento,Integer> implements PagamentiDao {

    public PagamentiDaoImpl() {
        super(Pagamento.class);
    }

}
