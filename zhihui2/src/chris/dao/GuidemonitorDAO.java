package chris.dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import chris.pojo.Guide;
import chris.pojo.Guidemonitor;

/**
 * A data access object (DAO) providing persistence and search support for
 * Guidemonitor entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see chris.pojo.Guidemonitor
 * @author MyEclipse Persistence Tools
 */
@Service("GuidemonitorDAO")
public class GuidemonitorDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(GuidemonitorDAO.class);
	// property constants
	public static final String MYDIR = "mydir";
	public static final String GUIDENAME = "guidename";
	public static final String GUIDEMACHINE = "guidemachine";

	protected void initDao() {
		// do nothing
	}

	public void save(Guidemonitor transientInstance) {
		log.debug("saving Guidemonitor instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Guidemonitor persistentInstance) {
		log.debug("deleting Guidemonitor instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Guidemonitor findById(java.lang.Integer id) {
		log.debug("getting Guidemonitor instance with id: " + id);
		try {
			Guidemonitor instance = (Guidemonitor) getHibernateTemplate().get(
					"chris.pojo.Guidemonitor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Guidemonitor> findByExample(Guidemonitor instance) {
		log.debug("finding Guidemonitor instance by example");
		try {
			List<Guidemonitor> results = (List<Guidemonitor>) getHibernateTemplate()
					.findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Guidemonitor instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Guidemonitor as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Guidemonitor> findByMydir(Object mydir) {
		return findByProperty(MYDIR, mydir);
	}

	public List<Guidemonitor> findByGuidename(Object guidename) {
		return findByProperty(GUIDENAME, guidename);
	}

	public List<Guidemonitor> findByGuidemachine(Object guidemachine) {
		return findByProperty(GUIDEMACHINE, guidemachine);
	}

	public List<Guidemonitor> findAll() {
		log.debug("finding all Guidemonitor instances");
		try {
			String queryString = "from Guidemonitor";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Guidemonitor merge(Guidemonitor detachedInstance) {
		log.debug("merging Guidemonitor instance");
		try {
			Guidemonitor result = (Guidemonitor) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Guidemonitor instance) {
		log.debug("attaching dirty Guidemonitor instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Guidemonitor instance) {
		log.debug("attaching clean Guidemonitor instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public List<Guidemonitor> findAll(int page,int rows){
		Query query=getSession().createQuery("from Guidemonitor order by gmtime desc");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
	public List<Guidemonitor> findByalite(String monitor_id,
			String monitor_name, int page, int rows){
		Query query=null;
		if(monitor_id!=null && monitor_name!=null &&monitor_id.length()>0 && monitor_name.length()>0 ){
			query=getSession().createQuery("from Guidemonitor where guidename=? and guidenum=? order by gmtime desc");
			query.setString(0,monitor_name);
			query.setString(1,monitor_id );
		}else if(monitor_id!=null && monitor_id.length()>0){
			 query=getSession().createQuery("from Guidemonitor where guidenum=? order by gmtime desc");
			query.setString(0,monitor_id);
		}else{
			 query=getSession().createQuery("from Guidemonitor where guidename=? order by gmtime desc");
			query.setString(0,monitor_name);
		}
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
	public List<Guidemonitor> findByalite(String monitor_id,
			String monitor_name){
		Query query=null;
		if(monitor_id!=null && monitor_name!=null){
			query=getSession().createQuery("from Guidemonitor where guidename=? and guidenum=? order by gmtime desc");
			query.setString(0,monitor_name);
			query.setString(1,monitor_id );
		}else if(monitor_id!=null){
			 query=getSession().createQuery("from Guidemonitor where guidenum=? order by gmtime desc");
			query.setString(0,monitor_id);
		}else{
			 query=getSession().createQuery("from Guidemonitor where guidename=? order by gmtime desc");
			query.setString(0,monitor_name);
		}
		return query.list();
	}
	
	public static GuidemonitorDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (GuidemonitorDAO) ctx.getBean("GuidemonitorDAO");
	}
}