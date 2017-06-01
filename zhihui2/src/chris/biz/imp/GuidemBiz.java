package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iGuidemBiz;
import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.service.DaoService;
@Service("GuidemBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class GuidemBiz implements iGuidemBiz {

	@Resource(name="DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(Guidem Guidem) {
		daoService.getGmdao().save(Guidem);
		return true;
	}

	public boolean update(Guidem Guidem) {
		daoService.getGmdao().merge(Guidem);
		return true;
	}

	public boolean delById(Integer Guidemid) {
		return false;
	}

	public Guidem findById(Integer Guidemid) {
		
		return daoService.getGmdao().findById(Guidemid);
	}

	public List<Guidem> findAll(int page, int rows) {
		return daoService.getGmdao().findAll(page, rows);
	}

	public int findMaxPage(int rows) {
		return daoService.getGmdao().findMaxPage(rows);
	}
	public Guidem findById2(String Guidenum) {
		
		return daoService.getGmdao().findById2(Guidenum);
	}

	public List<Guidem> findByGuidenum(String guidemnum) {
		return daoService.getGmdao().findByGuidenum(guidemnum);
	}

	public List<Guidem> findByGnum(String a) {
		return daoService.getGmdao().findByGnum(a);
	}

	public List<Guidem> findByGname(String a) {
		// TODO Auto-generated method stub
		return daoService.getGmdao().findByGname(a);
	}

	public List<Guidem> onTime(String before ,String later,int page,int rows) {
		return daoService.getGmdao().onTime(before, later, page, rows);
	}

	public List<Guidem> findAll2() {
		// TODO Auto-generated method stub
		return daoService.getGmdao().findAll();
	}

	public Guidem findById3(int a) {
		// TODO Auto-generated method stub
		return daoService.getGmdao().findById3(a);
	}

	public Guidem findBygid(int a) {
		// TODO Auto-generated method stub
		return daoService.getGmdao().findBygid(a);
	}

	public List<Guidem> findjiechcu(int page, int rows) {
		// TODO Auto-generated method stub
		return daoService.getGmdao().findjiechcu(page, rows);
	}

	public List<Guidem> findjiechcu() {
		// TODO Auto-generated method stub
		return daoService.getGmdao().findjiechcu();
	}

	public List<Guidem> findjiechcu2() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Guidem> onTime(String before, String later) {
		// TODO Auto-generated method stub
		return daoService.getGmdao().onTime(before, later);
	}

}
