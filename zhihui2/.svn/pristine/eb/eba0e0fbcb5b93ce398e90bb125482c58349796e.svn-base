package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iGuidemdtBiz;
import chris.pojo.Guidemdt;
import chris.service.DaoService;
@Service("GuidemdtBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class GuidemdtBiz implements iGuidemdtBiz{

	@Resource(name="DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public void save(Guidemdt gdt) {
		// TODO Auto-generated method stub
		daoService.getGuidemdtDAO().save(gdt);
		
	}

	public List<Guidemdt> findBygnum(int page, int rows, String gnum) {
		// TODO Auto-generated method stub
		return daoService.getGuidemdtDAO().findBygnum(page, rows, gnum);
	}

	public List<Guidemdt> findAll() {
		// TODO Auto-generated method stub
		return daoService.getGuidemdtDAO().findAll();
	}

	public List<Guidemdt> findBygnum(String gnum) {
		// TODO Auto-generated method stub
		return daoService.getGuidemdtDAO().findBygnum(gnum);
	}

}
