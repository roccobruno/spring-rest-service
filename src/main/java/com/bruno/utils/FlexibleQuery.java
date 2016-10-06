package com.bruno.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.MappingException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;


public class FlexibleQuery {

	protected Query query;
	protected Query queryCount;
	
	public FlexibleQuery(Query query) {

		this.query = query;
	}

	private boolean isNotEmpty(Object o){
		return (o!=null) && (!o.toString().trim().equals(""));
	}

	private boolean isNotEmptyCollection(Collection<?> o){
		return (o!=null) && (!o.isEmpty());
	}

	private boolean isNotEmptyArray(Object[] o){
		return (o!=null) && (o.length > 0);
	}


	public int executeUpdate() throws HibernateException {

		return query.executeUpdate();
	}



	public String[] getReturnAliases() throws HibernateException {

		return query.getReturnAliases();
	}


	public Type[] getReturnTypes() throws HibernateException {

		return query.getReturnTypes();
	}



	@SuppressWarnings("rawtypes")
	public Iterator iterate() throws HibernateException {

		return query.iterate();
	}



	@SuppressWarnings("rawtypes")
	public List list() throws HibernateException {
		return query.list();
		}


	public ScrollableResults scroll() throws HibernateException {

		return query.scroll();
	}


	public ScrollableResults scroll(ScrollMode scrollMode)
			throws HibernateException {

		return query.scroll(scrollMode);
	}


	public FlexibleQuery setLockMode(String alias, LockMode lockMode) {

		{query.setLockMode(alias, lockMode);
		if(queryCount != null) {
			queryCount.setLockMode(alias, lockMode);}
		}
		return this;
	}



	public String[] getNamedParameters() throws HibernateException {

		return query.getNamedParameters();
	}
	
//	public FlexibleQuery(Query query, Query queryCount, PaginatorUpdater pUpdater) {
//		this.query = query;
//		this.queryCount = queryCount;
//		this.pUpdater=pUpdater;
//		this.pdata = new PaginatorData(pUpdater.getCurrentPage(), pUpdater.getpageSize());
//	}

	public FlexibleQuery setBigDecimal(int position, BigDecimal number) {
		if (isNotEmpty(number)) {query.setBigDecimal(position, number);
		if(queryCount != null) {
			queryCount.setBigDecimal(position, number);}
		} 
		return this;
	}


	public FlexibleQuery setBigDecimal(String name, BigDecimal number) {

		if (isNotEmpty(number)) {query.setBigDecimal(name, number);
		if(queryCount != null) {
			queryCount.setBigDecimal(name, number);}
		}
		return this;
	}


	public FlexibleQuery setBigInteger(int position, BigInteger number) {

		if (isNotEmpty(number)) {query.setBigInteger(position, number);
		if(queryCount != null) {
			queryCount.setBigInteger(position, number);}
		}
		return this;
	}


	public FlexibleQuery setBigInteger(String name, BigInteger number) {

		if (isNotEmpty(number)) {query.setBigInteger(name, number);
		if(queryCount != null) {
			queryCount.setBigInteger(name, number);}
		}
		return this;
	}


	public FlexibleQuery setBinary(int position, byte[] val) {

		if (isNotEmpty(val)) {query.setBinary(position, val);
		if(queryCount != null) {
			queryCount.setBinary(position, val);}
		}
		return this;
	}


	public FlexibleQuery setBinary(String name, byte[] val) {

		if (isNotEmpty(val)) {query.setBinary(name, val);
		if(queryCount != null) {
			queryCount.setBinary(name, val);}
		}
		return this;
	}




	public FlexibleQuery setBoolean(int position, Boolean val) {
		if (isNotEmpty(val)) {query.setBoolean(position, val);
		if(queryCount != null) {
			queryCount.setBoolean(position, val);}
		}
		return this;
	}



	public FlexibleQuery setBoolean(String name, Boolean val) {
		if (isNotEmpty(val)) {query.setBoolean(name, val);
		if(queryCount != null) {
			queryCount.setBoolean(name, val);}
		}
		return this;
	}





	public FlexibleQuery setByte(int position, Byte val) {

		if (isNotEmpty(val)) {query.setByte(position, val);
		if(queryCount != null) {
			queryCount.setByte(position, val);}
		}
		return this;
	}


