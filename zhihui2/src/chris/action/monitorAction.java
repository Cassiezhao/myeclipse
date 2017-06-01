package chris.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.pojo.Guidemonitor;
import chris.service.BizService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Namespace("/")
public class monitorAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private String path;
	private int page;
	private int rows;
	private String myurl;

	public String getMyurl() {
		return myurl;
	}

	public void setMyurl(String myurl) {
		this.myurl = myurl;
	}

	// 会员账号
	private String monitor_id;
	private String monitor_name;

	public String getMonitor_id() {
		return monitor_id;
	}

	public void setMonitor_id(String monitor_id) {
		this.monitor_id = monitor_id;
	}

	public String getMonitor_name() {
		return monitor_name;
	}

	public void setMonitor_name(String monitor_name) {
		this.monitor_name = monitor_name;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Action(value = "myfindAll_monitor", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String myfindAll() {
		List<Guidemonitor> montor = null;
		int total = 0;
		int a = 0;
		if (page == 0) {
			page = 1;
		}
		if (rows == 0) {
			rows = 10;
		}
		System.out.println("monitor_id" + monitor_id + ":::: monitor_name"
				+ monitor_name);
		if (monitor_id != null || monitor_name != null) {

			if (monitor_id!=null&&monitor_name!=null&&monitor_id.length() > 0 &&  monitor_name.length() > 0) {
				montor = bizService.getGuidemonitorBiz().findByalite(
						monitor_id, monitor_name, page, rows);
				total = bizService.getGuidemonitorBiz()
						.findByalite(monitor_id, monitor_name).size();
				myurl = "myfindAll_monitor?monitor_id=" + monitor_id
						+ "monitor_name=" + monitor_name + "&";
				session.put("monitor_id", monitor_id);
				session.put("monitor_name", monitor_name);
			}
				else if (monitor_id!=null&&monitor_id.length() > 0) {
					montor = bizService.getGuidemonitorBiz().findByalite(
							monitor_id, monitor_name, page, rows);
					total = bizService.getGuidemonitorBiz()
							.findByalite(monitor_id, monitor_name).size();
					myurl = "myfindAll_monitor?monitor_id=" + monitor_id + "&";
					session.put("monitor_id", monitor_id);
					session.put("monitor_name", "");
				}
				else if ( monitor_name!=null &&monitor_name.length() > 0) {
					montor = bizService.getGuidemonitorBiz().findByalite(
							monitor_id, monitor_name, page, rows);
					total = bizService.getGuidemonitorBiz()
							.findByalite(monitor_id, monitor_name).size();
					myurl = "myfindAll_monitor?monitor_name=" + monitor_name
							+ "&";
					session.put("monitor_name", monitor_name);
					session.put("monitor_id", "");
				}else{
					montor = bizService.getGuidemonitorBiz().findAll(page, rows);
					total = bizService.getGuidemonitorBiz().findAll().size();
					session.put("monitor_name", "");
					session.put("monitor_id", "");
					myurl = "myfindAll_monitor?";
				}
			
		} else {

			montor = bizService.getGuidemonitorBiz().findAll(page, rows);
			total = bizService.getGuidemonitorBiz().findAll().size();

			myurl = "myfindAll_monitor?";
		}
		session.put("monitor", montor);
		session.put("myurl", myurl);
		session.put("page", page);
		session.put("rows", rows);
		session.put("total", total);
		System.out.println("进入");

		path = "guidemanage/monitorDetail.jsp";
		return "ok";
	}

	@Action(value = "search_monitor", results = { @Result(name = "ok", location = "${path}", type = "redirect") })
	public String search_monitor() {
		System.out.println("进入");

		path = "guidemanage/monitorDetail.jsp";
		return "ok";
	}

}
