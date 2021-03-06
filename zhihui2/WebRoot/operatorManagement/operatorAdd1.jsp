<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>	
	<meta charset="utf-8"/>
    <title>操作人员录入</title>
		<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="../assets/app/css/common.css" >
		<script type="text/javascript" src="../assets/app/js/common.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css"/>
		
		<script type="text/javascript" src="../assets/app/js/search.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/search.css" />	
		<script src="~/Content/bootstrapValidator/js/bootstrapValidator.min.js"></script>
    <link href="~/Content/bootstrapValidator/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link><link rel="stylesheet"
	href="../easyui/themes/icon.css" type="text/css"></link>
	<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','none');
		$("#list6").css('display','block');
		$("ul.tree li ul li").removeClass("active");
		$("#ok9").addClass("active");
		
	})
</script>
    
</head>	

<body>	
	<jsp:include page="../common2.jsp"/>
				<!--slide bar end-->
				
				<!--main content start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
					<div class="main-content-title" >
												
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="../index.jsp" style="padding-left:10px;">首页</a></li>			  			  
							<li>
								操作员信息录入
							</li>
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								人员录入
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>
									填写信息
							</font>
							
						</div>
						<!-- /.page-header -->
						
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-3"></div>
					<div class="col-md-6">			
						<div class="tab-content" style="">
													
							<form id="myform" action="../save_User" method="post">					   		
							      	<table style="margin:auto" id="tab">
										<tr style="height:43px;">
						    				<td><label for="guideMachineNumber" class="lableposition">姓名</label></td>
						    				<td><input  type="text" class="form-control" 
											 id="guideMachineNumber" style="border-radius:0 0 0 0;" name="user.username"/> </td>
						    			</tr>
										<tr style="height:43px;">
						    				<td><label for="companyNumber" class="lableposition">性别</label></td>
						    				<td>
												<input type="radio"  value="男" id="male" name="user.sex" checked="checked" style="margin-left:60px"/>男
						   				     	<input type="radio"  value="女" id="female" name="user.sex" style="margin-left:50px" />女
											</td>
						    			</tr>	
						    			
						    			<tr style="height:43px;">
						    				<td style="padding-right:70px;"><label for="guideName" class="lableposition">联系方式</label></td>
						    				<td style="width:270px"><input   type="text" class="form-control easyui-validatebox"  id="guideName" 
						    				validtype="mobile" required="true" missingMessage="必须为手机号且不为空" style="border-radius:0 0 0 0;"
						    				name="user.tel"
						    				/> </td>
						    			</tr>	
						    			
						    			
						    			<tr style="height:43px;">
						    				<td><label for="guestMachineNumber1" class="lableposition">账号</label></td>
						    				<td><input type="text" class="form-control easyui-validatebox"  id="guestMachineNumber1" style="border-radius:0 0 0 0;"
						    				name="user.count" required="true" 
						    				/> </td>
						    			</tr>
						    			<tr style="height:43px;">
						    				<td><label for="guestMachineNumber1" class="lableposition" style="color: red">${exit2}</label></td>
						    			</tr>
						    			
						    			<tr style="height:48px;">
						    			<td colspan="2" style="text-align:right" > 
						      			<button class="btn btn-primary btn-sm btn_reset" type="button" style="float:right;">
						   		      	<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						   		      	重置
						   		      </button>
						      		
						   		      <button id="ok" class="btn btn-primary btn-sm btn_submit" type="button" onclick="this.form.submit()" style="float:right;margin-right:5px;">
						   		      	<span class="glyphicon glyphicon-ok" aria-hidden="true" ></span>
						   		      	提交
						   		      </button>
									  
						    		</td>
						    		</tr>
							      	</table>
						      								
						     </form> 
							
						</div>
						<!-- table end -->
					</div>
					<div class="col-md-3"></div>
					<!--col 12 end-->
				</div>
			</div>	
		<!--row end-->						
		
		</div>
	</div>
		<!--row end-->						
		</div>
	</div >
	
	

	
	
	<script type="text/javascript" src="assets/app/js/common.js"></script>
	<script type="text/javascript">
	$(function(){
		
		var tabwidth = $("#tab").outerWidth(true); 
	    var btheight =  $("#ok").outerHeight(true);   
		
		  //$("#buts").width(tabwidth);
		 // $("#buts").height(btheight);
		
	});
	
	$.extend($.fn.validatebox.defaults.rules, {
		//验证汉子  
		CHS : {
			validator : function(value) {
				return /^[\u0391-\uFFE5]+$/.test(value);
			},
			message : '只能输入汉字'
		},
		//移动手机号码验证  
		mobile : {//value值为文本框中的值  
			validator : function(value) {
				var reg = /^1[3|4|5|8|9]\d{9}$/;
				return reg.test(value);
			},
			message : '输入手机号码格式不准确.'
		},
		idCode:{
				validator:function(value,param){
					return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(value);
				},
				message: '请输入正确的身份证号'
			},
	});
	
	/*function submitForm() {
		$('#myform').form('submit', {
			onSubmit : function() {
			
				return 	$(this).form('enableValidation').form('validate');
			}

		});
		$(':input', '#myform').not(':button, :submit, :reset, :hidden')
				.val('');
		location.reload();
	}*/
	</script>
</body>

</html>
