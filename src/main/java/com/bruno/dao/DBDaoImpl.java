package com.bruno.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bruno.model.Filter;
import com.bruno.utils.FlexibleQuery;
import com.bruno.utils.QueryBuilder;

public abstract class DBDaoImpl<T, D> implements IDBDao<T, D> {

    private static final Logger log = LoggerFactory.getLogger(DBDaoImpl.class);

    protected Class<T> entityClass;

    public DBDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactoryMopWS;

    @Override
    public void insert(T bean) {
        log.info("Start DBDaoImpl.insert method");
        try {
            sessionFactoryMopWS.getCurrentSession().save(bean);
            log.info("DBDaoImpl.insert successful");
        } catch (RuntimeException re) {
            log.error("DBDaoImpl.insert failed", re);
            throw re;
        }
    }

    @Override
    public void insertOrUpdate(T bean) {
        log.info("Start DBDaoImpl.insertOrUpdate method");
        try {
            sessionFactoryMopWS.getCurrentSession().saveOrUpdate(bean);
            log.info("DBDaoImpl.insertOrUpdate successful");
        } catch (RuntimeException re) {
            log.error("DBDaoImpl.insertOrUpdate failed", re);
            throw re;
        }
    }

    @Override
    public void update(T bean) {
        log.info("Start DBDaoImpl.update method");
        try {
            sessionFactoryMopWS.getCurrentSession().update(bean);
            log.info("DBDaoImpl.update successful");
        } catch (RuntimeException re) {
            log.error("DBDaoImpl.update failed", re);
            throw re;
        }
    }

    @Override
    public void delete(T bean) {
        log.info("Start DBDaoImpl.delete method");
        try {
            sessionFactoryMopWS.getCurrentSession().delete(bean);
            log.info("DBDaoImpl.delete successful");
        } catch (RuntimeException re) {
            log.error("DBDaoImpl.delete failed", re);
            throw re;
        }
    }

    @Override
    public T findbyId(D id) throws InstantiationException, IllegalAccessException {
        log.info("Start DBDaoImpl.findbyId method");
        try {
            log.info("DBDaoImpl.findbyId successful");
            return (T) sessionFactoryMopWS.getCurrentSession().createCriteria(entityClass)
                    .add(Restrictions.eq("id", id)).uniqueResult();
        } catch (RuntimeException re) {
            log.error("DBDaoImpl.findbyId failed", re);
            throw re;
        }
    }

    @Override
    public List<T> genericquery(String queryString) {
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
    public List<T> findAll() throws InstantiationException, IllegalAccessException {
        log.info("Start DBDaoImpl.findAll method");
        try {
            List<T> list = sessionFactoryMopWS.getCurrentSession().createCriteria(entityClass).list();
            log.info("DBDaoImpl.findAll successful");
            return list;
        } catch (RuntimeException re) {
            log.error("DBDaoImpl.findAll failed", re);
            throw re;
        }
    }

    // public void persist(MopcAnagClassificazioniUrp transientInstance) {
    // log.debug("persisting MopcAnagClassificazioniUrp instance");
    // try {
    // sessionFactory.getCurrentSession().persist(transientInstance);
    // log.debug("persist successful");
    // } catch (RuntimeException re) {
    // log.error("persist failed", re);
    // throw re;
    // }
    // }
    //
    // public void attachClean(MopcAnagClassificazioniUrp instance) {
    // log.debug("attaching clean MopcAnagClassificazioniUrp instance");
    // try {
    // sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
    // log.debug("attach successful");
    // } catch (RuntimeException re) {
    // log.error("attach failed", re);
    // throw re;
    // }
    // }
    //
    //
    // public MopcAnagClassificazioniUrp merge(MopcAnagClassificazioniUrp
    // detachedInstance) {
    // log.debug("merging MopcAnagClassificazioniUrp instance");
    // try {
    // MopcAnagClassificazioniUrp result = (MopcAnagClassificazioniUrp)
    // sessionFactory
    // .getCurrentSession().merge(detachedInstance);
    // log.debug("merge successful");
    // return result;
    // } catch (RuntimeException re) {
    // log.error("merge failed", re);
    // throw re;
    // }
    // }
    //
    // public MopcAnagClassificazioniUrp findById(int id) {
    // log.debug("getting MopcAnagClassificazioniUrp instance with id: " + id);
    // try {
    // MopcAnagClassificazioniUrp instance = (MopcAnagClassificazioniUrp)
    // sessionFactory
    // .getCurrentSession().get("MopcAnagClassificazioniUrp", id);
    // if (instance == null) {
    // log.debug("get successful, no instance found");
    // } else {
    // log.debug("get successful, instance found");
    // }
    // return instance;
    // } catch (RuntimeException re) {
    // log.error("get failed", re);
    // throw re;
    // }
    // }
    //
    // public List findByExample(MopcAnagClassificazioniUrp instance) {
    // log.debug("finding MopcAnagClassificazioniUrp instance by example");
    // try {
    // List results = sessionFactory.getCurrentSession()
    // .createCriteria("MopcAnagClassificazioniUrp")
    // .add(Example.create(instance)).list();
    // log.debug("find by example successful, result size: "
    // + results.size());
    // return results;
    // } catch (RuntimeException re) {
    // log.error("find by example failed", re);
    // throw re;
    // }
    // }

    @Override
    public List<T> getResourceList(Filter filter,String resourceName)  {
    	
    	String query = "FROM "+resourceName+" tab";
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
		queryBuilder.append(" and tab.numRecords = :numRecords ", filter.getNumRecords());
		queryBuilder.append(" and tab.ordinaPer = :ordinaPer ", filter.getOrdinaPer());
		
		queryBuilder.append(" and rownum <= 10");
//
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
		flex.setString("numRecords", filter.getNumRecords());
		flex.setString("ordinaPer", filter.getOrdinaPer());
		
		return flex.list();
    }

    protected FlexibleQuery createFlexibleQuery(QueryBuilder query) {
        return new FlexibleQuery(sessionFactoryMopWS.getCurrentSession().createQuery(query.toString()));
    }

    protected Query getNamedQuery(String queryName) {
        return sessionFactoryMopWS.getCurrentSession().getNamedQuery(queryName);
    }
}
