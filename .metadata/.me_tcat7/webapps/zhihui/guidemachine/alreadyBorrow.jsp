<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:if test="#session.pb2==null">
	<c:redirect url="../findAll_Guidem?i=1"></c:redirect>
</s:if>
<html>
<head>
<meta charset="utf-8" />
<title>归还导游机</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link><script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />

<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>	
	




<script type="text/javascript">
	$(function(){
		$("ul.tree li ul li").removeClass("active");
		$("#ok2").addClass("active");
	});
	
</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-174" data-genuitec-path="/zhihui2/WebRoot/guidemachine/alreadyBorrow.jsp">
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->


	<!-- main start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-174" data-genuitec-path="/zhihui2/WebRoot/guidemachine/alreadyBorrow.jsp">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a>
				</li>

				<li>归还导游机</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					借出导游机 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
				</font>

			</div>

			<!-- /.page-header搜索栏-->
			<div class="row">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">
						<form class="form-inline" action="../findAll_Guidem" method="post">
							<div class="form-group" style="padding-bottom:10px;">
								<select name="xuanze" style="font-size:12px;height:20px;">
									<option value="100" selected="selected">查询</option>
									<option value="1">按导游机编号查询</option>
									<option value="2">按导游编号查询</option>
									<option value="3">按导游姓名查询</option>
									<option value="4">按派单日期查询</option>
								</select> <input type="hidden" name="i" value="1" /> <input
									style="height:20px;padding-left:10px" id="js-in" name="shuju">
								<span
									style="font-size:20px;line-height:20px; position: absolute; margin-left:-20px; cursor: pointer"
									onclick="clearInput1()">×</span> <input type="text" id="cal1"
									style="height:20px;" name="before" /> - <input type="text"
									id="cal2" style="height:20px;" name="after" />
								<button class="glyphicon glyphicon-search"
									onclick="this.form.submit()"></button>

								<!-- 日期选择器 -->



							</div>
							<input type="button" value="导出" style="float:right"
								class="btn-info"
								onclick="javascript:window.location.href='../ExcelAction2'">
							<input type="button" value="快捷归还"
								style="float:right;margin-right:5px;" class="btn-info"
								onclick="quickReturn()">
						</form>

					</div>
				</div>
			</div>

			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">
						<div class="tab-content" style="">

							<table class="table table-bordered table-hover fontsize">
								<tr class="guideinfotitle" style="border-bottom-width: 2px;">
									<th>导游机编号</th>

									<th>导游编号</th>
									<th>导游姓名</th>
									<th>携带导游机个数</th>
									<th>派单日期</th>
									<th>导游机归还</th>
									
									
								</tr>
								<s:iterator value="#session.pb2.pagelist" var="guidem">
									<s:if test="#guidem.gmstate==2">

										<tr>
											<td>${guidem.guidemnum}</td>
											<td>${guidem.guide.guidenum }</td>

											<td>${guidem.guide.guidename }</td>
											<td>${guidem.youkeNum}</td>

											<td>${guidem.assignTime }</td>
											<td align='center'><a
												onclick="gosd(${guidem.guidemid })">归还</a></td>
											<!--  <td align='center'><a href="../pringtf_ChangeScore?guideid=${guidem.guide.guideid }">打印</a></td>-->
										</tr>
									</s:if>


								</s:iterator>
							</table>

						</div>
						<!-- table end -->
					</div>
					<!--col 12 end-->
					<div align="center">
						<div id="pp" class="easyui-pagination"
							style="border:1px solid #ccc"
							data-options="
									total: <%=session.getAttribute("total2")%>,pageSize:5
									">
						</div>
					</div>
					<div align="center">
						<font color="red">${BYZ}</font>
					</div>
				</div>

			</div>
			<!--row end-->

		</div>
	</div>
	<!-- 归还按钮表单start -->
	<div id="return">
		<form id="form3" action="../findById_Guidem" method="post">
			<table style="font-size:20px;">

				<tr>
					<td style="height:40px;"><input id="index" type="hidden"
						name="index" />
					</td>
				</tr>

				<tr>
					<td style="height:40px;">导游机编号:</td>
					<td style="height:40px;"><input type="text" name="newmnum" />
					</td>
				</tr>
				<tr>
					<td>导游编号:</td>
					<td><input id="myids" type="text" name="newgunm" /> <input
						type="hidden" name="j" value="1" /></td>

				</tr>
			</table>
		</form>
		<div style="padding-top:20px;padding-right:20%;">
			<button type="button" class="btn btn-primary "
				style="margin-right:10px;" onclick="tijiao2()">
				<span class="glyphicon glyphicon-ok"></span>确定
			</button>
			<button type="button" class="btn btn-default "
				style="margin-right:30px;" onclick="no()">
				<span class="glyphicon glyphicon-remove"></span>取消
			</button>


		</div>

	</div>
	<!-- 快捷归还按钮start -->
	<div id="qreturn">
		<form action="../findById3_Guidem" method="post" id="form4">
			<table style="font-size:20px;border:1px;">

				<tr>
					<td style="height:40px;">导游机编号:</td>

					<td style="height:40px;"><input type="text"
						name="guidem.guidemnum" /></td>
				</tr>
				<tr>
					<td style="height:40px;">导游编号:</td>
					<td style="height:40px;"><input type="text"
						name="guidem.guide.guidenum" />
					</td>
				</tr>
				<tr>
					<td style="height:40px;">游客机损坏个数:</td>
					<td style="height:40px;"><input type="text" name="youke" />
					</td>
				</tr>
				<tr>
					<td>导游机是否损坏：</td>
					<td><label class="checkbox-inline"> <input
							type="radio" value="0" style="margin-left:30px" name="tt" id="yes"
							 />是 </label> <label class="checkbox-inline"> <input
							type="radio" value="1" name="tt" style="margin-left:20px" checked="checked" id="no"/>否 </label></td>
				</tr>

				<tr>
					<td>损坏情况：</td>
					<td id="destory"><input type="checkbox" name="guidem.breakinfo"
						value="通话故障" />通话故障 <input type="checkbox"
						name="guidem.breakinfo" value="显示故障" />显示故障 <input
						type="checkbox" name="guidem.breakinfo" value="通信故障" />通信故障 <input
						type="checkbox" name="guidem.breakinfo" value="其他" />其他</td>
				</tr>
			</table>
		</form>
		<div style="padding-top:20px;padding-right:20%;">
			<button type="button" class="btn btn-primary "
				style="margin-right:10px;" onclick="tijiao()">
				<span class="glyphicon glyphicon-ok"></span>确定
			</button>
			<button type="button" class="btn btn-default "
				style="margin-right:30px;" onclick="no()">
				<span class="glyphicon glyphicon-remove"></span>取消
			</button>


		</div>
	</div>
	<!-- 快捷归还按钮end -->

