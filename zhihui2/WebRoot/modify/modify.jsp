<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>系统设置</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="../assets/app/css/common.css">
<link rel="stylesheet"
	href="../assets/app/css/HistoricalOrder_style.css" />
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<script type="text/javascript" src="../assets/app/js/search.js"></script>
<link rel="stylesheet" href="../assets/app/css/search.css" />
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link><script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script><script
	type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#list2").css('display', 'none');
		$("#list3").css('display', 'none');
		$("#list6").css('display', 'none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu8").addClass("active");

		$('input').each(function() {
			var default_value = this.value;
			$(this).focus(function() {
				if (this.value == default_value) {
					this.value = '';
				}
			});
			$(this).blur(function() {
				if (this.value == '') {
					this.value = default_value;
				}
			});
		});

	});

	function sub() {

		var text1 = parseInt($("#text1").val().replace(/[^0-9]/ig, ""));
		var text2 = parseInt($("#text2").val().replace(/[^0-9]/ig, ""));
		var text3 = parseInt($("#text3").val().replace(/[^0-9]/ig, ""));
		var Score = parseInt($("#eScore").val().replace(/[^0-9]/ig, ""));

		var text = text1 + text2 + text3;
		if (text > Score) {
			text = Score;
		}

		var tabval2 = null;
		$("#table2 input[type='text']").each(function() {
			tabval2 += parseInt($(this).val().replace(/[^0-9]/ig, ""));
		});
		var cut = parseInt($("#cut").val().replace(/[^0-9]/ig, ""));
		var tabval = null;
		tabval = text + tabval2 - cut;

		if (tabval > 100) {
			alert("总评分超过100分，请重新填写");
			return false;
		} else if (tabval < 100) {
			alert("总评分不足100分，请重新填写");
			return false;
		} else if (tabval == 100) {

			if (confirm("您确认要提交吗？")) {
				$("#myform").submit();
				alert("提交成功");
				/* $(':input', '#myform').not(':button, :submit, :reset, :hidden')
					.val(''); */
			}

		}else{
			alert("请输入正确参数");
			return false;
		}
	}
</script>

</head>

