<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<s:if test="#session.pingjia!=100">
	<c:redirect url="../findAll_Guide?i=4"></c:redirect>
</s:if>
<html>
  <head>
    <meta charset="utf-8"/>
    <title>评价信息</title>
		<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="../assets/app/css/common.css" >
		<script type="text/javascript" src="../assets/app/js/common.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css"/>
		
		
		<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link><script type="text/javascript"
	src="../assets/app/js/lhgcalendar.min.js"></script><script
	type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script><script
	type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css" type="text/css"></link>
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','none');
		$("#list6").css('display','none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu4").addClass("active");
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
						 				  
							<li>评价信息</li>
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								评价信息
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
							</font>
							
						</div>
						<!-- /.page-header -->
						<div class="row">	
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">	
								<form action="../findAll_Guide" class="form-inline" role="form" method="post">
									  <div class="form-group" style="padding-bottom:10px;">
										<select name="sousuo" style="font-size:12px;height:20px;">
										<option value="4">选择</option>
										  <option value="1">按导游编号查询</option>
										  <option value="2">按导游姓名查询</option>
										</select>
										<input type="hidden" name="i" value="4"/>
										<input name="xuanze" style="height:20px;padding-left:10px" id="js-in" >
										<span style="font-size:20px;line-height:20px; position: absolute; margin-left:-20px; cursor: pointer" onclick="clearInput1()">×</span>
										<button class="glyphicon glyphicon-search" onclick="this.form.submit()"></button>
										
										<!-- 日期选择器 -->
										
										
										
									  </div>
								
							</div>
						</div>
					</div>
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">			
						<div class="tab-content" >
													
							<table class="table table-bordered table-hover fontsize">
								<tr class="guideinfotitle" style="border-bottom-width: 2px;">
									
									<th >导游姓名</th>
									<th >导游编号</th> 
									<th>初始评分</th>
									<th>评定级别</th>
									<th >带团情况</th>
								</tr>
								<s:iterator value="#session.pb.pagelist" var="pp">
											<tr style="border-bottom-width: 2px;">
												<td>${pp.guidename}</td>
												<td>${pp.guidenum }</td>
												<td><a href="../findById1_Guide?index=${pp.guideid }">${pp.score }分</a></td>
												<td><a href="../findBysid_Paths?sid=${pp.guideid }">查看明细</a></td>
												<td><a href ="../findByGid_Paths?index=${pp.guideid}&i=1" >带团情况</a></td>

											</tr>
										</s:iterator>
								
						</table>
						</div>
						<!-- table end -->
					<div align="center">
						<div  id="pp" class="easyui-pagination" style="border:1px solid #ccc" data-options="
						total: <%=session.getAttribute("total") %>,pageSize:5
						">
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
	    total:<%=session.getAttribute("total") %>,
	    pageNumber:<%=session.getAttribute("page") %>,
	    pageSize:<%=session.getAttribute("rows") %>,
	     pageList: [5, 10, 15, 20],
    	onSelectPage:function(pageNumber, pageSize){
    		$(this).pagination('loading');
    		$(this).pagination('loaded');
    		window.location = "../findAll_Guide?i=4&page=" + pageNumber+"&rows="+pageSize;
    	}
    });
	function dorows() {
					var rows = document.form1.rows.value;
					if (isNaN(rows)) {
						alert("请输入正确的数字！");
						document.form1.rows.value = $
						{
							pb.rows
						}
						;
						return;
					}
					window.location = "../findAll_Guide.action?i=4&rows=" + rows;
				}
	function dopage() {
		var page = document.form1.page.value;
		if (isNaN(page)) {
			alert("请输入正确的数字！");
			document.form1.page.value = $
			{
				pb.page
			}
			;
			return;
		}
		window.location = "../findAll_Guide.action?i=4&page=" + page;
	}
	
	J(function(){
				J('#cal1').calendar({ format:'yyyy年MM月dd日' });
				J('#cal2').calendar({ format:'yyyy年MM月dd日' });
			});
		 
		function clearInput1() {
        document.getElementById('js-in').value = '';
		
    }
	</script> 			
	<script type="text/javascript">
	
	$path="${ctx}";
	$('.btn_clean').click(function(){
		if(confirm("确认清空?")){
			window.location.href="${ctx}/deleteAllRankInfo";
		}
	});
	</script>
  </body>
</html>
