<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test topClient invoke</h1>
<%
//request.getServletPath()
%>
<a href="./${request.servletPath }syncOrder/execute.do?task=t6" target="_blank">模拟top接口调用</a><br/>
<a href="./${request.servletPath }syncOrder/flush.do" target="_blank">刷新缓存</a><br/>


</body>
</html>