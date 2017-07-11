<div class="container">
	<div class="row">

		<div class="col-md-3">
			<!-- this coloumn would be for sidebar -->
			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<div class="col-md-9">
			<!-- to display actual products -->
			<div class="row">
				<div class="col-lg-12">
					<!-- Added a breadcrum component -->
					<c:if test="${userClickAllProducts==true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a>
							<li class="active">All Products</li>

						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts==true}">
						<ol class="breadcrumb">

							<li><a href="${contextRoot}/home">Home</a>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>

						</ol>
					</c:if>
				</div>

			</div>

		</div>


	</div>

</div>