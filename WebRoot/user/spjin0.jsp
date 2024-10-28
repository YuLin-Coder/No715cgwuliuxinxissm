<%@ page language="java" contentType="text/html; charset=utf-8"  import="com.model.User"  pageEncoding="utf-8"%>
   
<%
	// 权限验证
	User user = (User)session.getAttribute("user");
	if(user==null){
		System.out.println("没有得到zhaopinId");
		response.sendRedirect("index.jsp");
		return;
	}
	String userXingming = user.getUserXingming();
	int userId = user.getUserId();
	String userPassword = user.getUserPassword();
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>货物运输管理</title>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var url;
var userId = <%=userId%>;
	function searchSpjin(){
		$('#dg').datagrid('load',{
			spjinName:$('#s_spjinName').val(),
			spjinType1:$('#s_spjinType1').combobox("getValue"),
			spjinType:$('#s_spjinType').combobox("getValue"),
			shangpinId:$('#s_shangpinId').combobox("getValue"),
			spcangkuId:$('#s_spcangkuId').combobox("getValue"),
			spgysId:$('#s_spgysId').combobox("getValue"),
			userId:$('#s_userId').combobox("getValue"),
			sdate:$('#s_sdate').datebox("getValue"),
			edate:$('#s_edate').datebox("getValue")
		});
	}
	
	function saveSpjin(){
		$("#fm").form("submit",{
			url:url,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				var s=result;
				var result = eval('(' + result + ')');
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function openSpjinAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加货物运输");
		url="../addSpjin?userId="+userId;
	}
	
	function resetValue(){
	}
	
	function deleteSpjin(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].spjinId);
		}
		var ids=strIds.join(",");
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("../deleteSpjin",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].spjinName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function closeSpjinDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openSpjinModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑货物运输");
		url="../addSpjin?spjinId="+row.spjinId;
	}
	
	function formatSex(shujuSex, row) {  
		if(shujuSex==0){
			return "男";
		}
		if(shujuSex==1){
			return "女";
		}
	}
	
	function formatType1(shujuType1, row) {  
		if(shujuType1==0){
			return "零";
		}
		if(shujuType1==1){
			return "一";
		}
	}
	
	function formatType(shujuType, row) { 
		if(shujuType==0){
			return "提交";
		}
		if(shujuType==1){
			return "通过";
		}
		if(shujuType==2){
			return "拒绝";
		}
		if(shujuType==3){
			return "退货";
		}
	}
	
	function formatChakan(shujuImg, row) {
		if(shujuImg){
			return '<a target="_blank" style="color:red;" href="../' + shujuImg + '">查看' + '</a>'; 
		}else {
			return "未上传";
		}
	}
	
	function formatXiazai(shujuImgName, row) {
		if(shujuImgName){
			return '<a target="_blank" style="color:red;" href="../downFile?filename=' + shujuImgName + '">下载' + '</a>'; 
		}else {
			return "未上传";
		}
	}
	
	function daochuSpjin(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要导出的数据！");
			return;
		}
		var spjinIds=[];
		for(var i=0;i<selectedRows.length;i++){
			spjinIds.push(selectedRows[i].spjinId);
		}
		var ids=spjinIds.join(",");
		$.messager.confirm("系统提示","您确认要导出数据吗？",function(r){
			if(r){
				$.post("../daochuSpjin",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功导出数据：D:！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].spjinName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function datetostr(dateTime, row) {
		if(dateTime){
			var JsonDateValue = new Date(dateTime.time);
			var text = JsonDateValue.toLocaleString();
			return text;
		}else{
			return "未填写";
		}
	}
	
	function doPrint() {      
        bdhtml=window.document.body.innerHTML;      
        sprnstr="<!--startprint-->";      
        eprnstr="<!--endprint-->";      
        prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);      
        prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));      
        window.document.body.innerHTML=prnhtml;   
        window.print();      
	}
	
	function daoruSpjins(){
		$("#daoru").dialog("open").dialog("setTitle","导入货物运输");
		daoruurl="../daoruSpjin";
	}
	
	function closeDaoruSpjin(){
		$("#daoru").dialog("close");
		resetValue();
	}
	
	function saveDaoruSpjin(){
		$("#drfm").form("submit",{
			url:daoruurl,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#daoru").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function shangchuanSpjin(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#shangchuan").dialog("open").dialog("setTitle","上传货物运输");
		$("#shchfm").form("load",row);
		shchurl="../shangchuanSpjin?spjinId="+row.spjinId;
	}
	
	function closeShangchuanSpjin(){
		$("#shangchuan").dialog("close");
		resetValue();
	}
	
	function saveShangchuanSpjin(){
		$("#shchfm").form("submit",{
			url:shchurl,
			onSubmit:function(){
				return $(this).form("validate");
			},
			success:function(result){
			
				var s=result;
				var result = eval('(' + result + ')');
			
				if(result.errorMsg){
					$.messager.alert("系统提示",result.errorMsg);
					return;
				}else{
					$.messager.alert("系统提示","保存成功");
					resetValue();
					$("#shangchuan").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function datetostr(date, row) {
		if(date){
			var date = new Date(date.time);
        	var y=date.getFullYear();
        	var m=date.getMonth()+1;
        	var d=date.getDate();
        	var h=date.getHours();
        	var m1=date.getMinutes();
        	var s=date.getSeconds();
        	m = m<10?("0"+m):m;
        	d = d<10?("0"+d):d;
        	return y+"-"+m+"-"+d;
			var text = JsonDateValue.toLocaleString();
			return text;
		}else{
			return "未填写";
		}
	}
	
	function shenheSpjin(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要验收的数据！");
			return;
		}
		var row=selectedRows[0];
		url="../addSpjin?spjinId="+row.spjinId;
		$.messager.confirm("系统提示","您确认要验收吗？",function(r){
			if(r){
				$.post(url,{spjinType:1},function(result){
					if(result.errorMsg){
						$.messager.alert("系统提示",result.errorMsg);
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert("系统提示","您已成功验收！");
						$("#dg").datagrid("reload");
					}
				},"json");
			}
		});
	}
</script>
</head>
<body style="margin: 5px;">
<!--startprint-->
	<table id="dg" title="货物运输" class="easyui-datagrid" fitColumns="true"
	 pagination="true" url="../getSpjins?spjinType=0&userId=<%=userId %>" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="spjinId" width="10">编号</th>
				<th field="userId" width="20" hidden="true">客户ID</th>
				<th field="userName" width="20">客户</th>
				<th field="shangpinId" width="20" hidden="true">货物ID</th>
				<th field="shangpinName" width="20">货物</th>
				<th field="sptypeId" width="20" hidden="true">范围ID</th>
				<th field="sptypeName" width="20">范围</th>
				<th field="spjinName" width="40">地址</th>
				<th field="spcangkuId" width="20" hidden="true">车辆ID</th>
				<th field="spcangkuName" width="20">车辆</th>
				<th field="spgysId" width="20" hidden="true">司机ID</th>
				<th field="spgysName" width="20">司机</th>
				<th field="spjinDate" width="20" formatter="datetostr">时间</th>
			</tr>
		</thead>
	</table>
	
<!--endprint-->
	<div id="dlg" class="easyui-dialog" style="width: 540px;height: 400px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="5px;">
				<tr>
					<td>名称：</td>
					<td><input type="text" name="spjinName" id="spjinName" class="easyui-validatebox" required="true"/></td>
					<td>货物：</td>
					<td><input class="easyui-combobox" id="shangpinId" name="shangpinId"  data-options="panelHeight:'auto',editable:false,valueField:'shangpinId',textField:'shangpinName',url:'../shangpinComboList?shangpinType=1'"/></td>
				</tr>
				<tr>
					<td>备注1：</td>
					<td><input type="text" name="spjinMark1" id="spjinMark1" class="easyui-validatebox" required="true"/></td>
					<td>备注2：</td>
					<td><input type="text" name="spjinMark2" id="spjinMark2" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>总数：</td>
					<td><input type="text" name="spjinZong" id="spjinZong" class="easyui-validatebox" required="true"/></td>
					<td>单价：</td>
					<td><input type="text" name="spjinJine" id="spjinJine" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>时间1：</td>
					<td><input class="easyui-datetimebox" name="spjinDate" id="spjinDate" required="true" editable="false" /></td>
					<td>时间2：</td>
					<td><input class="easyui-datetimebox" name="spjinDate1" id="spjinDate1" required="true" editable="false" /></td>
				</tr>
				<tr>
					<td>车辆：</td>
					<td><input class="easyui-combobox" id="spcangkuId" name="spcangkuId"  data-options="panelHeight:'auto',editable:false,valueField:'spcangkuId',textField:'spcangkuName',url:'../spcangkuComboList'"/></td>
					<td>司机：</td>
					<td><input class="easyui-combobox" id="spgysId" name="spgysId"  data-options="panelHeight:'auto',editable:false,valueField:'spgysId',textField:'spgysName',url:'../spgysComboList'"/></td>
				</tr>
				<tr>
					<td valign="top">备注：</td>
					<td colspan="4"><textarea rows="7" cols="50" name="spjinMark" id="spjinMark"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveSpjin()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeSpjinDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
<!--上传-->	
	<div id="shangchuan" class="easyui-dialog" style="width: 320px;height: 140px;padding: 10px 20px"
		closed="true" buttons="#shangchuan-buttons">
		<form id="shchfm" method="post" enctype="multipart/form-data">
			<table cellspacing="5px;">
				<tr>
					<td><input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="shangchuan-buttons">
		<a href="javascript:saveShangchuanSpjin()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeShangchuanSpjin()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
<!--导入-->	
	<div id="daoru" class="easyui-dialog" style="width: 320px;height: 140px;padding: 10px 20px"
		closed="true" buttons="#daoru-buttons">
		<form id="drfm" method="post" enctype="multipart/form-data">
			<table cellspacing="5px;">
				<tr>
					<td><input type="file" name="uploadFile" id="uploadFile" class="easyui-validatebox" required="true"/></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="daoru-buttons">
		<a href="javascript:saveDaoruSpjin()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeDaoruSpjin()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	
</body>
</html>