package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

import chris.bean.dayinbean;
import chris.pojo.Guide;
import chris.pojo.Memory;
import chris.pojo.Systemscore;
import chris.pojo.User;
import chris.service.BizService;

@Controller
@Namespace("/")
public class ChangeScoreAciton  extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	@Resource(name = "BizService")
	private BizService bizService;
	private Map<String, Object> session;
	private String newtel;
	public String getNewtel() {
		return newtel;
	}

	public void setNewtel(String newtel) {
		this.newtel = newtel;
	}


	private String path;
	private int guideid;
	private String guidenum;
	public String getGuidenum() {
		return guidenum;
	}

	public void setGuidenum(String guidenum) {
		this.guidenum = guidenum;
	}

	public int getGuideid() {
		return guideid;
	}

	public void setGuideid(int guideid) {
		this.guideid = guideid;
	}


	private Systemscore sys;
	
	public Systemscore getSys() {
		return sys;
	}

	public void setSys(Systemscore sys) {
		this.sys = sys;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	/**
	 * 
	 * @return
	 * 响应点击事件，进入修改分数界面
	 */
	@Action(value = "changeScore_ChangeScore", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String  changeScore (){
		User host=(User) session.get("nuser");
		if(host.getUserpower()!=1){
			return "ok";
		}
		Systemscore syso = bizService.getSysScoreBiz().findAll().get(0);
		
		session.put("syso",syso);
		path="modify/modify.jsp";
		return "ok"; 
			
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	
	/**
	 * 修改系统分数
	 * @return
	 */
	@Action(value = "update_ChangeScore", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String update(){
		
		try {
			System.out.println(sys.toString());
			bizService.getSysScoreBiz().save(sys);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			jilu("设置系统分数失败");
		}
		jilu("设置系统分数成功");
		path="changeScore_ChangeScore";
		return "ok";
	}
	
	/**
	 * 改变系统的电话
	 * @return
	 */
	@Action(value = "telchange_ChangeScore", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String telchange(){
		System.out.println(newtel);
		Systemscore syso = bizService.getSysScoreBiz().findAll().get(0);
		syso.setTel(newtel);
		bizService.getSysScoreBiz().save(syso);
		String lsempjsonString = JSON.toJSONString("success");
		print(lsempjsonString);
		path=null;
		return null;
	}
	/**
	 * 打印凭条
	 * @return
	 */
	@Action(value = "pringtf_ChangeScore", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String pringtf(){
		System.out.println(guidenum);
	//	System.out.println(guideid);
		List<Guide> mygudeid = bizService.getGuideBiz().findByGnum(guidenum.toString());
		Guide myguide = mygudeid.get(0);
		Timestamp date = myguide.getGuidem().getAssignTime();
		Date mydate=(Date)date;
		Calendar c = Calendar.getInstance();
		c.setTime(mydate);
		
		dayinbean dib=new dayinbean(c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1,c.get(Calendar.DAY_OF_MONTH), myguide.getGuidename(),
				myguide.getGuidenum(), myguide.getYoukeMnum());
		System.out.println(dib.toString());
		session.put("dib", dib);
		jilu("打印凭单");
		path="guidemachine/prints.jsp";
		return "ok";
		
	}
	/**
	 * 历史记录表中添加数据
	 * @param s
	 */
	public void jilu(String s){
		User host=(User) session.get("nuser");
		Memory me=new Memory();
		me.setMessage(s);
		me.setUser(host);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		me.setMtime(d);
		me.setOpuser(host.getUsername());
		bizService.getMemoryBiz().save(me);
	}
	
	public void print(String data) {
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setCharacterEncoding("utf-8");
		try {
			PrintWriter out = rep.getWriter();
			out.print(data);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
