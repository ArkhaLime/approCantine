<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="./includes/Head.jsp"></jsp:include>
    <title>Erreur de connexion</title>
  </head>
  <body>
  <jsp:include page="./includes/Navbar.jsp"></jsp:include>
  <div class="container">
	<h1>Vos identifiants sont incorrectes!</h1>
	<a href="../Login.jsp" class="btn btn-primary">Retour vers la page de connexion</a>
  </div>
    

    <jsp:include page="./includes/Scripts.jsp"></jsp:include>
  </body>
</html>