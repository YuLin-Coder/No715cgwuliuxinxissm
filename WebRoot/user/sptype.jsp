<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>配送范围管理</title>
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var url;
	
	function searchSptype(){
		$('#dg').datagrid('load',{
			sptypeName:$('#s_sptypeName').val()
		});
	}
	
	function deleteSptype(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择要删除的数据！");
			return;
		}
		var strIds=[];
		for(var i=0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].sptypeId);
		}
		var ids=strIds.join(",");
		//输出选择的行
		//$.messager.alert("ids:" + ids);
		$.messager.confirm("系统提示","您确认要删掉这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("../deleteSptype",{delIds:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","您已成功删除<font color=red>"+result.delNums+"</font>条数据！");
						$("#dg").datagrid("reload");
					}else{
						$.messager.alert('系统提示','<font color=red>'+selectedRows[result.errorIndex].sptypeName+'</font>'+result.errorMsg);
					}
				},"json");
			}
		});
	}
	
	function openSptypeAddDialog(){
		$("#dlg").dialog("open").dialog("setTitle","添加配送范围");
		url="../addSptype";
	}
	
	function saveSptype(){
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
					$.messager.alert("系统提示","保存成功："+result.success);
					resetValue();
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
				}
			}
		});
	}
	
	function resetValue(){
		$("#sptypeName").val("");
		$("#sptypeMark").val("");
	}
	
	function closeSptypeDialog(){
		$("#dlg").dialog("close");
		resetValue();
	}
	
	function openSptypeModifyDialog(){
		var selectedRows=$("#dg").datagrid('getSelections');
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据！");
			return;
		}
		var row=selectedRows[0];
		$("#dlg").dialog("open").dialog("setTitle","编辑配送范围");
		$("#fm").form("load",row);
		url="../addSptype?sptypeId="+row.sptypeId;
	}
	
	function formatType(shujuType, row) {  
		if(shujuType==0){
			return "男";
		}
		if(shujuType==1){
			return "女";
		}
	}
</script>
</head>
<body style="margin: 5px;">
	<table id="dg" title="配送范围" class="easyui-datagrid" fitColumns="true"
	 pagination="true" url="../getSptypes" fit="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="cb" checkbox="true"></th>
				<th field="sptypeId" width="20">编号</th>
				<th field="sptypeName" width="50">名称</th>
				<th field="sptypeMark" width="100">描述</th>
			</tr>
		</thead>
	</table>
	
	
	<div id="dlg" class="easyui-dialog" style="width: 500px;height: 180px;padding: 10px 20px"
		closed="true" buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table>
				<tr>
					<td>名称：</td>
					<td><input type="text" name="sptypeName" id="sptypeName" class="easyui-validatebox" required="true"/></td>
					<td>描述：</td>
					<td><input type="text" name="sptypeMark" id="sptypeMark" class="easyui-validatebox" required="true"/></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><input type="text" name="sptypeMark1" id="sptypeMark1" class="easyui-validatebox" required="true"/></td>
					<td>性别：</td>
					<td><select class="easyui-combobox" id="sptypeMark2" name="sptypeMark2" editable="false" panelHeight="auto" style="width: 155px">
					    <option value="">请选择...</option>
						<option value="0">男</option>
						<option value="1">女</option>
					</select></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg-buttons">
		<a href="javascript:saveSptype()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeSptypeDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
	
</body>
</html>