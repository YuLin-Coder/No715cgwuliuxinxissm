<%@ page language="java" contentType="text/html; charset=utf-8"  import="com.model.User"  pageEncoding="utf-8"%>
   
<%
	// 权限验证
	User user = (User)session.getAttribute("user");
	if(user==null){
		System.out.println("没有得到qiuzhiId");
		response.sendRedirect("index.jsp");
		return;
	}
	String userXingming = user.getUserXingming();
	int userId = user.getUserId();
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
  	<a class="button button-little bg-green"><span class="icon-home"></span><%=userXingming %></a> &nbsp;&nbsp;
  	<a class="button button-little bg-red" href="tuichu.jsp"><span class="icon-power-off"></span> 退出登录</a> 
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>个人信息</h2>
  <ul style="display:block">
    <li><a href="user/user.jsp" target="right"><span class="icon-caret-right"></span>个人信息</a></li>
    <li><a href="usermima.jsp" target="right"><span class="icon-caret-right"></span>修改密码</a></li>
  </ul>
  <h2><span class="icon-user"></span>配送范围</h2>
  <ul>
    <li><a href="user/sptype.jsp" target="right"><span class="icon-caret-right"></span>配送范围</a></li>
  </ul>
  <h2><span class="icon-user"></span>货物信息</h2>
  <ul>
    <li><a href="user/shangpin.jsp" target="right"><span class="icon-caret-right"></span>货物信息</a></li>
  </ul>
  <h2><span class="icon-user"></span>货物运输</h2>
  <ul>
    <li><a href="user/spjin0.jsp" target="right"><span class="icon-caret-right"></span>运输途中</a></li>
    <li><a href="user/spjin1.jsp" target="right"><span class="icon-caret-right"></span>货物运达</a></li>
    <li><a href="user/spjin2.jsp" target="right"><span class="icon-caret-right"></span>货物验收</a></li>
  </ul>
  <h2><span class="icon-user"></span>反馈信息</h2>
  <ul>
    <li><a href="user/uyijian.jsp" target="right"><span class="icon-caret-right"></span>反馈信息</a></li>
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