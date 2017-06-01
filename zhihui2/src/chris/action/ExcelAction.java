package chris.action;

import java.io.InputStream;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.pojo.Session;
import chris.service.BizService;
import chris.service2.excelService;

/**
 * excel  导出。
 * @author chris
 *
 */
@Controller
@Namespace("/")
public class ExcelAction  implements SessionAware  {
	
	@Resource(name = "BizService")
	private BizService bizService;
	public BizService getBizService() {
		return bizService;
	}
	private Map<String, Object>  session;
	
	
	private String filename;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setBizService(BizService bizService) {
		this.bizService = bizService;
	}

	private InputStream inputStream; //（get,set方法省略）定义一个输入流，用于接住在Service类生成的含有EXCEL的输入流

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	//导游信息
	public String exportNetworkDeviceList() throws Exception {
		filename=System.currentTimeMillis()+"guide_detail.xls";
		List<Guide> gs=(List<Guide>) session.get("dyxx");
	    setInputStream(excelService.exportNetworkDeviceList(gs));  
	        return "getNetworkDeviceExportList";
	    }
	//导游机详情
	public String returnguide() throws Exception {
		filename=System.currentTimeMillis()+"guidem_borrow.xls";
		List<Guidem> gms=(List<Guidem>) session.get("dcgm");
	    setInputStream(excelService.exportNetworkDeviceList2(gms));  
	        return "getNetworkDeviceExportList";
	    }
	
	//导游机状态
	public String daoyoujizhuangtai() throws Exception {
		filename=System.currentTimeMillis()+"guidem_state.xls";
		 setInputStream(excelService.exportNetworkDeviceList3(bizService.getGuidemBiz().findAll2()));
	        return "getNetworkDeviceExportList";
	    }
	
	
	//评价信息
	public String pingjiaxinxi() throws Exception{
		
		filename=System.currentTimeMillis()+"guide_Analsy.xls";
		List<Session> mysession=(List<Session>) session.get("guide_Analsy");
		setInputStream(excelService.exportNetworkDeviceList4(mysession));
		
		  return "getNetworkDeviceExportList";
	}
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}	
	
}
