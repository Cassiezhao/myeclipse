	<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	
	<s:if test="#session.change==1">
	<div class="alert alert-success alert-dismissable">
	<button type="button" class="close" data-dismiss="alert"
			aria-hidden="true">
		&times;
	</button>
	请修改初始密码
	<button class="btn btn-primary btn-lg" data-toggle="modal"  data-target="#myModal">
	修改密码
</button>
	
</div>
	</s:if>
 
	
<head>	
	<meta charset="utf-8"/>
    <title>主页</title>
		<script type="text/javascript" src="assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="assets/app/css/common.css" >
		
	<script type="text/javascript" src="assets/app/js/common.js"></script>
	
	
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<link rel="stylesheet" href="easyui/themes/default/easyui.css"
	type="text/css"></link>
	<script type="text/javascript"
	src="easyui/locale/easyui-lang-zh_CN.js"></script>
	
	
	
</head>	

<body>	
<form method="post"  action="modify_User" >   
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改密码</h4>
            </div>
            <div class="modal-body">
            <div class="modal-body">
     <label for="log_passwd">
      <span>新密码:</span>
      <input id="log_passwd" name="newpassword" type="password" placeholder="输入您的新密码">
      <input type="hidden" name="userid" value="${ nuser.userid}"/>
     </label>
     
    </div></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" onclick="this.form.submit()" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>
<!-- end -->
	<jsp:include page="common.jsp"/>
				<!--slide bar end-->
				
				<!--main content start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff">
					<div class="main-content-title" >					
						<ul class="breadcrumb"  style="border-radius:0 0 0 0">
							<li><span class="glyphicon glyphicon-home"></span><a href="login.jsp" style="padding-left:10px;">首页</a></li>			  
						 	<li>登录信息</li>
						</ul>
					</div>					
					<div id="main-content-content" class="row main-content-content page-content" style="height:200px;">
							<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;style="height:200px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								首页
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>登录信息
							</font>
							<font style="float:right;margin-top:10px;font-size:12px;">
								<a  onclick="changePass()">修改密码</a>
							</font>
									
						</div>
							<div class="col-md-12" style="line-height:200px">
								<div class="image col-md-4" style="height:200px">
									<image src="assets/app/images/photo-1.jpg" class="img-thumbnail col-md-offset-6" style="height:150px;width:150px;">
										
									</image>
								</div>
								<div class="userinfo col-md-6" style="height:200px;">
									<table class="table">
										<tr style="background-color:#408080;color:white;">
											<td style="text-align:left;" colspan="2">用户信息</td>
										</tr>
										<tr id="user.name" >
											<td style="background-color:#787b85;color:white;">用户姓名</td>
											<td>${nuser.username }</td>
										</tr>
										<tr id="user.id">
											<td style="background-color:#787b85;color:white;">用户账号</td>
											<td>${nuser.count}</td>
										</tr>
										<tr id="user.loginTime">
											<td style="background-color:#787b85;color:white;">登录时间</td>
											<td>${nuser.userlogTime}</td>
										</tr>
									</table>
									
								</div>
							</div>
					</div>

	   	 	</div>
	   	 	<!--main content end-->
	   	 	
	   	 	
	   	 	<div id="dlg" class="easyui-dialog" style="width:300px;height:120px;padding:10px 20px"
								closed="true" buttons="#dlg-buttons">
							<form id="mainform" method="post" novalidate>
								<div class="fitem">
									<label>修改密码:</label>
									<input name="mainnewpassword" class="easyui-validatebox" required="true">
								</div >
								<div style="margin-top:10px;">
								   <button type="button" class="btn  btn-primary btn-xs" 
									style="color:#ffffff;margin-left:5px;" onclick="saveUser()">
									 <span class="glyphicon glyphicon-ok" style="margin-right:3px;"></span>确认</button>
									 
									<button type="button" class="btn  btn-default btn-xs" 
									 style="color:#000000;margin-left:5px;"
									 onclick="javascript:$('#dlg').dialog('close')">
									 <span class="glyphicon glyphicon-remove" style="margin-right:3px;"></span>取消</button>
								</div>
							</form>
						</div>
	   	 	
	   	 	
	   	 	
	   	 	

		</div>	
		<!--row end-->						
		</div>
		 <script type="text/javascript">
		 	function changePass(){
		 		
		 		$('#dlg').dialog('open').dialog('setTitle','修改密码');
		 	}
		 	
		 	function	saveUser(){
		 		$.ajax({
	                cache: true,
	                type: "POST",
	                url:"modifymainpassword_User",
	                data:$('#mainform').serialize(),// 你的formid
	                async: false,
	                error: function(data) {
	                	alert("数据有误");
	                },
	                success: function(data) {
	                	data = eval("(" + data + ")");
	                	if(data.success==0){
	                		alert("修改失败!");
	                	}else if(data.success==1){
	                		alert("修改成功!");
	                		
	                	}
	                	$('#dlg').dialog('close');
	                }
	            });
		 	}
		 </script>
	

	
	
</body>

   


   
</html>
