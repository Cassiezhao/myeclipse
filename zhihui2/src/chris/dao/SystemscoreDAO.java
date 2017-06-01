package chris.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import chris.pojo.Systemscore;

/**
 	* A data access object (DAO) providing persistence and search support for Systemscore entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see chris.pojo.Systemscore
  * @author MyEclipse Persistence Tools 
 */
@Service("SystemscoreDAO")
public class SystemscoreDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(SystemscoreDAO.class);
		//property constants
	public static final String WORKAGE1 = "workage1";
	public static final String WORKAGE2 = "workage2";
	public static final String WORKAGE3 = "workage3";
	public static final String PUTONG1 = "putong1";
	public static final String PUTONG2 = "putong2";
	public static final String PUTONG3 = "putong3";
	public static final String YUYAN = "yuyan";
	public static final String ZHENGSHU = "zhengshu";
	public static final String WEIZHIXINXI = "weizhixinxi";
	public static final String SHANGXIANSHIJIAN = "shangxianshijian";
	public static final String SXDD = "sxdd";
	public static final String SXCS = "sxcs";
	public static final String CTJJ = "ctjj";
	public static final String YKPJ = "ykpj";
	public static final String JWS = "jws";
	public static final String JWX = "jwx";
	public static final String JWZ = "jwz";
	public static final String JWY = "jwy";
	public static final String TEL = "tel";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Systemscore transientInstance) {
        log.debug("saving Systemscore instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Systemscore persistentInstance) {
        log.debug("deleting Systemscore instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Systemscore findById( java.lang.Integer id) {
        log.debug("getting Systemscore instance with id: " + id);
        try {
            Systemscore instance = (Systemscore) getHibernateTemplate()
                    .get("chris.pojo.Systemscore", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<Systemscore> findByExample(Systemscore instance) {
        log.debug("finding Systemscore instance by example");
        try {
            List<Systemscore> results = (List<Systemscore>) getHibernateTemplate().findByExample(instance); 
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Systemscore instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Systemscore as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<Systemscore> findByWorkage1(Object workage1
	) {
		return findByProperty(WORKAGE1, workage1
		);
	}
	
	public List<Systemscore> findByWorkage2(Object workage2
	) {
		return findByProperty(WORKAGE2, workage2
		);
	}
	
	public List<Systemscore> findByWorkage3(Object workage3
	) {
		return findByProperty(WORKAGE3, workage3
		);
	}
	
	public List<Systemscore> findByPutong1(Object putong1
	) {
		return findByProperty(PUTONG1, putong1
		);
	}
	
	public List<Systemscore> findByPutong2(Object putong2
	) {
		return findByProperty(PUTONG2, putong2
		);
	}
	
	public List<Systemscore> findByPutong3(Object putong3
	) {
		return findByProperty(PUTONG3, putong3
		);
	}
	
	public List<Systemscore> findByYuyan(Object yuyan
	) {
		return findByProperty(YUYAN, yuyan
		);
	}
	
	public List<Systemscore> findByZhengshu(Object zhengshu
	) {
		return findByProperty(ZHENGSHU, zhengshu
		);
	}
	
	public List<Systemscore> findByWeizhixinxi(Object weizhixinxi
	) {
		return findByProperty(WEIZHIXINXI, weizhixinxi
		);
	}
	
	public List<Systemscore> findByShangxianshijian(Object shangxianshijian
	) {
		return findByProperty(SHANGXIANSHIJIAN, shangxianshijian
		);
	}
	
	public List<Systemscore> findBySxdd(Object sxdd
	) {
		return findByProperty(SXDD, sxdd
		);
	}
	
	public List<Systemscore> findBySxcs(Object sxcs
	) {
		return findByProperty(SXCS, sxcs
		);
	}
	
	public List<Systemscore> findByCtjj(Object ctjj
	) {
		return findByProperty(CTJJ, ctjj
		);
	}
	
	public List<Systemscore> findByYkpj(Object ykpj
	) {
		return findByProperty(YKPJ, ykpj
		);
	}
	
	public List<Systemscore> findByJws(Object jws
	) {
		return findByProperty(JWS, jws
		);
	}
	
	public List<Systemscore> findByJwx(Object jwx
	) {
		return findByProperty(JWX, jwx
		);
	}
	
	public List<Systemscore> findByJwz(Object jwz
	) {
		return findByProperty(JWZ, jwz
		);
	}
	
	public List<Systemscore> findByJwy(Object jwy
	) {
		return findByProperty(JWY, jwy
		);
	}
	
	public List<Systemscore> findByTel(Object tel
	) {
		return findByProperty(TEL, tel
		);
	}
	

	public List findAll() {
		log.debug("finding all Systemscore instances");
		try {
			String queryString = "from Systemscore";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Systemscore merge(Systemscore detachedInstance) {
        log.debug("merging Systemscore instance");
        try {
            Systemscore result = (Systemscore) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Systemscore instance) {
        log.debug("attaching dirty Systemscore instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Systemscore instance) {
        log.debug("attaching clean Systemscore instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SystemscoreDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SystemscoreDAO) ctx.getBean("SystemscoreDAO");
	}
}