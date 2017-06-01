package chris.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import chris.pojo.Guidemdt;
import chris.service.BizService;

import com.opensymphony.xwork2.ActionSupport;

public class guidemDetailAction extends ActionSupport implements SessionAware{
	private String path;
	private int page;
	private int rows;
	private Map<String, Object> session;
	private String guidemid;
	@Resource(name = "BizService")
	private BizService bizService;
	
	public BizService getBizService() {
		return bizService;
	}
	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	public String getGuidemid() {
		return guidemid;
	}
	public void setGuidemid(String guidemid) {
		this.guidemid = guidemid;
	}
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}


	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}



	/**
	 * 
	 * @return
	 * 
	 * 导游机详细信息
	 */
	@Action(value = "guidemDetail", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findAll(){
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=10;
		}
		session.put("gdttotal", bizService.getGuidemdtBiz().findBygnum(guidemid).size());
		 List<Guidemdt> listgdt = bizService.getGuidemdtBiz().findBygnum(page, rows, guidemid);
	//	System.out.println(listgdt.get(0).getGuidemid());
		 session.put("gdtpage", page);
		session.put("gdtrows", rows);
		session.put("listgdt", listgdt);
		session.put("gdtid", guidemid);
		path="guidemachine/useMessageDetail.jsp";
		return "ok";
	}
	
	
	
	
	

}
