package com.bruno.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilityClass implements IUtilityClass,ResourceName{
	
	private static final Logger log = LoggerFactory.getLogger(UtilityClass.class);
	
	public int getResourceNameInt(String resourceName){
		
		if(resourceName.equalsIgnoreCase("pagamenti"))
			return PAGAMENTI;
		else if(resourceName.equalsIgnoreCase("impegni"))
			return IMPEGNI;
		return 0;
	}

}
