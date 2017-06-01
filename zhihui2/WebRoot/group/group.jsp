<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<s:if test="#session.lista2==null">
	<c:redirect url="../initgroup"></c:redirect>

</s:if>
<head>
<meta charset="utf-8" />
<title>导游分组</title>
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
		$("#list9").css('display','block');
		
		$("ul.tree li ul li").removeClass("active");
		$("#ok12").addClass("active");
	})
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
		.bgC{
		background-color:red;
		}
		#group1{
		padding-right:0px;
		}
		
		#group3{
		padding-right:0px;
		}
		.panel,.datagrid{
			border-right:1px solid #95B8E7;
		}
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
						<li>导游分组</li>
					</ul>
				</div>


				<!-- 
				搜索页
				 -->
				
				<div class="container-fluid">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							导游分组情况</font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>
					</div>
					
				
					<div style="margin-left:20px;margin-right:20px;">
						  <!-- 选区start -->
						  <form action="../groupdiv" method="post" >
								<s:select name="option" list="#session.lista2" listKey="adid" 
										listValue="areaname" />
									<button type="button" class="btn  btn-primary btn-xs" style="color:#ffffff;margin-left:5px;" onclick="this.form.submit()">
									 <span class="glyphicon glyphicon-ok" style="margin-right:3px;"></span>选择</button>
									 <br>
									 <br><span  style="margin-left:0px;height:18px;ling-height:18px;color:red;font-size:20px;">目前显示:${gpname }</span>
						</form>
							<div class="row" style="margin-top:20px;">
								<div class="col-md-3" style="height:300px;" id="group1">
									<table class="table table-bordered " id="table1">
										<thead>	
											<tr style="background-color:#ffffff">
											<td text-align="left">未分配的导游</td>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="#session.weifenpei2" var="wfp">
											<tr>
												<td>
													${wfp.guidename}
													<a href="../mydivguide?guideid=${wfp.guideid}&groupid=${gpid}"><button style="float:right;background-color:#ffffff;border:0px;color:#428bca">
														
														<span class="glyphicon glyphicon-hand-right" style="line-height:15px;" alt=""></span>
														分配
													</button>	
														</a>
														
												</td>
											</tr>
											</s:iterator>
										</tbody>
									</table>
								</div>
								
								<div class="col-md-3" id="grounp2" style="height:300px;">
									<table class="table table-bordered table-hover" id="table2">
										<thead>	
											<tr style="background-color:#ffffff">
											<td text-align="left">已分配的导游</td>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="#session.myguide" var="mg">
											<tr>
												<td>
													${mg.guidename}
													<a href="../cancelguide?guideid=${mg.guideid}"><button style="float:right;background-color:#ffffff;border:0px;color:#d9534f">
														
														<span class="glyphicon glyphicon-remove" style="line-height:15px;" alt=""></span>
														移除
													</button>	
														</a>
												</td>
											</tr>
											
										</s:iterator>
										</tbody>
									</table>
								</div>
								
								<div class="col-md-6" id="tab1">
								<table id="dg" title="分组情况" class="easyui-datagrid" style="height:300px"
										url="../gshow"
										toolbar="#toolbar" pagination="true"
										rownumbers="true" fitColumns="true" singleSelect="true">
									<thead>
										<tr>
										
											<th field="gname" width="50">
												组</th>
										</tr>
									</thead>
								</table>
								<div id="toolbar">
									<a href="#" class="easyui-linkbutton"  plain="true" onclick="newUser()">
										<span class="glyphicon glyphicon-plus" style="color:green;"></span> 新增组</a>
									<a href="#" class="easyui-linkbutton"  plain="true" onclick="editUser()">
										<span class="glyphicon glyphicon-pencil" style="color:green;"></span> 编辑</a>
									<a href="#" class="easyui-linkbutton"  plain="true" onclick="removeUser()">
										<span class="glyphicon glyphicon-remove" style="color:red;"></span> 删除</a>
								</div>
								
								<div id="dlg" class="easyui-dialog" style="width:400px;height:180px;padding:10px 20px"
										closed="true" buttons="#dlg-buttons">
									<div class="ftitle">分组情况</div>
									<form id="fm" method="post" novalidate>
										<div class="fitem">
										
											<label>组编号</label>
											<input name="gname" class="easyui-validatebox" required="true">
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
									
								</div>
				
								
								<!-- 选族end -->
								
								
							
						

					</div>  
				</div>
			
				<!--row end-->
				
			</div>

	

	
	<!--main content end-->

	
	<!--row end-->
	<script type="text/javascript">
	$(function(){
	   
	    
	    if($("#table1").height() <  $("#group1").height()){//如果表格高度没有达到 div的，隐藏下拉条
	    	
	    	$("#group1").css('overflow-y','none'); 
	    }else{
	    	
	    	$("#group1").css('overflow-y','scroll'); 
	    }
	    
		if($("#table2").height() <  $("#group2").height()){//如果表格高度没有达到 div的，隐藏下拉条
	    	
	    	$("#group2").css('overflow-y','none'); 
	    }else{
	    	
	    	$("#group2").css('overflow-y','scroll'); 
	    }
		
		if($("#table3").height() <  $("#group3").height()){//如果表格高度没有达到 div的，隐藏下拉条
	    	
	    	$("#group3").css('overflow-y','none'); 
	    }else{
	    	
	    	$("#group3").css('overflow-y','scroll'); 
	    }
	    
		if($("#table4").height() <  $("#group4").height()){//如果表格高度没有达到 div的，隐藏下拉条
	
		$("#group4").css('overflow-y','none'); 
		}else{
	
		$("#group4").css('overflow-y','scroll'); 
		}
		
		$("#tab1 .panel-body").width($("#tab1 .panel-header").outerWidth()-2);
		
	});
	function newUser(){
		$('#dlg').dialog('open').dialog('setTitle','新增组');
		$('#fm').form('clear');
		url = '../savegroup';
	}
	function editUser(){
		var row = $('#dg').datagrid('getSelected');
		if (row){
			$('#dlg').dialog('open').dialog('setTitle','编辑');
			$('#fm').form('load',row);
			url = '../updategroup?groupid='+row.ggid;
		}
	}
	function saveUser(){
		$('#fm').form('submit',{
			url: url,
			onSubmit: function(){
				return $(this).form('validate');
			},
			success: function(result){
				var result = eval('('+result+')');
				if (result.success){
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
			$.messager.confirm('删除','确认删除吗?',function(r){
				if (r){
					$.post('../delgroup',{groupid:row.ggid},function(result){
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
		
</body>
</html>