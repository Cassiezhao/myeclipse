package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iMessageBiz;
import chris.pojo.Message;
import chris.service.DaoService;
@Service("MessageBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class MessageBiz implements iMessageBiz{

	@Resource(name="DaoService")
	private DaoService daoService;
	

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}
	
	public void save(Message message) {
		// TODO Auto-generated method stub
		daoService.getMessageDao().save(message);
	}

	public List findAll() {
		return daoService.getMemoryDao().findAll();
	}

}
