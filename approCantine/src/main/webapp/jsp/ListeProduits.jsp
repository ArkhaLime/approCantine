<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="./includes/Head.jsp"></jsp:include>
    <title>Liste des produits</title>
  </head>
  <body>
  <jsp:include page="./includes/Navbar.jsp"></jsp:include>
  <div class="container body-content">
	<h1>Liste des produits</h1>
	<div class="row">
		<c:forEach items="${produits}" var="produit">
			<div class="col-xs-6 col-sm-6 col-md-4 fiche-produit">
				<img src="images/default.jpg" class="center-block img-produit" alt="<c:out value='${produit.libelle}'/>" />
				<p class="block barcode text-center margin-top-10px" style="font-size:4em;" ><c:out value="${produit.reference }"></c:out></p>
				<p class="text-center" ><c:out value="${produit.libelle}"/><br/>(<c:out value="${produit.conditionnement}"/>)</p>
				<form action="detail" method="get">
					<input type="hidden" value="<c:out value='${produit.ident }'/>" />
					<button class="btn btn-primary center-block" type="submit" >Voir détails</button>
				</form>
			</div>
		</c:forEach>
	</div>
  </div>
    <jsp:include page="./includes/Scripts.jsp"></jsp:include>
  </body>
</html>