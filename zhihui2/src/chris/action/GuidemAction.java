package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.stereotype.Service;

import chris.bean.PageBean;
import chris.dao.GuidemdtDAO;
import chris.dao.MemoryDAO;
import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.pojo.Guidemdt;
import chris.pojo.Memory;
import chris.pojo.Session;
import chris.pojo.User;
import chris.pojo.Youkem;
import chris.service.BizService;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
public class GuidemAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6299904952266089765L;
	private Map<String, Object> session;
	private int page;
	private int rows;
	private String path;
	private int index;
	private Guidem guidem;
	private String guidenum;
	private String guidemtel;
	public String getGuidemtel() {
		return guidemtel;
	}

	public void setGuidemtel(String guidemtel) {
		this.guidemtel = guidemtel;
	}

	private int i;
	private int j;
	private int xuanze;
	private String shuju;
	private Date before;
	private Date after;
	private String newgunm;
	private String newmnum;
	private int youke;
	private int tt;
	
	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public int getYouke() {
		return youke;
	}

	public void setYouke(int youke) {
		this.youke = youke;
	}

	public String getNewgunm() {
		return newgunm;
	}

	public void setNewgunm(String newgunm) {
		this.newgunm = newgunm;
	}

	public String getNewmnum() {
		return newmnum;
	}

	public void setNewmnum(String newmnum) {
		this.newmnum = newmnum;
	}

	public int getXuanze() {
		return xuanze;
	}

	public void setXuanze(int xuanze) {
		this.xuanze = xuanze;
	}

	public String getShuju() {
		return shuju;
	}

	public void setShuju(String shuju) {
		this.shuju = shuju;
	}

	public Date getBefore() {
		return before;
	}

	public void setBefore(Date before) {
		this.before = before;
	}

	public Date getAfter() {
		return after;
	}

	public void setAfter(Date after) {
		this.after = after;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getGuidenum() {
		return guidenum;
	}

	public void setGuidenum(String guidenum) {
		this.guidenum = guidenum;
	}

	public Guidem getGuidem() {
		return guidem;
	}

	public void setGuidem(Guidem guidem) {
		this.guidem = guidem;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Resource(name = "BizService")
	private BizService bizService;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;

	}
	/**
	 * 借导游机的跳转单元
	 * @return
	 */
	@Action(value = "toborrow_Guidem", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String toborrow() {
		System.out.println("测试进入");
		path = "init_Youkem?k=2";
		return "ok";
	}

	/**
	 * 指派导游机
	 * 
	 * @return
	 */
	@Action(value = "update_Guidem", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String update() {
		/**
		 * 下面是游客机的分配情况
		 */
		session.put("err2", "");
		session.put("err3", "");
		
		/**
		 * 分配导游机，应当将上一次的导游机的信息清零
		 */

		session.put("heihei", 2);
		Guidem a = null;
		String c;
		System.out.println(guidem.getGuidemnum());
		try {
			c=guidem.getGuide().getGuidenum();
			//根据导游机编号找到导游机
			a = bizService.getGuidemBiz().findById2(guidem.getGuidemnum());
		} catch (Exception e) {
			
			throw new RuntimeException("导游机不存在");
		}
		//1,可借，2借出，3损坏 4维修
		if(a==null || a.getGmstate()!=1){
			session.put("err2", "导游机编号不存在，或已借出");
			path="toborrow_Guidem";
			return "ok";
		}
		a.setAssignTime(new Timestamp(System.currentTimeMillis()));
		Guide b = null;
		try {
			//根据导游编号查询
			b = bizService.getGuideBiz().findById2(
					guidem.getGuide().getGuidenum());
		} catch (Exception e) {
			throw new RuntimeException("导游不存在");
		}
		List<Guidem> daoyouji = bizService.getGuidemBiz().findAll2();
		//遍历导游机
		for(Guidem g:daoyouji){
			
			if(g.getGmstate()==2){
				String d=g.getGuide().getGuidenum();
				System.out.println(c+"================="+d);
				if(d.equals(c)){
					session.put("err2","");
					session.put("err3","导游不存在,或已经派出！");
					path="toborrow_Guidem";
					return "ok";
				}
			}
		
		}
		Youkem youke = bizService.getYoukemBiz().findById(1);
		if(guidem.getYoukeNum()!=null){
			if(guidem.getYoukeNum()>youke.getYoukeMle()){
				session.put("err4","超出剩余游客机");
				path="toborrow_Guidem";
				return "ok";
			}
		}
		
//		if(b==null || b.getState()!=0||a.getGuide().getGuidenum()==guidem.getGuide().getGuidenum()){
//			
//		}
		
		youke.setYoukeMbr(guidem.getYoukeNum()
				+ youke.getYoukeMbr());
		youke.setYoukeMle(youke.getYoukeMle()
				- guidem.getYoukeNum());
		youke.setYoukeMboom(youke.getYoukeMboom());
		bizService.getYoukemBiz().update(youke);
		session.put("err2","");
		session.put("err3","");
		session.put("err4","");
		//导游机表设置导游
		a.setGuide(b);
		a.setGmstate(2);
		a.setYoukeNum(guidem.getYoukeNum());
		a.setRetT(null);
		int brotime=0;
		if(a.getBorrow()!=null){
			brotime=a.getBorrow();
		}
		a.setBorrow(brotime + 1);
		//导游表设置导游机
		b.setGuidem(a);
		b.setState(1);
		//session表的操作
		if(b.getOntimenum()==null){
			b.setOntimenum(1);
		}else{
			b.setOntimenum(b.getOntimenum()+1);
		}
		
		
		System.out.println(b.getOntimenum());
		b.setYoukeMnum(guidem.getYoukeNum());
		bizService.getGuideBiz().update(b);
		bizService.getGuidemBiz().update(a);
		path = "findAll_Guidem?i=1";
		
		jilu("指派导游机"+a.getGuidemnum()+"号");
		return "ok";
	}
	
	
	//进行数据备份
	public void jilu(String s){
		Memory me=new Memory();
		me.setMessage(s);
		User host=(User) session.get("nuser");
		me.setUser(host);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		me.setMtime(d);
		me.setOpuser(host.getUsername());
		bizService.getMemoryBiz().save(me);
	}
	
	@Action(value = "findAll_Guidem", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findAll() {
		String url=null;
		PageBean pb2 = (PageBean) session.get("pb2");
		pb2 = pb2 == null ? new PageBean() : pb2;
		page = page == 0 ? (pb2.getPage() == 0 ? 1 : pb2.getPage()) : page;
		rows = rows == 0 ? (pb2.getRows() == 0 ? 10 : pb2.getRows()) : rows;
		List<Guidem> guidems=null;
		session.put("url","../findAll_Guidem?");
		/**
		 * i=1时，进入已经借出的界面
		 */
		if (i == 1) {
			
			//xuanze代表不同的查询的方式
			switch (xuanze) {
			case 1:
				if(shuju!=null){
				//按照导游机编号查询
				 try {
					guidems = bizService.getGuidemBiz().findByGuidenum(shuju);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 session.put("total2", guidems.size());
				 pb2.setPagelist(guidems);
					session.put("pb2", pb2);
					session.put("dcgm", guidems);
				}
					path = "guidemachine/alreadyBorrow.jsp";
					return "ok";
			case 2:
				//按照导游编号查询
				if(shuju!=null){
				try {
				System.out.println(shuju);
				guidems = bizService.getGuidemBiz().findByGnum(shuju);
					//System.out.println(guidems.get(0).getGmstate()+guidems.get(0).getGuidemid());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 pb2.setPagelist(guidems);
				 session.put("total2", 1);
					session.put("pb2", pb2);
					session.put("dcgm", guidems);
				}
					path = "guidemachine/alreadyBorrow.jsp";
					return "ok";
			case 3:
				//按照导游姓名查询
				if(shuju!=null){
				try {
					guidems = bizService.getGuidemBiz().findByGname(shuju);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 pb2.setPagelist(guidems);
				 session.put("total2", guidems.size());
					session.put("pb2", pb2);
					session.put("dcgm", guidems);
				}
					path = "guidemachine/alreadyBorrow.jsp";
					return "ok";
			case 4:
			if(before!=null &&  after!=null){
				SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String newbefore=sf.format(before);
				String newlater=sf.format(after);
				System.out.println("当前的时间"+newbefore+"::"+newlater +"xuanze::"+xuanze);
				try {
					guidems = bizService.getGuidemBiz().onTime(newbefore, newlater,page,rows);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 pb2.setPagelist(guidems);
				 session.put("dcgm", guidems);
					session.put("pb2", pb2);
					session.put("total2", bizService.getGuidemBiz().onTime(newbefore, newlater));
					session.put("url", "../findAll_Guidem?xuanze="+xuanze+"&before="+newbefore+"&after"+newlater+"&");
			}
					path = "guidemachine/alreadyBorrow.jsp";
					return "ok";
			default:
				//默认全部查找
				guidems = bizService.getGuidemBiz().findjiechcu(page,rows);
				pb2.setPagelist(guidems);
				
				pb2.setPage(page);
				pb2.setRows(rows);
				session.put("rows2", rows);
				session.put("page2", page);
				session.put("total2", guidems.size());
				session.put("pb2", pb2);
				session.put("dcgm", guidems);
				path = "guidemachine/alreadyBorrow.jsp";
				break;
			}
			
			
		} 
		else {
			guidems = bizService.getGuidemBiz().findAll(page,rows);
			pb2.setPagelist(guidems);
			
			pb2.setPage(page);
			pb2.setRows(rows);
			session.put("rows2", rows);
			session.put("page2", page);
			session.put("total2", guidems.size());
			session.put("pb2", pb2);
			session.put("dcgm", guidems);
			path = "guidemachine/useMessage2.jsp";
		}

		return "ok";
	}
	/**
	 * 快捷归还
	 * @return
	 */
	@Action(value = "findById3_Guidem", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById3(){
		 
			//快捷归还
			List<Guidem> listg = bizService.getGuidemBiz().findAll2();
			session.put("BYZ","");
			System.out.println(guidem.getGuidemnum()+""+guidem.getGuide().getGuidenum()+"tt"+tt+"youke"+youke);
			String aa=guidem.getGuidemnum();
			String bb=guidem.getGuide().getGuidenum();
			int sd=bizService.getGuidemBiz().findById2(guidem.getGuidemnum()).getGuidemid();
			//导游通过导游机的id找到导游
			System.out.println("这个是导游机的ID"+sd);
			List<Guide> guidemss = bizService.getGuideBiz().findbyMid(sd);
			
			Youkem youke2 = bizService.getYoukemBiz().findById(1);		
			
			Session myCsession = null;
			for(Guidem gm:listg){
				if(gm.getGuidemnum().equals(aa)&& gm.getGuide().getGuidenum().equals(bb))
				{
					
					Integer c = gm.getYoukeNum();
					if(c==null){
						c=0;
					}
					gm.setYoukeNum(0);
					gm.setRetT(new Timestamp(System.currentTimeMillis()));
					//tt代表是否有损坏 1是无损，0是有损
					if(tt==1){
						gm.setGmstate(1);
						gm.setBreakinfo("无");
						youke2.setYoukeMbr(youke2.getYoukeMbr() - c);
						youke2.setYoukeMle(youke2.getYoukeMle() + c);
						youke2.setYoukeMboom(youke2.getYoukeMboom());
						session.put("BYZ","归还成功！点击可再次归还");
						jilu("归还导游机"+gm.getGuidemnum()+"号");
						
						Guidemdt gdt=new Guidemdt();
						gdt.setGuidemid(gm.getGuidemnum());
						gdt.setBrot(gm.getAssignTime());
						gdt.setRett(gm.getRetT());
						gdt.setSutinfo(gm.getBreakinfo());
						bizService.getGuidemdtBiz().save(gdt);
						
					}else if(tt==0){
						gm.setGmstate(3);
						gm.setBreakinfo(guidem.getBreakinfo());
						gm.setBreak_(gm.getBreak_()+1);
						youke2.setYoukeMbr(youke2.getYoukeMbr() - c);
						youke2.setYoukeMle(youke2.getYoukeMle() + c-youke);
						youke2.setYoukeMboom(youke2.getYoukeMboom()+youke);
						session.put("BYZ","损坏记录完成！点击可再次归还");
						jilu("导游机损坏"+gm.getGuidemnum()+"号");
						
						Guidemdt gdt=new Guidemdt();
						gdt.setGuidemid(gm.getGuidemnum());
						gdt.setBrot(gm.getAssignTime());
						gdt.setRett(gm.getRetT());
						gdt.setSutinfo(gm.getBreakinfo());
						bizService.getGuidemdtBiz().save(gdt);
					}
					/**
					 * 更新数据表操作，dephi后台需要使用
					 */
					try {
						for(Guide g1:guidemss){
							
							g1.setGuidem(null);
							g1.setState(0);
							g1.setYoukeMnum(0);
							myCsession = bizService.getSessionBiz().findByid(g1.getSessonid());
							bizService.getGuideBiz().update(g1);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					Guide g2 = guidemss.get(0);
//					List<Session> session1 = bizService.getSessionBiz().findBygId(g2.getGuideid());
//					for(Session session2:session1){
//						session2.setState(0);
//						bizService.getSessionBiz().update(session2);
//					}
					if(myCsession!=null){
					if(myCsession.getUplineT()==null){
						System.out.println("执行");
						myCsession.setUplineT(new Timestamp(System.currentTimeMillis()));
					}
					myCsession.setState(0);
					bizService.getSessionBiz().update(myCsession);
					}
					gm.setGuide(null);
					gm.setYoukeNum(0);
					bizService.getYoukemBiz().update(youke2);
					bizService.getGuidemBiz().update(gm);
					break;
				}
				
		}
			path="findAll_Guidem?i=1";
		return "ok";
	}
	
	/**
	 * 导游机归还模块
	 * @return
	 */
	@Action(value = "findById_Guidem", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById() {
		Guidem a = bizService.getGuidemBiz().findById(index);
		List<Guide> sad = bizService.getGuideBiz().findbyMid(index);
		 Session myCsession = null;
		System.out.println("导游idsadas"+index+":"+j);

		/**
		 * 下面是提交,归还
		 */
		if (j == 1) {
			
			if(newgunm!=null || newmnum!=null){
				
				if(a.getGuidemnum().equals(newmnum) &&a.getGuide().getGuidenum().equals(newgunm)){
					a.setGmstate(1);
					
					Integer c = a.getYoukeNum();
					if(c==null){
						c=0;
					}
					a.setYoukeNum(0);
					//bizService.getGuidemBiz().update(a);
					Youkem youke = bizService.getYoukemBiz().findById(1);
					
					youke.setYoukeMbr(youke.getYoukeMbr() - c);
					youke.setYoukeMle(youke.getYoukeMle() + c);
					youke.setYoukeMboom(youke.getYoukeMboom());
					
					
					bizService.getYoukemBiz().update(youke);
					a.setRetT(new Timestamp(System.currentTimeMillis()));
					
					try {
						for(Guide g1:sad){
							System.out.println("这是导游姓名"+g1.getGuidename()+"这是导游id"+g1.getGuideid());
							g1.setGuidem(null);
							g1.setState(0);
							g1.setYoukeMnum(0);
							//找到sessionid
							myCsession = bizService.getSessionBiz().findByid(g1.getSessonid());
						 	
							bizService.getGuideBiz().update(g1);
							
//							List<Session> session1 = bizService.getSessionBiz().findBygId(g1.getGuideid());
//							for(Session session2:session1){
//								session2.setState(0);
//								bizService.getSessionBiz().update(session2);
//							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					a.setGuide(null);
					a.setBreakinfo("无");
					if(myCsession!=null){
					if(myCsession.getUplineT()==null){
						System.out.println("执行");
						myCsession.setUplineT(new Timestamp(System.currentTimeMillis()));
					}
					myCsession.setState(0);
					bizService.getSessionBiz().update(myCsession);
					}
					bizService.getGuidemBiz().update(a);
					
					Guidemdt gdt=new Guidemdt();
					gdt.setGuidemid(a.getGuidemnum());
					gdt.setBrot(a.getAssignTime());
					gdt.setRett(a.getRetT());
					gdt.setSutinfo(a.getBreakinfo());
					bizService.getGuidemdtBiz().save(gdt);
					
					jilu("归还导游机"+a.getGuidemnum()+"号");
					// 游客机的标志位,使得进入游客机进入可以刷新
					session.put("heihei", 2);
					session.put("BYZ","归还成功！点击可再次归还");
				}else{
					session.put("BYZ","核对出现异常，导游编号或导游机编号异常");
				}
				
			}else{
			session.put("BYZ","输入导游机编号或者导游编号不能为空");
			
			}
			path="findAll_Guidem?i=1";
			return "ok";

		}  else if(j == 5){
			a.setGmstate(1);
			
			bizService.getGuidemBiz().update(a);
			// 游客机的标志位,使得进入游客机进入可以刷新
			session.put("heihei", 2);
			path = "findAll_Guidem";
		}
		/**
		 * 正在维修
		 */
		else {
			a.setGmstate(4);
			path = "findAll_Guidem";
			bizService.getGuidemBiz().update(a);

		}

		return "ok";

	}

	/**
	 * 保存导游模块
	 * @return
	 */
	
	@Action(value = "save_Guidem", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String save_Guidem() {
		User host=(User) session.get("nuser");
		if(host.getUserpower()!=1){
			return "ok";
		}
		System.out.println(guidenum+":+++++++++++++++++++++++++++++++"+guidemtel);
		Guidem g = new Guidem();
		g.setGuidemnum(guidenum);
		g.setGmtel(guidemtel);
		g.setGmstate(1);
		g.setBorrow(0);
		g.setYoukeNum(0);
		g.setBreak_(0);
		g.setMkdir(100001);
		g.setMkstatus(2);
		g.setListennum(0);
		g.setRecordtime(0);
		int c=0;
		boolean a ;
		List<Guidem> lg = bizService.getGuidemBiz().findAll2();
		for(Guidem g2s:lg){
			if(g2s.getGuidemnum().equals(guidenum)){
				c=1;
			}
		}
		if(c==1){
			a=false;
		}else{
			a= bizService.getGuidemBiz().save(g);
		}
		String lsempjsonString = null;
		if (a) {
			jilu("添加导游机成功"+g.getGuidemnum()+"号");
			lsempjsonString = JSONObject.toJSONString("添加成功");
		} else {
			jilu("添加导游机失败"+g.getGuidemnum()+"号");
			lsempjsonString = JSONObject.toJSONString("添加失败");
		}
		print(lsempjsonString);
		path = null;
		return null;
	}
	
	/**
	 * 改变导游电话号码
	 * @return
	 */
	@Action(value = "changeTel_Guidem", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String changeTel_Guidem(){
		String c=guidem.getGuidemnum();
		String d=guidem.getGmtel();
		System.out.println(c+"----------------"+d);
		Guidem guidem2 = bizService.getGuidemBiz().findByGuidenum(c).get(0);
		guidem2.setGmtel(d);
		bizService.getGuidemBiz().update(guidem2);
		String f=c+d;
		String lsempjsonString = JSONObject.toJSONString(f);
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

}
