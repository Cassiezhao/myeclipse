package chris.biz;

import java.util.Date;
import java.util.List;

import chris.pojo.Session;

public interface iSessionBiz {
	public List<Session> findBygId(int page,int rows,int gid);
	public int findMaxPage(int rows,int gid);
	public Session findByid(int sid);
	public List<Session> findAll();
	public List<Session> findBygId(int gid);
	public List<Session> onTime(String before ,String later);
	public Session update(Session session);
	public List<Session> upTime(String before ,String later,int guideid);
	public List<Session> upTime(String before ,String later,int page,int rows,int guideid);
	public List<Session> getTimeday(String year,String month,String day );
	public List<Session> getTimeMonth(String year,String month);
	public List<Session> findBygIdMonth(int gid);
	public List<Session> getTimedayguide(String year,String month,String day ,int guideid);
	public List<Session> getTimemonthguide(String year,String month,int guideid );
}
