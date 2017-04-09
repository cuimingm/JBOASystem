<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <title>My JSP 'addLeave.jsp' starting page</title>
    
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
  	<script type="text/javascript" src="js/leave.js"></script>
  	
  	<div>&nbsp;</div>
  	<div>&nbsp;</div>
    <div style="text-align:center">
    	<form id="addLeaveForm" method="post">   
	    <div>   
	        <label for="name">开始时间:</label>   
	        <input id="txtLeaveStart" type="text" name="leave.leaveStartTime" class="wdate" onclick="new WdatePicker()"/> 
	        &nbsp;&nbsp;&nbsp;&nbsp; 
	        <label for="email">结束时间:</label>   
	        <input id="txtLeaveEnd" type="text" name="leave.leaveEndTime" class="wdate"  onclick="new WdatePicker()"/> 
	    </div>
	    <div>&nbsp;</div>  
	     <div>   
	        <label for="name">请假天数:</label>   
	        <input type="text" name="leave.leaveDateCount" class="easyui-numberbox"  data-options="min:0.5,precision:1" required="required" />(天)  
	         
	         
	        <label for="name">休假类型:</label>   
	        <select id="cc" name="leave.leaveType" class="easyui-combobox" style="width:160px;">  
	        	<option value="1">事假</option>   
			    <option value="2">病假</option> 
			    <option value="3">年假</option>   
			    <option value="4">婚假</option>   
			    <option value="5">产假</option>   
			    <option value="6">丧假</option>   
			    <option value="7">亲子假</option>   
			</select>  
	    </div>   
	    <div>&nbsp;</div>  
	     <div>   
	        <label for="name">请假事由:</label>   
	        <textarea name="leave.leaveReason" rows="5" cols="55" style="border:1px solid #95B8E7"></textarea>
	    </div> 
	     <div>   
	        <a id="btnAddLeave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">提交</a>&nbsp;&nbsp;&nbsp;&nbsp;
	        <a id="btnCancelLeave" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">取消</a>  
	    </div>       
	</form>  
    </div>
    
  </body>
</html>
