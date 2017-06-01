package chris.dao;

import java.util.Calendar;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import chris.pojo.Guidem;
import chris.pojo.Total;

/**
 * A data access object (DAO) providing persistence and search support for Total
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see chris.pojo.Total
 * @author MyEclipse Persistence Tools
 */
@Service("TotalDAO")
public class TotalDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TotalDAO.class);
	// property constants
	public static final String GUIDE_ID = "guideId";
	public static final String PERSON = "person";
	public static final String POSITION = "position";

	protected void initDao() {
		// do nothing
	}

	public void save(Total transientInstance) {
		log.debug("saving Total instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Total persistentInstance) {
		log.debug("deleting Total instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Total findById(java.lang.Integer id) {
		log.debug("getting Total instance with id: " + id);
		try {
			Total instance = (Total) getHibernateTemplate().get(
					"chris.pojo.Total", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Total> findByExample(Total instance) {
		log.debug("finding Total instance by example");
		try {
			List<Total> results = (List<Total>) getHibernateTemplate()
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
		log.debug("finding Total instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Total as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Total> findByGuideId(Object guideId) {
		return findByProperty(GUIDE_ID, guideId);
	}

	public List<Total> findByPerson(Object person) {
		return findByProperty(PERSON, person);
	}

	public List<Total> findByPosition(Object position) {
		return findByProperty(POSITION, position);
	}

	public List findAll() {
		log.debug("finding all Total instances");
		try {
			String queryString = "from Total";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Total merge(Total detachedInstance) {
		log.debug("merging Total instance");
		try {
			Total result = (Total) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	
	
	
	
	public void attachDirty(Total instance) {
		log.debug("attaching dirty Total instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Total instance) {
		log.debug("attaching clean Total instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List<Total> findBygId(int page,int rows,int gid,int sessionId){
		Query query=getSession().createQuery("from Total t where guideId=? and t.session.sessionId=? order by t.onlineTime ");
		query.setInteger(0, gid);
		query.setInteger(1,sessionId);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	public List<Total> findBygId(int gid,int sessionId){
		Query query=getSession().createQuery("from Total t where guideId=? and t.session.sessionId=? order by t.onlineTime ");
		query.setInteger(0, gid);
		query.setInteger(1,sessionId);
		return query.list();
	}
	public int findMaxPage(int rows,int gid,int sessionId){
		int maxrow=0;
		int maxpage=1;
		String hql="select count(totalId) from Total t where guideId=? and t.session.sessionId=? ";
		Query query=getSessionFactory().getCurrentSession().createQuery(hql);
		query.setInteger(0, gid);
		query.setInteger(1,sessionId);
		maxrow=Integer.parseInt(query.list().get(0).toString());
		if(maxrow==0){
			maxpage=1;
		}else{
			maxpage=maxrow/rows==0?maxrow/rows:maxrow/rows+1;
		}
		
		return maxpage;
	}
	
	/**
	 * 判断时间段内的数据信息
	 */
	public List<Total> getTimeday(String before ,String later){
		Query query=getSession().createQuery("from Total t where    t.onlineTime between ? and ?   order by t.onlineTime" );
		query.setString(0, before);
		query.setString(1, later);
		return query.list();
	}
	
	
	public List<Total> getTimemonth(String year,String month ,String time1,String time2){
		
		Query query=getSession().createQuery("from Total t where YEAR(t.onlineTime)=? and MONTH(t.onlineTime)=? and HOUR(t.onlineTime)>=? and HOUR(t.onlineTime)<=? order by t.onlineTime" );
		query.setString(0, year);
		query.setString(1, month);
		query.setString(2, time1);
		query.setString(3, time2);
		return query.list();
	}
public List<Total> getTimemonthguide(String year,String month ,String time1,String time2,int guideid){
		
		Query query=getSession().createQuery("from Total t where YEAR(t.onlineTime)=? and MONTH(t.onlineTime)=? and HOUR(t.onlineTime)>=? and HOUR(t.onlineTime)<=?  and t.guideId=?  order by t.onlineTime" );
		query.setString(0, year);
		query.setString(1, month);
		query.setString(2, time1);
		query.setString(3, time2);
		query.setInteger(4, guideid);
		return query.list();
	}
public List<Total> getTimedayguide(String before ,String later,int guideid){
	Query query=getSession().createQuery("from Total t where    t.onlineTime between ? and ?  and  t.guideId=? order by t.onlineTime" );
	query.setString(0, before);
	query.setString(1, later);
	query.setInteger(2, guideid);
	return query.list();
}
	
public List<Total> guideljmonth(int guideid){
	Calendar ca = Calendar.getInstance();   
    int year = ca.get(Calendar.YEAR);
    int month = ca.get(Calendar.MONTH) + 1;
		Query query=getSession().createQuery("from Total t where YEAR(t.onlineTime)=? and MONTH(t.onlineTime)=? and t.guideId=? order by t.onlineTime" );
		query.setString(0, year+"");
		query.setString(1, month+"");
		query.setInteger(2, guideid);
		return query.list();
	}
public List<Total> guideljday(int guideid){
	Calendar ca = Calendar.getInstance();   
    int year = ca.get(Calendar.YEAR);
    int month = ca.get(Calendar.MONTH) + 1;
    int day=ca.get(Calendar.DAY_OF_MONTH);
		Query query=getSession().createQuery("from Total t where YEAR(t.onlineTime)=? and MONTH(t.onlineTime)=? and DAY(t.onlineTime)=? and t.guideId=? order by t.onlineTime" );
		query.setString(0, year+"");
		query.setString(1, month+"");
		query.setString(3, day+"");
		query.setInteger(2, guideid);
		
		return query.list();
	}	


	
	public static TotalDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TotalDAO) ctx.getBean("TotalDAO");
	}
}