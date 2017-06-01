package chris.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.pojo.Session;

/**
 * A data access object (DAO) providing persistence and search support for
 * Guidem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see chris.pojo.Guidem
 * @author MyEclipse Persistence Tools
 */
@Service("GuidemDAO")
public class GuidemDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(GuidemDAO.class);
	// property constants
	public static final String GUIDENUM = "guidemnum";
	public static final String BORROW = "borrow";
	public static final String BREAK_ = "break_";
	public static final String GMSTATE = "gmstate";
	public static final String BREAKINFO = "breakinfo";

	protected void initDao() {
		// do nothing
	}

	public void save(Guidem transientInstance) {
		log.debug("saving Guidem instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Guidem persistentInstance) {
		log.debug("deleting Guidem instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Guidem findById(java.lang.Integer id) {
		log.debug("getting Guidem instance with id: " + id);
		try {
			Guidem instance = (Guidem) getHibernateTemplate().get(
					"chris.pojo.Guidem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Guidem> findByExample(Guidem instance) {
		log.debug("finding Guidem instance by example");
		try {
			List<Guidem> results = (List<Guidem>) getHibernateTemplate()
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
		log.debug("finding Guidem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Guidem as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Guidem> findByGuidenum(Object guidenum) {
		return findByProperty(GUIDENUM, guidenum);
	}

	public List<Guidem> findByBorrow(Object borrow) {
		return findByProperty(BORROW, borrow);
	}

	public List<Guidem> findByBreak_(Object break_) {
		return findByProperty(BREAK_, break_);
	}

	public List<Guidem> findByGmstate(Object gmstate) {
		return findByProperty(GMSTATE, gmstate);
	}

	public List<Guidem> findByBreakinfo(Object breakinfo) {
		return findByProperty(BREAKINFO, breakinfo);
	}

	public List findAll() {
		log.debug("finding all Guidem instances");
		try {
			String queryString = "from Guidem";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Guidem merge(Guidem detachedInstance) {
		log.debug("merging Guidem instance");
		try {
			Guidem result = (Guidem) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Guidem instance) {
		log.debug("attaching dirty Guidem instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Guidem instance) {
		log.debug("attaching clean Guidem instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GuidemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GuidemDAO) ctx.getBean("GuidemDAO");
	}
	public List<Guidem> findAll(int page,int rows){
		Query query=getSession().createQuery("from Guidem order by guidemid");
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	public List<Guidem> findjiechcu(int page,int rows){
		Query query=getSession().createQuery("from Guidem g  where g.gmstate=?  order by guidemid");
		query.setInteger(0, 2);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
	public List<Guidem> findjiechcu2(){
		Query query=getSession().createQuery("from Guidem g  where g.gmstate=?  order by guidemid");
		query.setInteger(0, 2);
		return query.list();
	}
	
	public List<Guidem> findjiechcu(){
		Query query=getSession().createQuery("from Guidem g  where g.gmstate=?  order by guidemid");
		query.setInteger(0, 2);
		return query.list();
	}
	
	
	public List<Guidem> findAll2(){
		Query query=getSession().createQuery("from Guidem order by guidemid");
		return query.list();
	}
	public Guidem findById2(String a){
		Query query=getSession().createQuery("from Guidem g   " +
				"where g.guidemnum=?");
		query.setString(0, a);
		
		return (Guidem) query.list().get(0);
	}
	
	public Guidem findById3(int a){
		Query query=getSession().createQuery("from Guidem g   " +
				"where g.guide.guideid=?");
		query.setInteger(0, a);
		
		return (Guidem) query.list().get(0);
	}
	
	public Guidem findBygid(int a){
		Query query=getSession().createQuery("from Guidem g   " +
				"where g.guidemid=?");
		query.setInteger(0, a);
		
		return (Guidem) query.list().get(0);
	}
	public List<Guidem> findByGnum(String a){
		Query query=getSession().createQuery("from Guidem g   " +
				"where g.guide.guidenum=?");
		query.setString(0, a);
		
		return  query.list();
	}
	
	public List<Guidem> findByGname(String a){
		Query query=getSession().createQuery("from Guidem g  where g.guide.guidename like '%"+a+"%' order by guidemid" );
		return query.list();
	}
	
	public List<Guidem> onTime(String before ,String later,int page,int rows){
		Query query=getSession().createQuery("from Guidem g  where g.assignTime between ? and ? order by guidemid" );
		query.setString(0, before);
		query.setString(1, later);
		query.setFirstResult((page-1)*rows);
		query.setMaxResults(rows);
		return query.list();
	}
	
	public List<Guidem> onTime(String before ,String later){
		Query query=getSession().createQuery("from Guidem g  where g.assignTime between ? and ? order by guidemid" );
		query.setString(0, before);
		query.setString(1, later);
		return query.list();
	}
	
	public int findMaxPage(int rows){
		int maxrow=0;
		int maxpage=1;
		String hql="select count(guidemid) from Guidem";
		Query query=getSessionFactory().getCurrentSession().createQuery(hql);
		maxrow=Integer.parseInt(query.list().get(0).toString());
		if(maxrow==0){
			maxpage=1;
		}else{
			maxpage=maxrow/rows==0?maxrow/rows:maxrow/rows+1;
		}
		
		return maxpage;
	}
}