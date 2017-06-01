package chris.biz;

import java.util.List;

import chris.pojo.Guidemdt;

public interface iGuidemdtBiz {
	public void save(Guidemdt gdt);
	public List<Guidemdt> findBygnum(int page,int rows,String gnum);
	public List<Guidemdt>  findAll();
	public List<Guidemdt> findBygnum(String gnum);
}
