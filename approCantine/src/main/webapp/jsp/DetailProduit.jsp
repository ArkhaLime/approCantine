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
		<h1>Détail d'un produit</h1>
		<p class="text-info">Les champs avec un astérique (*) sont obligatoires</p>
		<form class="form-horizontal" action="" method="post">
			<input type="hidden"  id="ident" name="ident" value="<c:out value='${produit.ident }' default='-1'/>" required >
		  	
		  	<div class="form-group">
			    <label for="libelle" class="col-sm-2 control-label">Libellé *</label>
			    <div class="col-sm-10">
			      	<input type="text" class="form-control" id="libelle" name="libelle" placeholder="Libellé" value="<c:out value='${produit.libelle }' default=''/>" required >
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label for="marque" class="col-sm-2 control-label">Marque *</label>
			    <div class="col-sm-10">
			      	<input type="text" class="form-control" id="marque" name="marque" placeholder="Marque" value="<c:out value='${produit.marque }' default=''/>" required>
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label for="conditionnement" class="col-sm-2 control-label">Conditionnement</label>
			    <div class="col-sm-10">
			      	<input type="text" class="form-control" id="conditionnement" name="conditionnement" placeholder="Conditionnement" value="<c:out value='${produit.conditionnement }' default=''/>" >
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label for="reference" class="col-sm-2 control-label">Référence *</label>
			    <div class="col-sm-10">
			      	<input type="text" class="form-control" id="reference" name="reference" placeholder="Référence" value="<c:out value='${produit.reference }' default=''/>" required>
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label for="prix_achat" class="col-sm-2 control-label">Prix d'achat *</label>
			    <div class="col-sm-10">
			      	<input type="text" class="form-control" id="pris_achat" name="prix_achat" placeholder="Prix d'achat" value="<c:out value='${produit.prixAchat }' default=''/>" required>
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label for="min_rupture" class="col-sm-2 control-label">Min avant rupture *</label>
			    <div class="col-sm-10">
			      	<input type="number" min="1" class="form-control" id="min_rupture" name="min_rupture" placeholder="Min rupture" value="<c:out value='${produit.minRupture }' default=''/>" required>
			    </div>
		  	</div>
		  	<div class="form-group">
			    <label for="date_peremption" class="col-sm-2 control-label">Date de péremption *</label>
			    <div class="col-sm-10">
			      	<input type="text" class="form-control" id="date_peremption" name="date_peremption" placeholder="Date de péremption" value="<c:out value='${produit.frDatePeremption }' default=''/>" required>
			    </div>
		  	</div>
		  	<div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      	<button type="submit" class="btn btn-default">Enregistrer les modifications</button>
			    </div>
		  	</div>
		</form>
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
	    </script>
  	</body>
</html>