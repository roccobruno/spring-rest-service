package com.bruno.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.bruno.exception.GeneralException;
import com.bruno.exception.InternalServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bruno.exception.FilterNotFoundException;
import com.bruno.model.Filter;

@Component
//<<<<<<< HEAD
//public class UtilityClass implements IUtilityClass,IResourceName,IFilterName{
//	
//	private static final Logger log = LoggerFactory.getLogger(UtilityClass.class);
//	
//	@Autowired
//    IUtilityClass utilityClass;
//	
//	public int getResourceNameIntValue(String resourceName){
//		
//		if(resourceName.equalsIgnoreCase("pagamenti"))
//			return PAGAMENTI;
//		else if(resourceName.equalsIgnoreCase("impegni"))
//			return IMPEGNI;
//		return 0;
//	}
//	
//	public int getFilterNameIntValue(String filterName){
//		
//		if(filterName.equalsIgnoreCase("cup"))
//			return CUP;
//		if(filterName.equalsIgnoreCase("cig"))
//			return CIG;
//		if(filterName.equalsIgnoreCase("soggetto"))
//			return SOGGETTO;		
//		if(filterName.equalsIgnoreCase("formaGiuridica"))
//			return FORMAGIURIDICA;
//		if(filterName.equalsIgnoreCase("settore"))
//			return SETTORE;
//		if(filterName.equalsIgnoreCase("sottoSettore"))
//			return SOTTOSETTORE;
//		if(filterName.equalsIgnoreCase("categoria"))
//			return CATEGORIA;
//		if(filterName.equalsIgnoreCase("regione"))
//			return REGIONE;
//		if(filterName.equalsIgnoreCase("fonteCodLocaleProg"))
//			return FONTECODLOCALEPROG;
//		if(filterName.equalsIgnoreCase("dimensione"))
//			return DIMENSIONE;
//		if(filterName.equalsIgnoreCase("tipologiaLavori"))
//			return TIPOLOGIALAVORI;
//		if(filterName.equalsIgnoreCase("numRecords"))
//			return NUMRECORDS;
//		if(filterName.equalsIgnoreCase("ordinaPer"))
//			return ORDINAPER;
//		return 0;
//	}
//	
//	public void getFilter(Map<String,String> allRequestParams,Filter filter) throws Exception{
//		
//		Iterator<Map.Entry<String,String>> entryList = null;
//		Entry entry = null;
//		
//		try{
//			if(!allRequestParams.isEmpty()){
//				entryList = allRequestParams.entrySet().iterator();
//				while(entryList.hasNext()){
//					entry = entryList.next();
//					switch (getFilterNameIntValue(entry.getKey().toString())) {
//					
//					case CUP:
//						if(filter.getCup() == null)
//							filter.setCup((String)entry.getValue());						
//						break;
//						
//					case CIG:
//						if(filter.getCig() == null)
//							filter.setCig((String)entry.getValue());						
//						break;
//						
////					case SOGGETTO:
////						if(filter.getSoggetto() == null)
////							filter.setSoggetto((String)entry.getValue());	
////						break;
//						
//					case FORMAGIURIDICA:
//						if(filter.getFormaGiuridica() == null)
//							filter.setFormaGiuridica((String)entry.getValue());	
//						break;
//						
//					case SETTORE:
//						if(filter.getSettore() == null)
//							filter.setSettore((String)entry.getValue());	
//						break;
//						
//					case SOTTOSETTORE:
//						if(filter.getSottoSettore() == null)
//							filter.setSottoSettore((String)entry.getValue());	
//						break;
//						
//					case CATEGORIA:
//						if(filter.getCategoria() == null)
//							filter.setCategoria((String)entry.getValue());	
//						break;
//						
//					case REGIONE:
//						if(filter.getRegione() == null)
//							filter.setRegione((String)entry.getValue());	
//						break;
//						
//					case FONTECODLOCALEPROG:
//						if(filter.getFonteCodLocaleProg() == null)
//							filter.setFonteCodLocaleProg((String)entry.getValue());	
//						break;
//						
//					case DIMENSIONE:
//						if(filter.getDimensione() == null)
//							filter.setDimensione((String)entry.getValue());	
//						break;
//						
//					case TIPOLOGIALAVORI:
//						if(filter.getTipologiaLavori() == null)
//							filter.setTipologiaLavori((String)entry.getValue());	
//						break;
//						
//					case NUMRECORDS:
//						if(filter.getNumRecords() == null)
//							filter.setNumRecords((String)entry.getValue());	
//						break;
//						
////					case ORDINAPER:
////						if(filter.getOrdinaPer() == null)
////							filter.setOrdinaPer((String)entry.getValue());	
////						break;
//=======
public class UtilityClass implements IUtilityClass, IResourceName, IFilterName {


    private static final Logger log = LoggerFactory.getLogger(UtilityClass.class);

    @Autowired
    IUtilityClass utilityClass;

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

                        case SOGGETTO:
                            filter.setSoggetto((String) entry.getValue());
                            break;

                        case FORMAGIURIDICA:
                            filter.setFormaGiuridica((String) entry.getValue());
                            break;

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
                            filter.setNumRecords((Integer) entry.getValue());
                            break;

//                        case ORDINAPER:
//                            filter.setOrdinaPer((String) entry.getValue());
//                            break;

                        default:
//						ErrorMessage error = new ErrorMessage("001","Prova");
                            throw new FilterNotFoundException();
                    }
                }
            }

            return filter;
        } catch (FilterNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }

    }

}
