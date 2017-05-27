<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/>
<form action="listePerimes" method="get" class="form-inline">
	<div class="form-group">
	    <label for="select" class="control-label">Temps avant péremption</label>
      	<select class="form-control" id="select" name="nbJours">
      		<option value="0" <c:if test="${param.nbJours=='0' }">selected</c:if> >Périmés</option>
			<option value="7" <c:if test="${param.nbJours=='7' }">selected</c:if> >1 semaine</option>
			<option value="14" <c:if test="${param.nbJours=='14' || empty param.nbJours}">selected</c:if> >2 semaines</option>
			<option value="30" <c:if test="${param.nbJours=='30' }">selected</c:if> >1 mois</option>
			<option value="60" <c:if test="${param.nbJours=='60' }">selected</c:if> >2 mois</option>
		</select>
  	</div>
  	<button type="submit" class="btn btn-default">Rechercher</button>
</form>