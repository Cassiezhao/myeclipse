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

import chris.pojo.Guidem;
import chris.pojo.Memory;

/**
 	* A data access object (DAO) providing persistence and search support for Memory entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see chris.pojo.Memory
  * @author MyEclipse Persistence Tools 
 */
@Service("MemoryDAO")
public class MemoryDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(MemoryDAO.class);
		//property constants
	public static final String MESSAGE = "message";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Memory transientInstance) {
        log.debug("saving Memory instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Memory persistentInstance) {
        log.debug("deleting Memory instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Memory findById( java.lang.Integer id) {
        log.debug("getting Memory instance with id: " + id);
        try {
            Memory instance = (Memory) getHibernateTemplate()
                    .get("chris.pojo.Memory", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Memory> findByExample(Memory instance) {
        log.debug("finding Memory instance by example");
        try {
            List<Memory> results = (List<Memory>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Memory instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Memory as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Memory> findByMessage(Object message
	) {
		return findByProperty(MESSAGE, message
		);
	}
	

	public List findAll() {
		log.debug("finding all Memory instances");
		try {
			String queryString = "from Memory";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List<Memory> findAll(int userid){
		Query query=getSession().createQuery("from Memory m  where  m.user.userpower=0 or m.user.userid=?");
		query.setInteger(0, userid);
		
		return query.list();
	}
	public List<Memory> findAll(int page,int rows,int userid){
		Query query=getSession().createQuery("from Memory m  where  m.user.userpower=0 or m.user.userid=?");
		query.setInteger(0, userid);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		
		return query.list();
	}
	
	public List<Memory> findAllname(int page,int rows,int userid,String a){
		Query query=getSession().createQuery("from Memory m  where m.opuser like '%"+a+"%' and (m.user.userpower=0 or m.user.userid=? ) " );
		query.setInteger(0, userid);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		
		return query.list();
	}
	
	public List<Memory> findAllname(int userid,String a){
		Query query=getSession().createQuery("from Memory m  where   m.opuser like '%"+a+"%' and( m.user.userpower=0 or m.user.userid=?)  ");
		query.setInteger(0, userid);
		
		return query.list();
	}
	
	public List<Memory> timechange(int userid,String before ,String later,int page,int rows){
		Query query=getSession().createQuery("from Memory m where m.mtime between ? and ?  and (m.user.userpower=0 or m.user.userid=?) order by mmid" );
		
		query.setString(0, before);
		query.setString(1, later);
		query.setInteger(2, userid);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	public List<Memory> timechange(int userid,String before ,String later){
		Query query=getSession().createQuery("from Memory m where m.mtime between ? and ?  and (m.user.userpower=0 or m.user.userid=? )order by mmid" );
		query.setString(0, before);
		query.setString(1, later);
		query.setInteger(2, userid);
		return query.list();
	}
	
	
	
	
    public Memory merge(Memory detachedInstance) {
        log.debug("merging Memory instance");
        try {
            Memory result = (Memory) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Memory instance) {
        log.debug("attaching dirty Memory instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Memory instance) {
        log.debug("attaching clean Memory instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static MemoryDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (MemoryDAO) ctx.getBean("MemoryDAO");
	}
}