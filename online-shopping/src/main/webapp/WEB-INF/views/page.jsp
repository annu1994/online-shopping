<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/webapp/css" />
<spring:url var="js" value="/webapp/js" />
<spring:url var="images" value="/webapp/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online-Shopping-${title}</title>
<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot='${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/lib/bootstrap.min.css" rel="stylesheet">
<!-- Bootswatch Theme CSS -->
<link href="${css}/lib/bootswatch-theme.css" rel="stylesheet">
<link href="${css}/lib/jquery-datatable.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="${css}/viewPage.css" rel="stylesheet">
<link href="${css}/breadcrumb.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!--HomePage loaded on  the click of online-shopping-->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- About us page is loaded on the click of about link -->
			<c:if test="${userClickabout==true}">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- Contact us page is loaded on the click of contact link -->
			<c:if test="${userClickcontact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			<c:if
				test="${userClickSingleProduct==true}">
				<%@include file="showSingleProduct.jsp"%>
			</c:if>
			<c:if
				test="${userClickManageProduct==true}">
				<%@include file="manageProduct.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery -->
		<script src="${js}/lib/jquery-3.1.1.js"></script>
		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/lib/bootstrap.min.js"></script>
		<!-- JQuery Data Table -->
		<script src="${js}/lib/jquery_datatable1.10.16.js"></script>
		<!-- Data Table Bootstrap -->
		<script src="${js}/lib/dataTables.bootstrap.min.js"></script>
		<!--This js will active the Link Which user click -->
		<script src="${js}/activeClass.js"></script>
		<script src="${js}/Product-Category.js"></script>
	</div>

</body>
</html>
