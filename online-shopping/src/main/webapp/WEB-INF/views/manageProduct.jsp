<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<div class="row">
	<c:if test="${not empty message}">
		<div class="col-xs-12">
		
			<div class="alert alert-success alert-dismissible">
			
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			${message}
			</div>
		
		</div>
	</c:if>
		<div class="col-md-offset-2 col-md-8">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				<div class="panel-body"></div>
				<sf:form class="form-horizontal" modelAttribute="product"
					action="${contextRoot}/manage/products"
					method="POST"
				
				>
					<div class="form-group">
						<label class="control-label col-md-4" for="name">Enter
							Product Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="product-name"
								placeholder="Enter Product Name" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Brand
							Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="brand" id="brand-name"
								placeholder="Enter Brand Name" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="Description">
							Product Description : </label>
						<div class="col-md-8">
							<sf:textarea class="form-control" path="description" rows="4"
								id="description" placeholder="Enter product description here"></sf:textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Enter
							Unit Price : </label>
						<div class="col-md-8">
							<sf:input type="number" path="unitPrice" id="unitPrice"
								placeholder='UnitPrice in indianRupees' class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Product
							Quantity : </label>
						<div class="col-md-8">
							<sf:input type="number" path="quantity" id="quantity"
								placeholder="Quantity Available" class="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Category
							: </label>
						<div class="col-md-8">
							<sf:select class="form-control" path="categoryId" id="categoryId"
								items="${categories}"
								itemLabel="name"
								itemValue="id"
							/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-8">
							<input type="submit" name="submit" id="submit" value="submit"
								class="btn btn-primary" />
								
								<!-- set the other field as hidden bcoz at the time of edit the same product it would be given the default values -->
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="views"/>
								

						</div>
					</div>



				</sf:form>



			</div>





		</div>




	</div>



</div>