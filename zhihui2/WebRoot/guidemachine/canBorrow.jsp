<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<s:if test="#session.youkem==null">
	<c:redirect url="../init_Youkem?k=2"></c:redirect>
</s:if>
<html>
<head>
<title>指派导游机</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideInfo_style.css" /> 
<link rel="stylesheet" href="../easyui/themes/default/easyui.css"
	type="text/css"></link>
<script type="text/javascript"
	src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">

	$(function(){
		$("ul.tree li ul li").removeClass("active");
		$("#ok1").addClass("active");
	})
</script>


</head>

<body>
	<jsp:include page="../common2.jsp"/>


			<!-- main start-->
			<div id="main-content" class="main-content col-md-10"
				style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
				<div class="main-content-title">

					<ul class="breadcrumb">
						<li><span class="glyphicon glyphicon-home"></span><a
							href="../index.jsp" style="padding-left:10px;">首页</a></li>
						<li>指派导游机</li>
					</ul>

				</div>

				<div class="page-content">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							指派导游机 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>
							填写信息 </font>

					</div>
					<!-- /.page-header -->

					<div class="row" style="">
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<div class="tab-content" style="">

									<form action="../update_Guidem" method="post" id="form6">
										<table style="margin:auto">
											<tr>
												<td><label for="guideMachineNumber"
													class="lableposition">导游机编号</label></td>
												<td style="padding-left:10px;width:300px;">
												<input type="text" class="form-control easyui-validatebox" required="true"
													placeholder="导游机编号" name="guidem.guidemnum" id="guideMachineNumber"
													style="border-radius:0 0 0 0;" />
												</td>
												<td><div id="messange"></div><font color="red" size="2px">${err2 }</font></td>
											</tr>
											<tr>
												<td><label for="companyNumber" class="lableposition">导游编号</label>
												</td>
												<td style="padding-left:10px;width:300px;"><input type="text" class="form-control easyui-validatebox" required="true"
													name="guidem.guide.guidenum" placeholder="导游编号"
													id="guideNumber" style="border-radius:0 0 0 0;"  "
													 />
													
												</td>
												<td><div id="messange2"><font color="red" size="5px">${err3 }</font></td>
											</tr>


											<tr>
												<td><label for="guestMachineNumber"
													class="lableposition">游客机数量</label></td>
												<td style="padding-left:10px;width:300px;"><input type="text" class="form-control easyui-numberbox" required="true"
													placeholder="游客机数量(库存${youkem.youkeMle }个)" name="guidem.youkeNum" id="touristMachineAmount"
													style="border-radius:0 0 0 0;"  onClick=" this.value ='' "/>
												</td>
												<td><div id="messange3"><font color="red" size="5px">${err4 }</font></td>
											</tr>
											<tr id="trheight">
												<td colspan="2" style="text-align:right" >
													
													<!-- <button class="btn btn-primary btn-sm btn_submit"
															type="button" onclick="mypringt()">
															<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
															打印
														</button> -->
														<button class="btn btn-primary btn-sm btn_submit"
															type="button" onclick="submitForm()">
															<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
															提交
														</button>
														<button class="btn btn-primary btn-sm btn_reset"
															type="button" id="reset">
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
							<div class="col-md-2"></div>
							<!--col 12 end-->
						</div>
					</div>
					<!--row end-->

				</div>
			</div>
			
<script type="text/javascript">
	var myurl;
$(function(){
	var btheight =  $("#reset").outerHeight(true)+20;   
	$("#trheight").height(btheight);

$("#reset").click(function(event) {
		$("table input[type='text']").each(function(){
			this.value = ""; 
  		});
		 
	});

//导游机的ajax
$("#guideMachineNumber").blur(function(){
	var val=$("#guideMachineNumber").val();
	bianhao=$.trim(val);
	var args={"usernum":bianhao};
	$.ajax({
                cache: true,
                type: "POST",
                url:"../yznum_ajaxAction",
                data:args,// 你的formid
                async: false,
                error: function(request) {
                    alert("导游机不存在");
                    $("#guideMachineNumber").val("");
                },
                success: function(data) {
                	$("#messange").html(data);
                }
            });
	
	
});
//导游的ajax
$("#guideNumber").blur(function(){
	var val2=$("#guideNumber").val();
	bianhao2=$.trim(val2);
	var args={"guidenum":bianhao2};
	$.ajax({
                cache: true,
                type: "POST",
                url:"../ydaoy_ajaxAction",
                data:args,// 你的formid
                async: false,
                error: function(request) {
                    alert("导游不存在");
                    $("#guideNumber").val("");
                },
                success: function(data) {
                	$("#messange2").html(data);
                }
            });
	
 });
});

function mypringt(){
	location.href='../pringtf_ChangeScore?guidenum='+myurl; 
}
function submitForm() {
			
			$('#form6').form('submit', {
				onSubmit : function() {

					return $(this).form('enableValidation').form('validate');
				}
				
			});
			if($(this).form('enableValidation').form('validate')){
				alert('成功指派');
				myurl=$("#guideNumber").val();
			}
			if(confirm("是否打印?")){
				location.href='../pringtf_ChangeScore?guidenum='+myurl; 
			}
			$(':input', '#form6').not(':button, :submit, :reset, :hidden')
					.val('');
			
		}
</script>
</body>
</html>