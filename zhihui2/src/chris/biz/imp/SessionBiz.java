package chris.biz.imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iSessionBiz;
import chris.pojo.Session;
import chris.service.DaoService;
@Service("SessionBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class SessionBiz implements iSessionBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public List<Session> findBygId(int page, int rows, int gid) {
		return  daoService.getSessionDao().findBygId(page, rows, gid);
		
	}

	public int findMaxPage(int rows, int gid) {
		
		return daoService.getSessionDao().findMaxPage(rows, gid);
	}

	public Session findByid(int sid) {
		
		return daoService.getSessionDao().findById(sid);
	}

	public List<Session> findAll() {
		return daoService.getSessionDao().findAll();
	}

	public List<Session> findBygId(int gid) {
		return daoService.getSessionDao().findBygId(gid);
	}

	public List<Session> onTime(String before, String later) {
		return daoService.getSessionDao().onTime(before, later);
	}


	public Session update(Session detachedInstance) {
		return daoService.getSessionDao().merge(detachedInstance);
	}

	public List<Session> getTimeday(String year, String month, String day) {
		// TODO Auto-generated method stub
		return daoService.getSessionDao().getTimeday(year, month, day);
	}

	public List<Session> getTimeMonth(String year, String month) {
		// TODO Auto-generated method stub
		return daoService.getSessionDao().getTimemonth(year, month);
	}

	public List<Session> findBygIdMonth(int gid) {
		// TODO Auto-generated method stub
		return daoService.getSessionDao().findBygIdMonth(gid);
	}

	public List<Session> getTimedayguide(String year, String month, String day,
			int guideid) {
		// TODO Auto-generated method stub
		return daoService.getSessionDao().getTimedayguide(year, month, day, guideid);
	}

	public List<Session> getTimemonthguide(String year, String month,
			int guideid) {
		// TODO Auto-generated method stub
		return daoService.getSessionDao().getTimemonthguide(year, month, guideid);
	}

	public List<Session> upTime(String before, String later, int guideid) {
		// TODO Auto-generated method stub
		return daoService.getSessionDao().upTime(before, later, guideid);
	}

	public List<Session> upTime(String before, String later, int page,
			int rows, int guideid) {
		// TODO Auto-generated method stub
		return daoService.getSessionDao().upTime(before, later, page, rows, guideid);
	}

}
