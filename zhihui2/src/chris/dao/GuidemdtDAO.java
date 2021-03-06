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
import chris.pojo.Guidemdt;

/**
 	* A data access object (DAO) providing persistence and search support for Guidemdt entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see chris.pojo.Guidemdt
  * @author MyEclipse Persistence Tools 
 */
@Service("GuidemdtDAO")
public class GuidemdtDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(GuidemdtDAO.class);
		//property constants
	public static final String SUTINFO = "sutinfo";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Guidemdt transientInstance) {
        log.debug("saving Guidemdt instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Guidemdt persistentInstance) {
        log.debug("deleting Guidemdt instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Guidemdt findById( java.lang.Integer id) {
        log.debug("getting Guidemdt instance with id: " + id);
        try {
            Guidemdt instance = (Guidemdt) getHibernateTemplate()
                    .get("chris.pojo.Guidemdt", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Guidemdt> findByExample(Guidemdt instance) {
        log.debug("finding Guidemdt instance by example");
        try {
            List<Guidemdt> results = (List<Guidemdt>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Guidemdt instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Guidemdt as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Guidemdt> findBySutinfo(Object sutinfo
	) {
		return findByProperty(SUTINFO, sutinfo
		);
	}
	

	public List findAll() {
		log.debug("finding all Guidemdt instances");
		try {
			String queryString = "from Guidemdt";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List<Guidemdt> findBygnum(String gnum){
		Query query=getSession().createQuery("from Guidemdt g  where g.guidemid=? order by detaid");
		query.setString(0, gnum);
		return query.list();
	}
	
	public List<Guidemdt> findBygnum(int page,int rows,String gnum){
		Query query=getSession().createQuery("from Guidemdt g  where g.guidemid=? order by detaid");
		query.setString(0, gnum);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
    public Guidemdt merge(Guidemdt detachedInstance) {
        log.debug("merging Guidemdt instance");
        try {
            Guidemdt result = (Guidemdt) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Guidemdt instance) {
        log.debug("attaching dirty Guidemdt instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Guidemdt instance) {
        log.debug("attaching clean Guidemdt instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static GuidemdtDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (GuidemdtDAO) ctx.getBean("GuidemdtDAO");
	}
}