package chris.biz;

import java.util.List;

import chris.pojo.Message;

public interface iMessageBiz {
	public void save(Message message); 
	public List findAll() ;
}	
