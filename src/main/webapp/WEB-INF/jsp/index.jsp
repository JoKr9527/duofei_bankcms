<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>银行客户管理系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<frameset rows="24%,*">
    	<frame name="header" src="http://localhost:8080/BankCMS/goHeader" scrolling="no" noresize="noresize"></frame>
    	<frameset cols="4%,*,4%">
    		<frame name="left" src="" scrolling="no"></frame>
    		<frame name="content" src="" scrolling="auto"></frame>
    		<frame name="right" src="" scrolling="no"></frame>
    	</frameset>
    </frameset>
  </head>
  
  
    
    <noframes><body>抱歉，此网页使用了框架，您的浏览器暂不支持框架</body></noframes>
  
</html>
