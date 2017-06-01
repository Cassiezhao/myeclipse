<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>导游上下线情况</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

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
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','block');
		
		$("ul.tree li ul li").removeClass("active");
		$("#ok8").addClass("active");
	})
</script>
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
					href="../index.jsp" style="padding-left:10px;">首页</a>
				</li>
				<li><a href="guideOnlineMessage.jsp">上下线详情</a></li>
				<li>导游工作详情</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					导游路径分析 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
				</font>

			</div>
			<!-- /.page-header -->
			<div class="row">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">
						<form action="../findByGid_Paths" class="form-inline" role="form"
							method="post">
							<div class="form-group" style="padding-bottom:10px;">
								<select name="sousuo2" style="font-size:12px;height:20px;">
									<option value="100">选择</option>
									<option value="1">按上线时间查询</option>
									<!-- <option value="2">按下线时间查询</option> -->
								</select> <input type="hidden" name="i" value="2" /> <input
									type="hidden" name="index" value="${gid }" /> <input
									type="text" id="cal1" style="height:20px;" name="before" /> -
								<input type="text" id="cal2" style="height:20px;" name="later" />
								<button>
									<span class="glyphicon glyphicon-search"></span>
								</button>

								<!-- 日期选择器 -->



							</div>
						</form>

					</div>
				</div>
			</div>



			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">

					<div class="col-md-12">
						<table class="table table-bordered table-hover fontsize">
							<tr class="guideinfotitle" style="border-bottom-width: 2px;">
								<th>导游姓名</th>
								<th>导游编号</th>
								<th>导游机编号</th>
								<th>上线时间</th>
								<th>下线时间</th>
								<th>路径详情</th>
							</tr>


							<s:iterator value="#session.pathpb.pagelist" var="sessions">
								<tr>
									<td>${sessions.guide.guidename}</td>
									<td>${sessions.guide.guidenum}</td>
									<td>${sessions.guidemnum}</td>
									<td>${sessions.onlineT}</td>
									<td>${sessions.uplineT}</td>
									<td><a
										href="../findByGid2_Paths?index=${sessions.guide.guideid }&sessionid=${sessions.sessionId }">路径详情</a>
									<td>
								</tr>
							</s:iterator>


						</table>
						<!-- table end -->
						<div align="center">
							<div id="pp" class="easyui-pagination"
								style="border:1px solid #ccc"
								data-options="
							total: <%=session.getAttribute("total3")%>,pageSize:5">
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
	
	$('#pp').pagination(
				{
					total :
	<%=session.getAttribute("total3")%>
		,
					pageNumber :
	<%=session.getAttribute("page3")%>
		,
					pageSize :
	<%=session.getAttribute("rows3")%>
		,
					pageList : [ 5, 10, 15, 20 ],
					onSelectPage : function(pageNumber, pageSize) {
						$(this).pagination('loading');
						$(this).pagination('loaded');
						window.location = "<%=session.getAttribute("url")%>index=${gid}&i=2&page="+ pageNumber + "&rows=" + pageSize;
							}
						});
		J(function() {
			J('#cal1').calendar({
				format : 'yyyy-MM-dd HH:mm:ss'
			});
			J('#cal2').calendar({
				format : 'yyyy-MM-dd HH:mm:ss'
			});
		});
	</script>
</body>
</html>