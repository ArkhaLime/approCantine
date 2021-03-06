<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  	<head>
    	<jsp:include page="./includes/Head.jsp"></jsp:include>
    	<title>Détail d'un produit</title>
    	<link rel="stylesheet" href="./css/bootstrap-datepicker3.min.css" type="text/css">
 	</head>
  	<body>
	  	<jsp:include page="./includes/Navbar.jsp"></jsp:include>
	  	<div class="container body-content">
			<h1>Détail du produit</h1>
			<c:if test="${!produit.archive }">
				<p class="text-info">Les champs avec un astérique (*) sont obligatoires</p>
			</c:if>
			<c:if test="${produit.archive }">
				<p class="alert alert-danger">Ce produit n'est plus disponible!</p>
			</c:if>
			<form class="form-horizontal" action="update" method="post">
				<input type="hidden"  id="ident" name="ident" value="<c:out value='${produit.ident }' default='-1'/>" required >
			  	
			  	<div class="form-group">
				    <label for="libelle" class="col-sm-2 control-label">Libellé *</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="libelle" name="libelle" placeholder="Libellé" value="<c:out value='${produit.libelle }' default=''/>" required maxlength="100">
				    </div>
			  	</div>
			  	<div class="form-group">
				    <label for="marque" class="col-sm-2 control-label">Marque *</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="marque" name="marque" placeholder="Marque" value="<c:out value='${produit.marque }' default=''/>" required maxlength="100">
				    </div>
			  	</div>
			  	<div class="form-group">
				    <label for="conditionnement" class="col-sm-2 control-label">Conditionnement</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="conditionnement" name="conditionnement" placeholder="Conditionnement" value="<c:out value='${produit.conditionnement }' default=''/>" maxlength="50" >
				    </div>
			  	</div>
			  	<div class="form-group">
				    <label for="reference" class="col-sm-2 control-label">Référence *</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="reference" name="reference" placeholder="Référence" value="<c:out value='${produit.reference }' default=''/>" required maxlength="13">
				    </div>
			  	</div>
			  	<div class="form-group">
				    <label for="prix_achat" class="col-sm-2 control-label">Prix d'achat *</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="prix_achat" name="prix_achat" placeholder="Prix d'achat" value="<c:out value='${produit.prixAchat }' default=''/>" required>
				    	<span id="helpBlock" class="help-block"><c:out value="${prix_achat_erreur }"/></span>
				    </div>
			  	</div>
			  	<div class="form-group">
				    <label for="date_peremption" class="col-sm-2 control-label">Date de péremption *</label>
				    <div class="col-sm-10">
				      	<input type="text" class="form-control" id="date_peremption" name="date_peremption" placeholder="Date de péremption" value="<c:out value='${produit.frDatePeremption }' default=''/>" required>
				    </div>
			  	</div>
			  	<div class="form-group">
				    <label for="quantite" class="col-sm-2 control-label">Quantité *</label>
				    <div class="col-sm-10">
				      	<input type="number" min="1" class="form-control" id="quantite" name="quantite" placeholder="Quantité" value="<c:out value='${produit.quantite }' default='1'/>" required>
				    	<span id="helpBlock" class="help-block"><c:out value="${quantite_erreur }"/></span>
				    </div>
			  	</div>
			  	<div class="form-group">
				    <label for="min_rupture" class="col-sm-2 control-label">Min avant rupture *</label>
				    <div class="col-sm-10">
				      	<input type="number" min="1" class="form-control" id="min_rupture" name="min_rupture" placeholder="Min rupture" value="<c:out value='${produit.minRupture }' default='2'/>" required>
				    	<span id="helpBlock" class="help-block"><c:out value="${min_rupture_erreur }"/></span>
				    </div>
			  	</div>
			  	<c:if test="${!produit.archive }">
				  	<div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      	<button type="submit" class="btn btn-default">Enregistrer les modifications</button>
					    </div>
				  	</div>
			  	</c:if>
			</form>
			<div class="row">
				<div class="col-xs-5 col-sm-4">
					<a href="listeProduits" class="btn btn-primary" title="Retour à la liste des produits">Retour à la liste</a>
				</div>
				<c:if test="${produit.ident >= 1  && !produit.archive}">
					<div class="col-xs-5 col-sm-5">
						<form action="delete" method="post" id="formDelete">
							<input type="hidden" name="ident" value="${produit.ident }">
							<button type="submit" class="btn btn-danger">Supprimer ce produit</button>
						</form>
					</div>
				</c:if>
			</div>
	  	</div>
	    <jsp:include page="./includes/Scripts.jsp"></jsp:include>
	    <script src="script/bootstrap-datepicker.min.js"></script>
	    <script src="script/locales/bootstrap-datepicker.fr.min.js"></script>
	    <script>
		    $('#date_peremption').datepicker({
		        todayBtn: "linked",
		        autoclose: true,
		        todayHighlight: true,
		        language:'fr'
		    });
		    
		    $('#formDelete').submit(function() {
   	   			return confirm("Êtes-vous sûr de vouloir supprimer ce produit?");
    	  	});
	    </script>
  	</body>
</html>