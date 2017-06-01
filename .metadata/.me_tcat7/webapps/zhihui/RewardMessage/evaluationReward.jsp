<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
				$("#menu5").addClass("active");
				
			})
		</script>	
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-0" data-genuitec-path="/zhihui2/WebRoot/RewardMessage/evaluationReward.jsp">	
	<jsp:include page="../common2.jsp"/>
				<!--slide bar end-->
				<!-- main start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-0" data-genuitec-path="/zhihui2/WebRoot/RewardMessage/evaluationReward.jsp">
					<div class="main-content-title" >
												
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="../index.jsp" style="padding-left:10px;">首页</a></li>			  
						 				  
							<li>
								<a href="rewardMessage.jsp">奖惩信息</a>
							</li>
							<li>奖励</li>
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								奖励
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>详情
							</font>
							
						</div>
						<!-- /.page-header -->
						
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">			
						<table class="table table-bordered table-hover fontsize">
															<tr  style="border-bottom-width: 2px;">
																
																<th class="active">导游姓名</th>
																<td>${jl.guidename }</td>
																<th class="active">导游编号</th>
																<td>${jl.guidenum }</td>
															</tr>
															<tr style="border-bottom-width: 2px;">
																<th class="active">从业时间  </td>
																<td >${jl.workage }
																</td> 
																<th class="active">普通话等级</td>
																<td>
																	${jl.level }
																</td>
															</tr>
															
															<tr>
																<th class="active" style="width:180px;">是否连续从事讲解工作</th>
																<td>
																<s:if test="#session.jl.lianxujiangjie==1">
																		是
																	</s:if>
																	<s:else>
																		否
																	</s:else>
																</td>
																<th class="active" style="width:180px;">考核是否合格</th>
																<td>
																<s:if test="#session.jl.hege==1">
																		是
																	</s:if>
																	<s:else>
																		否
																	</s:else>
																</td>
															</tr>
															
															<tr>
																<th class="active">语言</th>
																<td colspan=3>${jl.language }
																	<button type="button" class="btn btn-default btn-xs" style="float:right" data-toggle="modal" data-target=".bs-example-modal-sm">
																		<span class="glyphicon glyphicon-plus"></span> 新增
																	</button>
																</td>
															</tr>
														<!-- 点击语言添加按钮-->
															<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
															  <div class="modal-dialog modal-sm">
																<div class="modal-content" style="padding-left:10px">
																	<h5>新增语言</h5>
																	<form action="../modify_Pingfen" method="post">
																	<input type="text" style="width:260px" name="yuyan">
																	<input type="hidden" name="myid" value="${jl.guideid }"/>
																	<input type="hidden" name="i" value="1"/>
																		<div style="margin-top:10px;margin-bottom:5px;width:260px">
																			<button type="button" class="btn-info" onclick="this.form.submit()">确定</button>
																			
																		</div>
																		</form>
																</div>
															  </div>
															</div>

														
														<!--点击添加按钮结束-->
	
															
															<tr>
																<th class="active">证书</th>
																<td colspan=3>${jl.experice }
																	<button type="button" class="btn btn-default btn-xs" style=";float:right" data-toggle="modal" data-target=".bs-example-modal-sm2">
																		<span class="glyphicon glyphicon-plus"></span> 新增
																	</button>
																</td>
															</tr>
														<!-- 点击证书添加按钮-->
															<div class="modal fade bs-example-modal-sm2" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
															  <div class="modal-dialog modal-sm">
																<div class="modal-content" style="padding-left:10px">
																	<h5>新增证书</h5>
																	<form action="../modify_Pingfen" method="post">
																	<input type="text" class="form-control" name="zhengshu" rows="3" style="width:260px;"></textarea>
																		<input type="hidden" name="myid" value="${jl.guideid }"/>
																	<input type="hidden" name="i" value="2"/>
																	
																		<div style="margin-top:10px;margin-bottom:5px;width:260px">
																			<button type="button" class="btn-info" onclick="this.form.submit()" >确定</button>
																			
																		</div>
																	</form>	
																</div>
															  </div>
															</div>

														
														<!--点击添加按钮结束-->
															
														</table>					
						<!-- table end -->
					</div>
					<!--col 12 end-->
				</div>
			</div>	
		<!--row end-->						
		
		</div>
	</div>
  </body>
</html>
