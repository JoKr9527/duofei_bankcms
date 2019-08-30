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
    
    <title>账户管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="background-color:#EDEDED;align:center;">
   <br>
	<c:if test="${index ==1 }">
		<div id="content" style="width:800px;align:center;margin:100px auto;">
			<form action="http://localhost:8080/BankCMS/openAccount"
				method="post" >
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="name"></td>
						<td>密码：</td>
						<td><input type="password" name="pswd"></td>
					</tr>
					<tr>
						<td>身份证号码：</td>
						<td><input type="text" name="identity"></td>
						<td>重复密码：</td>
						<td><input type="password" name="pswdX">
							<label id="er1"></label>
						</td>
					</tr>
					<tr>
						<td>存入金额：</td>
						<td><input type="text" name="all"></td>
						<td>住址：</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="reset" value="清空"></td>
						<td colspan="2"><input type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
		</div>
	</c:if>
	<c:if test="${index == 2 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/cancelAccount" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>身份证号：</td>
						<td><input type="text" name="identity"></td>
					</tr>
					<tr>
						<td>密码：</td>
						<td><input type="password" name="pswd"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="销户"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
	<c:if test="${index == 3 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/reportAccount" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>身份证号：</td>
						<td><input type="text" name="identity"></td>
					</tr>
					<tr><td>或者</td></tr>
					<tr>
						<td>账号：</td>
						<td><input type="text" name="clId"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="挂失"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
	<c:if test="${index == 4 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/cancelReportAccount" method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>身份证号：</td>
						<td><input type="text" name="identity"></td>
					</tr>
					<tr>
						<td>姓名：</td>
						<td><input type="text" name="clName"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="取消挂失"></td>
					</tr>
				</table>
			</form>
		</div>
	
	</c:if>
  </body>
</html>
