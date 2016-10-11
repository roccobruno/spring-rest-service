package com.bruno.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bruno.exception.ControllerException;
import com.bruno.exception.InternalServerErrorException;
import com.bruno.model.filter.Filter;

public interface IUtilityClass {
	
	int getResourceNameIntValue(String resourceName) throws InternalServerErrorException;
	int getFilterNameIntValue(String resourceName) throws InternalServerErrorException;
	String getBaseUrl(HttpServletRequest request) throws InternalServerErrorException;
	public Filter checkAndCreateFilter(Map<String, String> allRequestParams, String resourceName) throws ControllerException;

}
