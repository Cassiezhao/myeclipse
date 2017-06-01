package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.bean.PageBean;
import chris.biz.iSessionBiz;
import chris.dao.GuideDAO;
import chris.pojo.Guide;
import chris.pojo.Memory;
import chris.pojo.Session;
import chris.pojo.Systemscore;
import chris.pojo.User;
import chris.service.BizService;
import chris.service.DaoService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.json.JsonResult;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
public class GuideAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4662569447949994340L;
	private Map<String, Object> session;
	private int page;
	private int jia;
	private int gxg;
	
	public int getGxg() {
		return gxg;
	}

	public void setGxg(int gxg) {
		this.gxg = gxg;
	}

	public int getJia() {
		return jia;
	}

	public void setJia(int jia) {
		this.jia = jia;
	}

	private int rows;
	private String path;
	private int index;
	//判断标记
	
	
	private int i;
	private int sousuo;
	private String xuanze;
	public String getXuanze() {
		return xuanze;
	}

	public void setXuanze(String xuanze) {
		this.xuanze = xuanze;
	}

	private String checkbox;
	List<Guide> glist = new ArrayList<Guide>();

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public int getSousuo() {
		return sousuo;
	}

	public void setSousuo(int sousuo) {
		this.sousuo = sousuo;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private Guide guide;

	public Guide getGuide() {
		return guide;
	}

	public void setGuide(Guide guide) {
		this.guide = guide;
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

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	
	/**
	 * 导游存储
	 * @return
	 */
	@Action(value = "save_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String save() {
		//导游存储
		List<Guide> daoyos2 = bizService.getGuideBiz().findAll();
		for(Guide g:daoyos2){
			if(g.getGuidenum().equals(guide.getGuidenum())){
				
				path="guidemachine/guideNew1.jsp";
				return "ok";
				
			}
		}
		
		/**
		 * 设置初始状态
		 */
		guide.setState(0);
		guide.setHege(1);
		guide.setLianxujiangjie(1);
		guide.setChoutingjiangjie(0);
		guide.setOnnum(0);
		guide.setOntime(0);
		guide.setWzxx(0);
		guide.setSxdd(0);
		guide.setSumscore(0.0);
		guide.setYoukescore(0+"");
		guide.setGpassword("123");
		bizService.getGuideBiz().save(guide);
		
		
		System.out.println(guide.getGuideid() + ";" + guide.getBirth());
		session.put("guide", guide);
		path = "findAll_Guide?i=1";
		jilu("录入导游"+guide.getGuidename());
		
		return "ok";
	}
	
	/**
	 * 进入数据备份表
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
	
	/**
	 * 
	 * @return
	 *   导游管理核心模块
	 * 
	 */
	@Action(value = "findAll_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findAll() {
		List<Guide> guides = null;
		Guide findById ;
		PageBean pb = (PageBean) session.get("pb");
		pb = pb == null ? new PageBean() : pb;
		page = page == 0 ? (pb.getPage() == 0 ? 1 : pb.getPage()) : page;
		rows = rows == 0 ? (pb.getRows() == 0 ? 10 : pb.getRows()) : rows;
		session.put("total",bizService.getGuideBiz().findAll().size());
		session.put("dyxx",bizService.getGuideBiz().findAll() );
		
		//根据sousuo来进行导游查询的条件
		switch (sousuo) {
		case 1:
			if(xuanze!=null){
			//进行导游机编号查询
			sousuo=0;
			guides = bizService.getGuideBiz().findByGnum(xuanze);
			session.put("dyxx",guides);
			session.put("total",guides.size());
			}
			break;
		case 2:
			//导游姓名查询
			if(xuanze!=null){
			sousuo=0;
			guides=bizService.getGuideBiz().findByGname(xuanze);
			session.put("dyxx",guides);
			session.put("total",guides.size());}
			break;
		case 3:
			//就两个查询没有了
			break;
		default:
			sousuo = 0;
			guides = bizService.getGuideBiz().findAll(page,rows);
			
			break;
		}
		/**
		 * 再这里加入一个flag标记
		 */

		pb.setPagelist(guides);
		
		pb.setPage(page);
		pb.setRows(rows);
		
		//存储当前页面和行数
		session.put("page", page);
		session.put("rows", rows);
		session.put("pb", pb);
		//根据i值不同 设置导游的状态 
		switch (i) {
		case 1:
			if(gxg!=10)
			{
			if(index!=0){
			findById= bizService.getGuideBiz().findById(index);
			
			if(jia==1){
				jia=4;
				findById.setState(3);
				bizService.getGuideBiz().update(findById);
			}else if(jia==2)
			{
				jia=4;
				findById.setState(0);
				bizService.getGuideBiz().update(findById);
			}else if(jia==3){
				jia=4;
				findById.setState(4);
				bizService.getGuideBiz().update(findById);
			}else if(jia==5){
				findById.setState(5);
				jia=4;
				bizService.getGuideBiz().update(findById);
			}else{
				findById.setState(0);
				bizService.getGuideBiz().update(findById);
			}
			}
			//获取所有导游
			guides = bizService.getGuideBiz().findAll(page, rows);
			pb.setPagelist(guides);
			pb.setPage(page);
			pb.setRows(rows);
		
			session.put("pb", pb);
			
			}
			path = "guidemanage/guideMessage1.jsp";
			break;
		case 2:
			
			//在线导游部分的跳转
			guides = bizService.getGuideBiz().findzaixian(page,rows);
			pb.setPagelist(guides);
			pb.setPage(page);
			pb.setRows(rows);
			session.put("pb", pb);
			StringBuffer sb2 = new StringBuffer();
			sb2.append("[");
			int b = 0;
			for (Guide a1 : guides) {
				a1.getJingdu();
				/**
				 * 经纬度jason拼接
				 */
				if (b == guides.size() - 1) {
					sb2.append("{\"lng\":" + a1.getJingdu() + ",\"lat\":"
							+ a1.getWeidu() + ",\"count\":" + a1.getYoukeMnum()
							+ "}");
				} else {
					sb2.append("{\"lng\":" + a1.getJingdu() + ",\"lat\":"
							+ a1.getWeidu() + ",\"count\":" + a1.getYoukeMnum()
							+ "},");
				}
				b++;
			}
			session.put("total", bizService.getGuideBiz().findzaixian().size());
			sb2.append("];");
			String gaga = sb2.toString();
			session.put("gjing1", 108.893613f);
			session.put("gwei1", 34.157044f);
			session.put("initdata", gaga);
			path = "guidemanage/guideOnline.jsp";
			break;
		case 3:
			
			//直接进入在线信息模块
			path = "guidemanage/guideOnlineMessage.jsp";
			break;
			
		case 4:
			
			//导游基本信息模块
			Systemscore ssyss = bizService.getSysScoreBiz().findAll().get(0);
			System.out.println("进入评价开始");
			// 获取基本的信息 将基本信息处理并且赋值
			session.put("pingjia", 100);
			for (Guide ev : guides) {
				System.out.println(ev.getGuidename());
				int a = 0;
				if (ev.getLevel() == null) {
				} else if (ev.getLevel().contains("一")) {
					a += ssyss.getPutong1();
				} else if (ev.getLevel().contains("二")) {
					a += ssyss.getPutong2();
				} else {
					a += ssyss.getPutong3();
				}

				if (ev.getSchool() == null | ev.getWorkage() == null) {

				} else if ((ev.getSchool().contains("专") && ev.getWorkage() > 9)
						|| (ev.getSchool().contains("本") && ev.getWorkage() > 8)
						|| (ev.getSchool().contains("硕") && ev.getWorkage() > 6)) {
					a += ssyss.getXueli1();
				} else if ((ev.getSchool().contains("专")
						&& ev.getWorkage() <= 9 && ev.getWorkage() > 4)
						|| (ev.getSchool().contains("本")
								&& ev.getWorkage() <= 8 && ev.getWorkage() > 3)
						|| (ev.getSchool().contains("硕")
								&& ev.getWorkage() <= 6 && ev.getWorkage() > 1)) {
					a += ssyss.getXueli2();
				} else {
					a += ssyss.getXueli3();
				}
				// 证书
				if (ev.getExperice() != null) {
					String[] jiang = ev.getExperice().split("奖");
					String[] yu = ev.getLanguage().split("语");
					if (jiang.length + yu.length >ssyss.getYuyanzuigao() ) {
						a += ssyss.getYuyanzuigao();
					} else {
						a = a + jiang.length*ssyss.getYuyan() + yu.length*ssyss.getZhengshu();
					}
				}
				if (a > ssyss.getJibenzuigao()) {
					a = ssyss.getJibenzuigao();
				}
				ev.setScore(a + "");
				System.out.println(ev.getScore() + "结束");
				bizService.getGuideBiz().update(ev);
			}

			path = "evaluationMessage/evaluationMessage.jsp";
			break;
		case 5:{
			
			//导游监听模块
			guides = bizService.getGuideBiz().findzaixian(page,rows);
			pb.setPagelist(guides);
			session.put("total", bizService.getGuideBiz().findzaixian().size());
			session.put("pb", pb);
			path = "guidemanage/monitorGuide.jsp";
			break;
		}
		default:
			break;
		}

		return "ok";
	}

	/*
	 * 这里处理评分情况 TODO goto
	 */

	@Action(value = "init_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String init() {

		return "ok";
	}

	@Action(value = "findById1_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById1() {
		/**
		 * 这里处理得分情况 TODO
		 */
		Systemscore syso = bizService.getSysScoreBiz().findAll().get(0);
		Guide guide = bizService.getGuideBiz().findById(index);
		Map<String, Integer> map = new HashMap<String, Integer>();
		int congye = 0;
		if (guide.getSchool() == null | guide.getWorkage() == null) {

		} else if ((guide.getSchool().contains("专") && guide.getWorkage() > 9)
				|| (guide.getSchool().contains("本") && guide.getWorkage() > 8)
				|| (guide.getSchool().contains("硕") && guide.getWorkage() > 6)) {
			congye += syso.getXueli1();
		} else if ((guide.getSchool().contains("专") && guide.getWorkage() <= 9 && guide
				.getWorkage() > 4)
				|| (guide.getSchool().contains("本") && guide.getWorkage() <= 8 && guide
						.getWorkage() > 3)
				|| (guide.getSchool().contains("硕") && guide.getWorkage() <= 6 && guide
						.getWorkage() > 1)) {
			congye += syso.getXueli2();
		} else {
			congye += syso.getXueli3();
		}
		map.put("congye", congye);
		// 普通话等级
		int yuyan = 0;
		if (guide.getLevel() == null) {
		} else if (guide.getLevel().contains("一")) {
			yuyan +=syso.getPutong1();
		} else if (guide.getLevel().contains("二")) {
			yuyan += syso.getPutong2();
		} else {
			yuyan += syso.getPutong3();
		}
		map.put("yuyan", yuyan);
		// 语言和证书
		int zhengshu = 0;
		if (guide.getExperice() != null) {
			String[] jiang = guide.getExperice().split("奖");
			String[] yu = guide.getLanguage().split("语");
			if (jiang.length + yu.length > syso.getYuyanzuigao()) {
				zhengshu += syso.getYuyanzuigao();
			} else {
				zhengshu = zhengshu + jiang.length*syso.getYuyan() + yu.length*syso.getZhengshu();
			}
		}
		map.put("zhengshu", zhengshu);
		System.out.println(congye + ":" + yuyan + ":" + zhengshu);
		session.put("map", map);
		session.put("guide", guide);
		System.out.println(guide.getGuidename());
		path = "evaluationMessage/initialevaluation.jsp";
		return "ok";
	}

	@Action(value = "delById_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String delById() {
		User host=(User) session.get("nuser");
		if(host.getUserpower()!=1){
			path="guidemanage/guideMessage1.jsp";
			return "ok";
		}
		try {
			System.out.println(index);
			String a=bizService.getGuideBiz().findById(index).getGuidename();
			bizService.getGuideBiz().delById(index);
			jilu("删除导游"+a);
			path = "findAll_Guide?i=1";
			return "ok";
		} catch (Exception e) {
			throw new RuntimeException("删除失败");
		}
	}

	@Action(value = "findById2_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById2() {
		User host=(User) session.get("nuser");
		if(host.getUserpower()!=1){
			path="guidemanage/guideMessage1.jsp";
			return "ok";
		}
		System.out.println(index);
		Guide guide2 = bizService.getGuideBiz().findById(index);
		session.put("guide2", guide2);
		System.out.println(guide2.getGuidename());
		path = "guidemanage/guideModify.jsp";
		return "ok";
	}

	@Action(value = "findById3_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById3() {
		System.out.println(index);
		Guide guide3 = bizService.getGuideBiz().findById(index);
		session.put("guide3", guide3);
		System.out.println(guide3.getGuidename());
		path = "guidemanage/guidePathAnalysis.jsp";
		return "ok";
	}

	/*
	 * 导游的详细信息 TODO goto
	 */
	@Action(value = "findById4_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findById4() {
		System.out.println(index);
		Guide guide4 = bizService.getGuideBiz().findById(index);
		session.put("guide4", guide4);
		System.out.println(guide4.getGuidename());
		path = "guidemanage/guideDetail.jsp";
		return "ok";
	}

	@Action(value = "update_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String update() {
		System.out.println(guide.getGuidename());
		try {
			/*
			 * 导游的信息更新
			 * */
			Guide old = bizService.getGuideBiz().findById(guide.getGuideid());
			old.setAge(guide.getAge());
			old.setGuidename(guide.getGuidename());
			old.setSchool(guide.getSchool());
			old.setIdcard(guide.getIdcard());
			old.setGsex(guide.getGsex());
			old.setBirth(guide.getBirth());
			old.setGtel(guide.getGtel());
			old.setLanguage(guide.getLanguage());
			old.setLevel(guide.getLevel());
			old.setBlood(guide.getBlood());
			old.setWeight(guide.getWeight());
			old.setHeight(guide.getHeight());
			old.setGuidenum(guide.getGuidenum());
			old.setWorkage(guide.getWorkage());
			old.setDiseases(guide.getDiseases());
			old.setHege(guide.getHege());
			old.setLianxujiangjie(guide.getLianxujiangjie());
			old.setExperice(guide.getExperice());
			
			bizService.getGuideBiz().update(old);
			path = "findAll_Guide?i=1";
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		path = "error.jsp";
		return "ok";
	}

	@Action(value = "checkbox_Guide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String checkbox() {
		System.out.println(checkbox);
		String[] a = checkbox.split(",");
		
		StringBuffer sb = new StringBuffer();
		int id = 0;
		// {"lng":109.286153,"lat":34.390254,"count":50},
		// sb.append("[");

		List<Guide> guides2 = null;
		try {
			guides2 = new ArrayList<Guide>();
			Guide guide_new;
			for (int i = 0; i < a.length; i++) {
				//id = Integer.parseInt(a[i].trim());
				Guide a1 = bizService.getGuideBiz().findById2(a[i].trim());
				guide_new = new Guide();
				guide_new.setJingdu(a1.getJingdu());
				guide_new.setWeidu(a1.getWeidu());
				guide_new.setYoukeMnum(a1.getYoukeMnum());
				guides2.add(guide_new);
				System.out.println(a1.getGuidename());
			/**
			 * json解析。
			 * 
			 */
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//进行jason解析
		String lsempjsonString = JSON.toJSONString(guides2);
		//System.out.println(lsempjsonString);
		
		print(lsempjsonString);
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
}
