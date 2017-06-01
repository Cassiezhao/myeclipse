<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>评价信息</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />


<script type="text/javascript" src="../assets/app/js/search.js"></script>
<link rel="stylesheet" href="../assets/app/css/search.css" />
<script type="text/javascript">
	$(function(){
		$("#list2").css('display','none');
		$("#list3").css('display','none');
		$("#list6").css('display','none');
		$("ul.tree li ul li").removeClass("active");
		$("#menu4").addClass("active");
		
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
							href="../index.jsp" style="padding-left:10px;">首页</a>
						</li>
						<li><a href="evaluationMessage.jsp">评价信息</a></li>
						<li>详细评价信息</li>
					</ul>

				</div>

				<div class="page-content">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							评价信息 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>

					</div>
					<!-- /.page-header -->



					<!-- /.page-header -->

					<div class="row" style="">
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">
								<div class="tab-content" style="">

									<table class="table table-bordered table-hover fontsize">
										<tr style="border-bottom-width: 2px;">

											<th class="active">导游姓名</th>
											<td>${single.guidename}</td>
											<th class="active">导游编号</th>
											<td>${single.guidenum }</td>
										</tr>
										

										<tr>
											<th class="active" style="width:180px;">是否连续从事讲解工作</th>
											<td>
											<s:if test="#session.single.lianxujiangjie==1">
													是
											</s:if>
												<s:else>
													否
												</s:else>
											
											</td>
											<th class="active" style="width:180px;">考核是否合格</th>
											<td>
											<s:if test="#session.single.hege==1">
													是
											</s:if>
												<s:else>
													否
												</s:else>
											</td>
										</tr>
										<tr>
											<th class="active" style="width:180px;">位置信息</th>
											<td>
											<s:if test="#session.single.wzxx==1">
											未超出景区范围 <span style="float:right;">+${siyy.weizhixinxi }分 </span>
											</s:if>
											<s:else>
											超出景区范围
											</s:else>
											</td>
											<th class="active" style="width:180px;">在线时间</th>
											<td>
											<s:if test="#session.shijian==1">
											超出平均值 <span style="float:right;">+${siyy.shangxianshijian }分 </span>
											</s:if>
											<s:else>
											未超出平均值 
											</s:else>
											</td>
										</tr>

										<tr>
											<th class="active" style="width:180px;">上线地点</th>
											<td>
											
											<s:if test="#session.single.sxdd==1">
											未超出景区范围 <span style="float:right;">+${siyy.sxdd }分 </span>
											</s:if>
											<s:else>
											超出景区范围
											</s:else>
											
											</td>
											<th class="active" style="width:180px;">上线次数</th>
											<td>
											<s:if test="#session.cishu==1">
											超出平均值 <span style="float:right;">+${siyy.sxcs }分 </span>
											</s:if>
											<s:else>
											未超出平均值
											</s:else>
											
											</td>
										</tr>

										<tr>
											<th class="active" style="width:180px;">抽听讲解</th>
											<td colspan=3>内容不合格${single.choutingjiangjie }次 <span style="float:right;">-${choue}分 </span></td>
										</tr>
										<tr style="border-bottom-width: 2px;">
											<th class="active">基础评分</th>
											<td colspan="3"> ${single.score } </td>
										</tr>
										
										<tr>
											<th class="active">游客机平均分</th>
											<td colspan=3>${single.youkescore }
										</tr>
										<tr>
											<th class="active">总分</th>
											<td colspan=3>${single.sumscore }
										</tr>
										<tr>
											<th class="active">评定级别</th>
											<td colspan=3>${single.pinglevel }
										</tr>
										
									</table>
									<a href="../evalu_Pingfen?index=${single.guideid }"><button>重新评价</button> </a>
									</div>
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
				$path = "${ctx}";
				$('.btn_clean').click(function() {
					if (confirm("确认清空?")) {
						window.location.href = "${ctx}/deleteAllRankInfo";
					}
				});
			</script>
</body>
</html>

