<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"    %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<META http-equiv=Refresh content="3; url=index.jsp">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <STYLE type=text/css>BODY {
	BACKGROUND: #fff; MARGIN: 80px auto; FONT: 14px/150% Verdana, Georgia, Sans-Serif; COLOR: #000; TEXT-ALIGN: center
}
A:link {
	COLOR: #2c4c78; TEXT-DECORATION: none
}
A:visited {
	COLOR: #2c4c78; TEXT-DECORATION: none
}
A:hover {
	COLOR: #2c4c78; TEXT-DECORATION: none
}
A:active {
	COLOR: #2c4c78; TEXT-DECORATION: none
}
H1 {
	PADDING-RIGHT: 4px; PADDING-LEFT: 4px; FONT-SIZE: 14px; BACKGROUND: #eee; PADDING-BOTTOM: 4px; MARGIN: 0px; PADDING-TOP: 4px; BORDER-BOTTOM: #84b0c7 1px solid
}
DIV {
	BORDER-RIGHT: #84b0c7 1px solid; BORDER-TOP: #84b0c7 1px solid; BACKGROUND: #e5eef5; MARGIN: 0px auto; BORDER-LEFT: #84b0c7 1px solid; WIDTH: 500px; BORDER-BOTTOM: #84b0c7 1px solid
}
P {
	PADDING-RIGHT: 15px; PADDING-LEFT: 15px; PADDING-BOTTOM: 15px; MARGIN: 0px; PADDING-TOP: 15px
}
</STYLE>
  <body>
	<jsp:include page="common.jsp"/>
	<DIV>
<H1>提示：您访问的页面已经更名或迁移 :)</H1>
<P>请登陆<A href="index.jsp">智慧导游管理系统首页</A>重新搜索你需要的资源，3秒后自动返回首页</P>
</DIV>
	
  </body>
</html>
