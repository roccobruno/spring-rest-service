package com.bruno.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bruno.model.filter.Filter;
import com.bruno.utils.FlexibleQuery;
import com.bruno.utils.QueryBuilder;

@Component
public class DBDaoImpl implements IDBDao {

    private static final Logger log = LoggerFactory.getLogger(DBDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactoryMopWS;

    @Override
    public Object findbyId(String beanName, int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	log.info("Start DBDaoImpl.findbyId method");
	try {
	    Object tabellaCorrente = (Object) Class.forName(beanName).newInstance();
	    tabellaCorrente = (Object) sessionFactoryMopWS.getCurrentSession().get(tabellaCorrente.getClass(), id);
	    log.info("DBDaoImpl.findbyId successful");
	    return tabellaCorrente;
	} catch (RuntimeException re) {
	    log.error("DBDaoImpl.findbyId failed", re);
	    throw re;
	}
    }

    @Override
    public Object genericquery(String queryString) {
		log.info("Start DBDaoImpl.genericquery method");
		try {
		    Query query = sessionFactoryMopWS.getCurrentSession().createQuery(queryString);
		    log.info("DBDaoImpl.genericquery successful");
		    return query.list();
		} catch (RuntimeException re) {
		    log.error("DBDaoImpl.genericquery failed", re);
		    throw re;
		}
    }
    
    @Override
	public Long getCount(Filter filter, String resourceName) {
		String query = "Select count(*) FROM "+resourceName+" tab";
        FlexibleQuery flex = createFlexiQuery(filter, query);
		return (Long) flex.uniqueResult();
	}
    
    @Override
    public Object getResourceList(Filter filter,String resourceName)  {
    	
    	String query = "FROM "+resourceName+" tab";

        FlexibleQuery flex = createFlexiQuery(filter, query);
//		flex.setFirstResult((filter.getNumPagina() - 1) * filter.getNumRecordsForPage());
//		flex.setMaxResults(filter.getNumRecordsForPage());
		
		return flex.list();
    }

    private FlexibleQuery createFlexiQuery(Filter filter, String query) {
    	
    	filter.setSoggetto("80017210727");
    	QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.append(query);
		queryBuilder.append(" where ");
		queryBuilder.append(" 1=1 ");		
		
		queryBuilder.append(" and tab.cup = :cup ", filter.getCup());
		queryBuilder.append(" and tab.cig = :cig ", filter.getCig());
		queryBuilder.append(" and tab.soggetto = :soggetto ", filter.getSoggetto());
		queryBuilder.append(" and tab.formaGiuridica = :formaGiuridica ", filter.getFormaGiuridica());
		queryBuilder.append(" and tab.settore = :settore ", filter.getSettore());
		queryBuilder.append(" and tab.sottoSettore = :sottoSettore ", filter.getSottoSettore());		
		queryBuilder.append(" and tab.categoria = :categoria ", filter.getCategoria());
		queryBuilder.append(" and tab.regione = :regione ", filter.getRegione());
		queryBuilder.append(" and tab.fonteCodLocaleProg = :fonteCodLocaleProg ", filter.getFonteCodLocaleProg());
		queryBuilder.append(" and tab.dimensione = :dimensione ", filter.getDimensione());
		queryBuilder.append(" and tab.tipologiaLavori = :tipologiaLavori ", filter.getTipologiaLavori());
//		queryBuilder.append(" and rownum <= 100000");
		queryBuilder.append(" and rownum <= :numRecords  ", filter.getNumRecords());
		
		if(filter.getOrdinaPer() != null){
			queryBuilder.append(" order by tab."+filter.getOrdinaPer());
		}
		
		FlexibleQuery flex = createFlexibleQuery(queryBuilder);
		flex.setString("cup", filter.getCup());
		flex.setString("cig", filter.getCig());
		flex.setString("soggetto", filter.getSoggetto());
		flex.setString("formaGiuridica", filter.getFormaGiuridica());
		flex.setString("settore", filter.getSettore());
		flex.setString("sottoSettore", filter.getSottoSettore());		
		flex.setString("categoria", filter.getCategoria());
		flex.setString("regione", filter.getRegione());
		flex.setString("fonteCodLocaleProg", filter.getFonteCodLocaleProg());
		flex.setString("dimensione", filter.getDimensione());
		flex.setString("tipologiaLavori", filter.getTipologiaLavori());
		flex.setInteger("numRecords", filter.getNumRecords());

        return flex;
    }

    protected FlexibleQuery createFlexibleQuery(QueryBuilder query) {
		return new FlexibleQuery(sessionFactoryMopWS.getCurrentSession().createQuery(query.toString()));
	}
    
    protected Query getNamedQuery(String queryName) {
		return sessionFactoryMopWS.getCurrentSession().getNamedQuery(queryName);
	}
    
    protected Query createQuery(String queryString) {
		return sessionFactoryMopWS.getCurrentSession().createQuery(queryString);
	}
}
