package chris.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.pojo.Message;
import chris.service.BizService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
public class TuisongAction extends ActionSupport implements SessionAware {
	private String myword;
	private String hei;
	private String path;
	@Resource(name = "BizService")
	private BizService bizService;
	Timestamp ts ;
	public BizService getBizService() {
		return bizService;
	}
	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMyword() {
		return myword;
	}
	public void setMyword(String myword) {
		this.myword = myword;
	}
	public String getHei() {
		return hei;
	}
	public void setHei(String hei) {
		this.hei = hei;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	private Map<String, Object> session;
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	
	/**
	 * 语音消息推送
	 * @return
	 */
	@Action(value = "tui_Tuisong", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String tui() {
		Guide guides;
		Guidem guidemm;
		System.out.println(myword+"................."+hei);
		String[]a=hei.split(",");
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
			if(a[i]!=null){
				//guides= bizService.getGuideBiz().findById();
				 guidemm = bizService.getGuidemBiz().findBygid(Integer.parseInt(a[i]));
				guidemm.setSendmessage(myword);
				bizService.getGuidemBiz().update(guidemm);
				Message ms=new Message();
				ms.setGuidemnum(guidemm.getGuidemnum());
				ms.setStatus(1);
				ms.setContent(myword);
			  
		        //注意format的格式要与日期String的格式相匹配   
		          
		        
		        ts=new Timestamp(System.currentTimeMillis()); 
		        ms.setTime(ts);
				getBizService().getMessageBiz().save(ms);
			}
		}
		
		path="findAll_Guide?i=2";
		return "ok";
	}
}
