
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<s:if test="#session.user==null">
	<c:redirect url="../findAll_User"></c:redirect>
</s:if>
<head>
<meta charset="utf-8" />
<title>操作员信息详情</title>
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
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','none');
		$("#list6").css('display','block');
		$("ul.tree li ul li").removeClass("active");
		$("#ok10").addClass("active");
		
	})
</script>
</head>

<body>
	<jsp:include page="../common2.jsp"/>
			<!--slide bar end-->
			<!-- main start-->
			<div id="main-content" class="main-content col-md-10"
				style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
				<div class="main-content-title">

					<ul class="breadcrumb">
						<li><span class="glyphicon glyphicon-home"></span><a
							href="../index.jsp" style="padding-left:10px;">首页</a>
						</li>

						<li>操作员信息</li>
					</ul>

				</div>

				<div class="page-content">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							信息详情 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>

					</div>
					<!-- /.page-header -->

					<div class="row" style="">
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">
								<div class="tab-content" style="">

									<table class="table table-bordered table-hover fontsize">
										<tr class="guideinfotitle" style="border-bottom-width: 2px;">

											<th>操作员姓名</th>
											<th>操作员性别</th>
											<th>操作员账号</th>
											<th>联系方式</th>
											<th>恢复默认密码</th>
											<th>删除</th>
										</tr>
										<s:iterator value="#session.user" var="u">
										<s:if test="#session.nuser.userid==#u.userid || #u.userpower==0">
										<tr style="border-bottom-width: 2px;">
											
												<td>${u.username }</td>
												<td>${u.sex }</td>
												<td>${u.count}</td>
												<td>${u.tel }</td>
												<td>
													<a href="../changep_User?userid=${u.userid }" onclick="return makesure()"><button  type="button" class="btn-info">恢复</button></a>
												</td>
												<td>
													<s:if test="#session.nuser.userid!=#u.userid">
														<button class="btn-danger btn_del btn_delete" title="删除" onclick=" mydet(${u.userid })">
															<span class="glyphicon glyphicon-trash" aria-hidden="true">
															</span>
														</button>
														</s:if>
												</td>
												
										</tr>
										</s:if>	
									</s:iterator>

									</table>
								</div>
								<!-- table end -->
							</div>
							<!--col 12 end-->
						</div>
					</div>
					<!--row end-->

				</div>
			</div>
</body>
<script type="text/javascript">
function makesure() {
			return window.confirm("是否恢复初始密码？");
		}
	J(function() {
		J('#cal1').calendar({
			format : 'yyyy年MM月dd日'
		});
		J('#cal2').calendar({
			format : 'yyyy年MM月dd日'
		});
	});

function mydet(data){
	if(window.confirm("是否真的删除！")){
		var val2=data;
	var args={"userid":val2};
	$.ajax({
                cache: true,
                type: "POST",
                url:"../deluser_User",
                data:args,// 你的formid
                async: false,
                error: function(request) {
                alert("请求失败");
                },
                success: function(data) {
                	data = eval("(" + data + ")");
	                	if(data.success==0){
	                		alert("删除失败!");
	                	}else if(data.success==1){
	                		alert("删除成功!");
	                		window.location.reload();
	                	}
                }
            });
	}
}

	function clearInput1() {
		document.getElementById('js-in').value = '';

	}
</script>
</html>
