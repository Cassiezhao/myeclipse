package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iGuideBiz;
import chris.pojo.Guide;
import chris.service.DaoService;
@Service("GuideBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class GuideBiz  implements iGuideBiz{

	
	
	@Resource(name="DaoService")
	private DaoService daoService;
	

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(Guide guide) {
		daoService.getGdao().save(guide);
		return true;
	}

	public boolean update(Guide guide) {
		daoService.getGdao().merge(guide);
		return true;
	}

	public boolean delById(Integer eid) {
		daoService.getGdao().delete(daoService.getGdao().findById(eid));
		return true;
	}

	public Guide findById(Integer gid) {
		
		return daoService.getGdao().findById(gid);
	}

	public List<Guide> findAll(int page, int rows) {
		
		return daoService.getGdao().findAll(page, rows);
	}

	public int findMaxPage(int rows) {
		
		
		return daoService.getGdao().findMaxPage(rows);
	}

	public Guide findById2(String guidenum) {
		
		return daoService.getGdao().findById2(guidenum);
	}

	public List<Guide> findByGnum(String Gnum) {
		
		return daoService.getGdao().findByGuidenum(Gnum);
	}

	public List<Guide> findAll() {
		
		return daoService.getGdao().findAll();
	}

	public List<Guide> findByGname(String a) {
		return daoService.getGdao().findByGname(a);
	}

	public List<Guide> findbyMid(int a) {
		return daoService.getGdao().findbyMid(a);
	}

	public List<Guide> findzaixian(int page, int rows) {
		return daoService.getGdao().findzaixian(page, rows);
	}

	public List<Guide> findzaixian() {
		// TODO Auto-generated method stub
		return daoService.getGdao().findzaixian();
	}

	public List<Guide> findbygpid(int a) {
		// TODO Auto-generated method stub
		return daoService.getGdao().findbygpid(a);
	}

}
