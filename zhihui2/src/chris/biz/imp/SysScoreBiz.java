package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iSysScoreBiz;
import chris.pojo.Systemscore;
import chris.service.DaoService;

@Service("SysScoreBiz")
public class SysScoreBiz implements iSysScoreBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	public List<Systemscore> findAll() {
		// TODO Auto-generated method stub
		return daoService.getSystemScoreDao().findAll();
	}

	public void save(Systemscore sys) {
		daoService.getSystemScoreDao().merge(sys);
		
	}

	public Systemscore findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Systemscore merge(Systemscore detachedInstance) {
		// TODO Auto-generated method stub
		return null;
	}

}
