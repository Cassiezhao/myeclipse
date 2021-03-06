package chris.biz;

import java.util.List;

import chris.pojo.Guide;

public interface iGuideBiz {
	public boolean save(Guide guide);
	public boolean update(Guide guide);
	public boolean delById(Integer guideid);
	public Guide findById(Integer guide);
	public Guide findById2(String guidenum);
	public List<Guide> findAll(int page,int rows);
	public int findMaxPage(int rows);
	public List<Guide> findByGnum(String Gnum);
	public List<Guide> findAll();
	public List<Guide> findByGname(String a);
	public List<Guide> findbyMid(int a);
	public List<Guide> findzaixian(int page,int rows);
	public List<Guide> findzaixian();
	public List<Guide> findbygpid(int a);
}
