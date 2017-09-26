<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/webapp/css" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online-Shopping-${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/lib/bootstrap.min.css" rel="stylesheet">
<!-- Bootswatch Theme CSS -->
<link href="${css}/lib/bootswatch-theme.css" rel="stylesheet">
<link href="${css}/lib/jquery-datatable.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/viewPage.css" rel="stylesheet">
<link href="${css}/breadcrumb.css" rel="stylesheet">

</head>
<div class="wrapper">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">

				<a class="navbar-brand" href="${contextRoot}/home" id="home">Home</a>
			</div>
		</div>

	</nav>
	<div class="content">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">

					<div class="jumbotron">
						<h1>${errorTitle }</h1>
						</hr>
						<blockquote>${errorDescription}</blockquote>

					</div>


				</div>


			</div>




		</div>



	</div>
	<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>
	


</div>