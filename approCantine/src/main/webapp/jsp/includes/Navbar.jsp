<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<s:set var="ProjectName">Appro Cantine (Fiegel)</s:set>

<s:if test="%{userCo!=null}">
	<nav id="js-navbar" class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><s:property value="#ProjectName"/></a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Bonjour, <s:text name="userCo.nom"></s:text></a></li>
					<li><a href="#">Se déconnecter</a></li>
               </ul>
			</div><!--/.nav-collapse -->
		</div>
	</nav>
</s:if>
<s:else>
	<nav id="js-navbar" class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"><s:property value="#ProjectName"/></a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<!-- <ul class="nav navbar-nav">
				<li><a href="#">Accueil</a></li>
			</ul> -->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in" aria-hidden="true" style="font-size: large"></span>Se connecter</a></li>
	        </ul>
		</div><!--/.nav-collapse -->
	</div>
</nav>
</s:else>