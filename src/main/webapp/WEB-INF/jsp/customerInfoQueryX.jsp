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
			
			window.open("http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=1&pageNum=1&clId="+clId.value,"content");
		}
		function searchDraw(){
			var clId = document.getElementById("clId2");
			window.open("http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=2&pageNum=1&clId="+clId.value,"content");
		}
	</script>
  </head>
  
 <body style="background-color:#EDEDED;">
   
    <c:if test="${index == 1 }">
    	 
		<div id="content" style="width:58%;align:center;margin:10px auto;">
			<b>客户存款信息</b>
				<table  style="text-align:center;">
					<tr>
						<td rowspan="3">账号：</td>
						<td rowspan="3"><input type="text" id="clId"></td>
						<td rowspan="3"><input type="button" value="查找" onclick="search();"></td>
					</tr>
				</table>
				<table style="text-align:center;" cellpadding="12" border="2">
					<tr><th>操作员ID号</th><th>客户账号</th><th>余额</th><th>存款金额</th><th>存款时间</th></tr>
					<c:forEach items="${page.list}" var="d">
						<tr><td>${d.ma.mgId }</td><td>${d.cl.clId}</td><td>${d.clAll }</td><td>${d.deMoney }</td><td>${d.deDate }</td></tr>
					</c:forEach>
				</table>
				<div id="rePage" style="text-align:center;">
				<c:if test="${clId == null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=1&pageNum=${i}">${i}</a>
					</c:forEach>
				</c:if>
				<c:if test="${clId != null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=1&pageNum=${i}&clId=${clId}">${i}</a>
					</c:forEach>
				</c:if>
				</div>	
		</div>	
				
	</c:if>
    <c:if test="${index == 2 }">
    	
		<div id="content" style="width:50%;align:center;margin:10px auto;">
			<b>客户转账信息</b>
				<table  style="text-align:center;">
					<tr>
						<td rowspan="3">账号：</td>
						<td rowspan="3"><input type="text" id="clId2"></td>
						<td rowspan="3"><input type="button" value="查找" onclick="searchDraw();"></td>
					</tr>
				</table>
				<table style="text-align:center;" cellpadding="12" border="2">
					<tr><th>操作员ID号</th><th>客户账号</th><th>余额</th><th>收款账号</th><th>转账金额</th><th>转账时间</th></tr>
					<c:forEach items="${page.list}" var="t">
						<tr><td>${t.manager.mgId }</td><td>${t.client.clId}</td><td>${t.clAll }</td><td>${t.trClient.clId }</td><td>${t.trMoney }</td><td>${t.trDate }</td></tr>
					</c:forEach>
				</table>
				<div id="rePage" style="text-align:center;">
				<c:if test="${clId == null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=2&pageNum=${i}">${i}</a>
					</c:forEach>
				</c:if>
				<c:if test="${clId != null }">
					<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
						<a href="http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=2&pageNum=${i}&clId=${clId}">${i}</a>
					</c:forEach>
				</c:if>
				</div>	
		</div>	
	</c:if>
  </body>
</html>
