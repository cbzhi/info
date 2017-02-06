<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.error{
	color:red;
}
input.error1{
	background-color: #ffcccc;
}
</style>
<title>Insert title here</title>
</head>
<body>
<h1><s:message code="info.welcome" /> </h1>
<sf:form method = "post" commandName = "user">
	<sf:errors path="*" element="div" cssClass="error" />
	<sf:errors path="*" element="div" cssClass="error">
		哈哈
	</sf:errors>
	<sf:label path="username" cssErrorClass="error">用户名：</sf:label><sf:input path="username" cssErrorClass="error1" /><sf:errors path="username" cssClass="error"/><br>
	密码：<sf:password path="password"/><br>
	<input type = "submit" value = "Register">
</sf:form>
</body>
</html>