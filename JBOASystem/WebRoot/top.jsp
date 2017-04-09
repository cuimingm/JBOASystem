<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'top.jsp' starting page</title>
    
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
  <script type="text/javascript">
		function showTime(){
			var now=new Date();
			var year=now.getFullYear();
			var month=now.getMonth()+1;
			var date=now.getDate();
			var hour=now.getHours();
			var minuts=now.getMinutes();
			var second=now.getSeconds();
			var week=now.getDay();
			switch(week){
				case 0:
					week="星期日";
					break;
				case 1:
					week="星期一";
					break;
				case 2:
					week="星期二";
					break;
				case 3:
					week="星期三";
					break;
				case 4:
					week="星期四";
					break;
				case 5:
					week="星期五";
					break;
				case 6:
					week="星期六";
					break;
			}
			
			var text=year+"年"+month+"月"+date+"日"+week +"&nbsp;&nbsp;&nbsp;"+hour+":"+minuts+":"+second;
			$("#spanTime").html(text);
		}
		setInterval("showTime()",1000);
		window.onload=showTime();
	</script>
   <div style="">
   	
   	<p>&nbsp;</p>
   	<p>&nbsp;</p><br/>
   	 [所属部门：<span style="color:blue">${sessionScope.employee.department.deptName }</span>,
   	 职务：<span style="color:blue">${sessionScope.employee.job.jobName }</span>]&nbsp;&nbsp;&nbsp;&nbsp;
    <span style="color:blue">${sessionScope.employee.empName }</span>你好，欢迎使用办公自动化管理系统&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="exitEmp.action">安全退出</a>&nbsp;&nbsp;&nbsp;&nbsp;	当前时间为：<span id="spanTime"></span>
   </div>
  </body>
</html>
