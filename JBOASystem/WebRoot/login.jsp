<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>欢迎使用JBOA办公自动化管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow:hidden;
}
.STYLE1 {
	color: #000000;
	font-size: 12px;
}
-->
</style>


<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#empLoginForm").submit(function(){
			//获取用户名和密码的值
			if($("#txtGH").val()=="" || $("#txtMM").val()==""){
				alert("工号或密码不能为空！");
				$("#txtGH").focus();
				return false;
			}
		});
	});
</script>
</head>

<body>
	<s:if test="message==null">
	</s:if>
	<s:else>
		<script>
			alert("工号或密码错误，请重新登录");
		</script>
	</s:else>
	
<form id="empLoginForm" action="loginEmp.action" method="post">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td height="235" background="images/login_03.gif">&nbsp;</td>
      </tr>
      <tr>
        <td height="53"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="394" height="53" background="images/login_05.gif">&nbsp;</td>
            <td width="206" background="images/login_06.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="16%" height="25"><div align="right"><span class="STYLE1">工号</span></div></td>
                <td width="57%" height="25"><div align="center">
                  <input type="text" id="txtGH" name="emp.empNo" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td width="27%" height="25">&nbsp;</td>
              </tr>
              <tr>
                <td height="25"><div align="right"><span class="STYLE1">密码</span></div></td>
                <td height="25"><div align="center">
                  <input type="password" id="txtMM" name="emp.loginPassword" style="width:105px; height:17px; background-color:#292929; border:solid 1px #7dbad7; font-size:12px; color:#6cd0ff">
                </div></td>
                <td height="25"><div align="left">
                	<input type="image" src="images/dl.gif"  width="49" height="18" border="0"/>
               </div></td>
              </tr>
            </table></td>
            <td width="362" background="images/login_07.gif">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="213" background="images/login_08.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
