<div class="container">
	<div class="row">

		<div class="col-md-3">
			<!-- this coloumn would be for sidebar -->
			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<div class="col-md-9">
			<!-- to display actual products -->
			<div class="row">
				<!-- Added a breadcrum component -->
				
				<div class="col-xs-12">

					<c:if test="${userClickAllProducts==true}">
						<!-- 	when user click on the all product keep categoryId as empty -->
						<script>
						window.categoryId='';
						</script>
						<ol class="breadcrumb breadcrumb-arrow">
							<li><a href="${contextRoot}/home"><i class="glyphicon glyphicon-home"></i></a></li>
							<li class="active"><span>All Products</span></li>

						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts==true}">
						<!-- when user click particular category get the category id and store it into categoryId -->
						<script>
						window.categoryId='${category.id}';
						</script>
						<ol class="breadcrumb breadcrumb-arrow"">

							<li><a href="${contextRoot}/home"><i class="glyphicon glyphicon-home"></i></a></li>
							<li class="active"><span>Category</span></li>
							<li class="active"><span>${category.name}</span></li>

						</ol>
					</c:if>
				</div>

			</div>
			<div class="row">
					<div class="col-xs-12">
						<table class="table table-hover table-striped" id="ProductListTable">
							<thead>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									 <th>UnitPrice</th>
									<th>Quantity</th>
									<th></th>
							</thead>
							<tbody>
							
							</tbody>
							<tfoot>
								<tr>
									<th></th>
									<th>Name</th>
									<th>Brand</th>
									<th>UnitPrice</th>
									<th>Quantity</th>
									<th></th>
									</tr>	
							</tfoot>
						</table>


					</div>

				</div>

		</div>


	</div>

</div>