package chris.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.pojo.Guidem;
import chris.pojo.Message;
import chris.service.BizService;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Namespace("/")
public class textAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
	@Resource(name = "BizService")
	private BizService bizService;
	private String shangchuan2;
	public static String ww;
	public String getShangchuan2() {
		return shangchuan2;
	}

	public void setShangchuan2(String shangchuan2) {
		this.shangchuan2 = shangchuan2;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	private String path;
	private String filename;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	private File audioData;
	  public File getAudioData() {
		return audioData;
	}

	public void setAudioData(File audioData) {
		this.audioData = audioData;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	private HttpServletRequest req; 
	  private HttpServletResponse response;
	  private Map<String, Object> session;


	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	/**
	 * 进行语音数据的上传
	 * @return
	 * @throws IOException
	 */
	@Action(value = "shangchuan_textAction", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String shangchuan() throws IOException {
		if(audioData!=null){
		filename=System.currentTimeMillis()+".mp3";
		Guidem guidemm;
		System.out.println(ww);
		String[]a=ww.split(",");
		Timestamp ts;
		
		
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
			if(a[i]!=null){
				//guides= bizService.getGuideBiz().findById();
				 guidemm = bizService.getGuidemBiz().findBygid(Integer.parseInt(a[i]));
				guidemm.setSendmessage(filename);
				bizService.getGuidemBiz().update(guidemm);
				Message ms=new Message();
				ms.setGuidemnum(guidemm.getGuidemnum());
				ms.setStatus(2);
				ms.setContent(filename);
			  
		        //注意format的格式要与日期String的格式相匹配   
		        ts=new Timestamp(System.currentTimeMillis());
		        ms.setTime(ts);
				getBizService().getMessageBiz().save(ms);
			}
		}
	
	
		if(audioData!=null){
			System.out.println("成功");
		}
		FileOutputStream out = null;
		FileInputStream in = null;
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		String dir = servletContext.getRealPath("/files/"+filename );
		//System.out.println("文件名:"+filename);
		System.out.println("这是我们的地址"+dir);
		
		 out= new FileOutputStream(dir);
		 in= new FileInputStream(audioData);
		
		byte [] buffer = new byte[1024];
		int len = 0;
		
		while((len = in.read(buffer)) != -1){
			out.write(buffer, 0, len);
			
		}
		out.close();
		in.close();
		}else{
			
		}
		
		path="null";
		return "ok";
		
	}
	
	@Action(value = "shuju_textAction", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String shuju(){
		System.out.println("进入");
		ww=shangchuan2;
		System.out.println(ww);
		path = null;
		return null;
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
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.req=arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	
}
