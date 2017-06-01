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

import com.opensymphony.xwork2.ActionSupport;

import chris.bean.PageBean;
import chris.pojo.Memory;
import chris.pojo.User;
import chris.service.BizService;

@Controller
@Namespace("/")
public class MemoryAciton extends ActionSupport implements SessionAware {
	private String path;
	private int page;
	private int rows;
	private String memoryshuju;
	private Date  before;
	private Date  after;



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

	public String getMemoryshuju() {
		return memoryshuju;
	}

	public void setMemoryshuju(String memoryshuju) {
		this.memoryshuju = memoryshuju;
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

	public int getMemxuanze() {
		return memxuanze;
	}

	public void setMemxuanze(int memxuanze) {
		this.memxuanze = memxuanze;
	}

	/**
	 * 选择 1，名字 2， 日期选择
	 */
	private int memxuanze;
	


	public Map<String, Object> getSession() {
		return session;
	}

	private Map<String, Object> session;
	@Resource(name = "BizService")
	private BizService bizService;

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
	 * 显示所有的数据记录信息。
	 */
	@Action(value = "findAll_Memory", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String findAll() {
		User host = (User) session.get("nuser");
		if (host.getUserpower() != 1) {
			return "ok";
		}
		PageBean pb = (PageBean) session.get("pb");
		pb = pb == null ? new PageBean() : pb;
		page = page == 0 ? (pb.getPage() == 0 ? 1 : pb.getPage()) : page;
		rows = rows == 0 ? (pb.getRows() == 0 ? 10 : pb.getRows()) : rows;

		System.out.println(page + ":::::" + rows);
		int mysize = bizService.getMemoryBiz().findAll(host.getUserid()).size();
		System.out.println(mysize);
		List<Memory> memories = bizService.getMemoryBiz().findAll(page, rows,
				host.getUserid());
		int a = rows;
		System.out.println(a);
		session.put("aaa", a);
		session.put("mempage", page);
		session.put("memtotal", mysize);
		session.put("memories", memories);
		pb.setPagelist(memories);
		pb.setPage(page);
		pb.setRows(rows);
		path = "operationLog/operation.jsp";
		session.put("url", "findAll_Memory?");
		return "ok";
	}

	
	/**
	 * 条件查询数据记录
	 * @return
	 */
	@Action(value = "chaxun_Memory", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String chaxun() {
		System.out.println("当前页::"+page+"当前行::"+rows);
		if(page==0){
			page=1;
		}
		if(rows==0){
			rows=10;
		}
		
		User host = (User) session.get("nuser");
		/**
		 * 按照姓名查询
		 */
		System.out.println("这是当前的memxuanze"+memxuanze +"。。。这是当前的要求"+memoryshuju );
		if(memxuanze==1){
			System.out.println(memoryshuju);
			
			session.put("aaa", rows);
			session.put("mempage", page);
			session.put("memtotal", bizService.getMemoryBiz().findAllname(host.getUserid(), memoryshuju).size());
			System.out.println(bizService.getMemoryBiz().findAllname(host.getUserid(), memoryshuju).size());
			List<Memory> mydata = bizService.getMemoryBiz().findAllname(page, rows, host.getUserid(), memoryshuju);
			session.put("memories", mydata);
			session.put("url", "chaxun_Memory?memxuanze=1&memoryshuju="+memoryshuju+"&");
		}
		/**
		 * 按照日期查询
		 */
		else if(memxuanze==2){
			session.put("aaa", rows);
			session.put("mempage", page);
			System.out.println("这是当前的时间：：："+before+":::这是后来的时间:"+after);
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String newbefore=sf.format(before);
			String newlater=sf.format(after);
			session.put("memtotal", bizService.getMemoryBiz().timechange(host.getUserid(), newbefore, newlater).size());
			System.out.println( bizService.getMemoryBiz().timechange(host.getUserid(), newbefore, newlater).size());
			List<Memory> mydata = bizService.getMemoryBiz().timechange(host.getUserid(), newbefore, newlater, page, rows);
			session.put("memories", mydata);
			session.put("url", "chaxun_Memory?memxuanze=2&before="+newbefore+"&after="+newlater+"&");
			System.out.println( "chaxun_Memory?memxuanze=2&before="+newbefore+"&after="+newlater+"&");
		}else{
			path="findAll_Memory";
			return "ok";
		}
		
		
		
		
		path = "operationLog/operation.jsp";
		return "ok";
	}

	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
}