	public FlexibleQuery setByte(String name, Byte val) {

		if (isNotEmpty(val)) {query.setByte(name, val);
		if(queryCount != null) {
			queryCount.setByte(name, val);}
		}
		return this;
	}

	public FlexibleQuery setCacheMode(CacheMode cacheMode) {

		{query.setCacheMode(cacheMode);
		if(queryCount != null) {
			queryCount.setCacheMode(cacheMode);}
		}
		return this;
	}


	public FlexibleQuery setCacheRegion(String cacheRegion) {

		{query.setCacheRegion(cacheRegion);
		if(queryCount != null) {
			queryCount.setCacheRegion(cacheRegion);}
		}
		return this;
	}


	public FlexibleQuery setCacheable(boolean cacheable) {

		{query.setCacheable(cacheable);
		if(queryCount != null) {
			queryCount.setCacheable(cacheable);}
		}
		return this;
	}


	public FlexibleQuery setCalendar(int position, Calendar calendar) {

		if (isNotEmpty(calendar)) {query.setCalendar(position, calendar);
		if(queryCount != null) {
			queryCount.setCalendar(position, calendar);}
		}
		return this;
	}


	public FlexibleQuery setCalendar(String name, Calendar calendar) {

		if (isNotEmpty(calendar)) {query.setCalendar(name, calendar);
		if(queryCount != null) {
			queryCount.setCalendar(name, calendar);}
		}
		return this;
	}


	public FlexibleQuery setCalendarDate(int position, Calendar calendar) {

		if (isNotEmpty(calendar)) {query.setCalendarDate(position, calendar);
		if(queryCount != null) {
			queryCount.setCalendarDate(position, calendar);}
		}
		return this;
	}


	public FlexibleQuery setCalendarDate(String name, Calendar calendar) {

		if (isNotEmpty(calendar)) {query.setCalendarDate(name, calendar);
		if(queryCount != null) {
			queryCount.setCalendarDate(name, calendar);}
		}
		return this;
	}





	public FlexibleQuery setCharacter(int position, Character val) {

		if (isNotEmpty(val)) {query.setCharacter(position, val);
		if(queryCount != null) {
			queryCount.setCharacter(position, val);}
		}
		return this;
	}


	public FlexibleQuery setCharacter(String name, Character val) {

		if (isNotEmpty(val)) {query.setCharacter(name, val);
		if(queryCount != null) {
			queryCount.setCharacter(name, val);}
		}
		return this;
	}


	public FlexibleQuery setComment(String comment) {

		{query.setComment(comment);
		if(queryCount != null) {
			queryCount.setComment(comment);}
		}
		return this;
	}


	public FlexibleQuery setDate(int position, Date date) {

		if (isNotEmpty(date)) {query.setDate(position, date);
		if(queryCount != null) {
			queryCount.setDate(position, date);}
		}
		return this;
	}


	public FlexibleQuery setDate(String name, Date date) {

		if (isNotEmpty(date)) {query.setDate(name, date);
		if(queryCount != null) {
			queryCount.setDate(name, date);}
		}
		return this;
	}



	public FlexibleQuery setDouble(int position, Double val) {

		if (isNotEmpty(val)) {query.setDouble(position, val);
		if(queryCount != null) {
			queryCount.setDouble(position, val);}
		}
		return this;
	}

	public FlexibleQuery setDouble(String name, Double val) {

		if (isNotEmpty(val)) {query.setDouble(name, val);
		if(queryCount != null) {
			queryCount.setDouble(name, val);}
		}
		return this;
	}

	public FlexibleQuery setEntity(int position, Object val) {

		if (isNotEmpty(val)) {query.setEntity(position, val);
		if(queryCount != null) {
			queryCount.setEntity(position, val);}
		}
		return this;
	}


	public FlexibleQuery setEntity(String name, Object val) {

		if (isNotEmpty(val)) {query.setEntity(name, val);
		if(queryCount != null) {
			queryCount.setEntity(name, val);}
		}
		return this;
	}


