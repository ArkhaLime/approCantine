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
	<h1><c:out value="${titre }" default="Liste des produits"/></h1>
	<c:if test="${!showRupture && ! showPerime && !recherche}">
		<a href="detail" class="btn btn-primary">Ajouter un produit</a>
		<c:if test="${!empty valorisation }">
			<br/><br/>
			<p>Valorisation totale du stock: <c:out value="${valorisation.valeurTotale }"/>€<br/>
			Valorisation du stock périmé: <c:out value="${valorisation.valeurPerime }"/>€</p>
		</c:if>
	</c:if>
	<c:if test="${!showRupture && ! showPerime}">
		<jsp:include page="./includes/FormRecherche.jsp"></jsp:include>
	</c:if>
	<c:if test="${showRupture }">
		<jsp:include page="./includes/FormRupture.jsp"></jsp:include>
	</c:if>
	<c:if test="${showPerime }">
		<jsp:include page="./includes/FormPerime.jsp"></jsp:include>
	</c:if>
	<div class="row">
		<c:forEach items="${produits}" var="produit">
			<div class="col-xs-6 col-sm-6 col-md-4 col-lg-3 fiche-produit">
				<img src="images/default.jpg" class="center-block img-produit" alt="<c:out value='${produit.libelle}'/>" />
				<p class="block barcode text-center margin-top-10px" style="font-size:4em;" ><c:out value="${produit.reference }"></c:out></p>
				<p class="text-center" ><c:out value="${produit.libelle}"/><br/>(<c:out value="${produit.conditionnement}"/>)</p>
				<p class="text-center <c:if test='${produit.perime }'>bg-red</c:if> ">
					Date de péremption: <c:out value="${produit.frDatePeremption }"/> <br/>
					Interval avant péremption: <c:out value="${produit.intervalAvantPeremption }"/>
				</p>
				<p class="text-center <c:if test='${produit.rupture }'>bg-red</c:if> <c:if test='${produit.bientotRupture }'>bg-orange</c:if>">
					Quantité en stock: <c:out value="${produit.quantite }"/><br/>
					Rupture à partir de <c:out value="${produit.minRupture }"/>
				</p>
				<form action="detail" method="get">
					<input type="hidden" name="ident" value="<c:out value='${produit.ident }'/>" />
					<button class="btn btn-primary center-block" type="submit" >Voir détails</button>
				</form>
			</div>
		</c:forEach>
	</div>
  </div>
    <jsp:include page="./includes/Scripts.jsp"></jsp:include>
  </body>
</html>