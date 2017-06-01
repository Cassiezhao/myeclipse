<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8"/>
    <title>导游机损坏</title>
		<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
		<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

		<link rel="stylesheet" href="../assets/app/css/common.css" >
		<script type="text/javascript" src="../assets/app/js/common.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/GuideInfo_style.css"/>
		
		<script type="text/javascript" src="../assets/app/js/search.js"></script>	
		<link rel="stylesheet" href="../assets/app/css/search.css" />	
		<script type="text/javascript">
	$(function(){
		$("ul.tree li ul li").removeClass("active");
		$("#ok2").addClass("active");
	})
</script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"8123",secure:"8124"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-176" data-genuitec-path="/zhihui2/WebRoot/guidemachine/guideMachineDestory.jsp">	
<jsp:include page="../common2.jsp"/>
				<!--slide bar end-->
				
				
				<!-- main start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-176" data-genuitec-path="/zhihui2/WebRoot/guidemachine/guideMachineDestory.jsp">
					<div class="main-content-title" >
												
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="canBorrow.jsp" style="padding-left:10px;">首页</a></li>			  			  
							<li>
								<a href="alreadyBorrow.jsp">借出导游机</a>
							</li>
							<li>
								损坏
							</li>
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								损坏情况
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>
									详情
							</font>
							
						</div>
						<!-- /.page-header -->
						
			<div class="row" style="">
				<div style="margin-left:20px;margin-right:20px;">
					<div class="col-md-12">			
						<div class="tab-content" style="">
													
							<form action="../findById_Guidem?j=4" method="post">					   		
							      	<table style="margin:auto">
										<tr>
						    				<td>
												<label>
													<input name="guidem.breakinfo" type="checkbox" value="显示不正常" /></input>
												</label>
											</td>
											<td>显示不正常</td>
						    			</tr>
										<tr>
						    				<td>
						    				<input type="hidden" name="guidem.guidemid" value="${guidemx.guidemid }"/>
												<label>
													<input name="guidem.breakinfo" type="checkbox" value="通话故障" /></input>
												</label>
											</td>
											<td>
											通话故障
											</td>
						    			</tr>	
						    			
						    			<tr>
						    				<td>
												<label>
													<input name="guidem.breakinfo" type="checkbox" value="通信故障" /></input>
												</label>
											</td>
											<td>通信故障</td>
						    			</tr>	
						    			<tr>
						    				<td>
												<label>
													<input name="guidem.breakinfo" type="checkbox" value="其他" /></input>
												</label>
											</td>
											<td>其他</td>
						    			</tr>
						    			<tr>
						    				<td style="padding-right:5px;padding-top:10px">
													损坏游客机
											</td>
											<td><input type="text" name="youke" />个</td>
						    			</tr>
										<tr>
											<td colspan="2" align="center" style="padding-top:15px;">
												<button  class="btn btn-primary btn-sm btn_submit" type="button" 
												onclick="this.form.submit()"
												>
													<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
													提交
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
	<div class="search-icon">
		<button class="search" id="icon">
		   <span class="glyphicon glyphicon-search" aria-hidden="true" ></span>
		</button>					    				
	</div>
		    			
	<div class="search-info" >										 
		  <select class="selectway">
		  	<option value="1">按导游姓名查找导游信息</option>
		  	<option value="2">按导游编号查找导游信息</option>
		  	<option value="3">按订单编号查找订单信息</option>
		  	<option value="4">按导游机编号查找导游机信息</option>
		  </select>
		  <input type="text" id="searchInfo"/> 
		  <button class="search" id="query">
				<span class="glyphicon glyphicon-search" aria-hidden="true" ></span>
			</button>				
	</div>
	<script type="text/javascript">
		$('.btn_reset').click(function(){
			$("form")[0].reset();
		})
	</script>
	</script>
  </body>
</html>