package chris.bean;

import java.io.Serializable;

public class areadata implements Serializable{
	private int adid;
	private String areaname;
	public areadata(int adid, String areaname) {
		super();
		this.adid = adid;
		this.areaname = areaname;
	}
	public areadata() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAdid() {
		return adid;
	}
	public void setAdid(int adid) {
		this.adid = adid;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	
}