<body>
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->

	<!--main content start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
		<div class="main-content-title">

			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a>
				</li>
				<li>系统设置</li>
			</ul>

		</div>

		<div class="page-content">
			<div class="page-header"
				style="margin-top:10px;margin-left:20px;margin-right:20px;">
				<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
					系统设置 </font> <font style="color:#8089a0;font-size:14px"> <span
					class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>修改
				</font>

			</div>

			<!-- /.page-header -->
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-1"></div>
					<div class="col-md-10">
						<div class="table-responsive">
							<form action="../update_ChangeScore" method="post" id="myform">
								<table>
									<tr>
										<th colspan="4">基本信息</th>
									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">学历水平 </label></td>
										<td class="col-md-3"><input type="hidden" value="1" 
											name="sys.id" /> <input type="text" name="sys.xueli1"
											placeholder="一档${syso.xueli1 }分" class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字"
											id="text1"></td>
										<td class="col-md-3"><input type="text" name="sys.xueli2"
											placeholder="二档${syso.xueli2 }分" class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字">
										</td>
										<td class="col-md-3"><input type="text" name="sys.xueli3"
											placeholder="三档${syso.xueli3 }分" class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字">
										</td>
									</tr>
									<tr>

									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">普通话水平 </label></td>
										<td class="col-md-3"><input type="text"
											name="sys.putong1" placeholder="一档${syso.putong1}分"
											class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字" id="text2"></td>
										<td class="col-md-3"><input type="text"
											name="sys.putong2" placeholder="二档${syso.putong2}分"
											class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字"></td>
										<td class="col-md-3"><input type="text"
											name="sys.putong3" placeholder="三档${syso.putong3 }分"
											class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字"></td>
									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">加分项 </label></td>
										<td class="col-md-3"><input type="text" name="sys.yuyan"
											placeholder="语言加${syso.yuyan }分" class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字">
										</td>
										<td class="col-md-3"><input type="text"
											name="sys.zhengshu" placeholder="证书加${syso.zhengshu }分"
											class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字"></td>
										<td class="col-md-3"><input type="text"
											name="sys.yuyanzuigao" placeholder="总分${syso.yuyanzuigao }分"
											class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字"id="text3"></td>
									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">基础信息总分 </label></td>
										<td class="col-md-3"><input type="text"
											name="sys.jibenzuigao"
											placeholder="基础信息总共${syso.jibenzuigao }分"
											class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字" id="eScore"></td>
										<td class="col-md-3"></td>
										<td class="col-md-3"></td>

									</tr>

								</table>
								<table id="table2">
									<tr>
										<th colspan="4">设备信息</th>
									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">位置信息 </label></td>

										<td class="col-md-3"><input type="text"
											name="sys.weizhixinxi" placeholder="${syso.weizhixinxi}分"
											class="form-control easyui-numberbox"  required="true"
										missingMessage="必须为数字"></td>
										<!--  -->
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;float:right">
												<div style="text-align:center">上线时间</div> </label></td>
										<td class="col-md-3"><input type="text"
											name="sys.shangxianshijian"
											placeholder="${syso.shangxianshijian}分" class="form-control easyui-numberbox"  required="true">
										</td>
									</tr>
									<tr>

									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">上线地点 </label></td>
										<td class="col-md-3"><input type="text" name="sys.sxdd"
											placeholder="${syso.sxdd }分" class="form-control easyui-numberbox"  required="true"></td>
										<td class="col-md-3"><label class="control-label"
											style="line-height:34px;float:right">上线次数 </label></td>
										<td class="col-md-3"><input type="text" name="sys.sxcs"
											placeholder="${syso.sxcs}分" class="form-control easyui-numberbox"  required="true"></td>
									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">抽听讲解 </label></td>
										<td class="col-md-3"><input type="text" name="sys.ctjj"
											placeholder="一次不合格扣${syso.ctjj }分" class="form-control easyui-numberbox"  required="true"
											id="cut"></td>
										<td class="col-md-3"><label class="control-label"
											style="line-height:34px;float:right">游客评价 </label></td>
										<td class="col-md-3"><input type="text" name="sys.ykpj"
											placeholder="${syso.ykpj }分" class="form-control easyui-numberbox"  required="true"></td>
									</tr>
								</table>

								<table id="tab">
									<tr>
										<th colspan="4">景区经纬度 <font
											style="color:#8089a0;font-size:10px;font-family:SimSun">
												(请查询该景区地图最上边、最下边、最左边、最右边的经纬度填入下表) </font></th>
									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">上边经纬度 </label></td>

										<td class="col-md-3"><input type="text" name="sys.jws"
											placeholder="${syso.jws}" class="form-control"></td>
										<!--  -->
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;float:right">
												<div style="text-align:center">下边经纬度</div> </label></td>
										<td class="col-md-3"><input type="text" name="sys.jwx"
											placeholder="${syso.jwx }" class="form-control"></td>
									</tr>
									<tr>

									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">左边经纬度 </label></td>
										<td class="col-md-3"><input type="text" name="sys.jwz"
											placeholder="${syso.jwz }" class="form-control"></td>
										<td class="col-md-3"><label class="control-label"
											style="line-height:34px;float:right">右边经纬度 </label></td>
										<td class="col-md-3"><input type="text" name="sys.jwy"
											placeholder="${syso.jwy}" class="form-control"></td>
									</tr>


								</table>
								<div class="buts" style="margin-top:10px;">
									<button type="button" class="btn btn-warning btn-sm"
										style="float:right">取消</button>
									<button type="button" onclick="sub()"
										class="btn btn-primary btn-sm"
										style="float:right;margin-right:5px;" id="ok">确定</button>
								</div>

								<table>
									<tr>
										<!-- th colspan="4">后台电话
												</th> -->
									</tr>
									<tr>
										<td class="col-md-2"><label class="control-label"
											style="line-height:34px;">后台电话 </label></td>
										<td class="col-md-5"><input type="text" name="sys.tel"
											value="${syso.tel }" class="form-control" id="newtelnum">
										</td>
										<td class="col-md-3">
											<button type="button" onclick="telchange()"
												class="btn btn-warning btn-sm" style="float:right">修改电话</button>
										</td>
										<td class="col-md-2"></td>
									</tr>
								</table>

							</form>

						</div>

					</div>
					<div class="col-md-1"></div>
				</div>


			</div>
			<!-- row end-->
		</div>
	</div>
	</div>
	<script type="text/javascript">
		$(function() {
			var tabwidth = $("#tab").width();
			var btheight = $("#ok").outerHeight(true);

			$(".buts").width(tabwidth);
			$(".buts").height(btheight);

		});
		function telchange() {
			var newtel = $("#newtelnum").val();
			//window.location.href="../telchange_ChangeScore?newtel="+newtel;

			$.ajax({
				cache : true,
				type : "POST",
				url : "../telchange_ChangeScore",
				data : {
					"newtel" : newtel
				},// 你的formid
				async : false,
				error : function(request) {
					alert("请求失败");
				},
				success : function(data) {
					alert("修改电话成功");
				}
			});

		}
		/* 		function mypringt(){
		 location.href='../pringtf_ChangeScore?guidenum='+myurl; 
		 } */
	</script>

</body>

</html>