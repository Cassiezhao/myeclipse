package chris.biz;

import java.util.List;

import chris.pojo.User;

public interface iUserBiz {
	public boolean save(User user);
	public boolean update(User user);
	public void delete(User persistentInstance);
	public User findById(Integer uid);
	public List<User>findAll();
	
}
