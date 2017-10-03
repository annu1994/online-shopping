<div class="container">
   <div class="row">
      <div class="col-xs-12">
         <ol class="breadcrumb breadcrumb-arrow">
            <li><a href="${contextRoot}/home"><i
               class="glyphicon glyphicon-home"></i></a></li>
            <li><a href="${contextRoot}/show/all/products">Products</a></li>
            <li class="active"><span>${product.name}</span></li>
         </ol>
      </div>
   </div>
   <div class="panel panel-info">
      <div class="panel-body">
         <div class="row">
            <!-- To display the Product Image -->
            <div class="col-xs-12 col-sm-4">
               <div class="thumbnail">
                  <img src="${images}/${product.code}.jpg"
                     class="img img-responsive" />
               </div>
            </div>
            <!-- To display Description of Product -->
            <div class="col-xs-12 col-sm-8">
               <h3>${product.name}</h3>
               <hr />
               <p>${product.description}</p>
               <hr />
               <h4>
                  Price:<strong>&#8377; ${product.unitPrice }</strong>
               </h4>
               <hr />
               <c:choose>
                  <c:when test="${product.quantity <1}">
                     <h6>
                        Quantity Available:<span style="color: red">Out of Stock!</span>
                     </h6>
                  </c:when>
                  <c:otherwise>
                     <h6>Quantity Available:${product.quantity }</h6>
                  </c:otherwise>
               </c:choose>
               <!-- for disable the add to cart button if product quantity is less than 1 -->
               <c:choose>
                  <c:when test="${product.quantity <1}">
                     <a href="javascript:void(0)" class="btn btn-success disabled"><strike><span
                        class="glyphicon glyphicon-shopping-cart"></span>Add to Cart </strike> </a>
                  </c:when>
                  <c:otherwise>
                     <a href="${contextRoot}/cart/add/${product.id}/product"
                        class="btn btn-success"> <span
                        class="glyphicon glyphicon-shopping-cart"></span>Add to Cart
                     </a>
                  </c:otherwise>
               </c:choose>
               <a href="${contextRoot}/show/all/products" class="btn btn-primary">Back</a>
            </div>
         </div>
      </div>
   </div>
</div>