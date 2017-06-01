
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<s:if test="#session.jiangcheng==null">
	<c:redirect url="../jiangcheng_Pingfen"></c:redirect>
</s:if>

<head>
<meta charset="utf-8" />
<title>奖惩信息</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />


s
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script><script
	type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css" type="text/css"></link>
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','none');
		$("#list6").css('display','none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu5").addClass("active");
		
	})
</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-1" data-genuitec-path="/zhihui2/WebRoot/RewardMessage/rewardMessage.jsp">
	<jsp:include page="../common2.jsp"/>
			<!--slide bar end-->
			<!-- main start-->
			<div id="main-content" class="main-content col-md-10"
				style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-1" data-genuitec-path="/zhihui2/WebRoot/RewardMessage/rewardMessage.jsp">
				<div class="main-content-title">

					<ul class="breadcrumb">
						<li><span class="glyphicon glyphicon-home"></span><a
							href="../index.jsp" style="padding-left:10px;">首页</a></li>

						<li>奖惩信息</li>
					</ul>

				</div>

				<div class="page-content">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							奖惩信息 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>

					</div>
					<!-- /.page-header -->
					<div class="row">
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">
								<form action="../jiangcheng_Pingfen" class="form-inline"
									role="form" method="post">
									<div class="form-group" style="padding-bottom:10px;">
										<select name="sousuo" style="font-size:12px;height:20px;">
											<option value="4">选择</option>
											<option value="1">按导游编号查询</option>
											<option value="2">按导游姓名查询</option>
										</select> <input name="xuanze" style="height:20px;padding-left:10px"
											id="js-in"> <span
											style="font-size:20px;line-height:20px; position: absolute; margin-left:-20px; cursor: pointer"
											onclick="clearInput1()">×</span>
										<button class="glyphicon glyphicon-search"
											onclick="this.form.submit()"></button>

										<!-- 日期选择器 -->



									</div>
								</form>

							</div>
						</div>
					</div>
					<div class="row" style="">
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">
								<table class="table table-bordered table-hover fontsize">
									<tr class="guideinfotitle" style="border-bottom-width: 2px;">

										<th>导游姓名</th>
										<th>导游编号</th>
										<th>初始评分</th>
										<th>评价</th>
										<th></th>
										<th></th>
									</tr>
									<s:iterator value="#session.jiangcheng.pagelist" var="pp">
										<tr style="border-bottom-width: 2px;">
											<td>${pp.guidename}</td>
											<td>${pp.guidenum }</td>
											<td><a href="../evaluationMessage/initialevaluation.jsp">${pp.score}分</a>
											</td>
											<td><a href="../findBysid_Paths?sid=${pp.guideid }">星级</a>
											</td>
											<td><a href="../jiangli_Pingfen?sid=${pp.guideid }">
													<button type="button" class="btn-primary">奖励</button> </a>
											</td>
											<td>
											<a href="../koufen_Pingfen?sid=${ pp.guideid}" onclick="return dodel()">
													<button type="button" class="btn-danger"  >扣分</button></a>
												(一次扣除5分)
											</td>
										</tr>


									</s:iterator>

								</table>
								<!-- 点击扣分按钮-->
								<div class="modal fade bs-example-modal-sm6" tabindex="-1"
									role="dialog" aria-labelledby="mySmallModalLabel"
									aria-hidden="true">
									<div class="modal-dialog modal-sm">
										<div class="modal-content" style="padding-left:10px">
											<h5>抽听讲解扣分次数</h5>
											<form action="../modify_Pingfen" method="post">
												<input type="text" style="width:200px;margin-right:5px;"
													name="yuyan">次 <input type="hidden" name="myid"
													value="${jl.guideid }" /> <input type="hidden" name="i"
													value="1" />
												<div style="margin-top:10px;margin-bottom:5px;width:260px">
													<button type="button" class="btn-info"
														onclick="this.form.submit()">确定</button>

												</div>
											</form>
										</div>
									</div>
								</div>


								<!--点击按钮结束-->

								<!--col 12 end-->
							</div>
						</div>
						<!--row end-->
						<div align="center">
						<div  id="pp" class="easyui-pagination" style="border:1px solid #ccc" data-options="
						total: <%=session.getAttribute("total3") %>,pageSize:5
						">
						</div>
						</div>
					
					</div>
					</div>
				</div>
</body>
<script type="text/javascript">
$('#pp').pagination({
	    total:<%=session.getAttribute("total3") %>,
	    pageNumber:<%=session.getAttribute("page3") %>,
	    pageSize:<%=session.getAttribute("rows3") %>,
	     pageList: [5, 10, 15, 20],
    	onSelectPage:function(pageNumber, pageSize){
    		$(this).pagination('loading');
    		$(this).pagination('loaded');
    		window.location = "../jiangcheng_Pingfen?page=" + pageNumber+"&rows="+pageSize;
    	}
    });
	function dodel(){
		return window.confirm("是否真的扣分！");
	}
	
	function dorows() {
		var rows = document.form1.rows.value;
		if (isNaN(rows)) {
			alert("请输入正确的数字！");
			document.form1.rows.value = $
			{
				pb.rows
			}
			;
			return;
		}
		window.location = "../jiangcheng_Pingfen?rows=" + rows;
	}
	function dopage() {
		var page = document.form1.page.value;
		if (isNaN(page)) {
			alert("请输入正确的数字！");
			document.form1.page.value = $
			{
				pb.page
			}
			;
			return;
		}
		window.location = "../jiangcheng_Pingfen?page=" + page;
	}
</script>
</html>
