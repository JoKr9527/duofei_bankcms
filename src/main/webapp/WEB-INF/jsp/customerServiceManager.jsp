<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>客户业务管理</title>
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
			<form action="http://localhost:8080/BankCMS/drawMoney" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>账号：</td>
						<td><input type="text" name="clId" value="${client.clId }" disabled="disabled"></td>
					</tr>
					<tr>
						<td>取款金额：</td>
						<td><input type="text" name="drawMoney"></td>
					</tr>
					<tr>
						<td>剩余金额：</td>
						<td><input type="text" name="all" value="${client.clAll }" disabled="disabled"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="取款"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
	<c:if test="${index == 2 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/depositMoney" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>账号：</td>
						<td><input type="text" name="clId" value="${client.clId }" disabled="disabled"></td>
					</tr>
					<tr>
						<td>存款金额：</td>
						<td><input type="text" name="depositMoney"></td>
					</tr>
					<tr>
						<td>剩余金额：</td>
						<td><input type="text" name="all" value="${client.clAll }" disabled="disabled"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="存款"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
	<c:if test="${index == 3 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/transferMoney" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>账号：</td>
						<td><input type="text" name="clId" value="${client.clId }" disabled="disabled"></td>
					</tr>
					<tr>
						<td>转账金额：</td>
						<td><input type="text" name="trMoney"></td>
					</tr>
					<tr>
						<td>转账账号：</td>
						<td><input type="text" name="trClId"></td>
					</tr>
					<tr>
						<td>剩余金额：</td>
						<td><input type="text" name="all" value="${client.clAll }" disabled="disabled"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="转账"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
  </body>
</html>
