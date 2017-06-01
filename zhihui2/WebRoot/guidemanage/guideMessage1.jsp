<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:if test="#session.pb==null">
	<c:redirect url="../findAll_Guide?i=1"></c:redirect>

</s:if>
<head>
<meta charset="utf-8" />
<title>导游信息</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />

<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>
<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link>
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
		$("#ok5").addClass("active");
	})
</script>
</head>
<body>
	<jsp:include page="../common2.jsp"/>
			<!--slide bar end-->

			<!--main content start-->
			<div id="main-content" class="main-content col-md-10"
				style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff">
				<div class="main-content-title">
					<ul class="breadcrumb">
						<li><span class="glyphicon glyphicon-home"></span><a
							href="../index.jsp" style="padding-left:10px;">首页</a>
						</li>
						<li>导游信息</li>
					</ul>
				</div>


				<!-- 
				搜索页
				 -->
				
				<div class="container-fluid">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							导游信息 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>
					</div>
					
					
					<div class="row">
					<div style="margin-left:20px;margin-right:20px;">
						<div class="col-md-12">
							<form action="../findAll_Guide" class="form-inline" role="form"
								method="post">
								<div class="form-group" style="padding-bottom:10px;">
									<select name="sousuo" style="font-size:12px;height:20px;">
										<option value="4">选择</option>
										<option value="1">按导游编号查询</option>
										<option value="2">按导游姓名查询</option>
									</select> <input type="hidden" name="i" value="1" /> <input
										type="hidden" name="gxg" value="10" /> <input name="xuanze"
										style="height:20px;padding-left:10px" id="js-in"> <span
										style="font-size:20px;line-height:20px; position: absolute; margin-left:-20px; cursor: pointer"
										onclick="clearInput1()">×</span>
									<button class="glyphicon glyphicon-search"
										onclick="this.form.submit()"></button>

									<!-- 日期选择器 -->



								</div>
								<input type="button" value="导出" style="float:right"
									class="btn-info" onclick="javascript:window.location.href='../ExcelAction'">
							</form>

						</div>
					</div>
				</div>
					<div style="margin-left:20px;margin-right:20px;">
						<table class="table table-bordered table-hover fontsize ">
							<tr class="guideinfotitle" style="border-bottom-width: 2px;">
								<th>编号</th>
								<th>姓名</th>
								<th>性别</th>
								<th>工龄</th>
								<th>上线次数</th>
								<th>请假/销假</th>
								
								<th>借调/返回</th>
								<th>停职/复职</th>
								<th>查看详情</th>
								<th>带团览图</th>
								<th></th>
							</tr>

							<s:iterator value="#session.pb.pagelist" var="guide">
								<tr>

									<td>${guide.guidenum}</td>
									<td>${guide.guidename}</td>
									<td>${guide.gsex }</td>
									<td>${guide.workage }</td>
									<td>${guide.ontimenum }</td>
									<td><s:if test="#guide.state==1">
									导游在线
									</s:if> <s:if test="#guide.state==0">
											<a href="../findAll_Guide?i=1&jia=1&index=${guide.guideid}">
												<input type="button" value="请假" class="btn-info" "/> </a>
									导游离线
									</s:if> <s:elseif test="#guide.state==3">
											<a href="../findAll_Guide?i=1&jia=2&index=${guide.guideid}"><input
												type="button" value="销假" class="btn-info"> </a>
									导游请假中
									</s:elseif></td>
									
									
									
									
									
									<td><s:if test="#guide.state==0">
											<a href="../findAll_Guide?i=1&jia=3&index=${guide.guideid}"><input
												type="button" value="借调" class="btn-info"> </a>
										</s:if> <s:elseif test="#guide.state==4">
											<a href="../findAll_Guide?i=1&jia=4&index=${guide.guideid}"><input
												type="button" value="返回" class="btn-info"> </a>
									导游借调中
									</s:elseif></td>
									<td>
											<a href="../findAll_Guide?i=1&jia=5&index=${guide.guideid}"><input
												type="button" value="停职" class="btn-info"> </a>
										 <s:elseif test="#guide.state==5">
											<a href="../findAll_Guide?i=1&jia=4&index=${guide.guideid}"><input
												type="button" value="复职" class="btn-info"> </a>
									导游停职中
									</s:elseif></td>
									
									<td><a href="../findById4_Guide?index=${guide.guideid}">详情</a>
									</td>
									<td><a href="../guideDataas?daoyouid=${guide.guideid}">详情</a>
									</td>
									
									<td align="center"><a
										href="../findById2_Guide?index=${guide.guideid}">
											<button class="btn-info btn_modify" title="修改">
												<span class="glyphicon glyphicon-edit" aria-hidden="true"
													style="color:#ffffff;"> </span>
											</button> </a> <a href="../delById_Guide?index=${ guide.guideid}"
										onclick="return dodel()">
											<button class="btn-danger btn_del btn_delete" title="删除">
												<span class="glyphicon glyphicon-trash" aria-hidden="true">
												</span>
											</button> </a></td>
								</tr>
							</s:iterator>
						</table>
					</div>

					<div align="center">
						<div id="pp" class="easyui-pagination"
							style="border:1px solid #ccc"
							data-options="
							total: <%=session.getAttribute("total")%>,pageSize:5">
						</div>
					</div>
				</div>
				<!--row end-->
			</div>

		</div>

	</div>
	<!--main content end-->

	<!--row end-->
	<script type="text/javascript">
		$('#pp').pagination(
				{
					total :
	<%=session.getAttribute("total")%>
		,
					pageNumber :
	<%=session.getAttribute("page")%>
		,
					pageSize :
	<%=session.getAttribute("rows")%>
		,
					pageList : [ 5, 10, 15, 20 ],
					onSelectPage : function(pageNumber, pageSize) {
						$(this).pagination('loading');
						$(this).pagination('loaded');
						window.location = "../findAll_Guide.action?i=1&page="+ pageNumber+"&rows="+pageSize;
					}
				});
	</script>
	<script type="text/javascript">
		function dodel() {
			return window.confirm("是否真的删除！");
		}

		function dorows() {
			var rows = document.form1.rows.value;
			if (isNaN(rows)) {
				alert("请输入正确的数字！");
				document.form1.rows.value = 10;
				return;
			}
			window.location = "../findAll_Guide?i=1&rows=" + rows;
		}
		function dopage() {
			var page = document.form1.page.value;
			if (isNaN(page)) {
				alert("请输入正确的数字！");
				document.form1.page.value = 1;
				return;
			}
			window.location = "../findAll_Guide?i=1&page=" + page;
		}
	</script>
</body>
</html>