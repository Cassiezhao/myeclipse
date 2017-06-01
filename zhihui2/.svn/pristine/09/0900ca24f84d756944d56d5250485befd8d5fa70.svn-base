package chris.biz.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chris.biz.iBuletoothBiz;
import chris.pojo.Buletooth;
import chris.service.DaoService;

@Service("BuletoothBiz")
@Transactional(propagation=Propagation.REQUIRED)
public class BuletoothBiz implements iBuletoothBiz {
	@Resource(name="DaoService")
	private DaoService daoService;

	public DaoService getDaoService() {
		return daoService;
	}

	public void setDaoService(DaoService daoService) {
		this.daoService = daoService;
	}

	public void save(Buletooth bluetooth) {
		daoService.getBuletoothDAO().save(bluetooth);
	}

	public List<Buletooth> findAll(int page, int rows) {
		return daoService.getBuletoothDAO().findAll(page, rows);
	}

	public List<Buletooth> findAll() {
		// TODO Auto-generated method stub
		return daoService.getBuletoothDAO().findAll();
	}

	public Buletooth findById(Integer id) {
		return daoService.getBuletoothDAO().findById(id);
	}

	public Buletooth update(Buletooth detachedInstance) {
		// TODO Auto-generated method stub
		return daoService.getBuletoothDAO().merge(detachedInstance);
	}

	public void delete(Buletooth persistentInstance) {
		// TODO Auto-generated method stub
		daoService.getBuletoothDAO().delete(persistentInstance);
	}
}
