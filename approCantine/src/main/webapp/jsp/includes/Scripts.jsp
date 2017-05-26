<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="script/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="script/bootstrap.min.js"></script>

<script>
	$(document).ready(function() {
		paddingBody();
		setTimeout(paddingBody, 2000);
	});

	$(window).resize(function() {
		paddingBody();
	});

	function paddingBody() {
		var hauteur = $('#js-navbar').outerHeight(false);
		$('body').css('padding-top', hauteur);
	}
</script>
