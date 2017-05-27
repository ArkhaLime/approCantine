<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ProjectName">Appro Cantine (Fiegel)</c:set>

<c:if test="${!empty sessionScope.userCo}" var="connecte"></c:if>

<c:if test="${connecte == true}">
	<nav id="js-navbar" class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="listeProduits"><c:out value="${ProjectName}"></c:out></a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="listeProduits">Produits</a></li>
					<li><a href="listePerimes">Produits proche péremption</a></li>
					<li><a href="listeRuptures">Produit proche rupture</a></li>
				</ul>
				<%-- <ul class="nav navbar-nav navbar-right">
					<li><a href="#">Bonjour, <c:out value="${userCo.identite}"></c:out></a></li>
					<li>
						<form action="logout" method="post">
							<button type="submit">Déconnexion</button>
						</form>
					</li>
				</ul> --%>
				<form action="logout" class="navbar-right"
					id="logoutForm" method="post">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Bonjour, <c:out value="${userCo.identite}"></c:out></a></li>
						<li>
							<a href="javascript:document.getElementById('logoutForm').submit()"><span
								class="glyphicon glyphicon-log-out" aria-hidden="true"></span>Déconnexion
							</a>
						</li>
					</ul>
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
</c:if>
<c:if test="${connecte == false }">
	<nav id="js-navbar" class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><c:out value="${ProjectName}"></c:out></a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<!-- <ul class="nav navbar-nav">
				<li><a href="#">Accueil</a></li>
			</ul> -->
				<ul class="nav navbar-nav navbar-right">
					<li><a href="Login.jsp"><span
							class="glyphicon glyphicon-log-in" aria-hidden="true"
							style="font-size: large"></span>Se connecter</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
</c:if>