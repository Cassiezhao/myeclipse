<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8"/>
    <title>操作日志</title>
		<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="../assets/app/css/common.css" >
		<script type="text/javascript" src="../assets/app/js/common.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css"/>
		
<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>	
	
	<script
	type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link><script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
	
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','none');
		$("#list6").css('display','none');
		$("#list9").css('display','none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu11").addClass("active");
	})
</script>
</head>
  
  <body>	
	<jsp:include page="../common2.jsp"/>
				<!--slide bar end-->
				
				<!-- main start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
					<div class="main-content-title" >
												
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="../index.jsp" style="padding-left:10px;">首页</a></li>			  
						 				  
							<li>操作日志</li>
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								操作日志
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
							</font>
							
						</div>
						<!-- /.page-header -->
						<div class="row">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">
						<form class="form-inline" action="../chaxun_Memory" method="post">
							<div class="form-group" style="padding-bottom:10px;">
								<select name="memxuanze" style="font-size:12px;height:20px;">
									<option value="5000" selected="selected">查询</option>
									<option value="1">按操作人员姓名查询</option>
									<option value="2">按操作日期时间查询</option>
								</select> <input type="hidden" name="i" value="1" /> <input
									style="height:20px;padding-left:10px" id="js-in" name="memoryshuju">
								<span
									style="font-size:20px;line-height:20px; position: absolute; margin-left:-20px; cursor: pointer"
									onclick="clearInput1()">×</span> <input type="text" id="cal11"
									style="height:20px;" name="before" /> - <input type="text"
									id="cal22" style="height:20px;" name="after" />
								<button class="glyphicon glyphicon-search"
									onclick="this.form.submit()"></button>

								日期选择器



							</div>
						</form>

					</div>
				</div>
			</div>
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">			
						<div class="tab-content" >
													
							<table class="table table-bordered table-hover fontsize">
								<tr class="guideinfotitle" style="border-bottom-width: 2px;">
									
									<th >操作事件</th>
									<th >操作人员</th> 
									<th >操作信息</th> 
									
									<th >操作时间</th>
								</tr>
								<s:iterator value="#session.memories" var="mem">
								<tr style="border-bottom-width: 2px;">
									<td>${mem.mmid }</td>
									<td>${mem.opuser}</td>
									<td>${mem.message }</td>
									<td>${mem.mtime }</td>
									

								</tr>
								</s:iterator>
								
						</table>
						</div>
						<!-- table end -->
					<div align="center">
						<div  id="pp" class="easyui-pagination" style="border:1px solid #ccc" >
						</div>
						</div>
					
					</div>
					<!--col 12 end-->
				</div>
			</div>	
		<!--row end-->						
		
		</div>
	</div>
		   
	<script type="text/javascript">
	 $('#pp').pagination({
	 
	 pageSize:<%=session.getAttribute("aaa") %>,
	    total:<%=session.getAttribute("memtotal") %>,
	    pageNumber:<%=session.getAttribute("mempage") %>,
	    
	    
	     pageList: [5, 10, 15, 20],
	     
    	onSelectPage:function(pageNumber, pageSize){
    		$(this).pagination('loading');
    		$(this).pagination('loaded');
    
    		window.location = "../<%=session.getAttribute("url") %>page=" + pageNumber+"&rows="+pageSize;
    	}
    	
    });
	J(function() {
					J('#cal11').calendar({
						format : 'yyyy-MM-dd HH:mm:ss'
					});
					J('#cal22').calendar({
						format : 'yyyy-MM-dd HH:mm:ss'
					});
				});
				function clearInput1() {
					document.getElementById('js-in').value = '';
				};
	</script> 			
  </body>
</html>
