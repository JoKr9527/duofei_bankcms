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
    
    <title>客户信息查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function search(){
			var clId = document.getElementById("clId");
			var clIdentity = document.getElementById("clIdentity");
			
			window.open("http://localhost:8080/BankCMS/goCustomerInfoQuery?index=1&pageNum=1&clId="+clId.value+"&clIdentity="+clIdentity.value,"content");
		}
		function searchDraw(){
			var clId = document.getElementById("clId2");
			window.open("http://localhost:8080/BankCMS/goCustomerInfoQuery?index=2&pageNum=1&clId="+clId.value,"content");
		}
	</script>
  </head>
  
 <body style="background-color:#EDEDED;">
    
    <c:if test="${index == 1 }">
    	
		<div id="content" style="width:78%;align:center;margin:10px auto;">
			<b>客户基本信息</b>
				<table  style="text-align:center;">
					<tr>
						<td rowspan="3">账号：</td>
						<td rowspan="3"><input type="text" id="clId"></td>
						<td rowspan="3"><br></td>
						<td rowspan="3">身份证号：</td>
						<td rowspan="3"><input type="text" id="clIdentity"></td>
						<td rowspan="3"><input type="button" value="查找" onclick="search();"></td>
					</tr>
				</table>
				<table style="text-align:center;" cellpadding="15" border="2">
					<tr><th>客户账号</th><th>客户姓名</th><th>客户密码</th><th>身份证号码</th><th>账户金额</th><th>账户状态</th><th>账户地址</th><th>开户日期</th></tr>
					<c:forEach items="${page.list}" var="client">
						<tr><td>${client.clId }</td><td>${client.clName}</td><td>${client.clPswd }</td><td>${client.clIdentity }</td><td>${client.clAll }</td><td>${client.clStatus }</td><td>${client.clDate }</td><td>${client.clDate }</td></tr>
					</c:forEach>
				</table>
				<div id="rePage" style="text-align:center;">
				<c:if test="${clIdentity == null && clId == null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQuery?index=1&pageNum=${i}">${i}</a>
					</c:forEach>
				</c:if>
				<c:if test="${clIdentity != null || clId != null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQuery?index=1&pageNum=${i}&clId=${clId}&clIdentity=${clIdentity}">${i}</a>
					</c:forEach>
				</c:if>
				</div>	
		</div>	
	</c:if>
    <c:if test="${index == 2 }">
    	
		<div id="content" style="width:50%;align:center;margin:10px auto;">
			<b>客户取款信息</b>
				<table  style="text-align:center;">
					<tr>
						<td rowspan="3">账号：</td>
						<td rowspan="3"><input type="text" id="clId2"></td>
						<td rowspan="3"><input type="button" value="查找" onclick="searchDraw();"></td>
					</tr>
				</table>
				<table style="text-align:center;" cellpadding="12" border="2">
					<tr><th>操作员ID号</th><th>客户账号</th><th>余额</th><th>取款金额</th><th>取款时间</th></tr>
					<c:forEach items="${page.list}" var="d">
						<tr><td>${d.ma.mgId }</td><td>${d.cl.clId}</td><td>${d.clAll }</td><td>${d.drMoney }</td><td>${d.drDate }</td></tr>
					</c:forEach>
				</table>
				<div id="rePage" style="text-align:center;">
				<c:if test="${clId == null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQuery?index=2&pageNum=${i}">${i}</a>
					</c:forEach>
				</c:if>
				<c:if test="${clId != null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQuery?index=2&pageNum=${i}&clId=${clId}">${i}</a>
					</c:forEach>
				</c:if>
				</div>	
		</div>	
	</c:if>
  </body>
</html>
