package chris.biz;

import chris.pojo.Youkem;

public interface iYoukemBiz {
	public Youkem findById(Integer Youkemid);
	public boolean update(Youkem y);
}
