package com.bruno.utils;

import java.util.Collection;

public class QueryBuilder {

	
	private StringBuffer sb;
	
	public QueryBuilder(){
		sb=new StringBuffer();
	}
	
	public void append(String s){
		sb.append(s);
	}
	public void append(String s, boolean condition){
		if (condition){
			sb.append(s);
		}
	}
	public void append(String s, Object nullable){
		if ( (nullable!=null) && (!nullable.toString().trim().equals("")) ){
			sb.append(s);
		}
	}
	public void append(String s, Collection<?> nullable){
		if ( (nullable!=null) && (nullable.size() > 0) ){
			sb.append(s);
		}
	}
	@Override
	public String toString() {
		return sb.toString();
	}
	
}
