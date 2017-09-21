$(function() {

	var table = $('#ProductListTable');
	if (table.length) {
		console.log('inside the table');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '5 Records', 'All' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : '',
			},
			columns : [ 
				{
					data:'code',
					mRender:function(data,type,row){
						
						return '<img src="'+window.contextRoot+'/webapp/images/'+data+'.jpg" class="dataTableImg"/>';
					}
				},
				{
				data : 'name'
			}, {

				data : 'brand'
			}, {
				data : 'unitPrice',
				mRender : function(data, type, row) {
					return '&#8377; ' + data
				}
			}, {
				data : 'quantity'
			},
			{
				data:'id',
				bSortable:false,
				mRender:function(data,type,row){
					var str='';
					str+='<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"</span></a> &#160 ';
					str+='<a href="'+window.contextRoot+'/cart/add/'+data+'/product"class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"</span></a>';
					
					return str;
				}
			}

			]
		});

	}

})