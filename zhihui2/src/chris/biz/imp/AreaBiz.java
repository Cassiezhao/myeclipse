package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iAreaBiz;
import chris.pojo.Area;
import chris.service.DaoService;

@Service("AreaBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class AreaBiz implements iAreaBiz{
	@Resource(name="DaoService")
	private DaoService daoService;
	
	
	public DaoService getDaoService() {
		return daoService;
	}


	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}


	public List<Area> findAll() {
		// TODO Auto-generated method stub
		return daoService.getAreaDAO().findAll();
	}


	public List<Area> findAll(int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getAreaDAO().findAll(page, rows);
	}


	public void save(Area transientInstance) {
		// TODO Auto-generated method stub
		daoService.getAreaDAO().save(transientInstance);
	}


	public void delete(Area persistentInstance) {
		// TODO Auto-generated method stub
		daoService.getAreaDAO().delete(persistentInstance);
	}




	public Area findById(Integer id) {
		// TODO Auto-generated method stub
		return daoService.getAreaDAO().findById(id);
	}


	public Area merge(Area detachedInstance) {
		// TODO Auto-generated method stub
		return daoService.getAreaDAO().merge(detachedInstance);
	}

}
