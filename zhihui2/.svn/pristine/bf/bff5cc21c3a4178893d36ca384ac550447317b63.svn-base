package chris.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.pojo.Guidem;
import chris.pojo.Message;
import chris.service.BizService;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 语音上传模块
 * @author chris
 *
 */
public class WavAction extends ActionSupport implements SessionAware {
	private File ppt;
	private String pptContentType;
	private String pptFileName;
	private String mydir;

	public String getMydir() {
		return mydir;
	}

	public void setMydir(String mydir) {
		this.mydir = mydir;
	}

	private String shangchuan;
	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	@Resource(name = "BizService")
	private BizService bizService;

	public BizService getBizService() {
		return bizService;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	public String getShangchuan() {
		return shangchuan;
	}

	public void setShangchuan(String shangchuan) {
		this.shangchuan = shangchuan;
	}

	private String pptDesc;

	public File getPpt() {
		return ppt;
	}

	public void setPpt(File ppt) {
		this.ppt = ppt;
	}

	public String getPptContentType() {
		return pptContentType;
	}

	public void setPptContentType(String pptContentType) {
		this.pptContentType = pptContentType;
	}

	public String getPptFileName() {
		return pptFileName;
	}

	public void setPptFileName(String pptFileName) {
		this.pptFileName = pptFileName;
	}

	public String getPptDesc() {
		return pptDesc;
	}

	public void setPptDesc(String pptDesc) {
		this.pptDesc = pptDesc;
	}

	public String uplM() {
		System.out.println("进入");
		Guidem guidemm;
		System.out.println(shangchuan);
		if (shangchuan != null) {
			String[] a = shangchuan.split(",");
			Timestamp ts;

			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
				if (a[i] != null) {
					// guides= bizService.getGuideBiz().findById();
					guidemm = bizService.getGuidemBiz().findBygid(
							Integer.parseInt(a[i]));
					guidemm.setSendmessage(pptFileName);
					bizService.getGuidemBiz().update(guidemm);
					Message ms = new Message();
					ms.setGuidemnum(guidemm.getGuidemnum());
					ms.setStatus(2);
					ms.setContent(pptFileName);

					// 注意format的格式要与日期String的格式相匹配
					ts = new Timestamp(System.currentTimeMillis());
					ms.setTime(ts);
					getBizService().getMessageBiz().save(ms);
				}
			}
		}
		FileOutputStream out = null;
		FileInputStream in = null;

		ServletContext servletContext = ServletActionContext
				.getServletContext();
		// String[] mytruedir=pptFileName.split(".");
		// System.out.println("特殊符号前"+mytruedir[0]);

		String dir = servletContext.getRealPath("/files/" + pptFileName);
		System.out.println("文件名:" + pptFileName);
		System.out.println("这是我们的地址" + dir);

		try {
			out = new FileOutputStream(dir);
			in = new FileInputStream(ppt);

			byte[] buffer = new byte[1024];
			int len = 0;

			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);

			}
			out.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 手机端进行语音上传
	 * @return
	 */
	public String andup() {
		System.out.println("进入语音上传");
		FileOutputStream out = null;
		FileInputStream in = null;

		ServletContext servletContext = ServletActionContext
				.getServletContext();
		System.out.println(pptFileName);

		String aaa = pptFileName.substring(0, 4);
		String fristdir = servletContext.getRealPath("/files") + "/" + aaa
				+ "/";
		System.out.println(fristdir);
		File myfile = new File(fristdir);
		if (!myfile.exists()) {
			myfile.mkdir();
		}
		System.out.println(fristdir);
		// String dir = servletContext.getRealPath("/files/"+pptFileName);
		String dir = fristdir + pptFileName;
		System.out.println("文件名:" + pptFileName);
		System.out.println("这是我们的地址" + fristdir);

		try {
			out = new FileOutputStream(dir);
			in = new FileInputStream(ppt);

			byte[] buffer = new byte[1024];
			int len = 0;

			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);

			}
			out.close();
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 监听语音上传
	 * @return
	 */
	public String yinpinshangchuan() {
		System.out.println("进入音频上传");
		FileOutputStream out = null;
		FileInputStream in = null;

		ServletContext servletContext = ServletActionContext
				.getServletContext();
		System.out.println(pptFileName);
		// String aaa=pptFileName.substring(0, 15);
		String fristdir = servletContext.getRealPath("\\files") + "\\" + mydir
				+ "\\";
		String dir = null;
		try {
			dir = fristdir + pptFileName;
			System.out.println("文件名:" + pptFileName);
			System.out.println("这是我们的地址" + dir);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			out = new FileOutputStream(dir);

			in = new FileInputStream(ppt);

			byte[] buffer = new byte[1024];
			int len = 0;

			while ((len = in.read(buffer)) != -1) {
				out.write(buffer, 0, len);

			}
			/**
			 * 在这里将上传的数据的url地址已经获取。 
			 */
			out.close();
			in.close();

			// upload(aaa);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
}
