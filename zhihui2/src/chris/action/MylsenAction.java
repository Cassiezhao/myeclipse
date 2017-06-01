package chris.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;

import chris.pojo.Guidem;
import chris.pojo.Guidemonitor;
import chris.pojo.Memory;
import chris.pojo.User;
import chris.service.BizService;

@Controller
@Namespace("/")
public class MylsenAction implements SessionAware{
	@Resource(name = "BizService")
	private BizService bizService;
	private String path;
	private String mytime;
	private String muguidemid;
	
	public String getMytime() {
		return mytime;
	}

	public void setMytime(String mytime) {
		this.mytime = mytime;
	}

	public String getMuguidemid() {
		return muguidemid;
	}

	public void setMuguidemid(String muguidemid) {
		this.muguidemid = muguidemid;
	}

	private Map<String,Object>session;
public Map<String, Object> getSession() {
		return session;
	}

private String myid;


	public String getMyid() {
	return myid;
}

public void setMyid(String myid) {
	this.myid = myid;
}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	
	/**
	 * 开启监听
	 * @return
	 */
	@Action(value = "mylsen_Mylsen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String mylsen() {
		Map<String,Object> map=new HashMap<String, Object>();
		try {
			System.out.println("当前"+myid);
			
			 Guidem guidem = bizService.getGuidemBiz().findBygid((Integer.parseInt(myid)));
			Integer dir = guidem.getMkdir();
			Integer status = guidem.getMkstatus();
//			if(1==status ){
//				map.put("success", 2);
//				map.put("guidemId",myid);
//			}else{
			//如果当前没有监听 listennum代表当前监听的人数
			if(guidem.getListennum()==0){
				dir++;
				guidem.setMkdir(dir);
				guidem.setMkstatus(1);
				guidem.setListennum(1);
				guidem.setMydir(dir+"_"+guidem.getGuidemnum().subSequence(0, 4));
				
			}else{
				guidem.setListennum(guidem.getListennum()+1);
			}
				
			bizService.getGuidemBiz().update(guidem);
				System.out.println(dir+"_"+guidem.getGuidemnum().subSequence(0, 4)+"============================");
				map.put("success", 1);
//			}
			
			ServletContext servletContext = ServletActionContext.getServletContext();
			
		
		
			String fristdir=servletContext.getRealPath("/files")+"/"+dir+"_"+guidem.getGuidemnum().subSequence(0, 4)+"/";
			
			File myfile=new File(fristdir);
			System.out.println("当前工作目录"+fristdir+";当前状态"+status);
			if(!myfile.exists()){
				myfile.mkdir();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String lsempjsonString = JSON.toJSONString(map);
		print(lsempjsonString);
		//path=null;
		return null;
	}
	
	/**
	 * 开启录制
	 */
	@Action(value = "myarealsen_Mylsen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String myarealsen() {
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		System.out.println(mytime+":::"+muguidemid);
		/**
		 * 获取到对象
		 */
		int dirnum;
		String mydir;
		final String[]  myid= muguidemid.split(",");
		for(int i=0;i<myid.length;i++){
			Guidem okuidem= bizService.getGuidemBiz().findById(Integer.parseInt(myid[i]));
			okuidem.setRecordtime(Integer.parseInt(mytime));
			dirnum=okuidem.getMkdir();
			System.out.println(dirnum);
			dirnum++;
			okuidem.setMkdir(dirnum);
			mydir=dirnum+"_"+okuidem.getGuidemnum().subSequence(0, 4);
			okuidem.setMydir(mydir);
			bizService.getGuidemBiz().update(okuidem);
			
			String name=okuidem.getGuide().getGuidename();
			String guidenum=okuidem.getGuide().getGuidenum();
			String guidemname=okuidem.getGuidemnum();
			Timestamp d = new Timestamp(System.currentTimeMillis());
			/**
			 * 记录保存,将数据写入数据库
			 */
			Guidemonitor gm=new Guidemonitor(d,mydir,name,guidemname,guidenum);
			bizService.getGuidemonitorBiz().save(gm);
			String fristdir=servletContext.getRealPath("/files")+"/"+mydir+"/";
			
			File myfile=new File(fristdir);
			System.out.println("当前工作目录"+fristdir);
			if(!myfile.exists()){
				myfile.mkdir();
			}
			
			
		}
//		 TimerTask task = new TimerTask() {  
//	            @Override  
//	            public void run() {  
//	                // task to run goes here  
//	                System.out.println("Hello !!!");  
//	                for(int i=0;i<myid.length;i++){
//	                	Guidem okuidem = bizService.getGuidemBiz().findById(Integer.parseInt(myid[i]));
//	        			okuidem.setMkstatus(0);
//	        			bizService.getGuidemBiz().update(okuidem);
//	        		}
//	            }  
//	        };  
//	        Timer timer = new Timer();  
//	        //2000代表2秒
//	        timer.schedule(task, 10000);
		return null;
	}
	

	/**
	 * 停止监听模块
	 * @return
	 */
	@Action(value = "mylsop_Mylsen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String mylsop() {
		Map<String,Object> map=new HashMap<String, Object>();
			System.out.println("当前"+myid);
			 Guidem guidem = bizService.getGuidemBiz().findBygid((Integer.parseInt(myid)));
			if(guidem.getListennum()==1){
				//停止监听
				guidem.setMkstatus(0);
				guidem.setListennum(guidem.getListennum()-1);
				
			}else{
				if(guidem.getListennum()>1){
				guidem.setListennum(guidem.getListennum()-1);
				}else{
					guidem.setListennum(0);
				}
			}
			bizService.getGuidemBiz().update(guidem);
				Integer dir = guidem.getMkdir();
				Integer status = guidem.getMkstatus();
				
				map.put("success", 1);
			
			System.out.println("当前工作目录"+dir+";当前状态"+status);
			
		String lsempjsonString = JSON.toJSONString(map);
		print(lsempjsonString);
		path=null;
		return null;
	}
	/**
	 * 缓存机制。判断是否有2.MP3
	 * @return
	 */
	@Action(value = "jiance_Mylsen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String jiance(){
		ServletContext servletContext = ServletActionContext
				.getServletContext();
		Map<String,Object> map=new HashMap<String, Object>();
		System.out.println(myid);
		String mydir=bizService.getGuidemBiz().findBygid(Integer.parseInt(myid)).getMydir();
		//判断是否存在url
		String fristdir = servletContext.getRealPath("\\files") + "\\" + mydir
				+ "\\1.mp3";
		String myreadir=servletContext.getRealPath("\\files") + "\\" + mydir;
		File myfile = new File(fristdir);
		if (myfile.exists()) {
			
			map.put("success", mydir);
			/**
			 * 判断是否有多人同时监听
			 */
			Guidem aguidem = bizService.getGuidemBiz().findBygid(Integer.parseInt(myid));
			if(aguidem.getListennum()>1){	
				try {
					File myfilelist = new File(myreadir);
						if(myfilelist.exists()){
							File[] listFiles = myfilelist.listFiles();
							int i=listFiles.length-2;
							if(i<=2){
								i=2;
								
							}
							map.put("myi", i);
							System.out.println("这是当前的数据"+i);
						}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				map.put("myi", 1);
			}
			
			/**
			 * 在这里加入导游监听表的详细信息。
			 */
//			}
			String name=aguidem.getGuide().getGuidename();
			String guidenum=aguidem.getGuide().getGuidenum();
			String guidemname=aguidem.getGuidemnum();
			Timestamp d = new Timestamp(System.currentTimeMillis());
			/**
			 * 记录保存,将数据写入数据库
			 */
			Guidemonitor gm=new Guidemonitor(d,mydir,name,guidemname,guidenum);
			bizService.getGuidemonitorBiz().save(gm);
			
			System.out.println("该文件存在");
		}else{
			//文件不存在的时候就应该将数据重置
			 Guidem guidem = bizService.getGuidemBiz().findBygid((Integer.parseInt(myid)));
			 guidem.setMkstatus(0);
			 guidem.setListennum(0);
			 bizService.getGuidemBiz().update(guidem);
			map.put("success", 0);
			System.out.println("该文件不存在");
		}
		String lsempjsonString = JSON.toJSONString(map);
		print(lsempjsonString);
		path=null;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
}
