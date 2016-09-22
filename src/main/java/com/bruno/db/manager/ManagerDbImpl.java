package com.bruno.db.manager;

import java.util.ArrayList;
import java.util.List;

import com.bruno.exception.*;
import com.bruno.service.RisultatiRicerca;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bruno.dao.service.IDBDaoService;
import com.bruno.model.Filter;
import com.bruno.model.SwImpegni;
import com.bruno.model.json.ImpegniJson;
import com.bruno.model.json.PagamentiJson;
import com.bruno.model.json.PagamentiProva;
import com.bruno.model.json.PagamentoProva;
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

        try {
            switch (utilityClass.getResourceNameIntValue(resourceName)) {

                case PAGAMENTI:

                    RisultatiRicerca pagamentiJson = pagamentoService.getPagamenti(filter);

                    return pagamentiJson;

                case IMPEGNI:

                    List<SwImpegni> impegniList = (List<SwImpegni>) iDBDaoService.getResourceList(filter, "SwImpegni");
                    if (impegniList.isEmpty())
                        throw new EmptyListResorceException();

                    Long totalCount = iDBDaoService.getCount(filter,"SwImpegni");

                    List<ImpegniJson> impegniJson = wrapperToJson.impegni(impegniList);

                    return new RisultatiRicerca(totalCount,impegniJson,filter.getNumPagina(),filter.getNumRecords());

                default:
                    throw new ResourceNotFoundException();
            }
        } catch (EmptyListResorceException e) {
            throw new EmptyListResorceException();
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }

    @Override
//<<<<<<< HEAD
//    public Object getRisorsaById(String resourceName, String id) throws Exception {
//    	
//    	List<PagamentoProva> pagamentiList = new ArrayList<PagamentoProva>();
//    	
//    	try{
//    		switch (utilityClass.getResourceNameIntValue(resourceName)) {
//    		
//			case PAGAMENTI:
//=======
    public Object getRisorsaById(String resourceName, String id) throws GeneralException {


//<<<<<<< HEAD
//				List<PagamentiJson> pagamentiJson = pagamentoService.getPagamentoById(id);				
////				return new PagamentiProva(pagamentiList.add(pagamentiJson));
//=======
        try {
            switch (utilityClass.getResourceNameIntValue(resourceName)) {


                case PAGAMENTI:

                    List<PagamentiJson> pagamentiJson = pagamentoService.getPagamentoById(id);
                    return pagamentiJson;

                default:
                    throw new ResourceNotFoundException();
            }
        } catch (ResourceByIdNotFound e) {
            throw new ResourceByIdNotFound();
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException();
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }
}
