package chris.biz.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iYoukemBiz;
import chris.pojo.Youkem;
import chris.service.DaoService;
@Service("YouKemBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class YouKemBiz implements iYoukemBiz {
	@Resource(name="DaoService")
	private DaoService daoService;
	public DaoService getDaoService() {
		return daoService;
	}
	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	public Youkem findById(Integer Youkemid) {
		
		return daoService.getYoukeDao().findById(Youkemid);
	}
	public boolean update(Youkem y) {
		daoService.getYoukeDao().merge(y);
		return true;
	}

}