	public FlexibleQuery setFetchSize(int fetchSize) {

		{query.setFetchSize(fetchSize);
		if(queryCount != null) {
			queryCount.setFetchSize(fetchSize);}
		}
		return this;
	}


	public FlexibleQuery setFirstResult(int firstResult) {

		{query.setFirstResult(firstResult);
		if(queryCount != null) {
			queryCount.setFirstResult(firstResult);}
		}
		return this;
	}




	public FlexibleQuery setFloat(int position, Float val) {

		if (isNotEmpty(val)) {query.setFloat(position, val);
		if(queryCount != null) {
			queryCount.setFloat(position, val);}
		}
		return this;
	}


	public FlexibleQuery setFloat(String name, Float val) {

		if (isNotEmpty(val)) {query.setFloat(name, val);
		if(queryCount != null) {
			queryCount.setFloat(name, val);}
		}
		return this;
	}

	public FlexibleQuery setFlushMode(FlushMode flushMode) {

		{query.setFlushMode(flushMode);
		if(queryCount != null) {
			queryCount.setFlushMode(flushMode);}
		}
		return this;
	}




	public FlexibleQuery setInteger(int position, Integer val) {

		if (isNotEmpty(val)) {query.setInteger(position, val);
		if(queryCount != null) {
			queryCount.setInteger(position, val);}
		}
		return this;
	}


	public FlexibleQuery setInteger(String name, Integer val) {

		if (isNotEmpty(val)) {query.setInteger(name, val);
		if(queryCount != null) {
			queryCount.setInteger(name, val);}
		}
		return this;
	}

	public FlexibleQuery setLocale(int position, Locale locale) {

		{query.setLocale(position, locale);
		if(queryCount != null) {
			queryCount.setLocale(position, locale);}
		}
		return this;
	}


	public FlexibleQuery setLocale(String name, Locale locale) {

		{query.setLocale(name, locale);
		if(queryCount != null) {
			queryCount.setLocale(name, locale);}
		}
		return this;
	}




	public FlexibleQuery setLong(int position, Long val) {

		if (isNotEmpty(val)) {query.setLong(position, val);
		if(queryCount != null) {
			queryCount.setLong(position, val);}
		}
		return this;
	}


	public FlexibleQuery setLong(String name, Long val) {

		if (isNotEmpty(val)) {query.setLong(name, val);
		if(queryCount != null) {
			queryCount.setLong(name, val);}
		}
		return this;
	}

	public FlexibleQuery setMaxResults(int maxResults) {

		{query.setMaxResults(maxResults);
		if(queryCount != null) {
			queryCount.setMaxResults(maxResults);}
		}
		return this;
	}



	public FlexibleQuery setParameter(int position, Object val)
			throws HibernateException {

		if (isNotEmpty(val)) {query.setParameter(position, val);
		if(queryCount != null) {
			queryCount.setParameter(position, val);}
		}
		return this;
	}


	public FlexibleQuery setParameter(String name, Object val)
			throws HibernateException {

		if (isNotEmpty(val)) {query.setParameter(name, val);
		if(queryCount != null) {
			queryCount.setParameter(name, val);}
		}
		return this;
	}


	public FlexibleQuery setParameter(int arg0, Object val, Type arg2) {

		if (isNotEmpty(val)) {query.setParameter(arg0, val, arg2);
		if(queryCount != null) {
			queryCount.setParameter(arg0, val, arg2);}
		}
		return this;
	}


	public FlexibleQuery setParameter(String name, Object val, Type type) {

		if (isNotEmpty(val)) {query.setParameter(name, val, type);
		if(queryCount != null) {
			queryCount.setParameter(name, val, type);}
		}
		return this;
	}



	@SuppressWarnings("rawtypes")
	public FlexibleQuery setParameterList(String name, Collection vals)
			throws HibernateException {

		if (isNotEmptyCollection(vals)){query.setParameterList(name, vals);
		if(queryCount != null) {
			queryCount.setParameterList(name, vals);}
		}
		return this;
	}


	public FlexibleQuery setParameterList(String name, Object[] vals)
			throws HibernateException {

		if (isNotEmptyArray(vals)){query.setParameterList(name, vals);
		if(queryCount != null) {
			queryCount.setParameterList(name, vals);}
		}
		return this;
	}



