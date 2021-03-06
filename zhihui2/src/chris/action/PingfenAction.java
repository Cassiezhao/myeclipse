package chris.action;

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
import chris.pojo.Session;
import chris.pojo.Total;
import chris.service.BizService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
public class PingfenAction extends ActionSupport implements SessionAware {
	@Resource(name = "BizService")
	private BizService bizService;
	private int page;
	private int rows;
	private int sid;
	private int i;
	private int myid;
	private String yuyan;
	private String zhengshu;
	private int sousuo;
	private String xuanze;

	public int getSousuo() {
		return sousuo;
	}

	public void setSousuo(int sousuo) {
		this.sousuo = sousuo;
	}

	public String getXuanze() {
		return xuanze;
	}

	public void setXuanze(String xuanze) {
		this.xuanze = xuanze;
	}

	public String getYuyan() {
		return yuyan;
	}

	public void setYuyan(String yuyan) {
		this.yuyan = yuyan;
	}

	public String getZhengshu() {
		return zhengshu;
	}

	public void setZhengshu(String zhengshu) {
		this.zhengshu = zhengshu;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getMyid() {
		return myid;
	}

	public void setMyid(int myid) {
		this.myid = myid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	private Map<String, Object> session;

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	/**
	 * 计算个人评分
	 * @return
	 */
	@Action(value = "evalu_Pingfen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String evalu() {
		List<Guide> guidelist = bizService.getGuideBiz().findAll();
		for (Guide g : guidelist) {
			// 获得这个人这一次所有的每次路线详情
			List<Session> smals = bizService.getSessionBiz().findBygIdMonth(
					g.getGuideid());
			System.out.println(g.getGuideid());
			long time = 0;
			int sum = 0;
			int flag1 = 0;
			int flag2 = 0;
			double totallength=0;
			String [] score = null;
			double youkescore = 0;
			//找到这个月的
			Guide myguide = bizService.getGuideBiz().findById(g.getGuideid());
			for (Session se : smals) {
				if (se.getUplineT() != null && se.getOnlineT() != null) {
					Date d1 = se.getOnlineT();
					Date d2 = se.getUplineT();
					Long c = d2.getTime() - d1.getTime();
					time += c;
				}
				// 获取每一次的上线地点看是否超过景区
				if (se.getOnlineP() == null) {
					flag1 += 1;

				}
				// 通过session id获取这一次的所有路线将所有路线遍历，看是否符合
				List<Total> luxian = bizService.getTotalBiz().findBygId(
						se.getGuide().getGuideid(), se.getSessionId());
				for (Total lu : luxian) {
					// 判断位置是否符合
					if (lu.getJingdu() == null && lu.getWeidu() == null) {
						flag2 += 1;
					}
				}
				// 记录游客机的平均值
				if(se.getScore()!=null &&se.getScore().length()>0 ){
					 score=se.getScore().split(",");
					 System.out.println(score.toString());
					for(int i=0;i<score.length;i++){
					if(score[i]!=null){
						
						try {
							youkescore+=Double.parseDouble((score[i]).trim());
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							youkescore+=0;
						}
					}
					
				}
					totallength+=youkescore/score.length;
					System.out.println("当前游客评分::score"+youkescore/score.length);
					youkescore=0;
				}

			}
			if (flag1 == 0) {
				sum += 5;
				myguide.setSxdd(1);
			} else {
				myguide.setSxdd(0);
			}
			if (flag2 == 0) {
				sum += 5;
				myguide.setWzxx(1);
			} else {
				myguide.setWzxx(0);
			}
			// 获取到上线的平均时间
			int c = 0;
			if (smals.size() != 0) {
				c = (int) (time / smals.size() / 1000);
				// 游客机分数计算
				youkescore = totallength / smals.size();
			}

			myguide.setOntime(c);
			myguide.setYoukescore(youkescore*10+"");
			
			// 上线次数
			myguide.setOnnum(smals.size());

			bizService.getGuideBiz().update(myguide);
			System.out.println("本次游客机分数"+youkescore);
			youkescore=0;
			System.out.println("第" + g.getGuideid() + "个人平均上线时间" + c + "位置信息分数"
					+ sum + "上线次数" + smals.size());

		}
		path = "findAll_Guide?i=4";
		return "ok";
	}

	
	/**
	 * 奖励惩罚界面逻辑操作
	 * @return
	 */
	@Action(value = "jiangcheng_Pingfen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String jiangcheng() {
		List<Guide> guides = null;
		PageBean pb = (PageBean) session.get("pb");
		pb = pb == null ? new PageBean() : pb;
		page = page == 0 ? (pb.getPage() == 0 ? 1 : pb.getPage()) : page;
		rows = rows == 0 ? (pb.getRows() == 0 ? 10 : pb.getRows()) : rows;
		session.put("page3", page);
		session.put("rows3", rows);
		session.put("total3", bizService.getGuideBiz().findAll().size());
		switch (sousuo) {
		case 1:
			//进行导游机编号查询
			sousuo=0;
			guides = bizService.getGuideBiz().findByGnum(xuanze);
			session.put("total3", guides.size());
			break;
		case 2:
			//导游姓名查询
			sousuo=0;
			guides=bizService.getGuideBiz().findByGname(xuanze);
			session.put("total3", guides.size());
			break;
		case 3:
			
			break;
		default:
			sousuo = 0;
			guides = bizService.getGuideBiz().findAll();
			
			break;
		}

		/**
		 * 再这里加入一个flag标记
		 */

		pb.setPagelist(guides);
		pb.setPage(page);
		pb.setRows(rows);
		//新的分页
		
		session.put("jiangcheng", pb);

		path = "RewardMessage/rewardMessage.jsp";
		return "ok";
	}

	
	/**
	 * 进行奖励操作
	 * @return
	 */
	@Action(value = "jiangli_Pingfen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String jiangli() {
		Guide jL = bizService.getGuideBiz().findById(sid);

		session.put("jl", jL);
		path = "RewardMessage/evaluationReward.jsp";
		return "ok";
	}

	
	/**
	 * 增加导游语言和证书
	 * @return
	 */
	@Action(value = "modify_Pingfen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String modify() {
		path = "jiangli_Pingfen?sid=" + myid;
		Guide jL2 = bizService.getGuideBiz().findById(myid);
		if (i == 1) {
			// 新增语言

			jL2.setLanguage(jL2.getLanguage() + "、" + yuyan);
			System.out.println(yuyan);
		} else {
			// 新增证书
			jL2.setExperice(jL2.getExperice() + "、" + zhengshu);
			System.out.println(zhengshu);
		}
		bizService.getGuideBiz().update(jL2);
		return "ok";
	}
	
	/**
	 * 抽听讲解不合格扣分
	 * @return
	 */
	@Action(value = "koufen_Pingfen", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String koufen(){
		Guide guide = bizService.getGuideBiz().findById(sid);
		System.out.println(guide.getGuidename());
		guide.setChoutingjiangjie(guide.getChoutingjiangjie()+1);
		bizService.getGuideBiz().update(guide);
		path="jiangcheng_Pingfen";
		return "ok";
	}
}
