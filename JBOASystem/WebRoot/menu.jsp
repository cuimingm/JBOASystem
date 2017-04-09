<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<script type="text/javascript" src="js/menu.js"></script>
   	<ul id="menuTree" class="easyui-tree">
   		<li>
   			<span>报销单管理</span>
   			<ul>
   				<li>查看报销单</li>
   				<s:if test="#session.employee.job.jobName=='员工'">
   					<li>添加报销单</li>
   				</s:if>
   			</ul>
   		</li>
   		<li>
   			<span>请假管理</span>
   			<ul>
   				<li>查看请假</li>
   				<s:if test="#session.employee.job.jobName=='员工'">
   					<li>申请请假</li>
   				</s:if>	
   			</ul>
   		</li>
   		<s:if test="#session.employee.job.jobName!='员工'">
   		<li>
   			<span>统计报表</span>
   			<ul>
   				<li>考勤统计</li>
   				<li>请假统计</li>
   			</ul>
   		</li>
   		</s:if>
   		<li>
   			<span>信息中心</span>
   			<ul>
   				<li>待办事宜</li>
   				<li>开会通知</li>
   			</ul>
   		</li>
   	</ul>
  </body>
</html>
