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
					enctype="multipart/form-data"
				
				>
					<div class="form-group">
						<label class="control-label col-md-4" for="name">Enter
							Product Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="name" id="product-name"
								placeholder="Enter Product Name" class="form-control" />
							<sf:errors path="name" cssClass="help-block" element="em"/>	
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Brand
							Name: </label>
						<div class="col-md-8">
							<sf:input type="text" path="brand" id="brand-name"
								placeholder="Enter Brand Name" class="form-control" />
							<sf:errors path="brand" cssClass="help-block" element="em"/>		
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="Description">
							Product Description : </label>
						<div class="col-md-8">
							<sf:textarea class="form-control" path="description" rows="4"
								id="description" placeholder="Enter product description here"></sf:textarea>
							<sf:errors path="description" cssClass="help-block" element="em"/>		
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-4" for="brand">Enter
							Unit Price : </label>
						<div class="col-md-8">
							<sf:input type="number" path="unitPrice" id="unitPrice"
								placeholder='UnitPrice in indianRupees' class="form-control" />
							<sf:errors path="unitPrice" cssClass="help-block" element="em"/>	
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
						<label class="control-label col-md-4" for="file">Select
							Image : </label>
						<div class="col-md-8">
							<sf:input type="file" path="file" id="file"
								 class="form-control" />
						<sf:errors path="file" cssClass="help-block" element="em"/>		 
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


	<div class="row">
		<div class="col-xs-12">
			<h3>Available Products</h3>
			</hr>
		</div>
		<div class="col-xs-12">
			<div style="overflow:auto">
			
				<table class="table table-hover table-striped table-bordered" id="adminProductTable">
							<thead>
								<tr>
									
									<th>ID</th>
									<th>&#160;</th>
									 <th>Name</th>
									<th>Quantity</th>
									<th>UnitPrice</th>
									<th>Active</th>
									<th>Edit</th>
									
							</thead>
							<tbody>
							<tr>
								<td>3</td>
								<td>
									<img class="adminTableImage" src="${contextRoot}/webapp/images/PRD1FB1B30F39.jpg" alt="motorola lg-5"/>
								</td>
								<td>motorola lg-5</td>
								<td>5</td>
								<td>&#8377;5400</td>
								<td>
									<!-- Toggle switch -->
									<label class="switch">
										<input type="checkbox" checked="checked" value="3"/>
										<div class="slider"></div>										
									</label>
								</td>
								<td>
									<a href="${contextRoot}/manage/3/product" class="btn btn-warning">
									<span class="glyphicon glyphicon-pencil"></span>
									
									</a>
								
								</td>
							</tr>
							<tr>
								<td>3</td>
								<td>
									<img class="adminTableImage" src="${contextRoot}/webapp/images/PRD1FB1B30F39.jpg" alt="motorola lg-5"/>
								</td>
								<td>motorola lg-5</td>
								<td>5</td>
								<td>&#8377;5400</td>
								<td>
									<!-- Toggle switch -->
									<label class="switch">
										<input type="checkbox"  value="3"/>
										<div class="slider"></div>										
									</label>
								</td>
								<td>
									<a href="${contextRoot}/manage/3/product" class="btn btn-warning">
									<span class="glyphicon glyphicon-pencil"></span>
									
									</a>
								
								</td>
							</tr>		
							</tbody>
							<tfoot>
								<tr>
									
									<th>ID</th>
									<th>&#160;</th>
									 <th>Name</th>
									<th>Quantity</th>
									<th>UnitPrice</th>
									<th>Active</th>
									<th>Edit</th>
									</tr>	
							</tfoot>
						</table>
		
		</div>
	
	
	
	</div>
</div>