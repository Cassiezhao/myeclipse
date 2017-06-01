package chris.biz;

import java.util.List;

import chris.pojo.Total;

public interface iTotalBiz {
	public List<Total> findBygId(int page,int rows,int gid,int sessionId);
	public int findMaxPage(int rows,int gid,int sessionId);
	List<Total> findBygId(int gid,int sessionId);
	
	public List<Total> getTimeday(String before ,String later);
	public List<Total> getTimemonth(String year,String month ,String time1,String time2);
	public List<Total> guideljmonth(int guideid);
	public List<Total> guideljday(int guideid);
	public List<Total> getTimedayguide(String before ,String later,int guideid);
	public List<Total> getTimemonthguide(String year,String month ,String time1,String time2,int guideid);
}
