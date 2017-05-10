<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Insert title here</title>

  </head>
  
  <body>
    <form action="product-save.action" method="post">
		
		ProductName: <input type="text" name="productName"/>
		<br><br>

		ProductDesc: <input type="text" name="productDesc"/>
		<br><br>
		
		ProductPrice: <input type="text" name="productPrice" />
		<br><br>
		
		<input type="submit" value="Submit"/>
		<br><br>
	
	</form>

  </body>
</html>
