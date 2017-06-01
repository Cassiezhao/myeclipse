package chris.biz;

import java.util.List;

import chris.pojo.Guidemonitor;

public interface iGuidemonitorBiz {
	public void save(Guidemonitor gdt);
	public List<Guidemonitor> findBygnum(int page,int rows);
	public List<Guidemonitor>  findAll();
	public List<Guidemonitor>  findAll(int page,int rows);
	public List<Guidemonitor> findByalite(String monitor_id,String monitor_name,int page,int rows);
	public List<Guidemonitor> findByalite(String monitor_id,String monitor_name);
}
