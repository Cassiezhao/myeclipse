package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.alibaba.fastjson.JSON;

import chris.pojo.Guide;
import chris.pojo.Session;
import chris.pojo.Total;
import chris.pojo.pingjiafen;
import chris.service.BizService;
/**
 * 导游数据分析模块
 * @author chris
 *
 */
@Controller
@Namespace("/")
public class GuideDataAnalseAction  implements SessionAware{
	@Resource(name = "BizService")
	private BizService bizService;
	private String path;
	public int year;
	public static int daoyouid2;
	public int month;
	public int day;
	private int ssm;
	public int getSsm() {
		return ssm;
	}


	public void setSsm(int ssm) {
		this.ssm = ssm;
	}
	private int daoyouid;
	
	public int getDaoyouid() {
		return daoyouid;
	}


	public void setDaoyouid(int daoyouid) {
		this.daoyouid = daoyouid;
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
	
	
	@Action(value = "guideDataas", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String guideDataas(){
		Calendar ca = Calendar.getInstance();   
         year = ca.get(Calendar.YEAR);
         month = ca.get(Calendar.MONTH) + 1;
         day=ca.get(Calendar.DAY_OF_MONTH) ;
         System.out.println(year+":"+month+":"+day);
         System.out.println(daoyouid);
         daoyouid2=daoyouid;
        List<Total> mydayoulist = bizService.getTotalBiz().guideljmonth(daoyouid);
		List<Guide> guidelist=new ArrayList<Guide>();
		Guide guide_new ;
		for(Total t:mydayoulist){
			guide_new=new Guide();
			guide_new.setJingdu(t.getJingdu());
			guide_new.setWeidu(t.getWeidu());
			guidelist.add(guide_new);
		}
		String lsempjsonString = JSON.toJSONString(guidelist);
		System.out.println(lsempjsonString);
		session.put("dyjingdu", 108.893613);
		session.put("dyweidu", 34.157044);
		session.put("dydatas", lsempjsonString);
		
		int [] data=new  int[5] ;
		//游客人数柱状图
		int[] a = dayyoukeliumonth(data,daoyouid);
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
		List<Session> sessionlist = bizService.getSessionBiz().getTimemonthguide(year+"", month+"",daoyouid);
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
		pingjiafen mygo = null;
		try {
			//平均分
			sumarea/=sessionlist.size();
			//评价比率
			double rare = (double)pingjia/(double)myperson;
			System.out.println("评分比例"+rare);
			mygo = new pingjiafen(myperson,pingjia,String.format("%.2f", rare),sumarea);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.put("pjlei", mygo);
		}
		
		
		/**
		 * 带团时间饼图
		 */
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		List<Session> shijinasession = bizService.getSessionBiz().getTimemonthguide(year+"", month+"",daoyouid);
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
		if(shijinasession.size()==0){
			avertime=0;
		}else{
			avertime/=shijinasession.size();
		}
			
			// TODO Auto-generated catch block
		session.put("dtsj", shijianzhanbi);
		session.put("avertime", avertime);
		System.out.println("平均带团时间"+avertime);
		path = "guidemanage/guideDataAnalysis.jsp";
		return "ok";
		
	}
	
	/**
	 * 客流量
	 * @return
	 */
	@Action(value = "youkellfx", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String youkellfx(){

		Calendar ca = Calendar.getInstance();   
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH) + 1;
        day=ca.get(Calendar.DAY_OF_MONTH) ;
        daoyouid=daoyouid2;
        System.out.println(daoyouid);
        
		int [] data=new  int[5] ;
		//int[] a = null;
		//游客人数柱状图
		int[] a = null;
		System.out.println("当前ssm值"+ssm);
		if(ssm==0){
		a= dayyoukeliu(data,daoyouid);
		 }else if(ssm==1){
			 
			a= dayyoukeliumonth(data,daoyouid);
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
	
	@Action(value = "youkepjx", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String youkepjx(){
		daoyouid=daoyouid2;
		System.out.println("daoyouid"+daoyouid);
		Calendar ca = Calendar.getInstance();   
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH) + 1;
        day=ca.get(Calendar.DAY_OF_MONTH) ;
        List<Session> sessionlist = null ;
		if(ssm==3){
			sessionlist= bizService.getSessionBiz().getTimedayguide(year+"", month+"", day+"",daoyouid);
		}else if(ssm==4){
			sessionlist = bizService.getSessionBiz().getTimemonthguide(year+"", month+"",daoyouid);
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
					area+=Integer.parseInt(score[i].trim());
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
			area/=session.getPerson();
			sumarea+=area;
			area=0;
			
			
		}
				//平均分
				sumarea/=sessionlist.size();
				//评价比率
				double rare = (double)pingjia/(double)myperson;
				System.out.println(rare);
				
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("shuzu", fenji);
				map.put("myperson", myperson);
				map.put("pingjia", pingjia);
				map.put("rare", String.format("%.2f", rare));
				map.put("sumarea", sumarea);
				String lsempjsonString = JSON.toJSONString(map);
				print(lsempjsonString);
				System.out.println(lsempjsonString);
				
		}
		
		path="null";
		return null;
		
	}
	
	/**
	 * 游客带团图评价
	 * @return
	 */
	@Action(value = "youkedaituan", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String youkedaituan(){
		daoyouid=daoyouid2;
		System.out.println("daoyouid"+daoyouid);
		Calendar ca = Calendar.getInstance();   
        year = ca.get(Calendar.YEAR);
        month = ca.get(Calendar.MONTH) + 1;
        day=ca.get(Calendar.DAY_OF_MONTH) ;
        List<Session> shijinasession = null; 
		if(ssm==5){
			shijinasession= bizService.getSessionBiz().getTimedayguide(year+"", month+"", day+"",daoyouid);
		}else if(ssm==6){
			shijinasession = bizService.getSessionBiz().getTimemonthguide(year+"", month+"",daoyouid);
		}
       
		long c=0;
		//带团时间数据设置
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
		avertime/=shijinasession.size();
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
	
	
	/**
	 * 一天的导游区客流量
	 * @param data
	 * @param id
	 * @return
	 */
	public int[] dayyoukeliu(int [] data,int id){
		
		List<Total> totalday;
		int person=0;
		//游客量信息
		//当天信息处理
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String newbefore=sf.format(date);
		totalday = bizService.getTotalBiz().getTimedayguide(newbefore+" 08:00:00", newbefore+" 09:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[0]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimedayguide(newbefore+" 10:00:00", newbefore+" 11:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[1]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimedayguide(newbefore+" 12:00:00", newbefore+" 13:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[2]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimedayguide(newbefore+" 14:00:00", newbefore+" 15:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[3]=person;
		person=0;
		
		totalday = bizService.getTotalBiz().getTimedayguide(newbefore+" 16:00:00", newbefore+" 17:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[4]=person;
		person=0;
		
		
		
		return data;
	}
	
	
	public int[] dayyoukeliumonth(int [] data,int id){
		List<Total> totalday;
		int person=0;
		//游客量信息
		//当天信息处理
		//SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		//获取当前月的第一天
        
       // Calendar ca = Calendar.getInstance();   
        //ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH)); 
        //int year = ca.get(Calendar.YEAR);
        //int month = ca.get(Calendar.MONTH) + 1;
        System.out.println("===============last:"+month);
        
		//Date date=new Date();
		//String newbefore=sf.format(date);
		totalday = bizService.getTotalBiz().getTimemonthguide(year+"",month+"",  " 08:00:00", " 09:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[0]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonthguide(year+"",month+"",  " 10:00:00", " 11:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[1]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonthguide(year+"",month+"",  " 12:00:00", " 13:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[2]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonthguide(year+"",month+"",  " 14:00:00", " 15:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[3]=person;
		person=0;
		totalday = bizService.getTotalBiz().getTimemonthguide(year+"",month+"",  " 16:00:00", " 17:59:59",id);
		for(Total s:totalday){
			person+=s.getPerson();
		}
		data[4]=person;
		person=0;
		return data;
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
