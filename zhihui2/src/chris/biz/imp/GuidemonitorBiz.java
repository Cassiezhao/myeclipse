package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iGuidemonitorBiz;
import chris.pojo.Guidemonitor;
import chris.service.DaoService;
@Service("GuidemonitorBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class GuidemonitorBiz implements iGuidemonitorBiz{

	
	@Resource(name="DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	@Override
	public void save(Guidemonitor gdt) {
		// TODO Auto-generated method stub
		daoService.getGuidemonitorDAO().save(gdt);
	}

	@Override
	public List<Guidemonitor> findBygnum(int page, int rows) {
		
		return null;
	}

	@Override
	public List<Guidemonitor> findAll() {
		// TODO Auto-generated method stub
		return daoService.getGuidemonitorDAO().findAll();
	}

	@Override
	public List<Guidemonitor> findAll(int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getGuidemonitorDAO().findAll(page, rows);
	}

	@Override
	public List<Guidemonitor> findByalite(String monitor_id,
			String monitor_name, int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getGuidemonitorDAO().findByalite(monitor_id, monitor_name, page, rows);
	}

	@Override
	public List<Guidemonitor> findByalite(String monitor_id, String monitor_name) {
		// TODO Auto-generated method stub
		return daoService.getGuidemonitorDAO().findByalite(monitor_id, monitor_name);
	}

}
