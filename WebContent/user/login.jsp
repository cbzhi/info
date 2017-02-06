<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>登录界面</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="/common/head.jspf"%>
<link href="${info}/css/signin.css" rel="stylesheet">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style>
.error {
	color: #ff0000;
}

.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>

<body>
	 <form:errors path="*" element="div" cssClass="errorblock" />
	 ${command.user.username}${status.errorMessage}${result}11
	 <form:errors path="user.username" cssStyle="color:red"></form:errors>  
	<div class="container">
	<%-- 	<form:form class="form-signin text-center" action="${info}/user/login"  commandName = "user"
			method="post" >
 --%>		
 <form class="form-signin text-center" action="${info}/user/login" 
			method="post" >
 	<h2 class="form-signin-heading">Please sign in</h2>
			 <form:errors path="*" element="div" cssClass="errorblock" />
			
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="text" name="username" id="inputEmail" class="form-control"
				placeholder="username"  autofocus><br> 
				<label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" name="password" id="inputPassword"
				class="form-control" placeholder="password" required> <br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>

