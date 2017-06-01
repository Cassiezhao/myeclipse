package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iTotalBiz;
import chris.pojo.Total;
import chris.service.DaoService;
@Service("TotalBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class TotalBiz  implements iTotalBiz{
	@Resource(name="DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public List<Total> findBygId(int page, int rows, int gid, int sessionId) {
		return daoService.getTotalDao().findBygId(page, rows, gid, sessionId);
		
	}

	public int findMaxPage(int rows, int gid, int sessionId) {
		return daoService.getTotalDao().findMaxPage(rows, gid, sessionId);
		 
	}

	public List<Total> findBygId(int gid, int sessionId) {
		return daoService.getTotalDao().findBygId(gid, sessionId);
	}

	public List<Total> getTimeday(String before, String later) {
		return daoService.getTotalDao().getTimeday(before, later);
	}

	public List<Total> getTimemonth(String year, String month, String time1,
			String time2) {
		return daoService.getTotalDao().getTimemonth(year, month, time1, time2);
	}

	public List<Total> guideljmonth(int guideid) {
		// TODO Auto-generated method stub
		return daoService.getTotalDao().guideljmonth(guideid);
	}

	public List<Total> guideljday(int guideid) {
		// TODO Auto-generated method stub
		return daoService.getTotalDao().guideljday(guideid);
	}

	public List<Total> getTimedayguide(String before, String later, int guideid) {
		// TODO Auto-generated method stub
		return daoService.getTotalDao().getTimedayguide(before, later, guideid);
	}

	public List<Total> getTimemonthguide(String year, String month,
			String time1, String time2, int guideid) {
		// TODO Auto-generated method stub
		return daoService.getTotalDao().getTimemonthguide(year, month, time1, time2, guideid);
	}


	


}
