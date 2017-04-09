<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>JBOA办公自动化管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/style.css" type="text/css"></link>
		<link rel="stylesheet" href="js/easyui/themes/default/easyui.css"
			type="text/css"></link>
		<link rel="stylesheet" href="js/easyui/themes/icon.css"
			type="text/css"></link>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/easyui/locale/easyui-lang-zh_CN.js"></script></head>

	<body>
		<s:if test="#session.employee==null">
			<script>
	alert("您未登录，无法访问！");
	location.href = "login.jsp";
</script>
		</s:if>
		<div class="easyui-layout" data-options="fit:true">
			<div id="topLogo"
				data-options="region:'north',height:100,href:'top.jsp'"></div>
			<div id="leftMenu"
				data-options="region:'west',width:200,title:'导航菜单',split:true,href:'menu.jsp'"></div>
			<div id="mainOption" data-options="region:'center',href:'option.jsp'"></div>
		</div>
	</body>
</html>
