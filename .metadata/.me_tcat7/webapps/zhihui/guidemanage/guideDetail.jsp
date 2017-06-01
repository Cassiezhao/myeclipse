<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8"/>
    <title>导游信息</title>
		<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="../assets/app/css/common.css" >
		<script type="text/javascript" src="../assets/app/js/common.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css"/>
		
		<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','block');
		
		$("ul.tree li ul li").removeClass("active");
		$("#ok5").addClass("active");
	})
</script>	
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-182" data-genuitec-path="/zhihui2/WebRoot/guidemanage/guideDetail.jsp">	
	<jsp:include page="../common2.jsp"/>
				<!--slide bar end-->
				
				<!--main content start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-182" data-genuitec-path="/zhihui2/WebRoot/guidemanage/guideDetail.jsp">
					<div class="main-content-title" >											
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="../index.jsp" style="padding-left:10px;">首页</a></li>			  
						 	<li>
								<a href="guideMessage1.jsp">导游信息
								</a>
							</li>
							<li>导游信息详情</li>
						</ul>						
					</div>
					
					<div class="container-fluid">
				    <div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								导游详情								
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
							</font>
						</div>
						<div style="margin-left:20px;margin-right:20px;">
							<div class="row">
							<div class="col-md-11">
				
								<table class="table table-bordered">
										<tr>
											<th class="active">姓名</th>
											<td>${guide4.guidename }</td>
											<th class="active">性别</th>
											<td>${guide4.gsex }</td>
										</tr>
										<tr>
											<th class="active">年龄</th>
											<td>${guide4.age }</td>
											<th class="active">学历</th>
											<td>${guide4.school }</td>
										</tr>
										<tr>
											<th class="active">身份证号</th>
											<td>${guide4.idcard }</td>
											<th class="active">出生日期</th>
											<td>${guide4.birth}</td>
										</tr>
										<tr>
											<th class="active">联系电话</th>
											<td>${guide4.gtel }</td>
											<th class="active">普通话等级</th>
											<td>${guide4.level }</td>
										</tr>
										<tr>
											<th class="active">语言</th>
											<td>${guide4.language }</td>
											<th class="active">血型</th>
											<td>${guide4.blood}</td>
										</tr>
										<tr>
											<th class="active">身高</th>
											<td>${guide4.height }</td>
											<th class="active">体重</th>
											<td>${guide4.weight}</td>
										</tr>
										<tr>
											<th class="active">是否有传染性疾病</th>
											
											<td>
											<s:if test="#session.guide4.diseases==0">
													是
												</s:if>
												<s:else>
													否
												</s:else>
											</td>
											<th class="active">导游证编号</th>
											<td>${guide4.guidenum }</td>
										</tr>
										<tr>
											<th class="active">是否连续从事讲解工作</th>
											<td>
												<s:if test="#session.guide4.lianxujiangjie==1">
													是
												</s:if>
												<s:else>
													否
												</s:else>
											</td>
											<th class="active">考核是否合格</th>
											<td>
											<s:if test="#session.guide4.hege==0">
													否
												</s:if>
												<s:else>
													是
												</s:else>
											</td>
										</tr>
										<tr>
											<th class="active">从业时间</th>
											<td colspan=3>${guide4.workage }</td>
										</tr>
										<tr>
											<th class="active">证书</th>
											<td colspan=3>${guide4.experice }</td>
										</tr>
										
									</table>
									</div>
									<div class="col-md-1" align="right">
										<a href="../findById2_Guide?index=${guide4.guideid}">
										<button class="btn-info btn_modify" title="修改" value="" >
									
											<span class="glyphicon glyphicon-edit" aria-hidden="true" style="color:#ffffff;">							  			
											</span>						  		
										</button>	
										</a>
								</div>
								</div>
					  </div>
						
					</div>
						

	   	 	</div>
	   	 	<!--main content end-->
				
			</div>	
		<!--row end-->						
		</div>
		    			
	<script type="text/javascript">
		$path="${ctx}";
		$(".btn_modify").click(function(){
			var str="/IntelligentGuide/guideModify/"+this.value;
			window.location.href=str;
		});
		$(".btn_delete").click(function(){
			var str="/IntelligentGuide/guideDelete/"+this.value;
			if(confirm("确认删除吗？")){
				window.location.href=str;
			}
		});
	</script>
</body>
</html>