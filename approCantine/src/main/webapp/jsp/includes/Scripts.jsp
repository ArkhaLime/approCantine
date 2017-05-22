<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="script/jquery-3.2.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<%-- <script src="js/bootstrap.min.js"></script> --%>
<sb:head includeStyles="false" />
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
