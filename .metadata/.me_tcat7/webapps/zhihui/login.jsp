<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>

<!-- CSS -->

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/app/css/Form-elements.css">
<link rel="stylesheet" href="assets/app/css/Login.css">
<link rel="stylesheet" href="assets/css/bootstrap-theme.css">

<c:if test="${sessionScope.nuser!=null}">
	<c:redirect url="index.jsp"></c:redirect>
</c:if>

<script type="text/javascript" src="assets/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="assets/app/js/common.js"></script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>


<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-193" data-genuitec-path="/zhihui2/WebRoot/login.jsp">

	<!-- Top content -->
	<div class="top-content" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-193" data-genuitec-path="/zhihui2/WebRoot/login.jsp">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>智慧导游管理系统</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>欢迎登录</h3>
								<p>请输入您的用户名和密码:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form action="check_User" role="form" method="post" class="login-form">
								<div class="form-group">
									<label class="sr-only" for="username">Username</label> <input
										type="text" name="user.count" placeholder="Username..."
										class="form-username form-control" id="form-username">
								</div>
								<div class="form-group">
									<label class="sr-only" for="password">Password</label>
									 <input
										type="password" name="user.password" 
										class="form-password form-control" id="form-password" placeholder="Password...">
								</div>
								<div class="row">
									<div class="col-md-6">
										<button  id="btn_login"  class="btn">登录</button>
									</div>
									
									<div class="col-md-6">
										<button type="button" id="btn_cancel" class="btn">取消</button>
									</div>
									<div class="col-md-6">
									</div>
								</div>
							</form>

						</div>
						<div> <font color="red">${err }</font></div>
					</div>
				</div>

			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/app/js/jquery.backstretch.min.js"></script>
	<script src="assets/app/js/scripts.js"></script>


</body>

</html>