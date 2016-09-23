package com.bruno.db.manager;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.exception.EmptyListResorceException;
import com.bruno.exception.GeneralException;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.exception.ResourceByIdNotFound;
import com.bruno.exception.ResourceNotFoundException;
import com.bruno.model.bo.Filter;
import com.bruno.model.bo.PagamentiBo;
import com.bruno.model.bo.RisultatiRicerca;
import com.bruno.model.wrapper.WrapperToJson;
import com.bruno.service.IPagamentoService;
import com.bruno.utils.IResourceName;
import com.bruno.utils.IUtilityClass;

@Service
public class ManagerDbImpl implements IManagerDb,IResourceName {

    private static final Logger log = LoggerFactory.getLogger(ManagerDbImpl.class);

    @Autowired
    IDBDaoService iDBDaoService;

    @Autowired
    WrapperToJson wrapperToJson;

    @Autowired
    IUtilityClass utilityClass;

    @Autowired
    IPagamentoService pagamentoService;

    @Override
    public RisultatiRicerca getRisorsaList(String resourceName, Filter filter) throws GeneralException {
    	log.info("Start method ManagerDbImpl.getRisorsaList!");

        try {
            switch (utilityClass.getResourceNameIntValue(resourceName)) {

                case PAGAMENTI:

                    RisultatiRicerca<PagamentiBo> pagamentiJson = pagamentoService.getPagamenti(resourceName,filter);
                    return pagamentiJson;

                default:
                    throw new ResourceNotFoundException();
            }
        } catch (EmptyListResorceException e) {
        	log.error(e.getMessage());
            throw new EmptyListResorceException();
        } catch (ResourceNotFoundException e) {
        	log.error(e.getMessage());
            throw new ResourceNotFoundException();
        } catch (Exception e) {
        	log.error(e.getMessage());
            throw new InternalServerErrorException(e);
        }
    }

    @Override
    public Object getRisorsaById(String resourceName, String id) throws GeneralException {
    	log.info("Start method ManagerDbImpl.getRisorsaById!");

        try {
            switch (utilityClass.getResourceNameIntValue(resourceName)) {

                case PAGAMENTI:

                    List<PagamentiBo> pagamentiJson = pagamentoService.getPagamentoById(id);
                    return pagamentiJson;

                default:
                    throw new ResourceNotFoundException();
            }
        } catch (ResourceByIdNotFound e) {
        	log.error(e.getMessage());
            throw new ResourceByIdNotFound();
        } catch (ResourceNotFoundException e) {
        	log.error(e.getMessage());
            throw new ResourceNotFoundException();
        } catch (Exception e) {
        	log.error(e.getMessage());
            throw new InternalServerErrorException(e);
        }
    }
}
