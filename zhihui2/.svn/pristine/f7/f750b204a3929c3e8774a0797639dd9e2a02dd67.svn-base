package chris.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.bean.areadata;
import chris.pojo.Area;
import chris.pojo.Guide;
import chris.pojo.Guidegroup;
import chris.service.BizService;


/**
 * 分组模块
 * @author chris
 *
 */
@Controller
@Namespace("/")
public class divgaAction implements SessionAware{
	@Resource(name = "BizService")
	private BizService bizService;
	private String path;
	private String option;
	private int groupid;
	private int myareaid;
	private int guideid;
	
	public int getGuideid() {
		return guideid;
	}
	public void setGuideid(int guideid) {
		this.guideid = guideid;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getMyareaid() {
		return myareaid;
	}
	public void setMyareaid(int myareaid) {
		this.myareaid = myareaid;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}

	private Map<String, Object> session;
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		session=arg0;
	}
	public BizService getBizService() {
		return bizService;
	}
	public void setBizService(BizService bizService) {
		this.bizService = bizService;
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
	/**
	 * 初始化区域
	 * @return
	 */
	@Action(value = "initarea", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String initarea(){
		List<Area> myarealist = bizService.getAreaBiz().findAll();
		areadata ada=null;
		List<areadata> lista=new ArrayList<areadata>();
		for (int i = 0; i < myarealist.size(); i++) {
			ada=new areadata(i, myarealist.get(i).getAname());
			lista.add(ada);
		}
		session.put("lista", lista);
		path="group/quyu.jsp";
		return "ok";
	}
	
	@Action(value = "areadiv", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String areadiv(){
		List<Area> myarealist = bizService.getAreaBiz().findAll();
		Area arare=myarealist.get(Integer.parseInt(option));
		//组通过id查询
		//已经分配到该去的组
		List<Guidegroup> mygroup = bizService.getGuidegroupBiz().findbyaid(arare.getAid());
		session.put("mygroup", mygroup);
		session.put("aname", arare.getAname());
		session.put("areaid", arare.getAid());
		List<Guidegroup> myallgro = bizService.getGuidegroupBiz().findAll();
		List<Guidegroup> listargp=new ArrayList<Guidegroup>();
		//找到所有未分配的组
		for(Guidegroup gp:myallgro){
			if(gp.getArea()==null){
				listargp.add(gp);
			}
		}
		session.put("weifenpei", listargp);
		path="group/quyu.jsp";
		return "ok";
	}
	
	
	
	@Action(value = "mydivgroup", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String mydivgroup(){
		System.out.println("当前组ID"+groupid+"::当前区ID"+myareaid);
		/**
		 * 为组设置区域
		 */
		 Guidegroup sd = bizService.getGuidegroupBiz().findById(groupid);
		sd.setArea(bizService.getAreaBiz().findById(myareaid));
		bizService.getGuidegroupBiz().merge(sd);
		List<Guidegroup> mygroup = bizService.getGuidegroupBiz().findbyaid(myareaid);
		session.put("mygroup", mygroup);
		
		List<Guidegroup> myallgro = bizService.getGuidegroupBiz().findAll();
		List<Guidegroup> listargp=new ArrayList<Guidegroup>();
		/**
		 * 重新找到未分配的组
		 */
		for(Guidegroup gp:myallgro){
			if(gp.getArea()==null){
				listargp.add(gp);
			}
		}
		session.put("weifenpei", listargp);
		path="group/quyu.jsp";
		return "ok";
	}
	
	/**
	 * 取消分组
	 * @return
	 */
	@Action(value = "cancelgroup", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String cancelgroup(){
		 Guidegroup sd = bizService.getGuidegroupBiz().findById(groupid);
		 sd.setArea(null);
		 bizService.getGuidegroupBiz().merge(sd);
		 List<Guidegroup> mygroup = bizService.getGuidegroupBiz().findbyaid(myareaid);
			session.put("mygroup", mygroup);
			
			List<Guidegroup> myallgro = bizService.getGuidegroupBiz().findAll();
			List<Guidegroup> listargp=new ArrayList<Guidegroup>();
			/**
			 * 更新所有未分配的组
			 */
			for(Guidegroup gp:myallgro){
				if(gp.getArea()==null){
					listargp.add(gp);
				}
			}
			session.put("weifenpei", listargp);
		
		
		path="group/quyu.jsp";
		return "ok";
	}
	
	/**
	 * 初始化组，在界面中进行呈现
	 * @return
	 */
	@Action(value = "initgroup", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String initgroup(){
		List<Guidegroup> mygrplist = bizService.getGuidegroupBiz().findAll();
		areadata ada=null;
		List<areadata> lista2=new ArrayList<areadata>();
		for (int i = 0; i < mygrplist.size(); i++) {
			ada=new areadata(i, mygrplist.get(i).getGname());
			lista2.add(ada);
		}
		session.put("lista2", lista2);
		path="group/group.jsp";
		return "ok";
	}
	/**
	 * 
	 * @return
	 */
	@Action(value = "groupdiv", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String groupdiv(){
		 List<Guidegroup> mygplist = bizService.getGuidegroupBiz().findAll();
		Guidegroup myg = mygplist.get(Integer.parseInt(option));
		//组通过id查询
		//已经分配到该去的组
		List<Guide> myguide = bizService.getGuideBiz().findbygpid(myg.getGgid());
		session.put("myguide", myguide);
		session.put("gpname", myg.getGname());//祖名
		session.put("gpid", myg.getGgid());//组id
		//List<Guidegroup> myallgro = bizService.getGuidegroupBiz().findAll();
		List<Guide> myallgro = bizService.getGuideBiz().findAll();
		List<Guide> listargp=new ArrayList<Guide>();
		/**
		 * 找到未分组的导游
		 */
		for(Guide gp:myallgro){
			if(gp.getGuidegroup()==null){
				listargp.add(gp);
			}
		}
		session.put("weifenpei2", listargp);
		path="group/group.jsp";
		return "ok";
	}
	/**
	 * 
	 * @return
	 */
	@Action(value = "mydivguide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String mydivguide(){
		System.out.println("当前导游ID"+guideid+"::当前组ID"+groupid);
		 Guide myguide = bizService.getGuideBiz().findById(guideid);
		 myguide.setGuidegroup(bizService.getGuidegroupBiz().findById(groupid));
		 bizService.getGuideBiz().update(myguide);
		 List<Guide> myguide2 = bizService.getGuideBiz().findbygpid(groupid);
		 session.put("myguide", myguide2);
		 List<Guide> myallgro = bizService.getGuideBiz().findAll();
			List<Guide> listargp=new ArrayList<Guide>();
			/**
			 * 找到所有未分配的导游
			 */
			for(Guide gp:myallgro){
				if(gp.getGuidegroup()==null){
					listargp.add(gp);
				}
			}
			session.put("weifenpei2", listargp);
		 path="group/group.jsp";
		return "ok";
	}
	
	/**
	 * 取消导游的分配
	 * @return
	 */
	@Action(value = "cancelguide", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String cancelguide(){
		Guide gd = bizService.getGuideBiz().findById(guideid);
		gd.setGuidegroup(null);
		bizService.getGuideBiz().update(gd);
		
		 List<Guide> myguide2 = bizService.getGuideBiz().findbygpid(groupid);
		 session.put("myguide", myguide2);
		 List<Guide> myallgro = bizService.getGuideBiz().findAll();
			List<Guide> listargp=new ArrayList<Guide>();
			//将未分配的导游呈现
			for(Guide gp:myallgro){
				if(gp.getGuidegroup()==null){
					listargp.add(gp);
				}
			}
			session.put("weifenpei2", listargp);
		
		
			path="group/group.jsp";
		return "ok";
	}
}
