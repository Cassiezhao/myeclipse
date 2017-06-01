package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iGuidegroupBiz;
import chris.pojo.Guidegroup;
import chris.service.DaoService;
@Service("GuidegroupBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class GuidegroupBiz implements iGuidegroupBiz{

	@Resource(name="DaoService")
	private DaoService daoService;
	
	
	public DaoService getDaoService() {
		return daoService;
	}
	public void save(Guidegroup transientInstance) {
		// TODO Auto-generated method stub
		daoService.getGuidegroup().save(transientInstance);
	}

	public void delete(Guidegroup persistentInstance) {
		// TODO Auto-generated method stub
		daoService.getGuidegroup().delete(persistentInstance);
	}

	public Guidegroup findById(Integer id) {
		// TODO Auto-generated method stub
		return daoService.getGuidegroup().findById(id);
	}

	public List<Guidegroup> findAll() {
		// TODO Auto-generated method stub
		return daoService.getGuidegroup().findAll();
	}

	public Guidegroup merge(Guidegroup detachedInstance) {
		// TODO Auto-generated method stub
		return daoService.getGuidegroup().merge(detachedInstance);
	}

	public List<Guidegroup> findAll(int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getGuidegroup().findAll(page, rows);
	}
	public List<Guidegroup> findbyaid(int aid) {
		// TODO Auto-generated method stub
		return daoService.getGuidegroup().findbyaid(aid);
	}

}
