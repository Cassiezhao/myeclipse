<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>新增导游</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />

<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>


<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#list2").css('display', 'none');
		$("#list3").css('display', 'block');

		$("ul.tree li ul li").removeClass("active");
		$("#ok6").addClass("active");
	})
</script>
</head>

<body>
	<jsp:include page="../common2.jsp" />
	<!--slide bar end-->

	<!--main content start-->
	<div id="main-content" class="main-content col-md-10"
		style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff">
		<div class="main-content-title">
			<ul class="breadcrumb">
				<li><span class="glyphicon glyphicon-home"></span><a
					href="../index.jsp" style="padding-left:10px;">首页</a></li>

				<li>新增导游</li>
			</ul>
		</div>

		<div class="container-fluid">

			<div>
				<div class="page-header"
					style="margin-top:10px;margin-left:20px;margin-right:20px;">
					<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
						新增导游 </font> <font style="color:#8089a0;font-size:14px"> <span
						class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>请填写导游信息
					</font>
				</div>
				<div class="col-md-3"></div>
				<div class="col-md-8">
					<form id="guideModifySaveForm" action="../save_Guide" method="post">
						<table>
							<tr>
								<td style="padding-right:20px;"><label
									class="lableposition">姓名</label></td>
								<td style="width:170px"><input type="text"
									name="guide.guidename" class="easyui-validatebox form-control "
									required="true" missingMessage="不能为空"
									style="border-radius:0 0 0 0;" /></td>
								<td style="padding-left:45px"><label class="lableposition">性
										别</label></td>
								<td style=""><input type="radio" value="男" id="male"
									name="guide.gsex" style="margin-left:30px" checked="checked" />男
									<input name="guide.gsex" type="radio" value="女" id="female"
									style="margin-left:20px" />女</td>

							</tr>

							<tr style="">
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition" >身份证号</label></td>
								<td style="width:170px;padding-top:15px"><input
									name="guide.idcard" type="text"
									class="easyui-validatebox form-control " required="true"
									validtype="idCode" missingMessage="不能为空"
									style="border-radius:0 0 0 0;" value="" 
									id="id1"/>
								</td>
								<td
									style="padding-right:20px;padding-top:15px;padding-left:45px"><label
									class="lableposition" >出生日期</label></td>
								<td style="width:170px;padding-top:15px"><input id="cal1"
									type="text" class="form-control" name="guide.birth"
									readonly="readonly" style="border-radius:0 0 0 0;" value=""
									placeholder="以身份证为准" ></td>

							</tr>

							<tr>
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition">年龄</label></td>
								<td style="width:170px;padding-top:15px"><input type="text"
									class="easyui-validatebox form-control " required="true"
									missingMessage="不能为空" name="guide.age"
									style="border-radius:0 0 0 0;" value=""
									placeholder="以身份证为准" id="id3"/>
								</td>
								<td
									style="padding-right:20px;padding-top:15px;padding-left:45px"><label
									class="lableposition">学历</label></td>
								<td style="width:170px;padding-top:15px"><select
									class="form-control" name="guide.school">
										<option>专科</option>
										<option>本科</option>
										<option>研究生</option>
										<option>博士</option>
										<option>其他</option>
								</select>
								</td>
							</tr>


							<tr style="">
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition">联系电话</label></td>
								<td style="width:170px;padding-top:15px"><input type="text"
									class="easyui-validatebox form-control " required="true"
									validtype="mobile" missingMessage="不能为空"
									style="border-radius:0 0 0 0;" name="guide.gtel">
								</td>

								<td
									style="padding-right:20px;padding-top:15px;padding-left:45px"><label
									class="lableposition">普通话</label></td>
								<td style="width:170px;padding-top:15px"><select
									name="guide.level" class="form-control">
										<option>一级甲等</option>
										<option>一级乙等</option>
										<option>二级甲等</option>
										<option>二级乙等</option>
										<option>三级甲等</option>
										<option>三级乙等</option>
								</select>
								</td>

							</tr>


							<tr>
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition">语言</label></td>
								<td style="width:170px;padding-top:15px"><input type="text"
									class="easyui-validatebox form-control " required="true"
									missingMessage="不能为空" style="border-radius:0 0 0 0;"
									name="guide.language">
								</td>
								<td
									style="padding-right:20px;padding-top:15px;padding-left:45px"><label
									class="lableposition">血型</label></td>
								<td style="width:170px;padding-top:15px"><select
									class="form-control" name="guide.blood">
										<option>A型</option>
										<option>B型</option>
										<option>AB型</option>
										<option>O型</option>
										<option>RH血型</option>
										<option>其它稀有血型</option>
								</select>
								</td>
							</tr>

							<tr>
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition">身高</label></td>
								<td style="width:170px;padding-top:15px"><input type="text"
									class="easyui-validatebox form-control " required="true"
									missingMessage="不能为空" name="guide.height"
									style="border-radius:0 0 0 0;" placeholder="单位:cm"></td>
								<td
									style="padding-right:20px;padding-top:15px;padding-left:45px"><label
									class="lableposition">体重</label></td>
								<td style="width:170px;padding-top:15px"><input type="text"
									class="easyui-validatebox form-control " required="true"
									missingMessage="不能为空" style="border-radius:0 0 0 0;"
									name="guide.weight" placeholder="单位:kg" /></td>
							</tr>



							<tr>
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition"> 导游证编号</label></td>
								<td style="width:170px;padding-top:15px"><input
									name="guide.guidenum" type="text"
									class="easyui-validatebox form-control " required="true"
									missingMessage="不能为空" style="border-radius:0 0 0 0;" value="" />
								</td>
								<td
									style="padding-right:20px;padding-top:15px;padding-left:45px"><label
									class="lableposition"> 从业时间</label></td>
								<td style="width:170px;padding-top:15px"><input type="text"
									class="easyui-validatebox form-control " required="true"
									missingMessage="不能为空" style="border-radius:0 0 0 0;"
									name="guide.workage" placeholder="单位:年" /></td>
							</tr>

							<tr>
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition">是否有传染性疾病</label></td>
								<td style="padding-top:15px" colspan="3"><input
									type="radio" value="0" id="sd" style="margin-left:30px"
									name="guide.diseases" checked="checked" />是 <input
									type="radio" value="1" name="guide.diseases" id="sd"
									style="margin-left:20px" />否</td>

							<tr>
								<td style="padding-right:20px;padding-top:15px"><label
									class="lableposition">证书</label></td>
								<td style="padding-top:15px" colspan="3"><input type="text" placeholder="请输入含奖的证书——例如：英语一等奖"
									class="form-control" style="border-radius:0 0 0 0;"
									name="guide.experice" >
								</td>
							</tr>


						</table>

						<div class="btnright" style="margin-top:20px;float:center">
							<button id="btn_confirm" class="btn btn-primary btn-sm "
								type="button" onclick="submitForm()">
								<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
								确定
							</button>
							<!-- <button id="btn_cancel" class="btn btn-primary btn-sm"
										type="button">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										取消
									</button> -->
						</div>
					</form>
				</div>
			</div>

		</div>

	</div>
	<!--main content end-->

	</div>
	<!--row end-->
	</div>
	<script type="text/javascript">
		function submitForm() {
		
			//验证生日年龄身份证
			//1.substr字符串数组从0截取612522199305230029,获取身份证中的年月日，并去除空格
			var idCard = $("#id1").val().substr(6, 8).trim(); 
			
			//2.截取生日中的年,月,日	输入形式为2016年11月08日
			var year = $("#cal1").val().substr(0, 4).trim();
			var month = $("#cal1").val().substr(5, 2).trim();
			var day = $("#cal1").val().substr(8, 2).trim();
			var birth=year+month+day;
			
			//alert(birth.length);
			//alert(idCard.length);
			//3.获取年龄,计算身份证上的年
			var age = $("#id3").val().substr(0, 2).trim();//输入的年龄
			var idCardYear = $("#id1").val().substr(6, 4).trim(); //获取身份证上的年
			var nowYear = new Date().getFullYear();//获取当前系统年份
			var idCardAge = nowYear-idCardYear;//计算身份证上的年龄
			
			
			//4.判断生日和身份证是否相符
		
			if( idCard == birth){
				
			}else{
				alert("出生日期与身份证不符！");
				return false;
			}
			
			if( age == idCardAge){
			
			}else{
				alert("年龄与身份证不符,年龄应为本年年份减去身份证出生年！");
				return false;
			}
			
			//end
			
		
			$('#guideModifySaveForm').form('submit', {
				onSubmit : function() {
			
					return $(this).form('enableValidation').form('validate');
				},
				success:function(){
					alert("提交完成");
				}

			});
			$(':input', '#guideModifySaveForm').not(':button, :submit, :reset, :hidden')
					.val('');
		
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
			idCode : {
				validator : function(value, param) {
					return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
							.test(value);
				},
				message : '请输入正确的身份证号'
			},
		});
		J(function() {
			J('#cal1').calendar({
				format : 'yyyy年MM月dd日'
			});
			J('#cal2').calendar({
				format : 'yyyy年MM月dd日'
			});
		});
	</script>
</body>
</html>