	@SuppressWarnings("rawtypes")
	public FlexibleQuery setParameterList(String name, Collection vals, Type type)
			throws HibernateException {

		if (isNotEmptyCollection(vals)){query.setParameterList(name, vals, type);
		if(queryCount != null) {
			queryCount.setParameterList(name, vals, type);}
		}
		return this;
	}


	public FlexibleQuery setParameterList(String name, Object[] vals, Type type)
			throws HibernateException {

		if (isNotEmptyArray(vals)){query.setParameterList(name, vals, type);
		if(queryCount != null) {
			queryCount.setParameterList(name, vals, type);}
		}
		return this;
	}


	public FlexibleQuery setParameters(Object[] values, Type[] types) {

		{query.setParameters(values, types);
		if(queryCount != null) {
			queryCount.setParameters(values, types);}
		}
		return this;
	}



	@SuppressWarnings("rawtypes")
	public FlexibleQuery setProperties(Map arg0) throws HibernateException {
		{query.setProperties(arg0);
		if(queryCount != null) {
			queryCount.setProperties(arg0);}
		}
		return this;
	}


	public FlexibleQuery setProperties(Object arg0) throws HibernateException {

		{query.setProperties(arg0);
		if(queryCount != null) {
			queryCount.setProperties(arg0);}
		}
		return this;
	}


	public FlexibleQuery setReadOnly(boolean readOnly) {

		{query.setReadOnly(readOnly);
		if(queryCount != null) {
			queryCount.setReadOnly(readOnly);}
		}
		return this;
	}


	public FlexibleQuery setResultTransformer(ResultTransformer transformer) {

		query.setResultTransformer(transformer);
		return this;
	}


	public FlexibleQuery setSerializable(int position, Serializable val) {

		{query.setSerializable(position, val);
		if(queryCount != null) {
			queryCount.setSerializable(position, val);}
		}
		return this;
	}


	public FlexibleQuery setSerializable(String name, Serializable val) {

		{query.setSerializable(name, val);
		if(queryCount != null) {
			queryCount.setSerializable(name, val);}
		}
		return this;
	}



	public FlexibleQuery setShort(int position, Short val) {

		if (isNotEmpty(val)) {query.setShort(position, val);
		if(queryCount != null) {
			queryCount.setShort(position, val);}
		}
		return this;
	}

	public FlexibleQuery setShort(String name, Short val) {

		if (isNotEmpty(val)) {query.setShort(name, val);
		if(queryCount != null) {
			queryCount.setShort(name, val);}
		}
		return this;
	}



	public FlexibleQuery setString(int position, String val) {

		if (isNotEmpty(val)) {query.setString(position, val);
		if(queryCount != null) {
			queryCount.setString(position, val);}
		}
		return this;
	}


	public FlexibleQuery setString(String name, String val) {

		if (isNotEmpty(val)) {query.setString(name, val);
		if(queryCount != null) {
			queryCount.setString(name, val);}
		}
		return this;
	}


	public FlexibleQuery setText(int position, String val) {

		if (isNotEmpty(val)) {query.setText(position, val);
		if(queryCount != null) {
			queryCount.setText(position, val);}
		}
		return this;
	}


	public FlexibleQuery setText(String name, String val) {

		if (isNotEmpty(val)) {query.setText(name, val);
		if(queryCount != null) {
			queryCount.setText(name, val);}
		}
		return this;
	}


	public FlexibleQuery setTime(int position, Date date) {

		if (isNotEmpty(date)) {query.setTime(position, date);
		if(queryCount != null) {
			queryCount.setTime(position, date);}
		}
		return this;
	}


	public FlexibleQuery setTime(String name, Date date) {

		if (isNotEmpty(date)) {query.setTime(name, date);
		if(queryCount != null) {
			queryCount.setTime(name, date);}
		}
		return this;
	}


	public FlexibleQuery setTimeout(int timeout) {

		{query.setTimeout(timeout);
		if(queryCount != null) {
			queryCount.setTimeout(timeout);}
		}
		return this;
	}


	public FlexibleQuery setTimestamp(int position, Date date) {

		if (isNotEmpty(date)) {query.setTimestamp(position, date);
		if(queryCount != null) {
			queryCount.setTimestamp(position, date);}
		}
		return this;
	}


