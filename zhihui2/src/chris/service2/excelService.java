package chris.service2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Controller;

import sun.awt.SunHints;

import chris.pojo.Guide;
import chris.pojo.Guidem;
import chris.pojo.Session;
import chris.service.BizService;
public class excelService {
	
/**
 * poi    excel生成表
 * @param a
 * @return
 */
	public static  InputStream exportNetworkDeviceList(List<Guide> a ) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("导游状态表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

 

        //写列名，视自己的需求而定
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("编号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("性别");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("工龄");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("导游状态");
        cell.setCellStyle(style);
        
        
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，\
        //List<Guidem> a = bizService.getGuidemBiz().findAll2();
        for (int i = 0; i < a.size(); i++) {
            row = sheet.createRow((int) i + 1);
            //NetworkDevice netDevice = exportList.get(i);
            // 第四步，创建单元格，并设置值
            String state=null;
            if(a.get(i).getState()==0){
            	state="离线";
            }else if(a.get(i).getState()==1){
            	state="在线";
            }else if(a.get(i).getState()==3){
            	state="请假中";
            }else if(a.get(i).getState()==4){
            	state="借调";
            }else{
            	state="无状态";
            }
            row.createCell(0).setCellValue(a.get(i).getGuidenum());
            row.createCell(1).setCellValue(a.get(i).getGuidename());
            row.createCell(2).setCellValue(a.get(i).getGsex());
            row.createCell(3).setCellValue(a.get(i).getWorkage());
            row.createCell(4).setCellValue(state);

        }
        //自动设置EXCEL的列宽，视自己的需求而定，也可以用sheet.setDefaultColumnWidth(13);为全部列的列宽设置默认值
        sheet.autoSizeColumn((short)0);
        sheet.autoSizeColumn((short)2);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
        sheet.autoSizeColumn((short)10);

        //设置文件名，用格式化日期来生成一个ID
        String filePath="";
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(dt).toString();
        filePath = "D:NetDevice" + date + ".xls";
        File file=new File(filePath);
        try{
            OutputStream out=new FileOutputStream(file);
            wb.write(out);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        InputStream in=null;
        try{
            in=new FileInputStream(file);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return in;
    }

	public static  InputStream exportNetworkDeviceList2(List<Guidem> a ) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("导游派单表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

 

        //写列名，视自己的需求而定
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("导游机编号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("导游编号");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("导游姓名");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("携带游客机个数");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("派单日期");
        cell.setCellStyle(style);
        
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，\
        //List<Guidem> a = bizService.getGuidemBiz().findAll2();
        for (int i = 0; i < a.size(); i++) {
            row = sheet.createRow((int) i + 1);
            //NetworkDevice netDevice = exportList.get(i);
            // 第四步，创建单元格，并设置值
            if(a.get(i).getGuidemnum()==null){
            	row.createCell(0).setCellValue("暂无");
            }else{
            	row.createCell(0).setCellValue(a.get(i).getGuidemnum());
            }
            if(a.get(i).getGuide()==null){
            	row.createCell(1).setCellValue("暂无");
            }else{
            	row.createCell(1).setCellValue(a.get(i).getGuide().getGuidenum());
            }
            if(a.get(i).getGuide()==null||a.get(i).getGuide().getGuidename()==null){
            	row.createCell(2).setCellValue("暂无");
            }else{
            	row.createCell(2).setCellValue(a.get(i).getGuide().getGuidename());
            }
            if(a.get(i).getYoukeNum()==null){
            	 row.createCell(3).setCellValue(0);
            }else{
            	row.createCell(3).setCellValue(a.get(i).getYoukeNum());
            }
            if(a.get(i).getBroT()==null){
            	 row.createCell(4).setCellValue("暂无");
            }else{
            	 row.createCell(4).setCellValue(a.get(i).getBroT());
        	}

        }
        //自动设置EXCEL的列宽，视自己的需求而定，也可以用sheet.setDefaultColumnWidth(13);为全部列的列宽设置默认值
        sheet.autoSizeColumn((short)0);
        sheet.autoSizeColumn((short)2);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
        sheet.autoSizeColumn((short)10);

        //设置文件名，用格式化日期来生成一个ID
        String filePath="";
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(dt).toString();
        filePath = "returnGuidem" + date + ".xls";
        File file=new File(filePath);
        try{
            OutputStream out=new FileOutputStream(file);
            wb.write(out);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        InputStream in=null;
        try{
            in=new FileInputStream(file);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return in;
    }
	
	public static  InputStream exportNetworkDeviceList3(List<Guidem> a ) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("导游机使用状态表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        String asd;
        int jiecchu,guihuan;

        //写列名，视自己的需求而定
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("导游机编号");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("导游机电话");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        
        cell.setCellValue("使用次数");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("损坏次数");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("当前状态");
        cell.setCellStyle(style);
       
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，\
        //List<Guidem> a = bizService.getGuidemBiz().findAll2();
        for (int i = 0; i < a.size(); i++) {
            row = sheet.createRow((int) i + 1);
            //NetworkDevice netDevice = exportList.get(i);
            // 第四步，创建单元格，并设置值
            String state=null;
            if(a.get(i).getGmstate()==1){
            	state="导游机可借中";
            }else if(a.get(i).getGmstate()==2){
            	state="导游机借出中";
            }else if(a.get(i).getGmstate()==3){
            	state="导游机损坏中";
            }else if(a.get(i).getGmstate()==4){
            	state="导游机维修中";
            }
            
            if(a.get(i).getRetT()!=null){
            	 asd=a.get(i).getRetT().toString();
            }else{
            	asd="暂无";
            }
            if(a.get(i).getBorrow()==null){
            	jiecchu=0;
            }else{
            	jiecchu=a.get(i).getBorrow();
            }
            
            if(a.get(i).getBreak_()==null){
            	guihuan=0;
            }else{
            	guihuan=a.get(i).getBreak_();
            }
            try {
				row.createCell(0).setCellValue(a.get(i).getGuidemnum());
				row.createCell(1).setCellValue(a.get(i).getGmtel());
				row.createCell(2).setCellValue(jiecchu);
				row.createCell(3).setCellValue(guihuan);
				row.createCell(4).setCellValue(state);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        //自动设置EXCEL的列宽，视自己的需求而定，也可以用sheet.setDefaultColumnWidth(13);为全部列的列宽设置默认值
        sheet.autoSizeColumn((short)0);
        sheet.autoSizeColumn((short)2);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
        sheet.autoSizeColumn((short)10);

        //设置文件名，用格式化日期来生成一个ID
        String filePath="";
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(dt).toString();
        filePath = "returnGuidem" + date + ".xls";
        File file=new File(filePath);
        try{
            OutputStream out=new FileOutputStream(file);
            wb.write(out);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        InputStream in=null;
        try{
            in=new FileInputStream(file);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return in;
    }
	
	
	public static  InputStream exportNetworkDeviceList4(List<Session> a ) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("导游评价信息表");
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

        //写列名，视自己的需求而定
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("导游姓名");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("导游编号");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("带团日期");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("带团人数");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("游客评分");
        cell.setCellStyle(style);
        
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，\
        //List<Guidem> a = bizService.getGuidemBiz().findAll2();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < a.size(); i++) {
            row = sheet.createRow((int) i + 1);
            //NetworkDevice netDevice = exportList.get(i);<td>${pp.onlineT }</td>
//			<td>${pp.guide.youkeMnum}</td>
//			<td>${pp.score }</td>

            // 第四步，创建单元格，并设置值
            try {
				row.createCell(0).setCellValue(a.get(i).getGuide().getGuidename());
				row.createCell(1).setCellValue(a.get(i).getGuidemnum());
				row.createCell(2).setCellValue(df.format(a.get(i).getOnlineT()));
				row.createCell(3).setCellValue(a.get(i).getPerson());
				row.createCell(4).setCellValue(a.get(i).getScore());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        //自动设置EXCEL的列宽，视自己的需求而定，也可以用sheet.setDefaultColumnWidth(13);为全部列的列宽设置默认值
        sheet.autoSizeColumn((short)0);
        sheet.autoSizeColumn((short)2);
        sheet.autoSizeColumn((short)6);
        sheet.autoSizeColumn((short)7);
        sheet.autoSizeColumn((short)8);
        sheet.autoSizeColumn((short)9);
        sheet.autoSizeColumn((short)10);

        //设置文件名，用格式化日期来生成一个ID
        String filePath="";
        Date dt = new Date();
       // DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = df.format(dt).toString();
        filePath = "returnGuidem.xls";
        File file=new File(filePath);
        try{
            OutputStream out=new FileOutputStream(file);
            wb.write(out);
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        InputStream in=null;
        try{
            in=new FileInputStream(file);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return in;
    }
	
}