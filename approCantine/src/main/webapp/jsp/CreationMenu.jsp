<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="./includes/Head.jsp"></jsp:include>
		<title>Création d'un menu</title>
		<link rel="stylesheet" href="./css/bootstrap-datepicker3.min.css" type="text/css">
	</head>
	<body>
		<jsp:include page="./includes/Navbar.jsp"></jsp:include>
		<div class="container">
			<h1>Création de menu</h1>
			<p class="text-info">Les champs avec un astérique (*) sont obligatoires</p>
			<form id="form_menu" action="creationMenu" method="post" class="form-horizontal">
				<div class="form-group">
				    <label for="date_menu" class="col-sm-2 control-label">Date du menu *</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="date_menu" name="date" placeholder="Date du menu" required>
				    </div>
			  	</div>
			  	<hr/>
			  	<div class="row">
			  		<c:forEach items="${produits}" var="produit">
						<div class="col-xs-6 col-sm-6 col-md-4 col-lg-3 fiche-produit">
							<div class="checkbox text-center">
						        <label>
						          	<input type="checkbox" name="produits" value="<c:out value="${produit.ident }"/> "> <strong>Choisir ce produit</strong>
						        </label>
					      	</div>
							<img src="images/default.jpg" class="center-block img-produit margin-top-10px" alt="<c:out value='${produit.libelle}'/>" />
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
							<%-- <form action="detail" method="get">
								<input type="hidden" name="ident" value="<c:out value='${produit.ident }'/>" />
								<button class="btn btn-primary center-block" type="submit" >Voir détails</button>
							</form> --%>
						</div>
					</c:forEach>
					<c:if test="${empty produits }">	
						<div class="alert alert-info" style="margin-top:2em;">
							<p class="text-center">Désolé, mais votre recherche n'a retourné aucun résultat.<br/>Vérifiez la valeur que vous cherchez.</p>
						</div>
					</c:if>				
			  	</div>
			  	<hr/>
				<div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      	<button type="submit" class="btn btn-primary">Créer un menu</button>
				    </div>
			  	</div>
			</form>
		</div>
		<jsp:include page="./includes/Scripts.jsp"></jsp:include>
		<script src="script/bootstrap-datepicker.min.js"></script>
	    <script src="script/locales/bootstrap-datepicker.fr.min.js"></script>
		<script>
		    $('#date_menu').datepicker({
		        todayBtn: "linked",
		        autoclose: true,
		        todayHighlight: true,
		        language:'fr',
		        start:'d'
		    });
		    
		    $('#form_menu').submit(function() {
   	   			var nbCheckbox = $('#form_menu').find("input[type=checkbox]").filter(":checked").length;
   	   			console.log("nb de checkbox check",nbCheckbox);
   	   			if(nbCheckbox<=0){
   	   				alert("Vous devez choisir au moins produit!");
   	   				return false;
   	   			}
   	   			return true;
    	  	});
	    </script>
	</body>
</html>