<script type="text/javascript">
J(function() {
					J('#cal1').calendar({
						format : 'yyyy-MM-dd HH:mm:ss'
					});
					J('#cal2').calendar({
						format : 'yyyy-MM-dd HH:mm:ss'
					});
				});
				function clearInput1() {
					document.getElementById('js-in').value = '';
				};
</script>

	<script type="text/javascript">
	$(function(){
		  if ($("#no").attr("checked")) {
		  
		  	$("#destory").hide();
                    
           }
           
           $("#no").click(function () {
                $("#destory").hide();
            });
            
            $("#yes").click(function () {
                $("#destory").show();
            });
           
           
	})
	
			/*快捷归还按钮 start*/
			$('#qreturn').dialog({
						closed : true,
					});
				$('#return').dialog({
						closed : true,
					});
			function quickReturn(){
				$('#qreturn').dialog({
						title : '快捷归还导游机',
						width : 550,
						height : 300,
						closed : false,
						iconCls:'icon-save',
						cache : true,
						href : '',
						modal : true
					});
			
			}
			/*快捷归还按钮 end*/
			
			function tijiao(){
				$("#form4").submit();
			}
			
			function tijiao2(){
				$("#form3").submit();
			}
			/*归还按钮 start*/
			var num;
			function no(){
			$('#return').dialog({
						closed : true});
			$('#qreturn').dialog({
						closed : true});
			}
			
			function gosd( a) {
				num=a;
				$("#index").attr('value',num);
				$('#return').dialog({
					title : '完整归还导游机',
					width : 400,
					height : 200,
					closed : false,
					iconCls:'icon-save',
					cache : true,
					href : '',
					modal : true
				});
				}
			/*归还按钮 end*/	
				
				
				$('#pp').pagination(
						{
							total :
			<%=session.getAttribute("total2")%>
				,
							pageNumber :
			<%=session.getAttribute("page2")%>
				,
							pageSize :
			<%=session.getAttribute("rows2")%>
				,
							pageList : [ 5, 10, 15, 20 ],
							onSelectPage : function(pageNumber, pageSize) {
								$(this).pagination('loading');
								$(this).pagination('loaded');
								window.location = "<%=session.getAttribute("url")%>i=1&page="
										+ pageNumber + "&rows=" + pageSize;
							}
						});
						
			
			</script>
</body>
</html>