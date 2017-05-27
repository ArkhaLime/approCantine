<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="./includes/Head.jsp"></jsp:include>
		<title>Détail d'un menu</title>
	</head>
	<body>
		<jsp:include page="./includes/Navbar.jsp"></jsp:include>
		<div class="container">
			<h1>Menu du <c:out value="${menu.frDate }"/></h1>
			<h3>Liste des produits</h3>
			<div class="row">
				<c:forEach items="${menu.produits}" var="produit">
					<div class="col-xs-6 col-sm-6 col-md-4 col-lg-3 fiche-produit <c:if test="${produit.archive }">fiche-archive</c:if> ">
						<c:if test="${produit.archive }">
							<p class="text-center">Ce produit n'est plus disponible!</p>
						</c:if>
						<img src="images/default.jpg" class="center-block img-produit" alt="<c:out value='${produit.libelle}'/>" />
						<p class="block barcode text-center margin-top-10px" style="font-size:4em;" ><c:out value="${produit.reference }"></c:out></p>
						<p class="text-center" >
							<c:out value="${produit.libelle}"/><br/>
							[<c:out value="${produit.conditionnement}"/>]<br/>
							<c:out value="${produit.marque}"/>
						</p>
						<p class="text-center <c:if test='${produit.perime }'>bg-red</c:if> <c:if test='${produit.bientotPerime }'>bg-orange</c:if>">
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
				<c:if test="${empty menu.produits }">	
					<div class="alert alert-info" style="margin-top:2em;">
						<p class="text-center">Désolé, mais votre recherche n'a retourné aucun résultat.<br/>Vérifiez la valeur que vous cherchez.</p>
					</div>
				</c:if>
			</div>
			<a href="listeMenus" class="btn btn-primary" title="Retour à la liste des menus">Retour à la liste</a>
		</div>
		<jsp:include page="./includes/Scripts.jsp"></jsp:include>
	</body>
</html>