<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
	<meta charset="utf-8"/>
    <title>游客机管理</title>
			
		
</head>	

<body>	
	<div class="naver navbar-default" role="navigation">
		
		 <div class="container-fluid">
			<div class="navbar-header pull-left">
				<a class="navbar-brand" href="#">
					<small style="color:#fff;font-size:20px;">
							 导游机机管理系统
					</small>
				</a>
			</div>
			
			<div class="navbar-header pull-right" role="navigation">
					 <ul class="nav navbar-nav navbar-right">
						
						<li class="loginphoto">							
									<img class="img-circle" src="../assets/app/images/user.jpg" alt="这是张三的照片" style="padding-left:10px;padding-right:5px;">
									<small style="padding-right:5px">您好！${nuser.username }</small>							
							</li>	
						
						<li class="dropdown grey">
							<a href="../login.jsp" style="color:#fff">
								<span class="glyphicon glyphicon-remove" style="margin-right:2px;"></span>
									退出
							</a>
							
						</li>
					</ul>
				</div>
		</div>
	</div>
  <!-- nav end -->
   <!--slide bar start-->
  
    <div class="main-container" class="main-container">
		<div class="main-container-inner">
			<!--row start-->
			<div class="row">
				<!--slide bar start-->
				<div class="sidebar col-md-2" id="sidebar" style="padding-right:0px;">
					<ul class="nav nav-list tree">
						<li  class="submenu" id="menu1" style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
								<a href="../index.jsp">
								<span class="glyphicon glyphicon-home" style="padding-right:5px"></span>
								登录信息
							</a>
						</li>
						<li class="submenu" id="menu2" style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
							<a class="dropdown-toggle">
								<span class="glyphicon glyphicon-phone" style="padding-right:5px"></span>
								导游机管理	
								<span class="glyphicon glyphicon-menu-down" style="float:right;line-height:38px;"></span>
							</a>
							<div id="list2"  style="display:none;margin:0px">
								<ul  style="list-style:none;" class="menuitem">
									<li style="">
										<a href="../toborrow_Guidem" >
											指派导游机
										</a>
									</li>
									<li style="">
										<a href="../guidemachine/alreadyBorrow.jsp" >
											借出导游机
										</a>
									</li>
									<li style="">
										<a href="../guidemachine/logGuideMachine.jsp" >
											导游机录入
										</a>
									</li>
									<li style="">
										<a href="../guidemachine/useMessage2.jsp" >
											使用情况
										</a>
									</li>
								</ul>
							</div>

						</li>
						<li class="submenu" id="menu3"  style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
							<a href="#" class="dropdown-toggle">
								<span class="glyphicon glyphicon-user" style="padding-right:5px"></span>
								导游管理	
								<span class="glyphicon glyphicon-menu-down" style="float:right;line-height:38px;"></span>
							</a>
							<div id="list3"  style="display:none;margin:0px">
								<ul  class="menuitem" style="list-style:none;" >
									<li>
										<a href="../guidemanage/guideMessage1.jsp">导游信息</a>
									</li>
									<li>
										<a href="../guidemanage/guideNew1.jsp">新增导游</a>
									</li>
									<li>
										<a href="../guidemanage/guideOnline.jsp">在线导游</a>
									</li>
									</li>
									<li>
										<a href="../guidemanage/guideOnlineMessage.jsp">上下线详情</a>
									</li>
								</ul>
							</div>
							
						</li>
						<li id="menu4" style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
							<a href="../findAll_Guide?i=4">
								<span class="glyphicon glyphicon-star" style="padding-right:5px"></span>
								评价信息
							</a>
						</li>
						<li class="submenu"id="menu5"  style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
                                    <a href="#" class="dropdown-toggle">
                                    <span class="glyphicon glyphicon-eye-open" style="padding-right:5px"></span>操作员管理
									<span class="glyphicon glyphicon-menu-down" style="float:right;line-height:38px;"></span>
                                    </a>
                                    <div id="list4"  style="margin:0px;display:none;">
                                        <ul  class="menuitem" style="list-style:none;" >
                                            <li>
                                                <a href="../operatorManagement/operatorAdd1.jsp">人员录入</a>
                                            </li>
                                            <li>
                                                <a href="../operatorManagement/operatorDetail.jsp">信息详情</a>
                                            </li>
                                        </ul>
                                    </div>	
                                </li>
						
						<li id="menu6" style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
								<a href="../touristMachine/touristMachineManage.jsp">
								<span class="glyphicon glyphicon-phone" style="padding-right:5px"></span>
								游客机管理
							</a>
						</li>
						<li id="menu7" style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;"  class="active ">
								<a href="../backup/backupAndRecovery.jsp">
								<span class="glyphicon glyphicon-cloud-download" style="padding-right:5px"></span>
								备份和恢复
							</a>
						</li>
						
					</ul>
				</div>
				<!--slide bar end-->
				
				<!--main content start-->
				<div id="main-content" class="main-content col-md-10" style="border:1px solid #f2e1e8;border-width:0 0 0 1px;padding-left:0px;background-color:#ffffff;">
					<div class="main-content-title" >
												
						<ul class="breadcrumb" >
							<li><span class="glyphicon glyphicon-home"></span><a href="../index.jsp" style="padding-left:10px;">首页</a></li>			  
						 	<li>备份和恢复</li>			  
						</ul>
						
					</div>
		
					<div class="page-content" >
						<div class="page-header" style="margin-top:10px;margin-left:20px;margin-right:20px;">
							<font style="font-size:24px;padding-top:-10px;color:#2679b5;">
								数据备份和恢复
							</font>
							<font style="color:#8089a0;font-size:14px">
									<span class="glyphicon glyphicon-hand-right" style="margin-right:8px"></span>对数据进行备份和恢复
							</font>
							
						</div>
                        
						<!-- /.page-header -->	
						<div class="row" style="">
							<div style="margin-left:20px;margin-right:20px;">
								<div class="col-md-12">
										<div class="tabbable">
											
											<div class="col-md-6 tab-content" style="">
												<div id="home" class="tab-pane in active">	
													<table class="table table-bordered table-hover" style="font-size:13px">
												<tr>										
												  <td class="info" colspan="2">数据备份</th>
												</tr>	
											    <tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>导游机信息</td>
												</tr>
												<tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>导游信息</td>
												</tr>
												<tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>游客机信息</td>
												</tr>
												<tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>全选</td>
												</tr>
												<tr>									
												  <td colspan="2" >
													<button type="button" class="btn btn-info btn-xs" style="float:right">确定</button>
												  </td>
												</tr>
												</table>		
													
												</div>
												
											</div>	
											<div class="col-md-6"></div>
											<div class="col-md-6">
												<div id="profile" class="tab-pane">
													<table class="table table-bordered table-hover" style="font-size:13px">
												<tr>										
												  <td class="info" colspan="2">数据恢复</th>
												</tr>	
											    <tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>导游机信息</td>
												</tr>
												<tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>导游信息</td>
												</tr>
												<tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>游客机信息</td>
												</tr>
												<tr>										
												  <th class="info">
														<input type="checkbox" id="bguideMachineMessage" 
														value="option1">
												  </th>
												  <td>全选</td>
												</tr>
												<tr>									
												  <td colspan="2" >
													<button type="button" class="btn btn-info btn-xs" style="float:right">确定</button>
												  </td>
												</tr>
									    </table>
												</div>
											</div>
											<div class="col-md-6"></div>
										</div>
									</div>
									

					</div>
					<!-- row end-->
			</div>
		</div>
	</div>
</body>

</html>