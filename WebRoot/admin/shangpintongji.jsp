<%@ page language="java" contentType="text/html; charset=utf-8" import="com.model.Shangpin,java.util.List,java.util.ArrayList"
	pageEncoding="utf-8"%>

<%
	List<String> sptypeNames = new ArrayList<String>();
	sptypeNames = (List) session.getAttribute("sptypeNames");
	List<Integer> shangpinZongshus = new ArrayList<Integer>();
	shangpinZongshus = (List) session.getAttribute("shangpinZongshus");
	Integer zongshushangpin = (Integer) session.getAttribute("zongshushangpin");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>货物信息统计</title>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../js/jquery-1.7.2-min.js"></script>
<script type="text/javascript" src="../js/echarts.min.js"></script>
<script type="text/javascript" src="../js/jsapi.js"></script>
<script type="text/javascript" src="../js/corechart.js"></script>
<script type="text/javascript" src="../js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.ba-resize.min.js"></script>
</head>
<body style="margin: 5px;">
	<script type="text/javascript">
			gvChartInit();
			$(document).ready(function() {
				$('#myTable5').gvChart({
					chartType : 'PieChart',
					gvSettings : {
						vAxis : {
							title : 'No of players'
						},
						hAxis : {
							title : 'Month'
						},
						width : 600,
						height : 350
					}
				});
			});
		</script>
	<table id='myTable5'>
		<caption>货物信息统计</caption>
		<thead>
			<tr>
				<%
					if (zongshushangpin != null) {
				%>
				<th></th>
				<%
					}
				%>
				<%
					if (sptypeNames != null) {
						for (int i = 0; i < sptypeNames.size(); i++) {
				%>
				<th><%=sptypeNames.get(i)%></th>
				<%
					}
					}
				%>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
					if (zongshushangpin != null) {
				%>
				<th><%=zongshushangpin%></th>
				<%
					}
				%>
				<%
					if (shangpinZongshus != null) {
						for (int i = 0; i < shangpinZongshus.size(); i++) {
				%>
				<td><%=shangpinZongshus.get(i)%></td>
				<%
					}
					}
				%>
			</tr>
		</tbody>
	</table>

	<div>
		<form action="../shangpinTongji" method="post" >
		查询日期：&nbsp; <input class="easyui-datebox" name="sdate" id="sdate" editable="false" size="10" />-> 
		<input class="easyui-datebox" name="edate" id="edate" editable="false" size="10" />
		<input type="submit" value="查询"/>
		</form>
	</div>


</body>
</html>