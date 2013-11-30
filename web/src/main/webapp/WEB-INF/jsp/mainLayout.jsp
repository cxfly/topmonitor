<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/inc/tld.inc"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
test result= ${result }<br/>
<hr>

summary:<br/>
 <pre>${summary }   </pre> 
<table>
	<tr>
		<td>errorCount :</td><td>${errorCount }</td>
	</tr>
	<tr>
		<td>succCount :</td><td>${succCount }</td>
	</tr>
	<tr>
		<td>cacheSuccCount :</td><td>${cacheSuccCount }</td>
	</tr>
	<tr>
		<td>sum :</td><td>${allCount }</td>
	</tr>
</table>




</body>
</html>