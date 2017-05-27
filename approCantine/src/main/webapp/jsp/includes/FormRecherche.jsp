<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<br/>
<form action="recherche" method="get" class="form-inline">
	<div class="form-group">
	    <label for="select" class="control-label">Champ où chercher</label>
      	<select class="form-control" id="select" name="champ">
      		<option value="libelle" <c:if test="${param.champ=='libelle' || empty param.champ}">selected</c:if> >Libellé</option>
			<option value="marque" <c:if test="${param.champ=='marque' }">selected</c:if> >Marque</option>
			<option value="conditionnement" <c:if test="${param.champ=='conditionnement'}">selected</c:if> >Conditionnement</option>
			<option value="reference" <c:if test="${param.champ=='reference' }">selected</c:if> >Référence</option>
		</select>
  	</div>
  	<div class="form-group">
  		<label for="input" class="control-label" >Valeur à chercher</label>
  		<input type="text" id="input" name="valeur" class="form-control" value="<c:out value='${param.valeur }'/>">
  	</div>
  	<div class="checkbox">
	    <label>
	      	<input type="checkbox" name="desc" <c:if test="${param.desc=='on' }">checked="checked"</c:if> > Tri décroissant
	    </label>
  	</div>
  	<button type="submit" class="btn btn-default">Rechercher</button>
</form>