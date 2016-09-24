package com.bruno.utils;

import javax.servlet.http.HttpServletRequest;

public interface IUtilityClass {
	
	int getResourceNameIntValue(String resourceName);
	int getFilterNameIntValue(String resourceName);
	String getBaseUrl(HttpServletRequest request);

}
