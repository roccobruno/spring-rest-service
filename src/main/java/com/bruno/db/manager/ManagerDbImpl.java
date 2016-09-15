package com.bruno.db.manager;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.model.SwPagamenti;

@Service
public class ManagerDbImpl implements IManagerDb {

    private static final Logger log = LoggerFactory.getLogger(ManagerDbImpl.class);
    
    @Autowired
    IDBDaoService iDBDaoService;
    
    @Override
    public List<SwPagamenti> getPagamenti() {
        
        List<SwPagamenti> pagamentiList = (List<SwPagamenti>) iDBDaoService.genericquery("from SwPagamenti where rownum <= 10");

        return pagamentiList;
    }
}
