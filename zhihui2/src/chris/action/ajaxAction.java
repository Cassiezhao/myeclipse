package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;

import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.pojo.Systemscore;
import chris.service.BizService;

@Controller
@Namespace("/")
public class ajaxAction {
	@Resource(name = "BizService")
	private BizService bizService;
	private String path;
	private String usernum;
	private String guidenum;
	public String getGuidenum() {
		return guidenum;
	}

	public void setGuidenum(String guidenum) {
		this.guidenum = guidenum;
	}

	public String getUsernum() {
		return usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
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
	 * 导游机ajax请求
	 * 验证导游机是否在数据库中存在，通过判断state和数据是否为空来进行判断
	 * @return
	 */
	@Action(value = "yznum_ajaxAction", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String yznum() {
		int flag = 1;
		String result;
		
		List<Guidem> a = bizService.getGuidemBiz().findAll2();
		for (Guidem g : a) {
				
			
			if (g.getGuidemnum().equals(usernum) &&g.getGmstate()==1 ) {
				flag=0;
				
			}
		}
		if (flag != 0) {
			result = "<font color='red'>该导游机不可使用</font>";
		} else {
			result = "<font color='green'>该导游机可以使用</font>";
		}
		
		//将结果转换成ajax请求，然后传输给请求界面
		String lsempjsonString = JSON.toJSONString(result);
		print(lsempjsonString);
		path = null;
		return null;

	}
	
	/**
	 * 导游验证ajax请求
	 * 验证导游是否在数据库中存在，
	 * @return
	 */
	@Action(value = "ydaoy_ajaxAction", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String daoy() {
		int flag = 0,flag2=0;
		String result = null;
		List<Guide> daoyou2 = bizService.getGuideBiz().findAll();
		System.out.println("传入的导游编号"+guidenum);
		Guide daoyyy = bizService.getGuideBiz().findByGnum(guidenum).get(0);
		System.out.println("传入的导游编号"+daoyyy.getState());
		if(daoyyy.getState()>2){
			flag=1;
		}
		//判断导游编号数据库中是否存在
		for(Guide dao:daoyou2){
			if(dao.getGuidenum().equals(guidenum)){
				flag2=1;
				break;
			}
		}
		if(flag2!=1){
			flag=1;
		}
		List<Guidem> a = bizService.getGuidemBiz().findAll2();
		try {
			for (Guidem g : a) {
				if(g.getGuide()==null){
					//判断指派导游当前是否指派
				}else if(g.getGuide().getGuidenum().equals(guidenum)){
					flag=1;
					break;
				
				}
			}
			if (flag != 0) {
				result = "<font color='red'>该导游处于忙碌状态</font>";
			} else {
				result = "<font color='green'>该导游可带团</font>";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String lsempjsonString = JSON.toJSONString(result);
		print(lsempjsonString);
		path = null;
		return null;

	}
	//向网页传输数据
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
