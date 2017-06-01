package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iUserBiz;
import chris.pojo.User;
import chris.service.DaoService;
@Service("UserBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class UserBiz  implements iUserBiz{
	
	
	@Resource(name="DaoService")
	private DaoService daoService;
	
	
	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public boolean save(User user) {
		 daoService.getUdao().save(user);
		 return true;
	}

	public boolean update(User user) {
		 daoService.getUdao().merge(user);
		return true;
	}


	public User findById(Integer uid) {
		
		return daoService.getUdao().findById(uid);
	}
	
	public List<User> findAll() {
		return daoService.getUdao().findAll();
		
	}


	public void delete(User persistentInstance) {
		// TODO Auto-generated method stub
		daoService.getUdao().delete(persistentInstance);
	}
	
}
