<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
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

<title>header</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="jquery/jquery-3.2.1.js"></script>
<style type="text/css">
#ul1 {
	width: 95%;
	padding:0 0;
	margin: 0 auto;
}

#ul2 ul li {
	float: right;
}

ul li {
	display: inline;
	width: 12%;
	float: left;
}

/* ul li{
	display: inline;
	width: 15%;
	text-align: center;
	width: 15%;
} */
/* ul li table{
	display:inline;
} */
ul li table a {
	color:gray;
}
</style>
<script type="text/javascript">
	$(function(){
		$("#system").click(function(){
			$("#systemX").toggle();
		});
		$("#account").click(function(){
			$("#accountX").toggle();
		});
		$("#info").click(function(){
			$("#infoX").toggle();
		});
		$("#service").click(function(){
			$("#serviceX").toggle();
		});
		$("#query").click(function(){
			$("#queryX").toggle();
		});
		$("#help").click(function(){
			$("#helpX").toggle();
		});
	});
</script>
</head>

<body style="background-color: #EAEAEA;">

	<h3 style="color:#C5C1AA">银行客户管理系统</h3>

	<div id="ul1">
		<ul>
			<li ><a id="system" style="color: #5B5B5B;" href="javascript:void(0);"><b>系统管理</b></a>
				<table id="systemX" style="display:none;color:gray;">
					<tr><td><a href="http://localhost:8080/BankCMS/goSystemManager?index=1" target="content">修改密码</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/showSqlFile" target="content">数据库备份</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goSystemManager?index=3" target="content">数据库恢复</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/exit" target="_top">退出</a></td></tr>
				</table>		
			</li>
			<li ><a id="account" style="color: #5B5B5B;" href="javascript:void(0);"><b>账户管理</b></a>
				<table id="accountX" style="display:none;color:gray;">
					<tr><td><a href="http://localhost:8080/BankCMS/goAccountManager?index=1" target="content">开户</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goAccountManager?index=2" target="content">销户</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goAccountManager?index=3" target="content">挂失</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goAccountManager?index=4" target="content">取消挂失</a></td></tr>
				</table>		
			</li>
			<li ><a id="info" style="color: #5B5B5B;" href="javascript:void(0);"><b>客户信息管理</b></a>
				<table id="infoX" style="display:none;color:gray;">
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerInfoManager?index=1" target="content">客户身份验证</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerInfoManager?index=2" target="content">修改密码</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerInfoManager?index=3" target="content">注销</a></td></tr>
				</table>		
			</li>
			<li ><a id="service" style="color: #5B5B5B;" href="javascript:void(0);"><b>客户业务管理</b></a>
				<table id="serviceX" style="display:none;color:gray;">
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerServiceManager?index=1" target="content">客户取款</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerServiceManager?index=2" target="content">客户存款</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerServiceManager?index=3" target="content">客户转账</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/queryAll" target="content">查询账户余额</a></td></tr>
				</table>		
			</li>
			<li ><a id="query" style="color: #5B5B5B;" href="javascript:void(0);"><b>客户信息查询</b></a>
				<table id="queryX" style="display:none;color:gray;">
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerInfoQuery?index=1&pageNum=1" target="content">客户基本信息查询</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerInfoQuery?index=2&pageNum=1" target="content">客户取款信息查询</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=1&pageNum=1" target="content">客户存款信息查询</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goCustomerInfoQueryX?index=2&pageNum=1" target="content">客户转账信息查询</a></td></tr>
				</table>		
			</li>
			<li ><a id="help" style="color: #5B5B5B;" href="javascript:void(0);"><b>帮助</b></a>
				<table id="helpX" style="display:none;color:gray;">
					<tr><td><a href="http://localhost:8080/BankCMS/goHelp?index=1" target="content">关于</a></td></tr>
					<tr><td><a href="http://localhost:8080/BankCMS/goHelp?index=2" target="content">帮助</a></td></tr>
				</table>		
			</li>
		</ul>
	</div>
	<br>
	<script type="text/javascript">
		setInterval(
				"document.getElementById('time').innerHTML='时间:'+new Date().toLocaleString()+'星期'+'日一二三四五六'.charAt(new Date().getDay());",
				1000);
	</script>
	<div id="ul2">
		<ul>

			<li id="time">登录时间：
			<li>
			<li>操作员: ${managerId }
			<li>
		</ul>
	</div>

</body>
</html>
