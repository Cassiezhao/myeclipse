
package chris.action;
/**
 * 蓝牙的处理单元
 */
import java.io.IOException;
import java.io.PrintWriter;
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

import chris.pojo.Buletooth;
import chris.service.BizService;

@Controller
@Namespace("/")
public class BlueAction  implements SessionAware{
	@Resource(name = "BizService")
	private BizService bizService;
	private Map<String, Object> session;
	//跳转的路径
	private String path;
	private Buletooth blue;
	private int page;
	private int rows;
	private int  bluenum;
	private double jingdu;
	private double weidu;
	private int blueid;
	
	public int getBlueid() {
		return blueid;
	}
	public void setBlueid(int blueid) {
		this.blueid = blueid;
	}
	public int getBluenum() {
		return bluenum;
	}
	public void setBluenum(int bluenum) {
		this.bluenum = bluenum;
	}
	public double getJingdu() {
		return jingdu;
	}
	public void setJingdu(double jingdu) {
		this.jingdu = jingdu;
	}
	public double getWeidu() {
		return weidu;
	}
	public void setWeidu(double weidu) {
		this.weidu = weidu;
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
	public Buletooth getBlue() {
		return blue;
	}
	public void setBlue(Buletooth blue) {
		this.blue = blue;
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
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

	/**
	 * 新增蓝牙模块
	 * @return
	 */
	@Action(value = "saveblue", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String  saveblue (){
		System.out.println("jinru_save");
		try {
			Buletooth bule1=new Buletooth();
			System.out.println(bluenum);
			bule1.setBluenum(bluenum);
			bule1.setJingdu(jingdu);
			bule1.setWeidu(weidu);
			bizService.getBuletoothBiz().save(bule1);
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
	 
	/**
	 * 	修改蓝牙的模块
	 */
	@Action(value = "updateblue", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String updateblue(){
		Buletooth bluetooth = bizService.getBuletoothBiz().findById(blueid);
		
		bluetooth.setBluenum(bluenum);
		bluetooth.setJingdu(jingdu);
		bluetooth.setWeidu(weidu);
		
		bizService.getBuletoothBiz().update(bluetooth);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		
		return null;
	}
	
	/**
	 * 查询所有的蓝牙模块
	 * @return
	 */
	@Action(value = "findAllBlue", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findAllBlue(){
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=10;
		}
		System.out.println("jinru");
		List<Buletooth> bulelist = bizService.getBuletoothBiz().findAll(page, rows);
		int mysize=bizService.getBuletoothBiz().findAll().size();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("total",mysize);
		map.put("rows", bulelist);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		return null;
		
	}
	
	/**
	 * 删除蓝牙模块
	 * @return
	 */
	@Action(value = "delBlue", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String delBlue(){
		System.out.println("进入删除"+blueid);
		bizService.getBuletoothBiz().delete(bizService.getBuletoothBiz().findById(blueid));
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("success", 1);
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
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
