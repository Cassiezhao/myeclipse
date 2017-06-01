package chris.action;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.bean.PageBean;
import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.pojo.Session;
import chris.pojo.Systemscore;
import chris.pojo.Total;
import chris.service.BizService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
public class PathsAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private int index;
	private int page;
	private int rows;
	private String path;
	private int sessionid;
	private int i;
	private int sid;
	private int sousuo2;
	private Date before;
	private Date later;

	public Date getBefore() {
		return before;
	}

	public void setBefore(Date before) {
		this.before = before;
	}

	public Date getLater() {
		return later;
	}

	public void setLater(Date later) {
		this.later = later;
	}

	public int getSousuo2() {
		return sousuo2;
	}

	public void setSousuo2(int sousuo2) {
		this.sousuo2 = sousuo2;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getSessionid() {
		return sessionid;
	}

	public void setSessionid(int sessionid) {
		this.sessionid = sessionid;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Resource(name = "BizService")
	private BizService bizService;

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

	// TODO Auto-generated method stub
	@Action(value = "findByGid_Paths", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findByGid() {
		/**
		 * index 就是导游的id
		 */
		List<Session> a = null;
		List<Session> mylistsession = null;
		PageBean pathpb = (PageBean) session.get("pathpb");
		pathpb = pathpb == null ? new PageBean() : pathpb;
		page = page == 0 ? (pathpb.getPage() == 0 ? 1 : pathpb.getPage())
				: page;
		rows = rows == 0 ? (pathpb.getRows() == 0 ? 10 : pathpb.getRows())
				: rows;
		System.out.println("当前是第几页多少数据呢"+page+"::"+rows);
		pathpb.setPage(page);
		pathpb.setRows(rows);
		session.put("page3", page);
		session.put("rows3", rows);
		
		switch (sousuo2) {
		/**
		 * 这个是导游上下线详情
		 */
		case 1:
				System.out.println("这是现在的时间"+before+"没错"+later);
			if(before!=null && later!=null){
			// 按照上线时间搜索
			System.out.println("这是我的搜索，下面是我的时间"+sousuo2);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newbefore = sf.format(before);
			String newlater = sf.format(later);
			System.out.println(newbefore + "::" + newlater);

			mylistsession = bizService.getSessionBiz().upTime(newbefore.trim().toString(),
					newlater.trim().toString(),index);
			
			
			a= bizService.getSessionBiz().upTime(newbefore, newlater, page, rows, index);
			session.put("total3", mylistsession.size());
			System.out.println(a.size());
			session.put("url", "../findByGid_Paths?before="+newbefore+"&later="+newlater+"&sousuo2="+sousuo2+"&");
			}
			
		
			session.put("guide_Analsy",mylistsession );
			
			break;
		case 2:
			// 下线时间
			System.out.println("这是现在的时间"+before+"没错"+later);
			if(before!=null && later!=null){
			System.out.println("这是我的搜索，下面是我的时间"+sousuo2);
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newbefore2 = sf2.format(before);
			String newlater2 = sf2.format(later);
			System.out.println(newbefore2 + "::" + newlater2);
			mylistsession = bizService.getSessionBiz().upTime(newbefore2.trim().toString(),
					newlater2.trim().toString(),index);
			
			a= bizService.getSessionBiz().upTime(newbefore2, newlater2, page, rows, index);
			session.put("total3", mylistsession.size());
			session.put("url", "../findByGid_Paths?before="+newbefore2+"&later="+newlater2+"&sousuo2="+sousuo2+"&");
			}
			
			
			System.out.println(a.size());
			session.put("guide_Analsy",mylistsession );
			break;
			/**
			 * 这个是导游评价详情
			 */
		case 3:
			System.out.println("这是现在的时间"+before+"没错"+later);
			if(before!=null && later!=null){
			SimpleDateFormat sf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newbefore3 = sf3.format(before);
			String newlater3 = sf3.format(later);
			System.out.println("进入这是3时间选择"+newbefore3 + "::" + newlater3);

			mylistsession = bizService.getSessionBiz().upTime(newbefore3.trim().toString(),
					newlater3.trim().toString(),index);
			
			a= bizService.getSessionBiz().upTime(newbefore3, newlater3, page, rows, index);
			session.put("total3", mylistsession.size());
			System.out.println(a.size());
			session.put("url", "../findByGid_Paths?before="+newbefore3+"&later="+newlater3+"&sousuo2="+sousuo2+"&");
			}
			
			
			
			session.put("guide_Analsy",mylistsession );
			break;
		default:
			session.put("total3", bizService.getSessionBiz().findBygId(index).size());
			System.out.println(bizService.getSessionBiz().findBygId(index).size());
			System.out.println(sousuo2+"》》》"+index+">>>>>>>"+page+">>>"+rows);
			a = bizService.getSessionBiz().findBygId(page,rows,index);
			System.out.println("搜索到的数据有"+a.size()+"条");
			session.put("url", "../findByGid_Paths?");
			session.put("guide_Analsy",bizService.getSessionBiz().findBygId(index) );
			break;
		}
		pathpb.setPagelist(a);
		session.put("pathpb", pathpb);

		/**
		 * 获取导游的信息
		 */

		Guide b = bizService.getGuideBiz().findById(index);
		session.put("gname", b.getGuidename());
		session.put("gid", b.getGuideid());
		if (i == 1) {

			path = "evaluationMessage/evaluationDetail.jsp";
		} else {

			path = "guidemanage/guidework.jsp";
		}

		return "ok";
	}

	@Action(value = "findByGid2_Paths", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findByGid2() {
		List<Total> a = bizService.getTotalBiz().findBygId( index,
				sessionid);

		/**
		 * 百度地图模块
		 */
		if(a==null){
			path="guidemanage/guidework.jsp";
			return "ok";
		}
		try {
			session.put("jingdu", a.get(0).getJingdu());

			session.put("weidu", a.get(0).getWeidu());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer sb = new StringBuffer();
		/**
		 * 拼接json字符串
		 */
		sb.append("[{points:[");
		for (Total total : a) {
			sb.append("{\"lng\":" + total.getJingdu() + ",\"lat\":"
					+ total.getWeidu() + "},");

		}
		sb.append("]}];");
		String shuai = sb.toString();
		System.out.println(shuai);
		session.put("shuai", shuai);

		int sess = 0;
		Integer c = null;
		try {
			sess = a.get(0).getSession().getSessionId();
			c = a.get(0).getGuideId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.put("sess", sess);
		session.put("daoyouid", c);
		path = "guidemanage/guidePathAnalysis.jsp";
		return "ok";
	}

	// TODO 这里条跳转至single
	
	/**
	 * 
	 * @return
	 * 下述通过session表 进行评分设置
	 */
	@Action(value = "findBysid_Paths", results = { @Result(name = "ok", location = "${path}", type = "redirect")   })
	public String findBysid() {
		Systemscore siy = bizService.getSysScoreBiz().findAll().get(0);

		int shuju = 0, cishu2 = 0;
		
		double sumScore = 0;
		// Session a = bizService.getSessionBiz().findByid(sid);
		// 找到这一个人的所有情况

		List<Guide> alist = bizService.getGuideBiz().findAll();
		// 总上线次数
		int onlineNAver = 0;
		int onlineT = 0;
		for (Guide g1 : alist) {
			if (g1.getOnnum() == null) {
				g1.setOnnum(0);
			}
			if (g1.getOntime() == null) {
				g1.setOntime(0);
			}
			onlineNAver += g1.getOnnum();
			onlineT += g1.getOntime();
		}
		onlineNAver /= alist.size();
		onlineT /= alist.size();
		System.out.println("平均上线次数" + onlineNAver + ":::" + onlineT);
		for (Guide g1 : alist) {
			if (g1.getOnnum() == null) {
				g1.setOnnum(0);
			}
			if (g1.getOntime() == null) {
				g1.setOntime(0);
			}

			if (g1.getWzxx() == null) {
				g1.setWzxx(0);
			}
			if (g1.getSxdd() == null) {
				g1.setSxdd(0);
			}
			if (g1.getOnnum() >= onlineNAver) {
				sumScore += siy.getSxcs();
			}
			if (g1.getOntime() >= onlineT) {
				// shuju=1;
				sumScore += siy.getShangxianshijian();
			}
			if (g1.getWzxx() == 1) {

				sumScore += siy.getWeizhixinxi();
			}
			if (g1.getSxdd() == 1) {
				sumScore += siy.getSxdd();
			}
			if (g1.getYoukescore() == null) {
				g1.setYoukescore(0 + "");
			}
			if (g1.getChoutingjiangjie() == null) {
				g1.setChoutingjiangjie(0);
			}
			sumScore += Integer.parseInt(g1.getScore().trim().toString());
			sumScore += Double.parseDouble(g1.getYoukescore());
			sumScore -= g1.getChoutingjiangjie() * siy.getCtjj();
			if (g1.getHege() == null || g1.getHege() == 0
					|| g1.getLianxujiangjie() == null
					|| g1.getLianxujiangjie() == 0) {
				sumScore = 0;
			}
			g1.setSumscore(sumScore);
			System.out.println(sumScore + "总分");
			bizService.getGuideBiz().update(g1);
			sumScore = 0;
		}

		Guide smlguide = bizService.getGuideBiz().findById(sid);

		System.out.println("欢迎" + smlguide.getGuidename());
		int choue = 0;
		if (smlguide.getChoutingjiangjie() != null) {
			choue = smlguide.getChoutingjiangjie() * siy.getCtjj();
			session.put("choue", choue);
		}
		if (smlguide.getOntime() >= onlineT) {
			shuju = 1;
		}
		if (smlguide.getOnnum() >= onlineNAver) {
			cishu2 = 1;
		}

		int mysum = 0;
		for (Guide gm : bizService.getGuideBiz().findAll()) {
			mysum += gm.getSumscore();
		}
		double panduan = (double) smlguide.getSumscore() / (double) mysum
				* alist.size();
		if (panduan >= 1.5) {
			smlguide.setPinglevel("五星");
		} else if (panduan >= 1.2 && panduan < 1.5) {
			smlguide.setPinglevel("四星");
		} else if (panduan >= 0.8 && panduan < 1.2) {
			smlguide.setPinglevel("三星");
		} else if (panduan >= 0.6 && panduan < 0.8) {
			smlguide.setPinglevel("二星");
		} else if (panduan < 0.6) {
			smlguide.setPinglevel("一星");
		}
		session.put("shijian", shuju);
		session.put("cishu", cishu2);
		// session.put("junshi", onlineT);
		System.out.println(smlguide.getOnnum());
		session.put("onnum", smlguide.getOnnum());
		session.put("single", smlguide);
		session.put("siyy", siy);
		path = "evaluationMessage/evaluationSingle.jsp";
		return "ok";
	}
}
