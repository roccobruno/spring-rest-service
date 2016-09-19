package com.bruno.service.pagamenti;

import com.bruno.dao.IDBDao;
import com.bruno.dao.pagamenti.PagamentiDao;
import com.bruno.model.Pagamento;
import com.bruno.service.DBDaoServiceImpl;
import com.bruno.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PagamentiServiceImpl extends DBDaoServiceImpl<Pagamento, Integer> implements PagamentiService {

    @Autowired
    private PagamentiDao pagamentiDao;

    @Override
    public IDBDao<Pagamento, Integer> getIDBDao() {
        return pagamentiDao;
    }
}
