<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<div class="naver navbar-default" role="navigation" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc2-34" data-genuitec-path="/zhihui2/WebRoot/common2.jsp">

	<div class="container-fluid">
		<div class="navbar-header pull-left">
			<a class="navbar-brand" href="#"> <small
				style="color:#fff;font-size:20px;"> 智慧导游管理系统 </small> </a>
		</div>

		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav navbar-nav navbar-right">

				<li class="loginphoto"><img class="img-circle"
					src="../assets/app/images/user.jpg" alt="这是张三的照片"
					style="padding-left:10px;padding-right:5px;">您好！<s:if  test="#session.nuser.userpower==1">超级管理员  ${nuser.username }</s:if><s:else>
					普通管理员  ${nuser.username }</s:else> <small style="padding-right:5px"></small></li>

				<li class="dropdown grey"><a
					href="../exit_User?userid=${nuser.userid }"
					"
						style="color:#fff"> <span
						class="glyphicon glyphicon-remove" style="margin-right:2px;"></span>
						退出 </a></li>
			</ul>
		</div>
	</div>
</div>
<!-- nav end -->
<div class="main-container" class="main-container">
	<div class="main-container-inner">
		<!--row start-->
		<div class="row">
			<!--slide bar start-->
			<div class="sidebar col-md-2" id="sidebar" style="padding-right:0px;">
				<ul class="nav nav-list tree">
					<li class=" submenu" id="menu1"
						style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
						<a href="../index.jsp"> <span class="glyphicon glyphicon-home"
							style="padding-right:5px"></span> 登录信息 </a></li>
					<li class=" submenu" id="menu2"
						style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
						<a href="#" class="dropdown-toggle"> <span
							class="glyphicon glyphicon-phone" style="padding-right:5px"></span>
							导游机管理 <span class="glyphicon glyphicon-menu-down"
							style="float:right;line-height:38px;"></span> </a>
						<div id="list2" style="margin:0px;">
							<ul style="list-style:none;display:block;" class="menuitem">
								<li style="" id="ok1"><a href="../toborrow_Guidem">
										指派导游机 </a></li>
								<li style="" id="ok2"><a href="../findAll_Guidem?i=1">
										归还导游机 </a></li>
										<s:if test="#session.nuser.userpower==1">
								<li style="" id="ok3"><a
									href="../guidemachine/logGuideMachine.jsp"> 导游机录入 </a></li>
									</s:if>
								<li style="" id="ok4"><a href="../findAll_Guidem?i=2">
										使用情况 </a></li>
							</ul>
						</div></li>
					<li class="submenu" id="menu3"
						style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
						<a href="#" class="dropdown-toggle"> <span
							class="glyphicon glyphicon-user" style="padding-right:5px"></span>
							导游管理 <span class="glyphicon glyphicon-menu-down"
							style="float:right;line-height:38px;"></span> </a>
						<div id="list3" style="margin:0px;display:none;">
							<ul class="menuitem" style="list-style:none;">
								<li id="ok5"><a href="../findAll_Guide?i=1">导游信息</a></li>
								<s:if test="#session.nuser.userpower==1">
								<li id="ok6"><a href="../guidemanage/guideNew1.jsp">新增导游</a></li>
								</s:if>
								</li>
								<li id="ok7"><a href="../findAll_Guide?i=2">在线导游</a></li>
								<li id="ok8"><a href="../findAll_Guide?i=5">导游监听</a></li>
								<li id="ok9"><a href="../findAll_Guide?i=3">上下线详情</a></li>
				</ul>
			</div>

			</li>
			<li id="menu4"
				style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
				<a href="../findAll_Guide?i=4"> <span
					class="glyphicon glyphicon-star" style="padding-right:5px"></span>
					评价信息 </a></li>
			<li class="submenu" id="menu5"
				style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
				<a href="../jiangcheng_Pingfen"> <span
					class="glyphicon glyphicon-heart-empty" style="padding-right:5px"></span>
					奖惩信息 </a></li>
			<li class="submenu" id="menu6"
				style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
				<a href="#" class="dropdown-toggle"> <span
					class="glyphicon glyphicon-eye-open" style="padding-right:5px"></span>
					操作员管理 <span class="glyphicon glyphicon-menu-down"
					style="float:right;line-height:38px;"></span> </a>
				<div id="list6" style="margin:0px;display:none;">
					<ul class="menuitem" style="list-style:none;">
					<s:if test="#session.nuser.userpower==1">
						<li id="ok9"><a href="../operatorManagement/operatorAdd1.jsp">人员录入</a>
						</li>
						
						<li id="ok10"><a href="../findAll_User">信息详情</a></li>
						</s:if>
					</ul>
				</div></li>
				<s:if test="#session.nuser.userpower==1">
			<li id="menu7"
				style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
				<a href="../init_Youkem"> <span
					class="glyphicon glyphicon-phone" style="padding-right:5px"></span>
					游客机管理 </a></li>
					</s:if>
	<s:if test="#session.nuser.userpower==1">
			<li id="menu8"
				style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
				<a href="../changeScore_ChangeScore"> <span
					class="glyphicon glyphicon-pencil" style="padding-right:5px"></span>
					系统设置 </a></li>
				
				<li class="submenu" id="menu9"
							style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
							<a href="#" class="dropdown-toggle"> <span
								class="glyphicon glyphicon-eye-open" style="padding-right:5px"></span>
								导游分组<span class="glyphicon glyphicon-menu-down"
								style="float:right;line-height:38px;"></span> </a>
							<div id="list9" style="margin:0px;display:none;">
								<ul class="menuitem" style="list-style:none;">
									<li id="ok11"><a href="../initarea">分区情况</a></li>
								<li id="ok12"><a href="../initgroup">分组情况</a></li>
									</li>
								</ul>
							</div>
					</li>
					</s:if>
			<li id="menu10"
				style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;" >
				<a href="../jqrtshow_DataAnalyse"> <span
					class="glyphicon glyphicon-edit" style="padding-right:5px"></span>
					数据分析 </a></li>
					<s:if test="#session.nuser.userpower==1">
					<li id="menu11" style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
								<a href="../findAll_Memory">
								<span class="glyphicon glyphicon-file" style="padding-right:5px"></span>
								操作日志
							</a>
						</li>
						
						<li id="menu12" style="border-bottom: 1px solid #e5e5e5;border-right:1px solid #e5e5e5;">
								<a href="../blueTooth/blueTooth.jsp">
								<span class="glyphicon glyphicon-cog" style="padding-right:5px"></span>
								蓝牙设备
							</a>
						</li>
						</s:if>
						
						
			</ul>
		</div>
		<!--slide bar end-->
		<script type="text/javascript">
			$(function() {
				$('ul.tree > li').click(function(e) {
					$('ul.tree > li').removeClass('active');
				});

				$('#ok1').click(function(e) {
					$('li').removeClass('active');
					$('#ok1').addClass('active');

				});

				$('#ok2').click(function(e) {
					$('li').removeClass('active');
					$('#ok2').addClass('active');

				});
				
				$("#menu9").click(function(){
				});
			})
		</script>
