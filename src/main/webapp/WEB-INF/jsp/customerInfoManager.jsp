<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户信息管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="background-color:#EDEDED;">
    <br>
   <c:if test="${index == 1 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/validateAccount" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>账号：</td>
						<td><input type="text" name="clId"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="pswd"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="验证"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
	<c:if test="${index == 2 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/changeAccountPswd" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>新密码：</td>
						<td><input type="password" name="newPswd"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="修改"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
  </body>
</html>
