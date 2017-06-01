package chris.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import chris.pojo.Youkem;

/**
 * A data access object (DAO) providing persistence and search support for
 * Youkem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see chris.pojo.Youkem
 * @author MyEclipse Persistence Tools
 */
@Service("YoukemDAO")
public class YoukemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(YoukemDAO.class);
	// property constants
	public static final String YOUKE_MLE = "youkeMle";
	public static final String YOUKE_MBR = "youkeMbr";

	protected void initDao() {
		// do nothing
	}

	public void save(Youkem transientInstance) {
		log.debug("saving Youkem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Youkem persistentInstance) {
		log.debug("deleting Youkem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Youkem findById(java.lang.Integer id) {
		log.debug("getting Youkem instance with id: " + id);
		try {
			Youkem instance = (Youkem) getHibernateTemplate().get(
					"chris.pojo.Youkem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Youkem> findByExample(Youkem instance) {
		log.debug("finding Youkem instance by example");
		try {
			List<Youkem> results = (List<Youkem>) getHibernateTemplate()
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
		log.debug("finding Youkem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Youkem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Youkem> findByYoukeMle(Object youkeMle) {
		return findByProperty(YOUKE_MLE, youkeMle);
	}

	public List<Youkem> findByYoukeMbr(Object youkeMbr) {
		return findByProperty(YOUKE_MBR, youkeMbr);
	}

	public List findAll() {
		log.debug("finding all Youkem instances");
		try {
			String queryString = "from Youkem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Youkem merge(Youkem detachedInstance) {
		log.debug("merging Youkem instance");
		try {
			Youkem result = (Youkem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Youkem instance) {
		log.debug("attaching dirty Youkem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Youkem instance) {
		log.debug("attaching clean Youkem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static YoukemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (YoukemDAO) ctx.getBean("YoukemDAO");
	}
}