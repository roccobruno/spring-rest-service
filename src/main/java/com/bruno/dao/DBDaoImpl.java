package com.bruno.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.bruno.model.Filter;
import com.bruno.utils.FlexibleQuery;
import com.bruno.utils.QueryBuilder;

@Component
public class DBDaoImpl implements IDBDao {

    private static final Logger log = LoggerFactory.getLogger(DBDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactoryMopWS;

    @Override
    public void insert(Object bean) {
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
    public void insertOrUpdate(Object bean) {
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
    public void update(Object bean) {
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
    public void delete(Object bean) {
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
    public List<Object> genericquery(String queryString) {
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
    public List<Object> findAll(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
	log.info("Start DBDaoImpl.findAll method");
	try {
	    List<Object> list = sessionFactoryMopWS.getCurrentSession().createQuery("from " + beanName).list();
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
    public List<Object> getBy(Filter filter)  {
    	
    	Query query = getNamedQuery("IstanzeHO.get");
		QueryBuilder queryBuilder = new QueryBuilder();
		queryBuilder.append(query.getQueryString());
		queryBuilder.append(" where ");
		queryBuilder.append(" 1=1 ");
		
		
		queryBuilder.append(" and ist.idCom.id = :numeroAccertamento ", filter.getNumeroAccertamento());
		queryBuilder.append(" and ist.idCom.nomeCoop = :nomeCooperativa ", filter.getNomeCooperativa());
		queryBuilder.append(" and ist.idCom.codiceFiscale = :codiceFiscale ", filter.getCodiceFiscale());
		queryBuilder.append(" and ist.idAccert.codiceTributo = :codTributo ", filter.getCodiceTributo());
		queryBuilder.append(" and ist.idAccert.annoTributo = :annoTributo ", filter.getAnnoTributo());
		queryBuilder.append(" and ist.idCom.dtProt >= :dataDa ", filter.getDataDa());
		queryBuilder.append(" and ist.idCom.dtProt <= :dataA ", filter.getDataA());
		queryBuilder.append(" and ist.idAccert.idAssegnatario = :idAssegnatario ", filter.getIdAssegnatario());
		queryBuilder.append(" and ist.tipo = :tipoIstanza ", filter.getTipoIstanza());
		queryBuilder.append(" and ist.stato = :statoIstanza ", filter.getStatoIstanza());
		queryBuilder.append(" and ist.idAccert.tipo.id = 3 ", filter.isIstanzaSpontanea());
		queryBuilder.append(" ORDER BY ist.id desc ");
//
		FlexibleQuery flex = createFlexibleQuery(queryBuilder);
		flex.setString("nomeCooperativa", filter.getNomeCooperativa());
		flex.setLong("numeroAccertamento", filter.getNumeroAccertamento());
		flex.setString("codiceFiscale", filter.getCodiceFiscale());
		flex.setString("codTributo", filter.getCodiceTributo());
		flex.setLong("annoTributo", filter.getAnnoTributo());
		flex.setCalendar("dataDa", filter.getDataDa());
		flex.setCalendar("dataA", filter.getDataA());
		flex.setLong("idAssegnatario", filter.getIdAssegnatario());
		flex.setLong("tipoIstanza", filter.getTipoIstanza());
		flex.setLong("statoIstanza", filter.getStatoIstanza());
		
		return flex.list();

    }
    
    protected FlexibleQuery createFlexibleQuery(QueryBuilder query) {
		return new FlexibleQuery(sessionFactoryMopWS.getCurrentSession().createQuery(query.toString()));
	}
    
    protected Query getNamedQuery(String queryName) {
		return sessionFactoryMopWS.getCurrentSession().getNamedQuery(queryName);
	}
}