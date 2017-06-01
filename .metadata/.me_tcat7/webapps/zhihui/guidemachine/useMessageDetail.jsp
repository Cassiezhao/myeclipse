<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>导游机使用情况</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />

<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link>
<script type="text/javascript">
	$(function() {
		$("ul.tree li ul li").removeClass("active");
		$("#ok4").addClass("active");
	})
</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-180" data-genuitec-path="/zhihui2/WebRoot/guidemachine/useMessageDetail.jsp">
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->


	<!-- main start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-180" data-genuitec-path="/zhihui2/WebRoot/guidemachine/useMessageDetail.jsp">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="canBorrow.jsp" style="padding-left:10px;">首页</a>
				</li>
				<li><a href="../guidemachine/useMessage2.jsp">使用情况</a></li>
				<li>详情</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					详细情况 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
				</font>

			</div>
			<!-- /.page-header -->

			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">

					<div class="col-md-12">
						<div class="tabbable">


							<div class="tab-content" style="">
								<div id="home" class="tab-pane in active">
									<table class="table table-bordered table-hover fontsize">
										<tr class="guideinfotitle" style="border-bottom-width: 2px;">
											<th>导游机编号</th>
											<th>借出日期</th>
											<th>归还日期</th>
											<th>损坏情况</th>
										</tr>
										<s:iterator value="#session.listgdt" var="gdt">
											<tr>
												<td>${gdt.guidemid }</td>
												<td>${gdt.brot }</td>
												<td>${gdt.rett}</td>
												<td>${gdt.sutinfo}</td>
											</tr>
										</s:iterator>


									</table>

								</div>
							</div>
						</div>
					</div>
					<!-- /span -->
				</div>
				<!-- row end-->
				<!--main content end-->
				<div align="center">
					<div id="pp" class="easyui-pagination"
						style="border:1px solid #ccc"
						data-options="
							total: <%=session.getAttribute("gdttotal")%>,pageSize:5">
					</div>
				</div>

				<!--row end-->
			</div>

		</div>
	</div>

</body>
<script type="text/javascript">
	$('#pp').pagination(
			{
				total :
<%=session.getAttribute("gdttotal")%>
	,
				pageNumber :
<%=session.getAttribute("gdtpage")%>
	,
				pageSize :
<%=session.getAttribute("gdtrows")%>
	,
				pageList : [ 5, 10, 15, 20 ],
				onSelectPage : function(pageNumber, pageSize) {
					$(this).pagination('loading');
					$(this).pagination('loaded');
					window.location = "../guidemDetail?guidemid=${gdtid}&page=" + pageNumber
							+ "&rows=" + pageSize;
					//window.location = "../findAll_Guide.action?i=1&page="+ pageNumber+"&rows="+pageSize;
				}
			});
</script>
</html>