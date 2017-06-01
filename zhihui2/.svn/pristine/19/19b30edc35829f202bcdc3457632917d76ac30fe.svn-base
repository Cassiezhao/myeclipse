<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>蓝牙设备</title>
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
<link rel="stylesheet" href="../easyui/themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="../easyui/themes/icon.css" type="text/css"></link>
	<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','none');
		$("#list9").css('display','none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu12").addClass("active");
		
		$("#tab1  .panel-body").width($(".panel-header").outerWidth()-2);
	
	});

	
	
</script>
<style type="text/css">
	.panel-body{padding:0px;}
	#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
		.panel,.datagrid{
			border-right:1px solid #95B8E7;
		}
		.datagrid-pager{margin:auto;}
		.panel-body{text-align:center;}
		.pagination{margin-left:auto;}
</style>
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
						<li>蓝牙设备</li>
					</ul>
				</div>
				<div class="container-fluid">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							蓝牙设备信息 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>
					</div>
					<div style="margin-left:20px;margin-right:20px;" id="tab1">

					<!-- easyui测试start -->
						<table id="dg" title="蓝牙信息表" class="easyui-datagrid" style="height:450px"
								url="../findAllBlue"
								toolbar="#toolbar" pagination="true"
								rownumbers="true" fitColumns="true" singleSelect="true">
							<thead>
								<tr>
									<th field="bluenum" width="50">蓝牙编号</th>
									<th field="jingdu" width="50">经度</th>
									<th field="weidu" width="50">纬度</th>
									
								</tr>
							</thead>
						</table>
						<div id="toolbar">
							<a href="#" class="easyui-linkbutton"  plain="true" onclick="newUser()">
							<span class="glyphicon glyphicon-plus" style="color:green;"></span>新增蓝牙</a>
							<a href="#" class="easyui-linkbutton"  plain="true" onclick="editUser()">
							<span class="glyphicon glyphicon-pencil" style="color:green;"></span>编辑</a>
							<a href="#" class="easyui-linkbutton"  plain="true" onclick="removeUser()">
							<span class="glyphicon glyphicon-remove" style="color:red;"></span>删除</a>
						</div>
						
						<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
								closed="true" buttons="#dlg-buttons">
							<div class="ftitle">新增蓝牙</div>
							<form id="fm" method="post" novalidate>
								<div class="fitem">
									<label>蓝牙编号:</label>
									<input name="bluenum" class="easyui-validatebox" required="true">
								</div>
								<div class="fitem">
									<label>经度:</label>
									<input name="jingdu" class="easyui-validatebox" required="true">
								</div>
								<div class="fitem">
									<label>纬度:</label>
									<input name="weidu" class="easyui-validatebox" required="true">
								</div>
								<div >
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
						
						
					<!-- easyui测试start -->
				</div>  
				</div>
			
				<!--row end-->
				
			</div>


	<!--main content end-->

	
	<!--row end-->
	
	<!-- easyuistart -->
	<script>
	var myurl;
	$(function(){
		$("#dg").width($(".page-header").width);
		
	});
	
	function newUser(){
		$('#dlg').dialog('open').dialog('setTitle','新增蓝牙');
		$('#fm').form('clear');
		myurl = '../saveblue';
	}
	function editUser(){
		var row = $('#dg').datagrid('getSelected');
		if (row){
			$('#dlg').dialog('open').dialog('setTitle','编辑');
			$('#fm').form('load',row);
			
			myurl = '../updateblue?blueid='+row.blueid;
			
		}
	}
	function saveUser(){
		$('#fm').form('submit',{
			url: myurl,
			onSubmit: function(){
				return $(this).form('validate');
			},
			success: function(result){
				var result = eval('('+result+')');
				if (result.success==1){
					$('#dlg').dialog('close');		// close the dialog
					$('#dg').datagrid('reload');	// reload the user data
				} else {
					$.messager.show({
						title: 'Error',
						msg: result.msg
					});
				}
			}
		});
	}
	function removeUser(){
		var row = $('#dg').datagrid('getSelected');
		
		if (row){
			$.messager.confirm('删除蓝牙','确认删除吗?',function(r){
				if (r){
					$.post('../delBlue',{blueid:row.blueid},function(result){
						if (result.success){
							$('#dg').datagrid('reload');	// reload the user data
						} else {
							$.messager.show({	// show error message
								title: 'Error',
								msg: result.msg
							});
						}
					},'json');
				}
			});
		}
	}	
	</script>
	
	
	<!-- end -->
	
	
</body>
</html>