package chris.timer;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import chris.pojo.Guide;
import chris.pojo.Session;
import chris.pojo.Systemscore;
import chris.pojo.Total;
import chris.service.BizService;

public class OrderAnalyse {
	@Resource(name = "BizService")
	private BizService bizService;
	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	/**
	 * 时间调度模块
	 */
	protected void execute(){
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
	}


}
