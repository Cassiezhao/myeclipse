<%@page import="chris.pojo.Total"%>
<%@page import="chris.bean.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title>导游监听</title>

<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="../assets/app/css/mointorGuide.css">
<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />

<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link>
<style type="text/css">
#container {
	height: 400px;
	width: 100%;
}

#container2 {
	height: 400px;
	width: 100%;
}

#r-result {
	width: 100%;
}

#r-result2 {
	width: 100%;
}

.panel-body {
	padding: 0px;
}

.datagrid {
	margin-bottom: 0px;
}

.datagrid-pager {
	background-color: #ffffff;
	margin-left: auto;
}
</style>
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','block');
		
		$("ul.tree li ul li").removeClass("active");
		$("#ok8").addClass("active");
	});
</script>
<script type="text/javascript" src="../HZRecorder.js"></script>

<script type="text/javascript" src="../assets/js/jquery.timers.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery.timers.js"></script>
<script type="text/javascript" src="guideOnline.js"></script>
<script type="text/javascript" src="../assets/app/layer/layer.js"></script>
<script type="text/javascript" src="../assets/app/js/mointorGuide.js"></script>
</head>

<body>
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->


	<!-- main start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a></li>

				<li>导游监听</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;position:relative;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					导游列表 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
				</font>


			</div>


			<!-- /.page-header -->
			<div class="row">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">
						<div class="tab-content" style="">
							<div id="home" class="tab-pane in active">
								<form action=" " method="post">
									<table class="table table-bordered table-hover fontsize">
										<tr class="guideinfotitle" style="border-bottom-width: 2px;">
											<th><input type="checkbox" class="all" onclick="selectAll()"></th>
											<th>导游图片</th>
											<th>导游姓名</th>
											<th>导游编号</th>
											<th>导游机编号</th>
											<th>经度</th>
											<th>维度</th>
											<th>携带人数</th>
											<th>实时监听</th>
										</tr>

										<s:iterator value="#session.pb.pagelist" var="pp">
												<tr>
													<td><input type="checkbox" name="luzhiCheck" value="${pp.guidem.guidemid }"></td>
													<td><img style="width:50px;height:50px;"
														src="../files/${pp.photo}">
													</td>
													<td>${pp.guidename}</td>
													<td>${pp.guidenum }</td>
													<td>${pp.guidem.guidemnum }</td>
													<td>${pp.jingdu }</td>
													<td>${pp.weidu }</td>
													<td>${pp.youkeMnum }</td>
													<td>
														<input type="button" value="开始" onclick="mylistener(${pp.guidem.guidemid })" 
														style="background:#5cb85c;border:#3e8f3e;color:#ffffff"/>/
														
												<!--  -->		<input type="button" value="停止" onclick="mylistenerst(${pp.guidem.guidemid })" />
													</td>
												</tr>


										</s:iterator>

									</table>
								</form>
								
								<div class="" style="margin-top:20px;float:center">
									<button id="btn_confirm" class="btn btn-primary btn-sm "
															type="button" onclick="startR()">开始录制</button>
									<a href="../myfindAll_monitor" style="float:right">查看监听详情</a>	
								</div>
								
					<!-- modelstart -->
					<div id="mm" class="modal fade bs-example-modal-sm " tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
															  <div class="modal-dialog modal-sm">
																<div class="modal-content" style="padding-left:10px">
																	<h5>请输入录制时间：</h5>
																	<form action="" method="post">
																	<input type="text" style="width:260px" name="mytime" id="mytime" required="true" class="easyui-numberbox"
										missingMessage="必须为数字" style="border-radius:0 0 0 0;">
																	<input type="hidden" id="muguidemid" />
																		<div style="margin-top:10px;margin-bottom:5px;width:260px">
																			<button type="button" class="btn-info" onclick="startrange()">分钟</button>
																			
																		</div>
																		</form>
																</div>
															  </div>
															</div>
					<!-- m end -->			
								<div align="center">
									<div id="pp" class="easyui-pagination"
										style="border:1px solid #ccc"
										data-options="
												total: <%=session.getAttribute("total")%>,pageSize:5">
									</div>
								</div>
							</div>
				<div class="oAudio">
					若音频断开，请点击<input type="button" onclick="myconti()" value="重新连接" class="btn btn-sm btn-primary"/>
					<audio controls="controls" height="700" width="100" style="margin-top:30px;" id="audio">
					       
					    <!-- <source src="C:/Users/chirs/Desktop/pic/sad.mp3" /> -->
					    <!-- 100004_9732/1.amr" /> -->
					</audio>						
				</div>
</body>
<script type="text/javascript">
	
	
	$(function(){
		$('#pp').pagination({
	    total:<%=session.getAttribute("total")%>,
	    pageNumber:<%=session.getAttribute("page")%>,
	    pageSize:<%=session.getAttribute("rows")%>,
	     pageList: [5, 10, 15, 20],
    	onSelectPage:function(pageNumber, pageSize){
    		$(this).pagination('loading');
    		$(this).pagination('loaded');
    		window.location = "../findAll_Guide?i=5&page=" + pageNumber+"&rows="+pageSize;
    	}
    });
    $(".oAudio").dialog({
						closed : true,
		});

	});

</script>
</html>