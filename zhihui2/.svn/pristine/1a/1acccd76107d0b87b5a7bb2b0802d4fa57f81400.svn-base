package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import chris.pojo.Area;
import chris.pojo.Buletooth;
import chris.pojo.Guidegroup;
import chris.pojo.Memory;
import chris.pojo.User;
import chris.service.BizService;
/**
 * 
 * @author chris
 *	区域的Action
 */
@Controller
@Namespace("/")
public class AreaGroupAction implements SessionAware {
	@Resource(name = "BizService")
	private BizService bizService;
	private Map<String, Object> session;
	private String path;
	private int page;
	private int rows;
	private int areaid;
	private String aname;
	private String gname;
	private int groupid;
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}
	public int getAreaid() {
		return areaid;
	}
	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
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
	@Action(value = "Areashow", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String  Areashow(){
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=10;
		}
		try {
			//找到数据库中所有的分组
			List<Area> arealist = bizService.getAreaBiz().findAll(page, rows);
			
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("total",bizService.getAreaBiz().findAll().size());
			map.put("rows", arealist);
			//fastjson过滤属性，重点在于PropertyFilter 这个东西
			//（应用场景，hibernate懒加载过滤不要的属性） 
			PropertyFilter propertyFilter = new PropertyFilter() {

				public boolean apply(Object arg0, String propertyName, Object arg2) {

					if (propertyName.equals("guidegroups")) {
						return false;
					}
					return true;
				}
			};
			
			String lsdepjsonString = JSONObject.toJSONString(map, propertyFilter,
					SerializerFeature.DisableCircularReferenceDetect);
			
			
			//String lsempjsonString = JSONObject.toJSONString(map);
			System.out.println("一共多少个区？"+bizService.getAreaBiz().findAll().size());
			print(lsdepjsonString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	@Action(value = "saveArea", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String  saveArea (){
		System.out.println("jinru_save");
		try {
			Area area=new Area();
			area.setAname(aname);
			//得到区域进行保存
			bizService.getAreaBiz().save(area);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		
		return null;
	}
	
	@Action(value = "updateArea", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String  updateArea (){
		System.out.println(areaid);
		//找到所有的area（区域）
		Area myarea = bizService.getAreaBiz().findById(areaid);
		myarea.setAname(aname);
		bizService.getAreaBiz().merge(myarea);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		
		return null;
	}
	
	@Action(value = "delarea", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String delarea(){
		System.out.println(areaid);
		Area myarea = bizService.getAreaBiz().findById(areaid);
		//删除区域
		bizService.getAreaBiz().delete(myarea);
		//将区域对象持久化
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		//讲数据进行提交
	
		return null;
	}
	
	/**
	 * 组的方法
	 */
	
	@Action(value = "gshow", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String gshow(){
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=10;
		}
		try {
			List<Guidegroup> grouplist = bizService.getGuidegroupBiz().findAll(page, rows);
			
			Map<String,Object> map=new HashMap<String, Object>();
			//传递给后台，查出的总数据。
			map.put("total",bizService.getGuidegroupBiz().findAll().size());
			map.put("rows", grouplist);
			
			/**
			 * fastjason属性过滤器。
			 */
			PropertyFilter propertyFilter = new PropertyFilter() {

				public boolean apply(Object arg0, String propertyName, Object arg2) {

					if (propertyName.equals("area")) {
						return false;
					}
					if (propertyName.equals("guides")) {
						return false;
					}
					return true;
				}
			};
			
			String lsdepjsonString = JSONObject.toJSONString(map, propertyFilter,
					SerializerFeature.DisableCircularReferenceDetect);
			//String lsempjsonString = JSONObject.toJSONString(map);
			System.out.println("一共多少个组？"+bizService.getGuidegroupBiz().findAll().size());
			print(lsdepjsonString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Action(value = "savegroup", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String  savegroup (){
		System.out.println("jinru_save");
		try {
			Guidegroup group=new Guidegroup();
			group.setGname(gname);
			bizService.getGuidegroupBiz().save(group);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		jilu("创建新的组"+gname);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		
		return null;
	}
	
	
	@Action(value = "updategroup", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String  updategroup (){
		System.out.println(groupid);
		//通过id找到该组
		Guidegroup mygroup = bizService.getGuidegroupBiz().findById(groupid);
		//设置组名
		mygroup.setGname(gname);
		//更新该组
		bizService.getGuidegroupBiz().merge(mygroup);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		jilu("更新的组"+gname);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		
		return null;
	}
	

	@Action(value = "delgroup", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String delgroup(){
		System.out.println(groupid);
		bizService.getGuidegroupBiz().delete(bizService.getGuidegroupBiz().findById(groupid));
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		jilu("删除组"+bizService.getGuidegroupBiz().findById(groupid).getGname());
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		
		return null;
	}
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
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
	/**
	 *  
	 * @param s
	 * 给操作历史表，进行数据操作。
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
}



	
