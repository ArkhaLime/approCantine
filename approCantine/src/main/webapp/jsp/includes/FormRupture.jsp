<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br/>
<form action="listeRuptures" method="get" class="form-inline">
	<div class="form-group">
	    <label for="select" class="control-label">Coefficient avant rupture</label>
      	<select class="form-control" id="select" name="coef">
      		<option value="1" <c:if test="${param.coef=='1' }">selected</c:if> >Rupture</option>
			<option value="2" <c:if test="${param.coef=='2' || empty param.coef}">selected</c:if> >2 fois le minimum</option>
			<option value="3" <c:if test="${param.coef=='3'}">selected</c:if> >3 fois le minimum</option>
		</select>
  	</div>
  	<button type="submit" class="btn btn-default">Rechercher</button>
</form>