<%@ page language="java" contentType="text/html; charset=utf-8" import="com.model.Admin"
    pageEncoding="utf-8"%>
    
<%
	// 权限验证
	Admin admin = (Admin)session.getAttribute("admin");
	if(admin==null){
		System.out.println("没有得到adminId");
		response.sendRedirect("index.jsp");
		return;
	}
	String adminName = admin.getAdminName();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>物流管理系统</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>   
</head>
<body style="background-color:#f2f9fd;">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />物流管理系统</h1>
  </div>
  <div class="head-l">
  	<a class="button button-little bg-green"><span class="icon-home"></span><%=adminName %></a> &nbsp;&nbsp;
  	<a class="button button-little bg-red" href="tuichu.jsp"><span class="icon-power-off"></span> 退出登录</a> 
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>个人信息</h2>
  <ul style="display:block">
    <li><a href="adminmima.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
  </ul>
  <h2><span class="icon-user"></span>员工管理</h2>
  <ul>
    <li><a href="admin/yonghu.jsp" target="right"><span class="icon-caret-right"></span>员工管理</a></li>
  </ul>
  <h2><span class="icon-user"></span>客户管理</h2>
  <ul>
    <li><a href="admin/user.jsp" target="right"><span class="icon-caret-right"></span>客户管理</a></li>
  </ul>
  <h2><span class="icon-user"></span>反馈信息</h2>
  <ul>
    <li><a href="admin/huiuyijian.jsp" target="right"><span class="icon-caret-right"></span>回复反馈</a></li>
    <li><a href="admin/huiuyijian1.jsp" target="right"><span class="icon-caret-right"></span>反馈信息</a></li>
  </ul>
  <h2><span class="icon-user"></span>基础信息</h2>
  <ul>
    <li><a href="admin/spcangku.jsp" target="right"><span class="icon-caret-right"></span>车辆信息</a></li>
    <li><a href="admin/spgys.jsp" target="right"><span class="icon-caret-right"></span>司机信息</a></li>
    <li><a href="admin/sptype.jsp" target="right"><span class="icon-caret-right"></span>配送范围</a></li>
  </ul>
  <h2><span class="icon-user"></span>货物信息</h2>
  <ul>
    <li><a href="admin/shangpin0.jsp" target="right"><span class="icon-caret-right"></span>审核货物</a></li>
    <li><a href="admin/shangpin.jsp" target="right"><span class="icon-caret-right"></span>货物信息</a></li>
  </ul>
  <h2><span class="icon-user"></span>货物运输</h2>
  <ul>
    <li><a href="admin/spjin0.jsp" target="right"><span class="icon-caret-right"></span>运输途中</a></li>
    <li><a href="admin/spjin1.jsp" target="right"><span class="icon-caret-right"></span>货物运达</a></li>
    <li><a href="admin/spjin2.jsp" target="right"><span class="icon-caret-right"></span>货物验收</a></li>
  </ul>
  <h2><span class="icon-user"></span>统计信息</h2>
  <ul>
    <li><a href="admin/shangpintongji.jsp" target="right"><span class="icon-caret-right"></span>货物统计</a></li>
  </ul>
  <h2><span class="icon-user"></span>系统管理</h2>
  <ul>
    <li><a href="admin/rizhi.jsp" target="right"><span class="icon-caret-right"></span>登录日志</a></li>
  </ul>
</div>
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>
<ul class="bread">
  <li>物流管理系统</li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="index2.jsp" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
<p>物流管理系统</p>
</div>
</body>
</html>