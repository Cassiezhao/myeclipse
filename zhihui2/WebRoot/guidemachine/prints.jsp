<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta content="text/html;charset=utf-8" >
	<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript">
	function btnPrintClick(){
		var currentBtn = document.getElementById("js_print");
			
		
			currentBtn.style.display = "none" 
			$("input[type=text]").each(function(){
				
				$(this).css("border","0");
		
				
			});
		
        	window.print();  
    }  
		
	</script>
	<style type="text/css">
		table{ border-top:0; border-collapse:collapse;width:210mm ;height:140mm;}
		table tr td{ border-top:#000000 solid 1px;border-left:#000000 solid 1px;border-right:#00000 solid 1px;text-align:center; }
</style>
		
</head>
<body>
    <div id="stamp1">
			<button id="js_print" onclick="btnPrintClick()">打印</button>
			<table>
				<tr><td  colspan='9' style="text-align:center;border-top-style:none;border-left-style:none;border-right-style:0">秦始皇兵马俑旅行社导游派遣单</td></tr>
				<tr><td colspan='9'style="text-align:left;border-top:0;border-top-style:none;border-left-style:none;border-right-style:none">
				<input type="button" style="width:10%;background-color:#ffffff;border:0" value="${dib.year}" >年
				<input type="text" style="width:10%;background-color:#ffffff;border:0" value="${dib.month }">月
				<input type="text" style="width:10%;background-color:#ffffff;border:0" value="${dib.day }">日</td></tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;">导游姓名</td>
					<td style="width:30%" > 
						<input type="button" style="width:80%;background-color:#ffffff;border:0" value="${dib.guidename }">
					</td>
					<td style="width:20%">工号</td>
					<td style="width:30%;" colspan='6'>
						<input type="button" style="width:80%;background-color:#ffffff;border:0"  value="${dib.guidenum }">
					</td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;border:1px #ff000 solid">游客人数</td>
					<td style="width:30%"> 
						<input type="button" style="width:80%;background-color:#ffffff;border:0" value="${dib.youke }">
					</td>
					<td style="width:20%">游客来向</td>
					<td style="width:30%" colspan='6'>
						<input type="text" style="width:90%;">
					</td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;border:1px #ff000 solid">讲解时间</td>
					<td style="width:80%" colspan='8'><input type="text" style="width:15%">
					时
					<input type="text" style="width:15%">分
					至<input type="text" style="width:15%">
					时
					<input type="text" style="width:15%">
					分 </td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;border:1px #ff000 solid" rowspan='2'>金额</td>
					<td style="width:50%;border:1px #ff000 solid;border-right-style:none;" rowspan='2' colspan='2'>
						<input type="text" style="width:10%">伯
						<input type="text" style="width:10%">拾
						<input type="text" style="width:10%">元
						<input type="text" style="width:10%">角
						<input type="text" style="width:10%">分
					</td>
						<td style="wdith:5%;border-bottom-style:none;border-left-style:none;">
							
						</td>
						<td style="wdith:5%">伯</td>
						<td style="wdith:5%">拾</td>
						<td style="wdith:5%">元</td>
						<td style="wdith:5%">角</td>
						<td style="wdith:5%">分</td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					
						<td style="border-top-style:none;border-bottom-style:none;border-left-style:none;"></td>
					<td >
					 <input type="text" style="width:50%">
					</td>
					<td style="text-align:center">
						<input type="text" style="width:50%"></td>
					<td>
						<input type="text" style="width:50%"></td>
					<td >
						<input type="text" style="width:50%"></td>
					<td >
						<input type="text" style="width:50%"></td>
				</tr>
				
				
				<tr><td colspan='9'style="text-align:left;border-left-style:none;border-right-style:none;">主管 ： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  派遣员：</td></tr>
				
			</table>
	</div>
	
	<div id="stamp1">
			<table>
				<tr><td  colspan='9' style="text-align:center;border-top-style:none;border-left-style:none;border-right-style:0">秦始皇兵马俑旅行社导游派遣单</td></tr>
				<tr><td colspan='9'style="text-align:left;border-top:0;border-top-style:none;border-left-style:none;border-right-style:none">
				<input type="button" style="width:10%;background-color:#ffffff;border:0" value="${dib.year}" >年
				<input type="text" style="width:10%;background-color:#ffffff;border:0" value="${dib.month }">月
				<input type="text" style="width:10%;background-color:#ffffff;border:0" value="${dib.day }">日</td></tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;">导游姓名</td>
					<td style="width:30%" > 
						<input type="button" style="width:80%;background-color:#ffffff;border:0" value="${dib.guidename }">
					</td>
					<td style="width:20%">工号</td>
					<td style="width:30%;" colspan='6'>
						<input type="button" style="width:80%;background-color:#ffffff;border:0"  value="${dib.guidenum }">
					</td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;border:1px #ff000 solid">游客人数</td>
					<td style="width:30%"> 
						<input type="button" style="width:80%;background-color:#ffffff;border:0" value="${dib.youke }">
					</td>
					<td style="width:20%">游客来向</td>
					<td style="width:30%" colspan='6'>
						<input type="text" style="width:90%;">
					</td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;border:1px #ff000 solid">讲解时间</td>
					<td style="width:80%" colspan='8'><input type="text" style="width:15%">
					时
					<input type="text" style="width:15%">分
					至<input type="text" style="width:15%">
					时
					<input type="text" style="width:15%">
					分 </td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					<td style="width:20%;border:1px #ff000 solid" rowspan='2'>金额</td>
					<td style="width:50%;border:1px #ff000 solid;border-right-style:none;" rowspan='2' colspan='2'>
						<input type="text" style="width:10%">伯
						<input type="text" style="width:10%">拾
						<input type="text" style="width:10%">元
						<input type="text" style="width:10%">角
						<input type="text" style="width:10%">分
					</td>
						<td style="wdith:5%;border-bottom-style:none;border-left-style:none;">
							
						</td>
						<td style="wdith:5%">伯</td>
						<td style="wdith:5%">拾</td>
						<td style="wdith:5%">元</td>
						<td style="wdith:5%">角</td>
						<td style="wdith:5%">分</td>
				</tr>
				<tr style="border-right:#000000 solid 1px;">
					
						<td style="border-top-style:none;border-bottom-style:none;border-left-style:none;"></td>
					<td >
					 <input type="text" style="width:50%">
					</td>
					<td style="text-align:center">
						<input type="text" style="width:50%"></td>
					<td>
						<input type="text" style="width:50%"></td>
					<td >
						<input type="text" style="width:50%"></td>
					<td >
						<input type="text" style="width:50%"></td>
				</tr>
				
				
				<tr><td colspan='9'style="text-align:left;border-left-style:none;border-right-style:none;">主管 ： &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  派遣员：</td></tr>
				
			</table>
	</div>
	
</body>
</html>