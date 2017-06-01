<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8"/>
    <title>评价信息</title>
		<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="../assets/app/css/common.css" >
		<script type="text/javascript" src="../assets/app/js/common.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css"/>
		
		
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
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
					<div class="main-content-title" >
												
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="../index.jsp" style="padding-left:10px;">首页</a></li>			  
						 				  
							<li>
								<a href="evaluationMessage.jsp">评价信息</a>
							</li>
							<li>详情</li>
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								初始评分
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>详情
							</font>
							
						</div>
						<!-- /.page-header -->
						
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">			
						<form method="post">						
														<table class="table table-bordered table-hover fontsize">
															<tr  style="border-bottom-width: 2px;">
																
																<th class="active">导游姓名</th>
																<td>${guide.guidename }</td>
																<th class="active">导游编号</th>
																<td>${guide.guidenum }</td>
															</tr>
															<tr style="border-bottom-width: 2px;">
																<th class="active">从业时间  </td>
																<td >${guide.workage }
																	<span style="float:right;">+${session.map.congye }分
																	</span>
																</td> 
																<th class="active">普通话等级</td>
																<td>${guide.level }
																	<span style="float:right;">+${session.map.yuyan }分
																	</span>
																</td>
															</tr>
															
															<tr>
																<th class="active" style="width:180px;">是否连续从事讲解工作</th>
																<td>
																<s:if test="#session.guide.lianxujiangjie==1">
																		是
																	</s:if>
																	<s:else>
																		否
																	</s:else>
																</td>
																<th class="active" style="width:180px;">考核是否合格</th>
																<td>
																<s:if test="#session.guide.hege==1">
																		是
																	</s:if>
																	<s:else>
																		否
																	</s:else>
																
																</td>
															</tr>
															
															<tr>
																<th class="active">语言以及证书</th>
																<td colspan=3>语言:${guide.language }--------证书:${guide.experice }
																	<span style="float:right;">+${session.map.zhengshu }分</span></td>
															</tr>
															
															<tr>
																<th class="active">评分</th>
																<td colspan=3>${guide.score }</td>
															</tr>
															
														</table>
														
													</form>
											
					<!--col 12 end-->
				</div>
			</div>	
		<!--row end-->						
		
		</div>
	</div>
  </body>
</html>
