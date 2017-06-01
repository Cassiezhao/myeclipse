package chris.biz;

import java.util.List;

import chris.pojo.Guidem;
import chris.pojo.Memory;

public interface iMemoryBiz {
	 public void save(Memory mem) ;
	 public List<Memory> findAll() ;
	 public List<Memory> findAll(int page,int rows,int userid);
	 public List<Memory> findAll(int userid);
	 public List<Memory> findAllname(int page,int rows,int userid,String a);
	 public List<Memory> findAllname(int userid,String a);
	 public List<Memory> timechange(int userid,String before ,String later,int page,int rows);
	 public List<Memory> timechange(int userid,String before ,String later);
}
