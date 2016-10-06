package com.bruno.utils;

import javax.servlet.http.HttpServletRequest;

import com.bruno.exception.InternalServerErrorException;

public interface IUtilityClass {
	
	int getResourceNameIntValue(String resourceName) throws InternalServerErrorException;
	int getFilterNameIntValue(String resourceName) throws InternalServerErrorException;
	String getBaseUrl(HttpServletRequest request) throws InternalServerErrorException;

}
