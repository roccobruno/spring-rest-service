package com.bruno.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bruno.model.Filter;

public class UtilityClass implements IUtilityClass,ResourceName{
	
	private static final Logger log = LoggerFactory.getLogger(UtilityClass.class);
	
	public int getResourceNameInt(String resourceName){
		
		if(resourceName.equalsIgnoreCase("pagamenti"))
			return PAGAMENTI;
		else if(resourceName.equalsIgnoreCase("impegni"))
			return IMPEGNI;
		return 0;
	}
	
	public void getFilter(Map<String,String> allRequestParams,Filter filter){
		
	}

}
