package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iMemoryBiz;
import chris.pojo.Guidem;
import chris.pojo.Memory;
import chris.service.DaoService;
@Service("MemoryBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class MemoryBiz implements iMemoryBiz {

	@Resource(name="DaoService")
	private DaoService daoService;
	

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	
	public void save(Memory mem) {
		daoService.getMemoryDao().save(mem);
		
	}

	public List<Memory> findAll() {
		return daoService.getMemoryDao().findAll();
	}

	public List<Memory> findAll(int page, int rows, int userid) {
		return daoService.getMemoryDao().findAll(page, rows, userid);
	}

	public List<Memory> findAll(int userid) {
		// TODO Auto-generated method stub
		return daoService.getMemoryDao().findAll(userid);
	}

	public List<Memory> findAllname(int page, int rows, int userid, String a) {
		// TODO Auto-generated method stub
		return daoService.getMemoryDao().findAllname(page, rows, userid, a);
	}

	public List<Memory> findAllname(int userid, String a) {
		// TODO Auto-generated method stub
		return daoService.getMemoryDao().findAllname(userid, a);
	}

	public List<Memory> timechange(int userid, String before, String later,
			int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getMemoryDao().timechange(userid, before, later, page, rows);
	}


	public List<Memory> timechange(int userid, String before, String later) {
		// TODO Auto-generated method stub
		return daoService.getMemoryDao().timechange(userid, before, later);
	}


}
