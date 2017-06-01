
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>导游信息</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />
<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css"></link><script type="text/javascript"
	src="../assets/app/js/lhgcore.min.js"></script><script
	type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','block');
		
		$("ul.tree li ul li").removeClass("active");
		$("#ok5").addClass("active");
	})
</script>
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
						<li><a href="guideMessage1.jsp">导游信息 </a></li>
						<li>修改信息</li>
					</ul>
				</div>

				<div class="container-fluid">

					<div>
						<div class="page-header"
							style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								修改信息 </font> <font style="color:#8089a0;font-size:14px"> <span
								class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>请修改导游信息
							</font>
						</div>
						<div class="col-md-2"></div>
						<div class="col-md-10">
							<form id="guideModifySaveForm" action="../update_Guide" method="post">
								<table>
									<tr>
										
										<td style="padding-right:20px;"><label
											class="lableposition">姓名</label>
										</td>
										<td style="width:170px">
										<input type="hidden" name="guide.guideid" value="${guide2.guideid}"/>
										<input type="text" name="guide.guidename"value="${guide2.guidename}"
											class="form-control" style="border-radius:0 0 0 0;" />
										</td>
										<td style="padding-left:45px"><label
											class="lableposition">性 别</label>
										</td>
										<td style=""><input type="radio" value="男" id="male" name="guide.gsex " 
											style="margin-left:30px" checked="checked" />男 <input name="guide.gsex " 
											type="radio" value="女" id="female" style="margin-left:20px" />女
										</td>

									</tr>

									<tr style="">
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">身份证号</label>
										</td>
										<td style="width:170px;padding-top:15px"><input name="guide.idcard" value="${guide2.idcard }" 
										
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" /></td>
										<td
											style="padding-right:20px;padding-top:15px;padding-left:45px"><label
											class="lableposition">出生日期</label>
										</td>
										<td style="width:170px;padding-top:15px"><input value="${guide2.birth }" id="cal1" readonly="readonly"
						    					name="guide.birth"
											type="text" class="form-control"
											style="border-radius:0 0 0 0;"  placeholder="以身份证为准">
										</td>

									</tr>

									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">年龄</label>
										</td>
										<td style="width:170px;padding-top:15px"><input
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" value="${guide2.age }" name="guide.age" /></td>
										<td
											style="padding-right:20px;padding-top:15px;padding-left:45px"><label
											class="lableposition">学历</label>
										</td>
										<td style="width:170px;padding-top:15px" ><select  name="guide.school" 
											class="form-control" >
												<option >${guide2.school }</option>
												<option >专科</option>
												<option >本科</option>
												<option>研究生</option>
												<option>博士</option>
												<option>其他</option>
										</select></td>
									</tr>


									<tr style="">
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">联系电话</label>
										</td>
										<td style="width:170px;padding-top:15px"><input name="guide.gtel" value="${guide2.gtel }"
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" ></td>

										<td
											style="padding-right:20px;padding-top:15px;padding-left:45px"><label
											class="lableposition">普通话</label>
										</td>
										<td style="width:170px;padding-top:15px"><select
											class="form-control" name="guide.level" > 
												<option>${guide2.level }</option>
												<option>一级甲等</option>
												<option>一级乙等</option>
												<option>二级甲等</option>
												<option>二级乙等</option>
												<option>三级甲等</option>
												<option>三级乙等</option>
										</select></td>

									</tr>


									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">语言</label>
										</td>
										<td style="width:170px;padding-top:15px"><input
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" value="${guide2.language }"
    				name="guide.language "></td>
										<td
											style="padding-right:20px;padding-top:15px;padding-left:45px"><label
											class="lableposition">血型</label>
										</td>
										<td style="width:170px;padding-top:15px"><select name="guide.blood"
											class="form-control" >
												<option>${guide2.blood } </option>
												<option>A型</option>
												<option>B型</option>
												<option>O型</option>
												<option>RH血型</option>
												<option>其它稀有血型</option>
										</select></td>
									</tr>

									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">身高</label>
										</td>
										<td style="width:170px;padding-top:15px"><input
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" value="${guide2.height }" name="guide.height" placeholder="单位:cm">
										</td>
										<td
											style="padding-right:20px;padding-top:15px;padding-left:45px"><label
											class="lableposition">体重</label>
										</td>
										<td style="width:170px;padding-top:15px"><input
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" value="${guide2.weight }" name="guide.weight" placeholder="单位:kg" />
										</td>
									</tr>



									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition"> 导游证编号</label>
										</td>
										<td style="width:170px;padding-top:15px"><input
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" name="guide.guidenum" value="${guide2.guidenum}"/></td>
										<td
											style="padding-right:20px;padding-top:15px;padding-left:45px"><label
											class="lableposition"> 从业时间</label>
										</td>
										<td style="width:170px;padding-top:15px"><input
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" name="guide.workage" value="${guide2.workage }" placeholder="单位:年" />

										</td>
									</tr>

									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">是否有传染性疾病</label>
										</td>
										<td style="padding-top:15px" colspan="3"><input
											type="radio" value="0"  style="margin-left:30px" name="guide.diseases"
											/>是 <input type="radio" value="1"
											 style="margin-left:20px" checked="checked" name="guide.diseases"/>否</td>
									</tr>
									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">是否年度考核合格</label>
										</td>
										<td style="padding-top:15px" colspan="3"><input
											type="radio" value="1" id="male" style="margin-left:30px"
											checked="checked"  name="guide.hege"/>是 <input type="radio" value="0" name="guide.hege"
											 style="margin-left:20px" />否</td>
									</tr>
									
									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">是否连续从事讲解工作</label>
										</td>
										<td style="padding-top:15px" colspan="3"><input
											type="radio" value="1" id="male" style="margin-left:30px"
											checked="checked" name="guide.lianxujiangjie"/>是 <input type="radio" value="0"
											id="female" style="margin-left:20px" name="guide.lianxujiangjie" />否</td>
									</tr>
									<tr>
										<td style="padding-right:20px;padding-top:15px"><label
											class="lableposition">证书</label>
										</td>
										<td style="padding-top:15px" colspan="3"><input
											type="text" class="form-control"
											style="border-radius:0 0 0 0;" name="guide.experice" value="${guide2.experice }"></td>
									</tr>


								</table>

								<div class="btnright" style="margin-top:20px;">
									<button id="btn_confirm" class="btn btn-primary btn-sm "
										type="button" onclick="this.form.submit()">
										<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
										确定
									</button>
									<button id="btn_cancel" class="btn btn-primary btn-sm"
										type="button">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										取消
									</button>
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
	J(function(){
				J('#cal1').calendar({ format:'yyyy年MM月dd日' });
				J('#cal2').calendar({ format:'yyyy年MM月dd日' });
			});
	
		$path = "${ctx}";
		$(".btn_modify").click(function() {
			var str = "/IntelligentGuide/guideModify/" + this.value;
			window.location.href = str;
		});
		$(".btn_delete").click(function() {
			var str = "/IntelligentGuide/guideDelete/" + this.value;
			if (confirm("确认删除吗？")) {
				window.location.href = str;
			}
		});
	</script>
</body>
</html>