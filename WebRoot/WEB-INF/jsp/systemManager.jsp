<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>系统管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function goUp(fileName){
			
			fileName = fileName.replace(".","_");
			
			window.location.href="http://localhost:8080/BankCMS/downloadSqlFile?fileName="+fileName;
		}
	</script>
</head>

<body style="background-color:#EDEDED;align:center;">
	<br>
	<c:if test="${index ==1 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/changePswd"
				method="post">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>旧密码：</td>
						<td><input type="password" name="oldPw"></td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td><input type="password" name="newPw"></td>
					</tr>
					<tr>
						<td>重复密码：</td>
						<td><input type="password" name="newPw1"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="提交"></td>
					</tr>
				</table>
			</form>
		</div>
	</c:if>
	<c:if test="${index == 2 }">
		<!-- <div id="content" style="width:450px;align:center;margin:90px auto;"> -->
			<table width="100%" height="10px;" cellpadding="10px;" style="text-align:center;" border="1">
				<tr><td colspan="3"><b>备份文件下载</b></td></tr>
				<c:forEach items="${fileList }" var="fileName">
					<tr>
						<td colspan="2">${fileName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
						</td>
						<td ><input type="button" id="upload" onclick="goUp('${fileName}')" value="下载"></td>
					</tr>
				</c:forEach>
			</table>
		<!-- </div> -->
	</c:if>
	<c:if test="${index == 3 }">
		<div id="content" style="width:450px;align:center;margin:90px auto;">
			<form action="http://localhost:8080/BankCMS/uploadSqlFile" method="post" enctype="multipart/form-data">
				<table height="10px;" cellpadding="10px;" style="text-align:right;">
					<tr>
						<td>选择sql文件：</td>
						<td><input type="file" name="file"></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="恢复"></td>
					</tr>
				</table>
			</form>
		</div>
	</c:if>
</body>
</html>
