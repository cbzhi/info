<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/head.jspf"%>
<link href="${info}/css/signin.css" rel="stylesheet">
<style type="text/css">
.error {
	color: red;
}

input.error1 {
	background-color: #ffcccc;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<sf:form method="post" commandName="user" class = "form-signin text-center">
		<sf:label path="username" cssErrorClass="error">用户名：</sf:label>
		<sf:input path="username" cssErrorClass="error1" />
		<sf:errors path="username" cssClass="error" />
		<br>
		
		<sf:label path="password" cssErrorClass="error">密码：</sf:label>
		<sf:password path="password" cssErrorClass="error1"/>
		<sf:errors path="password" cssClass="error" />
		<br>
	
		<input type="submit" value="Register">
	</sf:form>
	
	
		<sf:form class="form-signin text-center" action="${info}/user/login"
			commandName="user" method="post">
			<sf:errors path="*" cssClass="errorblock"  element="div" ></sf:errors>
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="text" name="username" id="inputEmail"
				class="form-control" placeholder="username" autofocus>
			<br>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" name="password" id="inputPassword"
				class="form-control" placeholder="password" required>
			<br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<br>
			<a href = "${info}/user/forgetPsw">忘记密码</a>
			<a href = "${info}/user/register" style = "float: right;">注册</a>
		</sf:form>
</div>
</body>
</html>