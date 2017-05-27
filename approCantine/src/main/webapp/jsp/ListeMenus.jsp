<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="./includes/Head.jsp"></jsp:include>
		<title>Liste des menus</title>
		<link rel="stylesheet" href="./css/bootstrap-datepicker3.min.css" type="text/css">
	</head>
	<body>
		<jsp:include page="./includes/Navbar.jsp"></jsp:include>
		<div class="container">
			<h1><c:out value="${titre }" default="Liste des menus"/></h1>
			<c:if test="${!recherche}">
				<a href="creationMenu" class="btn btn-primary">Créer un nouveau menu</a>
			</c:if>
			<br/><br/>
			<form action="rechercheMenu" method="get" class="form-inline">
				<div class="form-group">
				    <label for="input_date">Date du menu</label>
				    <input type="text" class="form-control" id="input_date" name="date" placeholder="Date du menu" value="<c:out value="${param.date }"/>">
			  	</div>
			  	<button type="submit" class="btn btn-default">Rechercher</button>
			</form>
			<div class="row">
				<c:forEach items="${menus}" var="menu">
					<div class="col-xs-6 col-sm-6 col-md-4 col-lg-3 fiche-produit">
						<img src="images/default.jpg" class="center-block img-produit" alt="<c:out value='${menu.frDate}'/>" />
						<p class="text-center" >
							Menu du <c:out value="${menu.frDate}"/>
						</p>
						<form action="detailMenu" method="get">
							<input type="hidden" name="ident" value="<c:out value='${menu.ident }'/>" />
							<button class="btn btn-primary center-block" type="submit" >Voir détails</button>
						</form>
					</div>
				</c:forEach>
				<c:if test="${empty menus }">	
					<div class="alert alert-info" style="margin-top:2em;">
						<p class="text-center">Désolé, mais votre recherche n'a retourné aucun résultat.<br/>Vérifiez la valeur que vous cherchez.</p>
					</div>
				</c:if>
			</div>
		</div>
		<jsp:include page="./includes/Scripts.jsp"></jsp:include>
		<script src="script/bootstrap-datepicker.min.js"></script>
	    <script src="script/locales/bootstrap-datepicker.fr.min.js"></script>
	    <script>
		    $('#input_date').datepicker({
		        todayBtn: "linked",
		        autoclose: true,
		        todayHighlight: true,
		        language:'fr'
		    });
	    </script>
	</body>
</html>