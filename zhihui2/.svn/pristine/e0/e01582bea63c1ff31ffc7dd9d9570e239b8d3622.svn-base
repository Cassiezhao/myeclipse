<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:if test="#session.heihei!=1">
	<c:redirect url="../init_Youkem"></c:redirect>
</s:if>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8" />
<title>游客机管理</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="../assets/app/css/common.css">
<link rel="stylesheet"
	href="../assets/app/css/HistoricalOrder_style.css" />
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<script type="text/javascript">
	$(function() {
		$("#list2").css('display', 'none');
		$("#list3").css('display', 'none');
		$("#list6").css('display', 'none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu7").addClass("active");

	})
</script>

<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link><script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script><script
	type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<body>
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->

	<!--main content start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a></li>
				<li>游客机管理</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					游客机管理 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>游客机库存&数量录入
				</font>

			</div>

			<!-- /.page-header -->
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-3"></div>
					<div class="col-md-6">
						<table class="table table-bordered table-hover"
							style="font-size:13px">
							<tr>
								<th class="info">现有游客机数量</th>
								<td style="width:200px;">${youkem.youkeMle }</td>
							</tr>
							<tr>
								<th class="info">借出游客机数量</th>
								<td>${youkem.youkeMbr }</td>
							</tr>
							<tr>
								<th class="info">损坏游客机数量</th>
								<td>${youkem.youkeMboom }</td>
							</tr>
						</table>
						<form id="form1" action="../init_Youkem?k=1" method="post"
							style="padding-top:20px;">
							<table>
								<tr>
									<th>添加游客机</th>
									<td style="width:200px;padding-left:10px;"><input
										class="easyui-numberbox" required="true"
										missingMessage="必须为数字" style="border-radius:0 0 0 0;"
										id="num1" name="num" />
									</td>
									<td style="padding-left:10px;">
										<button id="btn" class="btn btn-primary btn-sm " type="button"
											onclick="this.form.submit()">
											<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
											确定
										</button>
									</td>
								</tr>
							</table>
						</form>
					</div>
					<!-- /span -->
					<div class="col-md-3"></div>

				</div>
				<!-- row end-->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$('#num1').validatebox(options);
	$("#btn").click(function() {
		$("#form1").submit();
		$("#num1").val("");
	});
</script>
</html>