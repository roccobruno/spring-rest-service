package com.bruno.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javassist.expr.NewArray;
import com.bruno.exception.GeneralException;
import com.bruno.exception.InternalServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bruno.exception.FilterNotFoundException;
import com.bruno.model.filter.Filter;

@Component
public class UtilityClass implements IUtilityClass, IResourceName, IFilterName {


    private static final Logger log = LoggerFactory.getLogger(UtilityClass.class);

    @Autowired
    IUtilityClass utilityClass;
    
    public String getBaseUrl(HttpServletRequest request) {
        String typeConnection = false ? "https://" : "http://";

        StringBuilder builder = new StringBuilder(typeConnection);
        builder.append(request.getServerName()).append(":").append(request.getServerPort()).append(request.getRequestURI());
        return builder.toString();
    }

    public int getResourceNameIntValue(String resourceName) {

        if (resourceName.equalsIgnoreCase("pagamenti"))
            return PAGAMENTI;
        else if (resourceName.equalsIgnoreCase("impegni"))
            return IMPEGNI;
        return 0;
    }

    public int getFilterNameIntValue(String filterName) {

        if (filterName.equalsIgnoreCase("cup"))
            return CUP;
        if (filterName.equalsIgnoreCase("cig"))
            return CIG;
        if (filterName.equalsIgnoreCase("soggetto"))
            return SOGGETTO;
        if (filterName.equalsIgnoreCase("formaGiuridica"))
            return FORMAGIURIDICA;
        if (filterName.equalsIgnoreCase("settore"))
            return SETTORE;
        if (filterName.equalsIgnoreCase("sottoSettore"))
            return SOTTOSETTORE;
        if (filterName.equalsIgnoreCase("categoria"))
            return CATEGORIA;
        if (filterName.equalsIgnoreCase("regione"))
            return REGIONE;
        if (filterName.equalsIgnoreCase("fonteCodLocaleProg"))
            return FONTECODLOCALEPROG;
        if (filterName.equalsIgnoreCase("dimensione"))
            return DIMENSIONE;
        if (filterName.equalsIgnoreCase("tipologiaLavori"))
            return TIPOLOGIALAVORI;
        if (filterName.equalsIgnoreCase("numRecords"))
            return NUMRECORDS;
        if (filterName.equalsIgnoreCase("ordinaPer"))
            return ORDINAPER;
        if (filterName.equalsIgnoreCase("pageNumber"))
            return NUMPAGINA;
        if (filterName.equalsIgnoreCase("totalRecords"))
            return TOTALRECORDS;
        return 0;
    }

    public Filter checkAndCreateFilter(Map<String, String> allRequestParams) throws GeneralException {

        Filter filter = new Filter();
        Iterator<Map.Entry<String, String>> entryList = null;
        Entry entry = null;

        try {
            if (!allRequestParams.isEmpty()) {
                entryList = allRequestParams.entrySet().iterator();

                while (entryList.hasNext()) {
                    entry = entryList.next();
                    switch (getFilterNameIntValue(entry.getKey().toString())) {

                        case CUP:
                            filter.setCup((String) entry.getValue());
                            break;

                        case CIG:
                            filter.setCig((String) entry.getValue());
                            break;

//                        case SOGGETTO:
//                            filter.setSoggetto((String) entry.getValue());
//                            break;

//                        case FORMAGIURIDICA:
//                            filter.setFormaGiuridica((String) entry.getValue());
//                            break;

                        case SETTORE:
                            filter.setSettore((String) entry.getValue());
                            break;

                        case SOTTOSETTORE:
                            filter.setSottoSettore((String) entry.getValue());
                            break;

                        case CATEGORIA:
                            filter.setCategoria((String) entry.getValue());
                            break;

                        case REGIONE:
                            filter.setRegione((String) entry.getValue());
                            break;

                        case FONTECODLOCALEPROG:
                            filter.setFonteCodLocaleProg((String) entry.getValue());
                            break;

                        case DIMENSIONE:
                            filter.setDimensione((String) entry.getValue());
                            break;

                        case TIPOLOGIALAVORI:
                            filter.setTipologiaLavori((String) entry.getValue());
                            break;

                        case NUMRECORDS:
                            filter.setNumRecords(Integer.parseInt((String) entry.getValue()));
                            break;
                            
                        case NUMPAGINA:
                        	filter.setNumPagina(Integer.parseInt((String) entry.getValue()));
                            break;
                            
                        case TOTALRECORDS:
                        	filter.setTotalRecords(Integer.parseInt((String) entry.getValue()));
                            break;

                        default:
                            throw new FilterNotFoundException();
                    }
                }
            }

            return filter;
        } catch (FilterNotFoundException e) {
        	log.error(e.getMessage());
            throw e;
        } catch (Exception e) {
        	log.error(e.getMessage());
            throw new InternalServerErrorException(e);
        }

    }

}
