package com.bruno.db.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.exception.BudRequestException;
import com.bruno.exception.ControllerException;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.filter.Filter;
import com.bruno.model.response.RisultatiRicerca;
import com.bruno.model.wrapper.WrapperFromHoToBoImpl;
import com.bruno.service.IPagamentoService;
import com.bruno.utils.IResourceName;
import com.bruno.utils.IUtilityClass;

@Service
public class ManagerDbImpl implements IManagerDb,IResourceName {

    private static final Logger log = LoggerFactory.getLogger(ManagerDbImpl.class);

    @Autowired
    IDBDaoService iDBDaoService;

    @Autowired
    WrapperFromHoToBoImpl wrapperToJson;

    @Autowired
    IUtilityClass utilityClass;

    @Autowired
    IPagamentoService pagamentoService;

    @Override
    public RisultatiRicerca getRisorsaList(String resourceName, Filter filter,String baseUrl) throws ControllerException {
    	log.info("Start method ManagerDbImpl.getRisorsaList!");

        try {
            switch (utilityClass.getResourceNameIntValue(resourceName)) {

                case PAGAMENTI:

                    RisultatiRicerca<PagamentiBo> pagamentiBo = pagamentoService.getPagamenti(filter,baseUrl);
                    return pagamentiBo;

                default:
                    throw new BudRequestException();
            }
        } catch (BudRequestException e) {
        	log.error(e.getMessage());
            throw new BudRequestException();
        } catch (Exception e) {
        	log.error(e.getMessage());
            throw new InternalServerErrorException();
        }
    }

    @Override
    public Object getRisorsaById(String resourceName, String id,String baseUrl) throws ControllerException {
    	log.info("Start method ManagerDbImpl.getRisorsaById!");

        try {
            switch (utilityClass.getResourceNameIntValue(resourceName)) {

                case PAGAMENTI:

                	 RisultatiRicerca<PagamentiBo> pagamentiBo = pagamentoService.getPagamento(id,baseUrl);
                    return pagamentiBo;

                default:
                    throw new BudRequestException();
            }
        } catch (BudRequestException e) {
        	log.error(e.getMessage());
            throw new BudRequestException();
        } catch (Exception e) {
        	log.error(e.getMessage());
            throw new InternalServerErrorException();
        }
    }
}
