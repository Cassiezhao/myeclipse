package chris.dao;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import chris.pojo.Guidem;
import chris.pojo.Session;
import chris.pojo.Total;

/**
 * A data access object (DAO) providing persistence and search support for
 * Session entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see chris.pojo.Session
 * @author MyEclipse Persistence Tools
 */
@Service("SessionDAO")
public class SessionDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SessionDAO.class);
	// property constants
	public static final String STATE = "state";
	public static final String SCORE = "score";
	public static final String INFO = "info";
	public static final String PERSON = "person";
	public static final String ONLINE_P = "onlineP";
	public static final String UPLINE_P = "uplineP";

	protected void initDao() {
		// do nothing
	}

	public void save(Session transientInstance) {
		log.debug("saving Session instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Session persistentInstance) {
		log.debug("deleting Session instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Session findById(java.lang.Integer id) {
		log.debug("getting Session instance with id: " + id);
		try {
			Session instance = (Session) getHibernateTemplate().get(
					"chris.pojo.Session", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Session> findByExample(Session instance) {
		log.debug("finding Session instance by example");
		try {
			List<Session> results = (List<Session>) getHibernateTemplate()
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
		log.debug("finding Session instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Session as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Session> findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List<Session> findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List<Session> findByInfo(Object info) {
		return findByProperty(INFO, info);
	}

	public List<Session> findByPerson(Object person) {
		return findByProperty(PERSON, person);
	}

	public List<Session> findByOnlineP(Object onlineP) {
		return findByProperty(ONLINE_P, onlineP);
	}

	public List<Session> findByUplineP(Object uplineP) {
		return findByProperty(UPLINE_P, uplineP);
	}

	public List findAll() {
		log.debug("finding all Session instances");
		try {
			String queryString = "from Session";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Session merge(Session detachedInstance) {
		log.debug("merging Session instance");
		try {
			Session result = (Session) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Session instance) {
		log.debug("attaching dirty Session instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Session instance) {
		log.debug("attaching clean Session instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}	
	
	public List<Session> findBygId(int page,int rows,int gid){
		Query query=getSession().createQuery("from Session s  where s.guide.guideid=? order by onlineT");
		query.setInteger(0, gid);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
	public List<Session> findBygId(int gid){
		Query query=getSession().createQuery("from Session s  where s.guide.guideid=?  order by onlineT");
		query.setInteger(0, gid);
		return query.list();
	}
	
	
	public List<Session> findBygIdMonth(int gid){
		Calendar ca = Calendar.getInstance();   
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH) + 1;
        //and YEAR(s.onlineT)=? and MONTH(s.onlineT)=?
		Query query=getSession().createQuery("from Session s  where s.guide.guideid=? and YEAR(s.onlineT)=? and MONTH(s.onlineT)=?  order by onlineT");
		query.setInteger(0, gid);
		query.setString(1, year+"");
		query.setString(2, month+"");
		return query.list();
	}
	
	public List<Session> onTime(String before ,String later){
		Query query=getSession().createQuery("from Session s  where s.onlineT between ? and ? order by s.onlineT" );
		query.setString(0, before);
		query.setString(1, later);
		
		return query.list();
	}
	
	public List<Session> upTime(String before ,String later,int guideid){
		Query query=getSession().createQuery("from Session s  where  s.guide.guideid=? and  s.onlineT between ? and ? order by s.onlineT" );
		query.setInteger(0, guideid);
		query.setString(1, before);
		query.setString(2, later);
		
		return query.list();
	}
	
	public List<Session> upTime(String before ,String later,int page,int rows,int guideid){
		Query query=getSession().createQuery("from Session s  where  s.guide.guideid=? and s.onlineT between ? and ? order by s.onlineT" );
		query.setInteger(0, guideid);
		query.setString(1, before);
		query.setString(2, later);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
	public List<Session> getTimemonth(String year,String month ){
		
		Query query=getSession().createQuery("from Session s where YEAR(s.onlineT)=? and MONTH(s.onlineT)=?   order by s.sessionId" );
		query.setString(0, year);
		query.setString(1, month);
		return query.list();
	}
public List<Session> getTimemonthguide(String year,String month,int guideid ){
		
		Query query=getSession().createQuery("from Session s where YEAR(s.onlineT)=? and MONTH(s.onlineT)=?  and s.guide.guideid=? order by s.sessionId" );
		query.setString(0, year);
		query.setString(1, month);
		query.setInteger(2, guideid);
		return query.list();
	}
	
	
public List<Session> getTimeday(String year,String month,String day ){
		
		Query query=getSession().createQuery("from Session s where YEAR(s.onlineT)=? and MONTH(s.onlineT)=?and  DAY(s.onlineT)=?   order by s.sessionId" );
		query.setString(0, year);
		query.setString(1, month);
		query.setString(2, day);
		return query.list();
	}

public List<Session> getTimedayguide(String year,String month,String day ,int guideid){
	
	Query query=getSession().createQuery("from Session s where YEAR(s.onlineT)=? and MONTH(s.onlineT)=?and  DAY(s.onlineT)=?  and s.guide.guideid=?  order by s.sessionId" );
	query.setString(0, year);
	query.setString(1, month);
	query.setString(2, day);
	query.setInteger(3, guideid);
	return query.list();
}
	public int findMaxPage(int rows,int gid){
		int maxrow=0;
		int maxpage=1;
		String hql="select count(sessionId) from Session where guide.guideid=?";
		Query query=getSessionFactory().getCurrentSession().createQuery(hql);
		query.setInteger(0, gid);
		maxrow=Integer.parseInt(query.list().get(0).toString());
		if(maxrow==0){
			maxpage=1;
		}else{
			maxpage=maxrow/rows==0?maxrow/rows:maxrow/rows+1;
		}
		
		return maxpage;
	}
	
	public static SessionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SessionDAO) ctx.getBean("SessionDAO");
	}
}