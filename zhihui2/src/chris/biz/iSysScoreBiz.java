package chris.biz;

import java.util.List;

import chris.pojo.Systemscore;

public interface iSysScoreBiz {
	 public List<Systemscore> findAll(); 
	 public void save(Systemscore sys);
	 public Systemscore findById( java.lang.Integer id);
	 public Systemscore merge(Systemscore detachedInstance);
}
