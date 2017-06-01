<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<s:if test="#session.pb2==null">
	<c:redirect url="../findAll_Guidem?i=2"></c:redirect>

</s:if>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>导游机使用情况</title>
<script type="text/javascript" src="../assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="../assets/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/bootstrap-theme.min.css" />
<link rel="stylesheet" href="../assets/css/font-awesome.min.css" />

<link rel="stylesheet" href="../assets/app/css/common.css">
<script type="text/javascript" src="../assets/app/js/common.js"></script>
<link rel="stylesheet" href="../assets/app/css/GuideManage_style.css" />

<script type="text/javascript" src="../assets/app/js/search.js"></script>
<link rel="stylesheet" href="../assets/app/css/lhgcalendar.css"
	type="text/css">
</link>
<script type="text/javascript" src="../assets/app/js/lhgcalendar.min.js"></script>
<script type="text/javascript" src="../assets/app/js/lhgcore.min.js"></script>
<script type="text/javascript" src="../assets/js/jBootstrapPage.js"></script><link
	rel="stylesheet" href="../assets/css/jBootsrapPage.css" type="text/css"></link>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script><script
	type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" href="../easyui/themes/default/easyui.css" type="text/css"></link>	
<script type="text/javascript">
	$(function(){
		$("ul.tree li ul li").removeClass("active");
		$("#ok4").addClass("active");
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
						<li>导游机使用情况</li>
					</ul>

				</div>

				<div class="page-content">
					<div class="page-header"
						style="margin-top:10px;margin-left:20px;margin-right:20px;">
						<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
							使用情况 </font> <font style="color:#8089a0;font-size:14px"> <span
							class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>查看
						</font>

					</div>
					<!-- /.page-header 搜索框 -->
					<!--  
					<div class="row">	
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">	
								<form class="form-inline" role="form">
									  <div class="form-group" style="padding-bottom:10px;">
										<select style="font-size:12px;height:20px;">
										  <option>按导游机编号查询</option>
										  <option>按导游编号查询</option>
										  <option>按导游姓名查询</option>
										</select>
										<input style="height:20px;padding-left:10px" id="js-in" >
										<span style="font-size:20px;line-height:20px; position: absolute; margin-left:-20px; cursor: pointer" onclick="clearInput1()">×</span>
										<input type="text"  id="cal1" style="height:20px;" id="js-time1"/>
										-
										<input type="text"  id="cal2" style="height:20px;" id="js-time2"/>
										<button class="glyphicon glyphicon-search" style="border: 0px"></button>
									  </div>
									<input type="button" value="导出" style="float:right" class="btn-info">
								</form>
								
							</div>
						</div>
					</div>
					-->
					<div class="row" style="">
						<div style="margin-left:20px;margin-right:20px;">
							<div class="col-md-12">
								<div class="tabbable">
									<ul class="nav nav-tabs" id="myTab">
										<li class="active"><a data-toggle="tab" href="#home">
												正常使用 </a></li>

										<li><a data-toggle="tab" href="#profile"> 正在维修 </a></li>
											<input type="button" value="导出" style="float:right;margin-left:5px;"
									class="btn-info" onclick="javascript:window.location.href='../ExcelAction3'">
										<input type="button" value="修改导游机电话" style="float:right;" class="btn-info"   onclick="modifyPassword()">							
									</ul>
									

									<div class="tab-content" style="">
										<div id="home" class="tab-pane in active">
											<table class="table table-bordered table-hover fontsize">
												<tr class="guideinfotitle" style="border-bottom-width: 2px;">
													<th>导游机编号</th>
													<th>导游机电话</th>
													<th>使用次数</th>
													<th>损坏次数</th>
													<th>当前状态</th>
													<th></th>
												</tr>

												<s:iterator value="#session.pb2.pagelist" var="guidem">
													<s:if test="#guidem.gmstate<4">
														<tr>
															<td>${ guidem.guidemnum}</td>
															<td>${ guidem.gmtel}</td>
															<td><a
																href="../guidemDetail?guidemid=${guidem.guidemnum }">${guidem.borrow}</a>
															</td>
															<td>${guidem.break_}</td>
															<s:if test="#guidem.gmstate==1">
																<td>机器正常可借</td>
																<td align='center'></td>
															</s:if>
															<s:if test="#guidem.gmstate==2">
																<td>机器正常已借出</td>
																<td align='center'></td>
															</s:if>
															<s:if test="#guidem.gmstate==3">
																<td>机器正常已损坏</td>
																<td align='center'><a
																	href="../findById_Guidem?index=${ guidem.guidemid}"><button
																			type="button" class="btn-info btn_return">维修</button>
																</a></td>
															</s:if>
														</tr>
													</s:if>
												</s:iterator>
											</table>

										</div>


										<div id="profile" class="tab-pane">
											<table class="table table-bordered table-hover fontsize">
												<tr class="guideinfotitle" style="border-bottom-width: 2px;">
													<th>导游机编号</th>
													<th>导游机电话</th>
													<th>使用次数</th>
													<th>损坏次数</th>
													<th></th>
												</tr>

												<s:iterator value="#session.pb2.pagelist" var="guidem">
													<s:if test="#guidem.gmstate==4">
														<tr>
															<td>${ guidem.guidemnum}</td>
															<td>${ guidem.gmtel}</td>
															<td><a
																href="../guidemDetail?guidemid=${guidem.guidemnum }">${guidem.borrow}</a>
															</td>
															<td>${guidem.break_}</td>
															<td align='center'><a
																href="../findById_Guidem?j=5&index=${ guidem.guidemid}">
																	<button type="button" class="btn-info btn_return"
																		value="">完成</button> </a></td>
														</tr>
													</s:if>
												</s:iterator>
											</table>
										</div>
									</div>
								</div>
							</div>
							<!-- /span -->
						</div>
						<!-- row end-->
						<!--main content end-->
							<div align="center">
							<div  id="pp" class="easyui-pagination" style="border:1px solid #ccc" data-options="
							total: <%=session.getAttribute("total2") %>,pageSize:5">
							</div>
							</div>
						<!--row end-->
					</div>
						
				</div>
			</div>
			
			
			<!-- 修改密码按钮start -->
				<div id="mpassword">
					<form action="" method="post" id="formtel" > 
						<table style="font-size:20px;border:1px;">	
						
							<tr >
								<td style="height:40px;">导游机编号:</td>
								
								<td style="height:40px;">
								<input type="text"  id="bianhao" name="guidem.guidemnum"/>
								
								</td>
							</tr>
							<tr>
								<td style="height:40px;">新导游机电话:</td>
								<td style="height:40px;">
								
								<input type="text" id="dianhua" name="guidem.gmtel"/></td>
							</tr>
							
						</table>
				</form>
				<div style="padding-top:20px;padding-right:20%;">
					<button type="button" class="btn btn-primary " style="margin-right:10px;" onclick="tijiao()">
  						<span class="glyphicon glyphicon-ok"></span>确定
					</button>
					<button type="button" class="btn btn-default " style="margin-right:30px;" onclick="no()">
  						<span class="glyphicon glyphicon-remove"></span>取消
					</button>
				
					
				</div>
				</div>
			<!-- 修改密码按钮end -->
			
			
</body>
<script type="text/javascript">
 $('#pp').pagination({
	    total:<%=session.getAttribute("total2") %>,
	    pageNumber:<%=session.getAttribute("page2") %>,
	    pageSize:<%=session.getAttribute("rows2") %>,
	     pageList: [5, 10, 15, 20],
    	onSelectPage:function(pageNumber, pageSize){
    		$(this).pagination('loading');
    		$(this).pagination('loaded');
    		window.location = "../findAll_Guidem?i=2&page=" + pageNumber+"&rows="+pageSize;
    		//window.location = "../findAll_Guide.action?i=1&page="+ pageNumber+"&rows="+pageSize;
    	}
    });
    
    /*修改密码按钮 start*/
			$('#mpassword').dialog({
						closed : true,
					});
				
			function modifyPassword(){
				$('#mpassword').dialog({
						title : '修改导游机电话',
						width : 400,
						height : 180,
						closed : false,
						iconCls:'icon-save',
						cache : true,
						href : '',
						modal : true
					});
			
			}
			
			function no(){
			$('#mpassword').dialog({
						closed : true});
			}
			
			function tijiao(){
				//$("#form5").submit();
				$.ajax({
                cache: true,
                type: "POST",
                url:"../changeTel_Guidem",
                data:$('#formtel').serialize(),// 你的formid
                async: false,
                error: function(request) {
                    alert("Connection error");
                },
                success: function(data) {
                	$("#dianhua").val("");
                	$("#bianhao").val("");
                   $('#mpassword').dialog({
						closed : true,
					});
                }
            });
			}
			/*修改密码按钮 end*/
</script>

<script type="text/javascript">
	J(function() {
		J('#cal1').calendar({
			format : 'yyyy年MM月dd日'
		});
		J('#cal2').calendar({
			format : 'yyyy年MM月dd日'
		});
	});

	

</script>

</html>