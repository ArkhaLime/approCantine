<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="./jsp/includes/Head.jsp"></jsp:include>
<title>Connexion</title>
<link rel="stylesheet" href="./css/signin.css" type="text/css">
</head>
<body>
	<jsp:include page="./jsp/includes/Navbar.jsp"></jsp:include>
	<div class="container">
	<%-- Template signin Bootstrap --%>
		<%-- <form class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> 
			<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form> --%>
		<form class="form-signin" action="login" method="post">
			<h2 class="form-signin-heading">Connectez-vous</h2>
			<label for="inputEmail" class="sr-only">Adresse email</label> 
			<input type="email" id="inputEmail" name="login" class="form-control" placeholder="Adresse email" required autofocus>
			<label for="inputPassword" class="sr-only">Mot de passe</label>
			<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Mot de passe" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>

	</div>

	<jsp:include page="./jsp/includes/Scripts.jsp"></jsp:include>
</body>
</html>