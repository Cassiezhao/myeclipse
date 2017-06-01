package chris.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class downloadAction extends ActionSupport{

	/**
	 * 下面4个参数构成了下载的主要的节奏
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contentType;
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getContentDisposition() {
		return contentDisposition;
	}
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}
	public long getContentLength() {
		return contentLength;
	}
	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	private String contentDisposition;
	private long contentLength;
	private InputStream inputStream;
	private String filename;
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	//下载
	public  String  upload() throws IOException {
		contentType ="text/html";//下载的类型
		//http请求头
		contentDisposition="attachment;filename="+filename;
		ServletContext ser=ServletActionContext.getServletContext();
		String a=ser.getRealPath("files/"+filename);
		System.out.println("下载链接"+a);
		inputStream = new FileInputStream(a);
		contentLength = inputStream.available();
		return "success";
	}
}
