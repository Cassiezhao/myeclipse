package chris.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import url.myurl;

import chris.pojo.Memory;
import chris.pojo.User;
import chris.service.BizService;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
public class UserAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8677933912203748665L;
	
	private int userid;
	private String mainnewpassword;
	public String getMainnewpassword() {
		return mainnewpassword;
	}

	public void setMainnewpassword(String mainnewpassword) {
		this.mainnewpassword = mainnewpassword;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	private String newpassword;
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	@Resource(name="BizService")
	private BizService bizService;
	private User user;
	private String path;
	private Map<String, Object> session;
	public Map<String, Object> getSession() {
		return session;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}
	
	
	
	/**
	 * 保存用户模块
	 * @return
	 */
	@Action(value="save_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String save(){
		//System.out.println(user.getUsername()+":::::::"+user.getUsernum());
		User host=(User) session.get("nuser");
		if(host.getUserpower()!=1){
			return null;
		}
		List<User> users = bizService.getUserBiz().findAll();
		for(User uu:users){
			System.out.println(uu.getUsername()+"::::"+uu.getUsernum());
			if(uu.getCount().equals((user.getCount()))){
				path="save_User";
				session.put("exit2"," 账户已存在");
				return "ok";
			}
		}
		try {
			String ps=user.getTel().trim().substring(user.getTel().length()-6);
			System.out.println(ps);
			System.out.println("这是性别:"+user.getSex());
			user.setPassword(ps);
			user.setState(0);
			user.setUserpower(0);
			bizService.getUserBiz().save(user);
			jilu("存入新用户"+user.getUsername());
			System.out.println(user.getUserid());
			session.put("exit2","");
			path="findAll_User";
			return "ok";
		} catch (Exception e) {
			path="error.jsp";
		}
		return "ok";
	}
	
	/**
	 * 操作人员
	 * @return
	 */
	@Action(value="findAll_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String findAll(){
		List<User> a=bizService.getUserBiz().findAll();
		session.put("user", a);
		path="operatorManagement/operatorDetail.jsp";
		return "ok";
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	
	/**
	 * 管理员修改密码
	 * @return
	 */
	@Action(value="check_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String check(){
		
		List<User> a = bizService.getUserBiz().findAll();
		int sb=0;
//		username;
//		private Integer usernum;
//		private Timestamp userlogTime;
		if(user.getState()==null ||user.getState()!=1){
			sb=1;
		}
		if(user!=null && sb==1){
		for(User u :a){
			System.out.println(u.getCount()+":"+u.getPassword());
			System.out.println(user.getCount()+":"+user.getPassword());
			if(u.getCount()!=null && u.getPassword()!=null){
			if(u.getCount().equals(user.getCount())&&u.getPassword().equals(user.getPassword())){
				Date now=new Date();
				if(u.getPassword().equals(u.getTel().trim().substring(u.getTel().length()-6))){
					session.put("change", 1);
				}else{
					session.put("change", 2);
				}
				String b = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒").format(now);
				//将业主查出来
				User user2 = bizService.getUserBiz().findById(u.getUserid());
//				if(u.getState()==1 &&  myurl.zhanghao.contains(user2.getUsername()) ){
//					session.put("err", "用户已经登录");
//					path="login.jsp";
//					
//					return "ok";
//				}
				user2.setUserlogTime(b);
				user2.setState(1);
				myurl.zhanghao.add(user2.getUsername());
				bizService.getUserBiz().update(user2);
				session.put("nuser", user2);
				session.put("err", "");
				path="index.jsp";
				return "ok";
			}
			}
		}}else{
			session.put("err", "账号或密码错误");
		}
		
		path="login.jsp";
		
		return "ok";		
	}
	
	
	/**
	 * 修改用户
	 * @return
	 */
	@Action(value="modify_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String modify(){
		
		User a = bizService.getUserBiz().findById(userid);
		if(a.getTel().trim().substring(a.getTel().length()-6).equals(newpassword)){
			session.put("change", 1);
		}else{
			session.put("change", 2);
		a.setPassword(newpassword);
		bizService.getUserBiz().update(a);
		}
		path="findAll_User";
		return "ok";
	}
	
	/**
	 * 设置初始密码
	 * @return
	 */
	@Action(value="changep_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String changep(){
		User host=(User) session.get("nuser");
		if(host.getUserpower()!=1){
			return null;
		}
		User a = bizService.getUserBiz().findById(userid);
		a.setPassword(a.getTel().trim().substring(a.getTel().length()-6));
		bizService.getUserBiz().update(a);
		path="findAll_User";
		return "ok";
			
	}
	
	/**
	 * 退出登陆
	 * @return
	 */
	@Action(value="exit_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String exit(){
		User a=bizService.getUserBiz().findById(userid);
		a.setState(0);
		bizService.getUserBiz().update(a);
		session.clear();
		path="login.jsp";
		return "ok";
	}
	public void jilu(String s){
		Memory me=new Memory();
		me.setMessage(s);
		User host=(User) session.get("nuser");
		me.setOpuser(host.getUsername());
		me.setUser(host);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		me.setMtime(d);
		bizService.getMemoryBiz().save(me);
	}
	
	
	
	/**
	 * 修改密码
	 * @return
	 */
	@Action(value="modifymainpassword_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String modifymainpassword(){
		Map<String, Object> map = null;
		try {
			System.out.println("进入");
			map = new HashMap<String, Object>();
			
			
			
			User main=(User) session.get("nuser");
			if(main.getUserpower()==0){
				map.put("success", 0);
			}else{
				main.setPassword(mainnewpassword);
				
				if(bizService.getUserBiz().update(main)){
					map.put("success", 1);
					System.out.println("修改成功");
				}else{
					map.put("success", 0);
					System.out.println("修改失败");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String lsempjsonString = JSONObject.toJSONString(map);
		print(lsempjsonString);
		return null;
	}
	
	/**
	 * 删除用户
	 * @return
	 */
	@Action(value="deluser_User",results={
			@Result(name="ok",location="${path}",type="redirect")
	})
	public String deluser(){
		User host=(User) session.get("nuser");
		Map<String, Object> map = null;
		System.out.println("现在的导游id"+userid);
		bizService.getUserBiz().delete(bizService.getUserBiz().findById(userid));
		map = new HashMap<String, Object>();
		if(host.getUserpower()!=1){
			map.put("success", 0);
			return null;
		}
		
		map.put("success", 1);
		List<User> a=bizService.getUserBiz().findAll();
		session.put("user", a);
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
