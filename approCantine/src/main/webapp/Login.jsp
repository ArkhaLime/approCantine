<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
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
		<%-- <s:form cssClass="form-signin" action="controller.Connect.login.action" method="POST" > --%>
		<s:form cssClass="form-signin" action="verifLogin.action" method="POST" >
			<h2 class="form-signin-heading">Connectez-vous</h2>
			<label for="inputEmail" class="sr-only">Adresse mail</label> 
			<s:textfield id="inputEmail" name="userEmail" placeholder="Adresse mail" required="" autofocus=""></s:textfield>
			<label for="inputPassword" class="sr-only">Mot de passe</label>
			<s:password id="inputPassword" name="userPwd" placeholder="Mot de passe" required=""></s:password>
			<s:submit value="Connexion" cssClass="btn btn-lg btn-primary btn-block"></s:submit>
		</s:form>
	</div>

	<jsp:include page="./jsp/includes/Scripts.jsp"></jsp:include>
</body>
</html>