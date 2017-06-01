package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import chirs.listener.SessionListener;
import chris.pojo.Guide;
import chris.pojo.Session;
import chris.pojo.Total;
import chris.pojo.pingjiafen;
import chris.service.BizService;

import com.alibaba.fastjson.JSON;


/**
 * 数据分析模块
 * @author chris
 *
 */
@Controller
@Namespace("/")
public class DataAnalyseAction implements SessionAware{

	@Resource(name = "BizService")
	private BizService bizService;
	private String path;
	public int year;
	public int month;
	public int day;
	private int ssh;
	
	public int getSsh() {
		return ssh;
	}


	public void setSsh(int ssh) {
		this.ssh = ssh;
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


	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}


	public BizService getBizService() {
		return bizService;
	}
	private Map<String, Object>  session;
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}
	
	/**
	 * 一些基础数据操作
	 * @return
	 */
	@Action(value = "jqrtshow_DataAnalyse", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String jqrtshow(){
		
		
		Calendar ca = Calendar.getInstance();   
         year = ca.get(Calendar.YEAR);
         month = ca.get(Calendar.MONTH) + 1;
         day=ca.get(Calendar.DAY_OF_MONTH) ;
         System.out.println(year+":"+month+":"+day);
		//在线地图信息
		try {
			//找到所有导游
			List<Guide> guides = bizService.getGuideBiz().findzaixian();
			System.out.println(guides.size());
			session.put("zaixianrenshu", guides.size());
			List<Guide> guidelist=new ArrayList<Guide>();
			Guide guide_new ;
			for(Guide g:guides){
				guide_new=new Guide();
				guide_new.setJingdu(g.getJingdu());
				guide_new.setWeidu(g.getWeidu());
				guide_new.setYoukeMnum(g.getYoukeMnum());
				guidelist.add(guide_new);
			}
			String lsempjsonString = JSON.toJSONString(guidelist);
			System.out.println(lsempjsonString);
			session.put("gjingdu", guides.get(0).getJingdu());
			session.put("gweidu", guides.get(0).getWeidu());
			session.put("datas", lsempjsonString);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int [] data=new  int[5] ;
		//游客人数柱状图
		int[] a = dayyoukeliumonth(data);
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		for(int sad:a){
			sb.append(sad+",");
		}
		sb.append("]");
		session.put("datapingjia", sb.toString());
		System.out.println(sb.toString());
		//评价饼图
		//List<Session> sessionlist = bizService.getSessionBiz().getTimeday(year+"", month+"",+day+"");
		List<Session> sessionlist = bizService.getSessionBiz().getTimeMonth(year+"", month+"");
		//游客总人数 myperson与实际评价次数pingjia 评价比例rare，评价平均分sumarea ,星级占比 fenji[5]
		if(sessionlist!=null && sessionlist.size()!=0){
		int myperson = 0,pingjia=0,area=0,sumarea=0;
		int [] fenji=new int[5];
		double ratio;
		for(Session session:sessionlist){
			myperson+=session.getPerson();
			if(session.getScore()!=null){
			try {
				String [] score=session.getScore().split(",");
				for(int i=0;i<score.length;i++){
					
					try {
						area+=Integer.parseInt(score[i].trim());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						area=0;
					}
					if(Integer.parseInt(score[i].trim())==1){
						pingjia++;
						fenji[0]+=1;
					}else if(Integer.parseInt(score[i].trim())==2){
						pingjia++;
						fenji[1]+=1;
					}else if(Integer.parseInt(score[i].trim())==3){
						pingjia++;
						fenji[2]+=1;
					}else if(Integer.parseInt(score[i].trim())==4){
						pingjia++;
						fenji[3]+=1;
					}else if(Integer.parseInt(score[i].trim())==5){
						pingjia++;
						fenji[4]+=1;
					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(session.getPerson()==0){
				area=0;
			}else{
				area/=session.getPerson();
			}
			
			sumarea+=area;
			area=0;
			//pingjia+=score.length;
		}
		session.put("fenji", fenji);
		for(int as:fenji){
			System.out.println("分级:::"+as);
		}
		//平均分
		sumarea/=sessionlist.size();
		//评价比率
		double rare = (double)pingjia/(double)myperson;
		System.out.println("评分比例"+rare);
		String myrare=String.format("%.2f", rare);
		pingjiafen mygo=new pingjiafen(myperson,pingjia,myrare,sumarea);
		session.put("pjlei", mygo);
		}
		
		
		/**
		 * 带团时间饼图
		 */
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Session> shijinasession = bizService.getSessionBiz().getTimeMonth(year+"", month+"");
		long c=0;
		//带团时间数据
		int [] shijianzhanbi=new int [5];
		int avertime=0;
		for(Session shijian:shijinasession){
			if(shijian.getUplineT()!=null){
				c=shijian.getUplineT().getTime()-shijian.getOnlineT().getTime();
				c/=1000*60;
				avertime+=c;
				System.out.println( shijian.getSessionId()+"::相差::"+c+"分钟");
				if(c<=30){
					shijianzhanbi[0]++;
				}else if(c>30 && c<=60){
					shijianzhanbi[1]++;
				}else if(c>30 && c<=60){
					shijianzhanbi[1]++;
				}else if(c>60 && c<=90){
					shijianzhanbi[2]++;
				}else if(c>90 && c<=120){
					shijianzhanbi[3]++;
				}else if(c>120 ){
					shijianzhanbi[4]++;
				}
			}
		}
		try {
			if(shijinasession.size()!=0){
				
				avertime/=shijinasession.size();
			}else{
				avertime=0;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.put("dtsj", shijianzhanbi);
		session.put("avertime", avertime);
		System.out.println("平均带团时间"+avertime);
		path = "dataAnalysis/dataAnalysis.jsp";
		return "ok";
		
	}
	
	/**
	 * 游客流量设计图
	 * @return
	 */
	@Action(value = "keliuliang", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String keliuliang(){
		Calendar ca = Calendar.getInstance();   
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH) + 1;
        day=ca.get(Calendar.DAY_OF_MONTH) ;
		int [] data=new  int[5] ;
		//int[] a = null;
		//游客人数柱状图
		int[] a = null;
		System.out.println(ssh);
		if(ssh==0){
		a= dayyoukeliu(data);
		 }else if(ssh==1){
			 
			a= dayyoukeliumonth(data);
			System.out.println(a[1]);
		}
		StringBuffer sb=new StringBuffer();
		sb.append("[");
		for(int sad:a){
			sb.append(sad+",");
		}
		sb.append("]");
	//String lsempjsonString = JSON.toJSONString(sb.toString());
		print(sb.toString());
		System.out.println(sb.toString());
		path="null";
		return null;
	}
	
	/**
	 * 游客评价星级算法设计
	 * @return
	 */
	@Action(value = "xingji", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String xingji(){
		Calendar ca = Calendar.getInstance();   
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH) + 1;
        day=ca.get(Calendar.DAY_OF_MONTH) ;
        List<Session> sessionlist = null ;
		if(ssh==3){
			sessionlist= bizService.getSessionBiz().getTimeday(year+"", month+"", day+"");
		}else if(ssh==4){
			sessionlist = bizService.getSessionBiz().getTimeMonth(year+"", month+"");
		}
		
		//游客总人数 myperson与实际评价次数pingjia 评价比例rare，评价平均分sumarea ,星级占比 fenji[5]
		if(sessionlist!=null && sessionlist.size()!=0){
		int myperson = 0,pingjia=0,area=0,sumarea=0;
		int [] fenji=new int[5];
		double ratio;
		for(Session session:sessionlist){
			myperson+=session.getPerson();
			if(session.getScore()!=null){
			try {
				String [] score=session.getScore().split(",");
				for(int i=0;i<score.length;i++){
					
					try {
						area+=Integer.parseInt(score[i].trim());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						area=0;
					}
					if(Integer.parseInt(score[i].trim())==1){
						pingjia++;
						fenji[0]+=1;
					}else if(Integer.parseInt(score[i].trim())==2){
						pingjia++;
						fenji[1]+=1;
					}else if(Integer.parseInt(score[i].trim())==3){
						pingjia++;
						fenji[2]+=1;
					}else if(Integer.parseInt(score[i].trim())==4){
						pingjia++;
						fenji[3]+=1;
					}else if(Integer.parseInt(score[i].trim())==5){
						pingjia++;
						fenji[4]+=1;
					}
					
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
			try {
				area/=session.getPerson();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				area=0;
			}
			sumarea+=area;
			area=0;
			//pingjia+=score.length;
			
			
		}
				//平均分
				sumarea/=sessionlist.size();
				//评价比率
				double rare = (double)pingjia/(double)myperson;
				System.out.println(rare);
				String myrare=String.format("%.2f", rare);
				//pingjiafen mygo=new pingjiafen(myperson,pingjia,myrare,sumarea);
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("shuzu", fenji);
				map.put("myperson", myperson);
				map.put("pingjia", pingjia);
				map.put("rare", myrare);
				map.put("sumarea", sumarea);
				String lsempjsonString = JSON.toJSONString(map);
				print(lsempjsonString);
				System.out.println(lsempjsonString);
				
		}
		
		path="null";
		return null;
	}
	
	/**
	 * 带团是时间比例
	 * @return
	 */
	@Action(value = "dtsjbl", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String dtsjbl(){
		Calendar ca = Calendar.getInstance();   
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH) + 1;
        day=ca.get(Calendar.DAY_OF_MONTH) ;
        List<Session> shijinasession = null; 
		if(ssh==5){
			shijinasession= bizService.getSessionBiz().getTimeday(year+"", month+"", day+"");
		}else if(ssh==6){
			shijinasession = bizService.getSessionBiz().getTimeMonth(year+"", month+"");
		}
       
		long c=0;
		//带团时间数据
		int [] shijianzhanbi=new int [5];
		int avertime=0;
		for(Session shijian:shijinasession){
			if(shijian.getUplineT()!=null){
				c=shijian.getUplineT().getTime()-shijian.getOnlineT().getTime();
				c/=1000*60;
				avertime+=c;
				System.out.println( shijian.getSessionId()+"::相差::"+c+"分钟");
				if(c<=30){
					shijianzhanbi[0]++;
				}else if(c>30 && c<=60){
					shijianzhanbi[1]++;
				}else if(c>30 && c<=60){
					shijianzhanbi[1]++;
				}else if(c>60 && c<=90){
					shijianzhanbi[2]++;
				}else if(c>90 && c<=120){
					shijianzhanbi[3]++;
				}else if(c>120 ){
					shijianzhanbi[4]++;
				}
			}
		}
		try {
			avertime/=shijinasession.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			avertime=0;
		}
		System.out.println("平均带团时间"+avertime);
        
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("shijianzhanbi", shijianzhanbi);
		map.put("avertime", avertime);
		String lsempjsonString = JSON.toJSONString(map);
		print(lsempjsonString);
		System.out.println(lsempjsonString);
		
		
		path="null";
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
	
	//按日搜索
	public int[] dayyoukeliu(int [] data){
		List<Total> totalday;
		int person=0;
		//游客量信息
		//当天信息处理
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String newbefore=sf.format(date);
		totalday = bizService.getTotalBiz().getTimeday(newbefore+" 08:00:00", newbefore+" 09:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[0]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimeday(newbefore+" 10:00:00", newbefore+" 11:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[1]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimeday(newbefore+" 12:00:00", newbefore+" 13:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[2]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimeday(newbefore+" 14:00:00", newbefore+" 15:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[3]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimeday(newbefore+" 16:00:00", newbefore+" 17:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[4]=person;
		person=0;
		
		
		
		return data;
	}
	
	//按月搜索
	public int[] dayyoukeliumonth(int [] data){
		List<Total> totalday;
		int person=0;
		//游客量信息
		//当天信息处理
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		//获取当前月的第一天
        
        Calendar ca = Calendar.getInstance();   
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        //int year = ca.get(Calendar.YEAR);
        //int month = ca.get(Calendar.MONTH) + 1;
        System.out.println("===============last:"+month);
        
		//Date date=new Date();
		//String newbefore=sf.format(date);
		totalday = bizService.getTotalBiz().getTimemonth(year+"",month+"",  " 08:00:00", " 09:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[0]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonth(year+"",month+"",  " 10:00:00", " 11:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[1]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonth(year+"",month+"",  " 12:00:00", " 13:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[2]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonth(year+"",month+"",  " 14:00:00", " 15:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[3]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonth(year+"",month+"",  " 16:00:00", " 17:59:59");
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[4]=person;
		person=0;
		return data;
	}
	
	
	
	
}
