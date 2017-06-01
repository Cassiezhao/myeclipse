<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>导游机录入</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideInfo_style.css" />





<script type="text/javascript">
	$(function() {
		$("ul.tree li ul li").removeClass("active");
		$("#ok3").addClass("active");
	})
</script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link><script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script><script
	type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>

<body>
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->


	<!-- main start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a></li>
				<li>导游机录入</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					导游机录入 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>
					详情 </font>

			</div>
			<!-- /.page-header -->

			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">
						<div class="tab-content" style="">

							<form action="../save_Guidem" id="form1">
								<table style="margin:auto">
									<tr>
										<td><label for="guideMachineNumber" class="lableposition">导游机编号</label>
										</td>
										<td style="padding-left:6px;"><input name="guidenum"
											type="text" class="easyui-validatebox" placeholder="导游机编号"
											id="guideMachineNumber" validtype="minLength[1]"
											style="border-radius:0 0 0 0;" required="true"
											missingMessage="不能为空" />
										</td>
									</tr>
									<tr>
										<td><label for="guideMachineNumber" class="lableposition">导游机电话</label>
										</td>
										<td style="padding-left:6px;"><input name="guidemtel"
											type="text" class="easyui-validatebox" validtype="mobile"
											required="true" missingMessage="不能为空" placeholder="导游机电话"
											id="guideMachineTel" style="border-radius:0 0 0 0;" />
										</td>
									</tr>
									<tr>
										<td colspan="2" align="center" style="padding-top:15px;">
											<button class="btn btn-primary btn-sm btn_submit"
												type="button" id="bt1" onclick="sub()">
												<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
												提交
											</button>
											<button class="btn btn-primary btn-sm btn_reset"
												type="button">
												<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
												重置
											</button>
										</td>

									</tr>

								</table>
							</form>

						</div>
						<!-- table end -->
					</div>
					<!--col 12 end-->
				</div>
			</div>
			<!--row end-->

		</div>
	</div>

	<script type="text/javascript">
	
	
	
	
		function sub() {
			if ($.trim($("#guideMachineNumber").val()) == ""
					|| $.trim($("#guideMachineTel").val()) == "") {

			} else {
				$.ajax({
					url : '../save_Guidem',
					cathe : false,
					type : "POST",
					data : $('#form1').serialize(),
					dataType : 'json',
					success : function(data) {
							alert("添加完成");
							$("input[name='guidenum']").val("").focus();
							$("input[name='guidemtel']").val("");
						
					}
				});
			}
		}

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
		});
		$('#guideMachineTel').validatebox(options);
	</script>
</body>
</html>