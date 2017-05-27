<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="./includes/Head.jsp"></jsp:include>
    <title>Erreur</title>
  </head>
  <body>
  <jsp:include page="./includes/Navbar.jsp"></jsp:include>
  <div class="container body-content">
	<h1>Une erreur est survenue!</h1>
	<p>
		Voici l'erreur: <strong><c:out value="${exception.message}"></c:out></strong>.<br/>
		Veuillez contacter l'administrateur de ce site.
	</p>
	<c:out value="${exception}" default="Vide"></c:out>
  </div>
    <jsp:include page="./includes/Scripts.jsp"></jsp:include>
  </body>
</html>