package chris.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import chris.pojo.Area;
import chris.pojo.Guidegroup;

/**
 * A data access object (DAO) providing persistence and search support for
 * Guidegroup entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see chris.pojo.Guidegroup
 * @author MyEclipse Persistence Tools
 */
@Service("GuidegroupDAO")
public class GuidegroupDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(GuidegroupDAO.class);
	// property constants
	public static final String GNAME = "gname";

	protected void initDao() {
		// do nothing
	}

	public void save(Guidegroup transientInstance) {
		log.debug("saving Guidegroup instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Guidegroup persistentInstance) {
		log.debug("deleting Guidegroup instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Guidegroup findById(java.lang.Integer id) {
		log.debug("getting Guidegroup instance with id: " + id);
		try {
			Guidegroup instance = (Guidegroup) getHibernateTemplate().get(
					"chris.pojo.Guidegroup", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Guidegroup> findByExample(Guidegroup instance) {
		log.debug("finding Guidegroup instance by example");
		try {
			List<Guidegroup> results = (List<Guidegroup>) getHibernateTemplate()
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
		log.debug("finding Guidegroup instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Guidegroup as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Guidegroup> findByGname(Object gname) {
		return findByProperty(GNAME, gname);
	}

	public List<Guidegroup> findAll() {
		log.debug("finding all Guidegroup instances");
		try {
			String queryString = "from Guidegroup";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<Guidegroup> findAll(int page,int rows){
		Query query=getSession().createQuery("from Guidegroup");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
	public List<Guidegroup> findbyaid(int aid){
		Query query=getSession().createQuery("from Guidegroup g where g.area.aid=?");
		query.setInteger(0, aid);
		return query.list(); 
	}
	public Guidegroup merge(Guidegroup detachedInstance) {
		log.debug("merging Guidegroup instance");
		try {
			Guidegroup result = (Guidegroup) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Guidegroup instance) {
		log.debug("attaching dirty Guidegroup instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Guidegroup instance) {
		log.debug("attaching clean Guidegroup instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GuidegroupDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GuidegroupDAO) ctx.getBean("GuidegroupDAO");
	}
}