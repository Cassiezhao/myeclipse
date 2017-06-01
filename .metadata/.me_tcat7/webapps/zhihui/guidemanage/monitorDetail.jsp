<%@page import="chris.pojo.Total"%>
<%@page import="chris.bean.PageBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-190" data-genuitec-path="/zhihui2/WebRoot/guidemanage/monitorDetail.jsp">
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->


	<!-- main start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-190" data-genuitec-path="/zhihui2/WebRoot/guidemanage/monitorDetail.jsp">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a></li>
				<li><a href="monitorGuide.jsp">导游监听</a></li>
				<li>导游监听详情</li>
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
				<div class="box-content" style="margin-left:20px;margin-bottom:4px;">
						<form action="../myfindAll_monitor" method="post">
							导游编号:
							<input type="text" name="monitor_id" value="${monitor_id}" style="-web-kit-appearance:none;-moz-appearance: none;outline:0;border-radius:4px;border:1px solid #c8cccf;padding-left:4px;"/>
							导游姓名:
							<input type="text" name="monitor_name" value="${monitor_name}" style="-web-kit-appearance:none;-moz-appearance: none;outline:0;border-radius:4px;border:1px solid #c8cccf;padding-left:4px;"/>
							
							<button onclick="this.form.submit()" class="btn btn-sm btn-primary">查询 </button>
						
						</form>
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
											 <th>导游编号</th>
											<th>导游姓名</th>
											
											<th>导游机编号</th>
											<th>抽听时间</th>
											<th>录音</th>
										</tr>
									<s:iterator	value="#session.monitor" var="monitor"> 
											<tr>
												<td>${monitor.guidenum }</td>
												<td>${monitor.guidename }</td>
												<td>${monitor. guidemachine}</td>
												
												<td><fmt:formatDate value="${monitor.gmtime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
												<td style="text-align:center" onclick="mDetail('${monitor.mydir }')"><span class="glyphicon glyphicon-volume-up" ></spackn></td>
													
											</tr>


				</s:iterator>
									</table>
								</form>
									
								<div align="center">
									<div id="pp" class="easyui-pagination"
										style="border:1px solid #ccc"
										data-options="
												total: <%=session.getAttribute("total")%>,pageSize:5">
									</div>
								</div>
							</div>
				<div class="oAudio">
				
				<div>
					
					<audio controls="controls" height="700" width="100" style="margin-top:30px;" id="audio">       
					    <!-- <source src="C:/Users/chirs/Desktop/pic/sad.mp3" /> -->
					    <!-- 100004_9732/1.amr" /> -->
					</audio>		
									
				</div>
				<!--
				">
				  -->
</body>
<script type="text/javascript">
var j=1;
var myurl;
	function mDetail(myurl){
		$('.oAudio').dialog({
    						title : '播放音频',
    						width : 300,
    						height : 100,
    						closed : false,
    						cache : true,
    						href : '',
    						modal : true
    					});
    	alert(myurl);
    	var audio=document.getElementById("audio");
            			audio.src="../files/"+myurl+"/1.mp3";
            			audio.play();
            			
            			audio.onended=function(){
            				audio.src="../files/"+myurl+"/"+j+".mp3";
            				audio.play();
            				j++;
            			}
	}
	
	$(function(){
		$('#pp').pagination({
	    total:<%=session.getAttribute("total")%>,
	    pageNumber:<%=session.getAttribute("page")%>,
	    pageSize:<%=session.getAttribute("rows")%>,
	     pageList: [5, 10, 15, 20],
    	onSelectPage:function(pageNumber, pageSize){
    		$(this).pagination('loading');
    		$(this).pagination('loaded');
    		window.location = "../<%=session.getAttribute("myurl") %>page=" + pageNumber+"&rows="+pageSize;
    	}
    });
    $(".oAudio").dialog({
						closed : true,
		});

	});

</script>
</html>