	public FlexibleQuery setTimestamp(String name, Date date) {

		if (isNotEmpty(date)) {query.setTimestamp(name, date);
		if(queryCount != null) {
			queryCount.setTimestamp(name, date);}
		}
		return this;
	}


	public String toString() {

		return query.toString();
	}




	public Object uniqueResult() throws HibernateException {

		return query.uniqueResult();
	}




	public boolean equals(Object obj) {

		return query.equals(obj);
	}




	public int hashCode() {

		return query.hashCode();
	}





	public String getQueryString() {

		return query.getQueryString();
	}

	public FlexibleQuery addEntity(String entityName) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addEntity(entityName);
			if(queryCount != null) {
				((SQLQuery)queryCount).addEntity(entityName);}
			}
		}
		return this;
	}

	public FlexibleQuery addEntity(Class<?> entityClass) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addEntity(entityClass);
			if(queryCount != null) {
				((SQLQuery)queryCount).addEntity(entityClass);}
			}
		}
		return this;
	}

	public FlexibleQuery addEntity(String alias, String entityName) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addEntity(alias, entityName);
			if(queryCount != null) {
				((SQLQuery)queryCount).addEntity(alias, entityName);}
			}
		}
		return this;
	}


	public FlexibleQuery addEntity(String alias, Class<?> entityClass) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addEntity(alias, entityClass);
			if(queryCount != null) {
				((SQLQuery)queryCount).addEntity(alias, entityClass);}
			}
		}
		return this;
	}


	public FlexibleQuery addEntity(String alias, String entityName, LockMode lockMode) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addEntity(alias, entityName, lockMode);
			if(queryCount != null) {
				((SQLQuery)queryCount).addEntity(alias, entityName, lockMode);}
			}
		}
		return this;
	}


	public FlexibleQuery addEntity(String alias, Class<?> entityClass, LockMode lockMode) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addEntity(alias, entityClass, lockMode);
			if(queryCount != null) {
				((SQLQuery)queryCount).addEntity(alias, entityClass, lockMode);}
			}
		}
		return this;
	}


	public FlexibleQuery addJoin(String alias, String path) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addJoin(alias, path);
			if(queryCount != null) {
				((SQLQuery)queryCount).addJoin(alias, path);}
			}
		}
		return this;
	}


	public FlexibleQuery addJoin(String alias, String path, LockMode lockMode) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addJoin(alias, path, lockMode);
			if(queryCount != null) {
				((SQLQuery)queryCount).addJoin(alias, path, lockMode);}
			}
		}
		return this;
	}


	public FlexibleQuery addScalar(String columnAlias) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addScalar(columnAlias);
			if(queryCount != null) {
				((SQLQuery)queryCount).addScalar(columnAlias);}
			}
		}
		return this;
	}


	public FlexibleQuery addScalar(String columnAlias, Type type) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addScalar(columnAlias, type);
			if(queryCount != null) {
				((SQLQuery)queryCount).addScalar(columnAlias, type);}
			}
		}
		return this;
	}


	public FlexibleQuery addSynchronizedEntityClass(Class<?> entityClass)
			throws MappingException {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addSynchronizedEntityClass(entityClass);
			if(queryCount != null) {
				((SQLQuery)queryCount).addSynchronizedEntityClass(entityClass);}
			}
		}
		return this;
	}


	public FlexibleQuery addSynchronizedEntityName(String entityName)
			throws MappingException {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addSynchronizedEntityName(entityName);
			if(queryCount != null) {
				((SQLQuery)queryCount).addSynchronizedEntityName(entityName);}
			}
		}
		return this;
	}


	public FlexibleQuery addSynchronizedQuerySpace(String querySpace) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).addSynchronizedQuerySpace(querySpace);
			if(queryCount != null) {
				((SQLQuery)queryCount).addSynchronizedQuerySpace(querySpace);}
			}
		}
		return this;
	}


	public FlexibleQuery setResultSetMapping(String name) {
		if (query instanceof SQLQuery) {
			{((SQLQuery)query).setResultSetMapping(name);
			}
		}
		return this;
	}




}
